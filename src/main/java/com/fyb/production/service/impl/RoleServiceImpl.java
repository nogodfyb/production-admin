package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Rights;
import com.fyb.production.entity.Role;
import com.fyb.production.entity.RoleRights;
import com.fyb.production.mapper.RoleMapper;
import com.fyb.production.mapper.RoleRightsMapper;
import com.fyb.production.service.IRightsService;
import com.fyb.production.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRightsMapper roleRightsMapper;

    @Autowired
    private IRightsService rightsService;

    @Override
    public CommonResult<List<Role>> getAllRolesTree(){

        List<Role> roles = roleMapper.selectList(null);

        for (Role role:roles
             ) {
            QueryWrapper<RoleRights> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("rights_id");
            queryWrapper.eq("role_id",role.getRoleId());
            List<Object> roleIdList = roleRightsMapper.selectObjs(queryWrapper);
            List<Integer> idList = (List<Integer>) (List<?>) roleIdList;
            if(idList.size()!=0){
                ArrayList<Rights> allRightsTree = rightsService.getAllRightsTree(idList);
                role.setChildren(allRightsTree);
            }
        }
        return CommonResult.success(roles);
    }

}
