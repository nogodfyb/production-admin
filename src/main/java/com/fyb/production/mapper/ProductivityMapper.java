package com.fyb.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fyb.production.entity.Productivity;
import com.fyb.production.vo.ProductivityVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
public interface ProductivityMapper extends BaseMapper<Productivity> {

    List<ProductivityVo> queryAllProductivityVo();

}
