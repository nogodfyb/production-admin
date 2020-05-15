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

import java.time.LocalDate;
import java.util.List;

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
            //得到该机台的机台编码
            String machineCode = item.getMachineCode();
            //白班计划产量
            Integer shiftBaiProduction=0;
            //中班计划产量
            Integer shiftZhoProduction=0;
            //夜班计划产量
            Integer shiftYeProduction=0;
            switch (dailyProduction%3){
                case 0:
                    shiftBaiProduction=dailyProduction/3;
                    shiftZhoProduction=dailyProduction/3;
                    shiftYeProduction=dailyProduction/3;
                    break;
                case 2:
                    shiftBaiProduction=dailyProduction/3+1;
                    shiftZhoProduction=dailyProduction/3+1;
                    shiftYeProduction=dailyProduction/3;
                    break;
                case 1:
                    shiftBaiProduction=dailyProduction/3+1;
                    shiftZhoProduction=dailyProduction/3;
                    shiftYeProduction=dailyProduction/3;
                    break;
            }
            MachinePlan machinePlan = new MachinePlan();
            machinePlan.setPlanNo(planNo);
            machinePlan.setProductionDate(productionDate);
            machinePlan.setShift(Const.Shift.BAI);
            machinePlan.setScheduledProduction(shiftBaiProduction);
            machinePlan.setProductCode(productCode);
            machinePlan.setMachineCode(machineCode);
            //插入白班生产计划
            machinePlanMapper.insert(machinePlan);
            //插入中班生产计划
            machinePlan.setShift(Const.Shift.ZHONG);
            machinePlan.setScheduledProduction(shiftZhoProduction);
            machinePlanMapper.insert(machinePlan);
            //插入夜班生产计划
            machinePlan.setShift(Const.Shift.YE);
            machinePlan.setScheduledProduction(shiftYeProduction);
            machinePlanMapper.insert(machinePlan);
        }

    }


}
