package com.fyb.production.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fyb.production.common.CommonPage;
import com.fyb.production.common.CommonResult;
import com.fyb.production.common.Const;
import com.fyb.production.dto.UserPageParam;
import com.fyb.production.dto.UserParam;
import com.fyb.production.entity.User;
import com.fyb.production.service.IUserService;
import com.fyb.production.util.MD5Util;
import com.fyb.production.vo.UserVo;
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
    public CommonResult<CommonPage<UserVo>> queryAllUsers(@Valid UserPageParam userPageParam){
        Page<UserVo> userPage = new Page<>();
        userPage.setSize(userPageParam.getPageSize());
        userPage.setCurrent(userPageParam.getPageNum());
        IPage<UserVo> pageResult = userService.pageQueryAllUsers(userPage,userPageParam.getQuery());
        CommonPage<UserVo> userCommonPage = CommonPage.restPage(pageResult);
        CommonResult<CommonPage<UserVo>> success = CommonResult.success(userCommonPage);
        return success;
    }
    //根据id查询用户信息
    @GetMapping("/users/{userId}")
    public  CommonResult<User> queryUserById(@PathVariable Integer userId){
        User user = userService.getById(userId);
        if(null!=user){
            user.setPassword(null);
            return CommonResult.success(user);
        }
        return CommonResult.failed();
    }
    //根据id修改用户信息
    @PutMapping("/users")
    public  CommonResult<User> updateUserById(@RequestBody User user){
        boolean update = userService.updateById(user);
        if(update){
           return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    //登录
    @PostMapping("/login")
    public CommonResult<User> login(@RequestBody UserParam userParam, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userParam.getUsername()).eq("password",
                MD5Util.encode(userParam.getPassword()));
        User userInfo = userService.getOne(queryWrapper);
        if(null!=userInfo){
            userInfo.setPassword(null);
            session.setAttribute(Const.CURRENT_USER,userInfo);
            CommonResult<User> success = CommonResult.success(userInfo);
            return success;
        }
        CommonResult<User> failed = CommonResult.failed();
        return failed;
    }

    //添加用户
    @PostMapping("/add")
    public CommonResult<User> addUser(@RequestBody User user ){
        user.setPassword(MD5Util.encode(user.getPassword()));
        user.setRoleId(3);
        boolean save = userService.save(user);
        if (save){
            return  CommonResult.success(user.setPassword(null));
        }else {
            return CommonResult.failed();
        }
    }

    //更新状态
    @PutMapping("/{userId}/state/{state}")
    public CommonResult<User> updateUserState(@PathVariable Integer userId, @PathVariable Boolean state){
        User user = new User();
        user.setId(userId);
        user.setIsAlive(state);
        boolean update = userService.updateById(user);
        if (update){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

}
