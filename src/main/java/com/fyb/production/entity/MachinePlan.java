package com.fyb.production.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author fyb
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MachinePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 机台编码
     */
    private String machineCode;

    /**
     * 计划批次号
     */
    private Integer planNo;

    /**
     * 生产日期
     */
    private LocalDate productionDate;

    private String shift;

    /**
     * 计划产量
     */
    private Integer scheduledProduction;

    /**
     * 产品代码
     */
    private String productCode;


}
