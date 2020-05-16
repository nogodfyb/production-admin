package com.fyb.production.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MachinePlanPageParam {

    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    private String productionDate;
    private Integer PlanNo;
}
