package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:06
 * @description：订单DTO
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class OrderDTO {
    private Long orderId;
    private String orderNumber;
    private String orderDescription;
    private UserDTO userDTO;
}
