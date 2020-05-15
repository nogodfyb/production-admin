package com.fyb.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fyb.production.entity.MachinePlan;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fyb
 * @since 2020-05-14
 */
public interface MachinePlanMapper extends BaseMapper<MachinePlan> {
    Boolean isFull(LocalDate productionDate);

    MachinePlan selectUnFull(LocalDate productionDate);

}
