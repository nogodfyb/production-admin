package com.fyb.production.service;

import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-11
 */
public interface IRoleService extends IService<Role> {

    CommonResult<List<Role>> getAllRolesTree();
}
