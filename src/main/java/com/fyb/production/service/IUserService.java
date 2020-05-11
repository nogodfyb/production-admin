package com.fyb.production.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fyb.production.entity.User;
import com.fyb.production.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-09
 */
public interface IUserService extends IService<User> {


    IPage<UserVo> pageQueryAllUsers(Page<UserVo> userPage, String query);
}
