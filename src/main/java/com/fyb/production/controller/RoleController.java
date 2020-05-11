package com.fyb.production.controller;


import com.fyb.production.common.CommonResult;
import com.fyb.production.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/production/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    // 获取所有角色并附带权限tree
    @GetMapping("/roles")
    public CommonResult getAllRoles(){
      return  roleService.getAllRolesTree();
    }


}
