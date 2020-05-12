package com.fyb.production.vo;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductivityVo {

    /**
     * 机台代码
     */
    private String machineCode;

    /**
     * 日产量
     */
    private Integer dailyProduction;

    //机台信息描述
    private String description;

    //产品名称
    private String name;

    /**
     * 价格，单位/元
     */
    private BigDecimal unitPrice;
}
