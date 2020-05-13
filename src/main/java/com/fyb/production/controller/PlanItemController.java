package com.fyb.production.controller;


import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.service.IPlanItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-13
 */
@RestController
@RequestMapping("/production/plan-item")
public class PlanItemController {
    
    @Autowired
    private IPlanItemService planItemService;
    
    //添加计划
    @PostMapping("/add")
    public CommonResult<PlanItem> addPlan(@RequestBody @Valid PlanItem planItem){
        boolean save = planItemService.save(planItem);
        if(save){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }


}
