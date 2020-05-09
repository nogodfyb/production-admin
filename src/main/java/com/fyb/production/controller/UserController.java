package com.fyb.production.controller;


import com.fyb.production.entity.User;
import com.fyb.production.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
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
    public List<User> queryAllUsers(){
        List<User> userList = userService.list();
        return userList;
    }


}
