package com.fyb.production.service;

import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Productivity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fyb.production.vo.ProductivityVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
public interface IProductivityService extends IService<Productivity> {

    CommonResult<List<ProductivityVo>> queryAllProductivityVo();
}
