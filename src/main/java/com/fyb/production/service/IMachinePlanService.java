package com.fyb.production.service;

import com.fyb.production.entity.MachinePlan;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-14
 */
public interface IMachinePlanService extends IService<MachinePlan> {

    //排满整天的生产计划
    void generateMachinePlanWholeDay(Integer planNo, LocalDate productionDate, String productCode);

    //接在整天之后，排满剩余产量，既然是整天之后,生产日期应该去数据库中查找最后一天加+1
    void  generateMachinePlanRemainAfterWholeDays(Integer planNo, String productCode, Integer remain);

    //当天安排了生产计划，但是没排满，补足了未排满的那个机台之后，按排这之后剩余的产量
    void generateMachinePlanIfNotFull(Integer planNo, LocalDate productionDate, String productCode, Integer remain);
}
