package com.kenshine.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:10
 * @description：订单信息
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Order", description = "订单信息")
public class Order implements Serializable {
    private static final long serialVersionUID = -8338268688999888461L;

    @ApiModelProperty(value = "订单id")
    private Long id;
    @ApiModelProperty(value = "订单编号")
    private String orderNumber;
    @ApiModelProperty(value = "订单描述")
    private String orderDescription;
    @ApiModelProperty(value = "订单所属用户id")
    private Long userId;

}
