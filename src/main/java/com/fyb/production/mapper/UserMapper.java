package com.fyb.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fyb.production.entity.User;
import com.fyb.production.vo.UserVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fyb
 * @since 2020-05-09
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<UserVo> selectPageVo(Page<UserVo> page, String query);

}
