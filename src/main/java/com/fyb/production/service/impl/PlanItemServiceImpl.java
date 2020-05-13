package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.mapper.PlanItemMapper;
import com.fyb.production.service.IPlanItemService;
import com.fyb.production.vo.PlanItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-13
 */
@Service
public class PlanItemServiceImpl extends ServiceImpl<PlanItemMapper, PlanItem> implements IPlanItemService {

    @Autowired
    private PlanItemMapper planItemMapper;

    @Override
    public List<PlanItemVo> selectAllPlanItemsVo(){
        List<PlanItemVo> planItemVos = planItemMapper.selectAll();
        return planItemVos;
    }

}
