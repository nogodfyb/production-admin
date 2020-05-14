package com.fyb.production.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author fyb
 * @since 2020-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PlanItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 计划批次号
     */
    @NotNull(message = "planNo不能为空")
    private Integer planNo;

    /**
     * 产品id
     */
    @NotNull(message = "productId不能为空")
    private Integer productId;

    /**
     * 产品数量
     */
    @NotNull(message = "productQuantity不能为空")
    private Integer productQuantity;

    /**
     * 起始时间
     */
    @NotNull(message = "startTime不能为空")
    private LocalDate startTime;

    private Boolean isPlan;
}
