package com.fyb.production.controller;


import com.fyb.production.common.CommonResult;
import com.fyb.production.service.IProductivityService;
import com.fyb.production.vo.ProductivityVo;
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
@RequestMapping("/production/productivity")
public class ProductivityController {

    @Autowired
    private IProductivityService productivityService;

    @GetMapping("/list")
    public CommonResult<List<ProductivityVo>> list(){
        return productivityService.queryAllProductivityVo();
    }

}
