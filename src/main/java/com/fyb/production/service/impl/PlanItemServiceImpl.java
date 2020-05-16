package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.common.Const;
import com.fyb.production.entity.MachinePlan;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.entity.Productivity;
import com.fyb.production.mapper.MachinePlanMapper;
import com.fyb.production.mapper.PlanItemMapper;
import com.fyb.production.service.IMachinePlanService;
import com.fyb.production.service.IPlanItemService;
import com.fyb.production.service.IProductivityService;
import com.fyb.production.vo.PlanItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-13
 */
@Service
public class PlanItemServiceImpl extends ServiceImpl<PlanItemMapper, PlanItem> implements IPlanItemService {

    @Autowired
    private PlanItemMapper planItemMapper;

    @Autowired
    private MachinePlanMapper machinePlanMapper;


    @Autowired
    private IProductivityService productivityService;

    @Autowired
    private IMachinePlanService machinePlanService;

    @Override
    public List<PlanItemVo> selectAllPlanItemsVo(){
        List<PlanItemVo> planItemVos = planItemMapper.selectAll();
        return planItemVos;
    }

    @Override
    public void generateProductionPlans(List<Integer> planIdList){
        //这里有一个隐患，虽然正常用户无法获取已排的生产计划id，但是会受到攻击，有空处理bug
        List<PlanItem> planItems = planItemMapper.selectBatchIds(planIdList);
        //标记planItems已排
        PlanItem planItem = new PlanItem();
        planItem.setIsPlan(true);
        for (Integer id:planIdList
             ) {
            planItem.setId(id);
            planItemMapper.updateById(planItem);
        }
        for (PlanItem item: planItems
             ) {
            LocalDate startTime = item.getStartTime();
            //根据起始时间读取当天所有机台生产计划
            QueryWrapper<MachinePlan> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("production_date",item.getStartTime());
            List<MachinePlan> machinePlanList = machinePlanService.list(queryWrapper);
            //当天没有安排生产计划
            if(machinePlanList.size()==0){
                QueryWrapper<Productivity> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.select("sum(daily_production) as total").eq("product_code",item.getProductCode());
                Map<String, Object> map = productivityService.getMap(queryWrapper2);
                //单个产品36台机器一天的产能
                BigDecimal total = (BigDecimal) map.get("total");
                //可以将如下个整天排满
                int wholeDays = item.getProductQuantity() / total.intValue();
                for (int i = 0; i <wholeDays ; i++) {
                    machinePlanService.generateMachinePlanWholeDay(item.getPlanNo(),startTime.plusDays(i),item.getProductCode());
                }
                //还剩需要安排多少产量productQuantity-total*wholeDays 这些产量可以在一天排完
                int remainProduction=item.getProductQuantity()-total.intValue()*wholeDays;
                //剩余产量排满
                machinePlanService.generateMachinePlanRemainAfterWholeDays(item.getPlanNo(),item.getProductCode(),remainProduction);
            }
            //当天安排了生产计划
            else {
                //查询目前已经安排到哪一天了
                QueryWrapper<MachinePlan> machinePlanQueryWrapper = new QueryWrapper<>();
                machinePlanQueryWrapper.select("max(production_date) as productionDate");
                Map<String, Object> map = machinePlanService.getMap(machinePlanQueryWrapper);
                Date productionDate = (Date) map.get("productionDate");
                //目前已经排到的日期
                LocalDate localDate = productionDate.toLocalDate();
                //再次查询该日期是否已排满
                Boolean full = machinePlanMapper.isFull(localDate);
                //如果排满了
                if (full){
                    //新起一天开始排
                    LocalDate newProductionDate = localDate.plusDays(1);
                    QueryWrapper<Productivity> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.select("sum(daily_production) as total").eq("product_code",item.getProductCode());
                    Map<String, Object> map2 = productivityService.getMap(queryWrapper2);
                    //单个产品36台机器一天的产能
                    BigDecimal total = (BigDecimal) map2.get("total");
                    //可以将如下个整天排满
                    int wholeDays = item.getProductQuantity() / total.intValue();
                    for (int i = 0; i <wholeDays ; i++) {
                        machinePlanService.generateMachinePlanWholeDay(item.getPlanNo(),newProductionDate,item.getProductCode());
                    }
                    //还剩需要安排多少产量productQuantity-total*wholeDays 这些产量可以在一天排完
                    int remainProduction=item.getProductQuantity()-total.intValue()*wholeDays;
                    //剩余产量排满
                    machinePlanService.generateMachinePlanRemainAfterWholeDays(item.getPlanNo(),item.getProductCode(),remainProduction);
                }
                //如果没排满
                else {
                    //查出是哪个机台没排满
                    MachinePlan machinePlan = machinePlanMapper.selectUnFull(localDate);
                    //查询出当前需要安排生产的产品对应该机台的产能
                    QueryWrapper<Productivity> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("machine_code",machinePlan.getMachineCode()).
                            eq("product_code",item.getProductCode());
                    Productivity productivity  = productivityService.getOne(queryWrapper2);
                    //当前机台还能排多少产量
                    Integer currentProduction=productivity.getDailyProduction()/3-machinePlan.getScheduledProduction();
                    machinePlan.setId(null);
                    machinePlan.setPlanNo(item.getPlanNo());
                    machinePlan.setScheduledProduction(currentProduction);
                    machinePlan.setProductCode(item.getProductCode());
                    //安排
                    machinePlanMapper.insert(machinePlan);
                    Integer remain=item.getProductQuantity()-currentProduction;
                    //再将当天剩余排满
                    QueryWrapper<MachinePlan> machinePlanQueryWrapper1 = new QueryWrapper<>();
                    machinePlanQueryWrapper1.eq("machine_code",machinePlan.getMachineCode()).
                            eq("production_date",machinePlan.getProductionDate());
                    List<MachinePlan> list = machinePlanService.list(machinePlanQueryWrapper1);

                    //还需要排中班，夜班
                    if(list.size()==2){
                        machinePlan.setShift(Const.Shift.ZHONG);
                        machinePlan.setScheduledProduction(productivity.getDailyProduction()/3);
                        machinePlanMapper.insert(machinePlan);
                        remain=remain-productivity.getDailyProduction()/3;
                        machinePlan.setShift(Const.Shift.YE);
                        machinePlanMapper.insert(machinePlan);
                        remain=remain-productivity.getDailyProduction()/3;
                    }
                    //还需要排夜班
                    if(list.size()==3){
                        machinePlan.setShift(Const.Shift.YE);
                        machinePlan.setScheduledProduction(productivity.getDailyProduction()/3);
                        machinePlanMapper.insert(machinePlan);
                        remain=remain-productivity.getDailyProduction()/3;
                    }
                    //安排remain产量
                    machinePlanService.generateMachinePlanIfNotFull(item.getPlanNo(),localDate,item.getProductCode(),remain);
                }


            }

        }
    }

    @Override
    public Boolean validateTimeSequence(List<Integer> idList){
        List<PlanItem> planItems = planItemMapper.selectBatchIds(idList);
        for (int i = 0; i <planItems.size()-1 ; i++) {
             LocalDate beforeTime = planItems.get(i).getStartTime();
             LocalDate afterTime = planItems.get(i+1).getStartTime();
            if(afterTime.compareTo(beforeTime)<0){
                return false;
            }
        }
        return true;
    }

}
