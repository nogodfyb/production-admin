package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Productivity;
import com.fyb.production.mapper.ProductivityMapper;
import com.fyb.production.service.IProductivityService;
import com.fyb.production.vo.ProductivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
@Service
public class ProductivityServiceImpl extends ServiceImpl<ProductivityMapper, Productivity> implements IProductivityService {
    @Autowired
    private ProductivityMapper productivityMapper;


    @Override
    public CommonResult<List<ProductivityVo>> queryAllProductivityVo(){
        List<ProductivityVo> productivityVos = productivityMapper.queryAllProductivityVo();
        if (productivityVos.size()!=0){
            return CommonResult.success(productivityVos);
        }
        return CommonResult.failed();
    }




}
