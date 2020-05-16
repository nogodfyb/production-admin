package com.fyb.production.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fyb.production.common.CommonPage;
import com.fyb.production.common.CommonResult;
import com.fyb.production.dto.MachinePlanPageParam;
import com.fyb.production.entity.MachinePlan;
import com.fyb.production.service.IMachinePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    public CommonResult<CommonPage<MachinePlan>> pageList(@Valid MachinePlanPageParam pageParam){
        Page<MachinePlan> machinePlanPage = new Page<>();
        machinePlanPage.setCurrent(pageParam.getPageNum());
        machinePlanPage.setSize(pageParam.getPageSize());
        QueryWrapper<MachinePlan> queryWrapper = new QueryWrapper<>();
        if(pageParam.getPlanNo()!=null&& !StringUtils.isEmpty(pageParam.getProductionDate())){
            queryWrapper.eq("production_date",pageParam.getProductionDate()).
                    eq("plan_no",pageParam.getPlanNo());
        }
        if(pageParam.getPlanNo()==null&& !StringUtils.isEmpty(pageParam.getProductionDate())){
            queryWrapper.eq("production_date",pageParam.getProductionDate());
        }
        if(pageParam.getPlanNo()!=null&& StringUtils.isEmpty(pageParam.getProductionDate())){
            queryWrapper.eq("plan_no",pageParam.getPlanNo());
        }
        Page<MachinePlan> pageResult = machinePlanService.page(machinePlanPage,queryWrapper);
        CommonPage<MachinePlan> commonPage = CommonPage.restPage(pageResult);
        return CommonResult.success(commonPage);
    }

}
