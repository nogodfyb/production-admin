package com.fyb.production.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Rights;
import com.fyb.production.service.IRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/production/rights")
public class RightsController {

    @Autowired
    private IRightsService rightsService;

    //列表形式查出所有权限
    @GetMapping("/list")
    public CommonResult<List<Rights>> queryAllRightsList(){
        QueryWrapper<Rights> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("level");
        List<Rights> list = rightsService.list(queryWrapper);
        if(list.size()!=0){
            return CommonResult.success(list);
        }
        return CommonResult.failed();
    }
    //树状形式查出所有权限
    @GetMapping("/tree")
    public CommonResult<List<Rights>> queryAllRightsTree(){
        QueryWrapper<Rights> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id");
        queryWrapper.orderByAsc("level");
        List<Object> objectList = rightsService.listObjs(queryWrapper);
        List<Integer> idList = (List<Integer>) (List<?>) objectList;
        if(idList.size()!=0){
            ArrayList<Rights> treeList = rightsService.getAllRightsTree(idList);
            return CommonResult.success(treeList);
        }
        return CommonResult.failed();
    }


}
