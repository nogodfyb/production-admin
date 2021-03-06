package com.fyb.production.service.impl;

import com.fyb.production.entity.Product;
import com.fyb.production.mapper.ProductMapper;
import com.fyb.production.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
