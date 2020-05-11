package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fyb.production.entity.User;
import com.fyb.production.mapper.UserMapper;
import com.fyb.production.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public IPage<UserVo> pageQueryAllUsers(Page<UserVo> userPage, String query) {

        IPage<UserVo> userVoIPage = userMapper.selectPageVo(userPage, query);

        return userVoIPage;
    }
}
