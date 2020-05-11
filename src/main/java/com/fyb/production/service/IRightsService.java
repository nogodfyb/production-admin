package com.fyb.production.service;

import com.fyb.production.entity.Rights;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-11
 */
public interface IRightsService extends IService<Rights> {

    ArrayList<Rights> getAllRightsTree(List<Integer> idList);
}
