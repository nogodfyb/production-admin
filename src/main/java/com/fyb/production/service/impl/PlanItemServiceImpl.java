package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.entity.PlanItem;
import com.fyb.production.mapper.PlanItemMapper;
import com.fyb.production.service.IPlanItemService;
import com.fyb.production.service.IProductivityService;
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

    @Autowired
    private IProductivityService productivityService;

    @Override
    public List<PlanItemVo> selectAllPlanItemsVo(){
        List<PlanItemVo> planItemVos = planItemMapper.selectAll();
        return planItemVos;
    }

    @Override
    public void generateProductionPlans(List<Integer> planIdList){
        List<PlanItem> planItems = planItemMapper.selectBatchIds(planIdList);
        //可以根据Index索引位置对半分配机台生产计划，目前暂不采用
        for (int i = 0; i <planItems.size() ; i++) {
                //获取productItemId
                Integer id = planItems.get(i).getId();
                //获取产品id
                Integer productId = planItems.get(i).getProductId();
                //获取产品计划生产数量
                Integer productQuantity = planItems.get(i).getProductQuantity();
                productivityService.generateProductionPlansByProductivity(id,productId,productQuantity);
        }
    }

}
