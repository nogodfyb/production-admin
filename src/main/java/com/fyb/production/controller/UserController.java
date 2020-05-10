package com.fyb.production.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fyb.production.common.CommonPage;
import com.fyb.production.common.CommonResult;
import com.fyb.production.common.Const;
import com.fyb.production.dto.UserPageParam;
import com.fyb.production.dto.UserParam;
import com.fyb.production.entity.User;
import com.fyb.production.service.IUserService;
import com.fyb.production.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    //分页查询
    @GetMapping("/users")
    public CommonResult<CommonPage<User>> queryAllUsers(@Valid UserPageParam userPageParam){
        Page<User> userPage = new Page<>();
        userPage.setSize(userPageParam.getPageSize());
        userPage.setCurrent(userPageParam.getPageNum());
        Page<User> pageResult = userService.page(userPage);
        CommonPage<User> userCommonPage = CommonPage.restPage(pageResult);
        CommonResult<CommonPage<User>> success = CommonResult.success(userCommonPage);
        return success;
    }

    @PostMapping("/login")
    public CommonResult<User> login(@RequestBody UserParam userParam, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userParam.getUsername()).eq("password",
                MD5Util.encode(userParam.getPassword()));
        User userInfo = userService.getOne(queryWrapper);
        if(userInfo!=null){
            userInfo.setPassword(null);
            session.setAttribute(Const.CURRENT_USER,userInfo);
            CommonResult<User> success = CommonResult.success(userInfo);
            return success;
        }
        CommonResult<User> failed = CommonResult.failed();
        return failed;
    }

    @PostMapping("/add")
    public CommonResult<User> addUser(@RequestBody User user ){
        user.setPassword(MD5Util.encode(user.getPassword()));
        boolean save = userService.save(user);
        if (save){
            return  CommonResult.success(user.setPassword(null));
        }else {
            return CommonResult.failed();
        }
    }



}
