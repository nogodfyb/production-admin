package com.fyb.production.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fyb.production.common.CommonPage;
import com.fyb.production.common.CommonResult;
import com.fyb.production.dto.UserPageParam;
import com.fyb.production.entity.MachinePlan;
import com.fyb.production.service.IMachinePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/production/machine-plan")
public class MachinePlanController {

    @Autowired
    private IMachinePlanService machinePlanService;

    //分页查询
    @GetMapping("/list")
    public CommonResult<CommonPage<MachinePlan>> pageList(@Valid UserPageParam userPageParam){
        Page<MachinePlan> machinePlanPage = new Page<>();
        machinePlanPage.setCurrent(userPageParam.getPageNum());
        machinePlanPage.setSize(userPageParam.getPageSize());
        Page<MachinePlan> pageResult = machinePlanService.page(machinePlanPage);
        CommonPage<MachinePlan> commonPage = CommonPage.restPage(pageResult);
        return CommonResult.success(commonPage);
    }

}
