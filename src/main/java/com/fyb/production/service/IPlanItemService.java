package com.fyb.production.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.vo.PlanItemVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fyb
 * @since 2020-05-13
 */
public interface IPlanItemService extends IService<PlanItem> {

    List<PlanItemVo> selectAllPlanItemsVo();

    void generateProductionPlans(List<Integer> planIdList);

    Boolean validateTimeSequence(List<Integer> idList);
}
