package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.entity.MachinePlan;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.entity.Productivity;
import com.fyb.production.mapper.PlanItemMapper;
import com.fyb.production.service.IMachinePlanService;
import com.fyb.production.service.IPlanItemService;
import com.fyb.production.service.IProductivityService;
import com.fyb.production.vo.PlanItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        List<PlanItem> planItems = planItemMapper.selectBatchIds(planIdList);
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
                queryWrapper.select("sum(daily_production) as total").eq("product_code",item.getProductId());
                Map<String, Object> map = productivityService.getMap(queryWrapper2);
                //单个产品36台机器一天的产能
                BigDecimal total = (BigDecimal) map.get("total");
                //可以将如下个整天排满
                int wholeDays = item.getProductQuantity() / total.intValue();
                //还剩需要安排多少产量productQuantity-total*wholeDays 这些产量可以在一天排完
                int remainProduction=item.getProductQuantity()-total.intValue()*wholeDays;
                //剩余产量排满，排一个机台remain-当个机台的日产量，产生新的remain直到排完

            }else {

            }

        }
    }

}