package com.fyb.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fyb.production.common.CommonResult;
import com.fyb.production.entity.Productivity;
import com.fyb.production.mapper.ProductivityMapper;
import com.fyb.production.service.IProductivityService;
import com.fyb.production.vo.ProductivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fyb
 * @since 2020-05-12
 */
@Service
public class ProductivityServiceImpl extends ServiceImpl<ProductivityMapper, Productivity> implements IProductivityService {
    @Autowired
    private ProductivityMapper productivityMapper;

    @Override
    public CommonResult<List<ProductivityVo>> queryAllProductivityVo(){
        List<ProductivityVo> productivityVos = productivityMapper.queryAllProductivityVo();
        if (productivityVos.size()!=0){
            return CommonResult.success(productivityVos);
        }
        return CommonResult.failed();
    }

    @Override
    public void generateProductionPlansByProductivity(Integer planItemId, Integer productCode, Integer productQuantity){

/*        //根据产品id获取36台机器的产能
        QueryWrapper<Productivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_code",productCode);
        List<Productivity> productivityList = productivityMapper.selectList(queryWrapper);
        //算出该产品36台机器一天的产能，这里有两种方式，通过mysql的sum，或者java循环遍历相加
        Integer sumDailyProduction=0;
        for (Productivity item:productivityList
             ) {
            sumDailyProduction+=item.getDailyProduction();
        }
        System.out.println(sumDailyProduction);*/
        QueryWrapper<Productivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("sum(daily_production) as total").eq("product_code",productCode);
        Map<String, Object> map = getMap(queryWrapper);
        //单个产品36台机器一天的产能
        BigDecimal total = (BigDecimal) map.get("total");
        //可以将如下个整天排满
        int wholeDays = productQuantity / total.intValue();
        //还剩需要安排多少产量productQuantity-total*wholeDays
        int remainProduction=productQuantity-total.intValue()*wholeDays;
        System.out.println("可以排的整天数:"+wholeDays);
        System.out.println("剩余产量:"+remainProduction);


    }


}
