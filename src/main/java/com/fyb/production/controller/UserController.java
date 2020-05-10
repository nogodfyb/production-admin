package com.fyb.production.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fyb.production.common.CommonResult;
import com.fyb.production.common.Const;
import com.fyb.production.dto.UserParam;
import com.fyb.production.entity.User;
import com.fyb.production.service.IUserService;
import com.fyb.production.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fyb
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/production/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public CommonResult<List<User>> queryAllUsers(){
        List<User> userList = userService.list();
        CommonResult<List<User>> success = CommonResult.success(userList);
        return success;
    }

    @PostMapping("/login")
    public CommonResult<User> login(@RequestBody UserParam userParam, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userParam.getUsername()).eq("password",
                MD5Util.encode(userParam.getPassword()));
        User userInfo = userService.getOne(queryWrapper);
        if(userInfo!=null){
            session.setAttribute(Const.CURRENT_USER,userInfo);
            CommonResult<User> success = CommonResult.success(userInfo);
            return success;
        }
        CommonResult<User> failed = CommonResult.failed();
        return failed;
    }

}
