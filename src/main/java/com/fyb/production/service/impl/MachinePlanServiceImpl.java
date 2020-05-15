package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.common.Const;
import com.fyb.production.entity.MachinePlan;
import com.fyb.production.entity.Productivity;
import com.fyb.production.mapper.MachinePlanMapper;
import com.fyb.production.service.IMachinePlanService;
import com.fyb.production.service.IProductivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @since 2020-05-14
 */
@Service
public class MachinePlanServiceImpl extends ServiceImpl<MachinePlanMapper, MachinePlan> implements IMachinePlanService {

    @Autowired
    private MachinePlanMapper machinePlanMapper;

    @Autowired
    private IProductivityService productivityService;

    //排满整天的生产计划
    @Override
    public void generateMachinePlanWholeDay(Integer planNo, LocalDate productionDate, String productCode){

        //根据产品code 查询每个机台的产能
        QueryWrapper<Productivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_code",productCode);
        List<Productivity> list = productivityService.list(queryWrapper);
        //循环遍历36个机台产能
        for (Productivity item: list
             ) {
            //得到该机台的对应产品的日产量
            Integer dailyProduction = item.getDailyProduction();
            //算出每班产量
            Integer shiftProduction = dailyProduction/3;
            //得到该机台的机台编码
            String machineCode = item.getMachineCode();
            MachinePlan machinePlan = new MachinePlan();
            machinePlan.setPlanNo(planNo);
            machinePlan.setProductionDate(productionDate);
            machinePlan.setShift(Const.Shift.BAI);
            machinePlan.setScheduledProduction(shiftProduction);
            machinePlan.setProductCode(productCode);
            machinePlan.setMachineCode(machineCode);
            //插入白班生产计划
            machinePlanMapper.insert(machinePlan);
            //插入中班生产计划
            machinePlan.setShift(Const.Shift.ZHONG);
            machinePlanMapper.insert(machinePlan);
            //插入夜班生产计划
            machinePlan.setShift(Const.Shift.YE);
            machinePlanMapper.insert(machinePlan);
        }

    }

    //接在整天之后，排满剩余产量，既然是整天之后,生产日期应该去数据库中查找最后一天加+1
    @Override
    public void  generateMachinePlanRemainAfterWholeDays(Integer planNo, String productCode, Integer remain){
        QueryWrapper<MachinePlan> machinePlanQueryWrapper = new QueryWrapper<>();
        machinePlanQueryWrapper.select("max(production_date) as productionDate");
        Map<String, Object> map = getMap(machinePlanQueryWrapper);
        Date productionDate = (Date) map.get("productionDate");
        LocalDate localDate = productionDate.toLocalDate().plusDays(1);
        //根据产品code 查询每个机台的产能
        QueryWrapper<Productivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_code",productCode);
        List<Productivity> list = productivityService.list(queryWrapper);
        //循环遍历36个机台产能
        for (Productivity item: list
        ){
            //得到该机台的对应产品的日产量
            Integer dailyProduction = item.getDailyProduction();
            //算出每班产量
            Integer shiftProduction = dailyProduction/3;
            //得到该机台的机台编码
            String machineCode = item.getMachineCode();
            MachinePlan machinePlan = new MachinePlan();
            machinePlan.setPlanNo(planNo);
            machinePlan.setProductionDate(localDate);
            machinePlan.setShift(Const.Shift.BAI);
            machinePlan.setScheduledProduction(shiftProduction);
            machinePlan.setProductCode(productCode);
            machinePlan.setMachineCode(machineCode);
            //插入白班生产计划
            if((remain-shiftProduction)>=0){
                machinePlanMapper.insert(machinePlan);
                remain=remain-shiftProduction;
            }else {
                machinePlan.setScheduledProduction(remain);
                machinePlanMapper.insert(machinePlan);
                break;}
            //插入中班计划
            if((remain-shiftProduction)>=0){
                machinePlan.setShift(Const.Shift.ZHONG);
                machinePlanMapper.insert(machinePlan);
                remain=remain-shiftProduction;
            }else {
                machinePlan.setShift(Const.Shift.ZHONG);
                machinePlan.setScheduledProduction(remain);
                machinePlanMapper.insert(machinePlan);
                break;}
            //插入夜班计划
            if((remain-shiftProduction)>=0){
                machinePlan.setShift(Const.Shift.YE);
                machinePlanMapper.insert(machinePlan);
                remain=remain-shiftProduction;
            }else {
                machinePlan.setShift(Const.Shift.YE);
                machinePlan.setScheduledProduction(remain);
                machinePlanMapper.insert(machinePlan);
                break;}
        }
    }

    //当天安排了生产计划，但是没排满，补足了未排满的那个机台之后，按排这之后剩余的产量
    public void generateMachinePlan(){

    }


}
