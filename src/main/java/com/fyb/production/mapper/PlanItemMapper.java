package com.fyb.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.vo.PlanItemVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fyb
 * @since 2020-05-13
 */
public interface PlanItemMapper extends BaseMapper<PlanItem> {

    List<PlanItemVo> selectAll();

}
