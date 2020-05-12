package com.fyb.production.controller;


import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Product;
import com.fyb.production.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
@RestController
@RequestMapping("/production/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public CommonResult<List<Product>> listAll(){
        List<Product> list = productService.list();
        if (list.size()==0){
            return CommonResult.failed();
        }
        return CommonResult.success(list);
    }

}
