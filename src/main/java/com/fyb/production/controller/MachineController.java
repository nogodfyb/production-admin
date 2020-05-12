package com.fyb.production.controller;


import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Machine;
import com.fyb.production.service.IMachineService;
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
@RequestMapping("/production/machine")
public class MachineController {

    @Autowired
    private IMachineService machineService;

    //查询所有机台
    @GetMapping("/list")
    public CommonResult<List<Machine>> queryAllMachines(){
        List<Machine> list = machineService.list();
        if(list.size()==0){
            return CommonResult.failed();
        }
        return CommonResult.success(list);
    }

}
