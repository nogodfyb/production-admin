package com.fyb.production.controller;


import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.service.IPlanItemService;
import com.fyb.production.vo.PlanItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

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
        LocalDate startTime = planItem.getStartTime();
        LocalDate now = LocalDate.now();
        if(startTime.compareTo(now)<0){
            return CommonResult.failed();
        }
        planItem.setIsPlan(false);
        boolean save = planItemService.save(planItem);
        if(save){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    //查询所有
    @GetMapping("/list")
    public CommonResult<List<PlanItemVo>> selectList(){
        List<PlanItemVo> planItemVos = planItemService.selectAllPlanItemsVo();
        if(planItemVos.size()==0){
            return CommonResult.failed();
        }
        return CommonResult.success(planItemVos);
    }

    //接受生产计划idList，并生成机台计划
    @PostMapping("/generateProductionPlans")
    public CommonResult generateProductionPlans (@RequestBody List<Integer> idList)  {
        planItemService.generateProductionPlans(idList);
        return CommonResult.success(null);
    }


}
