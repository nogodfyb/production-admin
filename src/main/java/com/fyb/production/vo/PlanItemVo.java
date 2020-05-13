package com.fyb.production.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanItemVo {

    private Integer id;

    private Integer planNo;

    private String name;

    private Integer productQuantity;

    private LocalDate startTime;

}
