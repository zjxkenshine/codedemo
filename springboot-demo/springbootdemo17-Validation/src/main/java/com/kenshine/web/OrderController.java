package com.kenshine.web;

import com.kenshine.domain.Order;
import com.kenshine.response.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:24
 * @description：嵌套校验
 * @modified By：
 * @version: $
 */
@RequestMapping("/order")
@RestController
@Validated
public class OrderController {

    @PostMapping("/save")
    public CommonResult<Order> saveOrder(@RequestBody @Valid Order order) {
        return CommonResult.ok("订单保存成功", order);
    }

}
