package com.kenshine.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:28
 * @description：订单
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Order", description = "订单信息")
public class Order implements Serializable {

    private static final long serialVersionUID = -688022729580581140L;
    @Schema(name = "id", description = "订单id")
    private Long id;
    @Schema(name = "orderNumber", description = "订单编号")
    private String orderNumber;
    @Schema(name = "orderDescription", description = "订单描述")
    private String orderDescription;
    @Schema(name = "userId", description = "订单所属用户id")
    private Long userId;

}
