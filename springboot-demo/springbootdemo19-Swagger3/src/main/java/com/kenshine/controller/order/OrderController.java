package com.kenshine.controller.order;

import com.kenshine.domain.CommonResult;
import com.kenshine.domain.Order;
import com.kenshine.service.OrderService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:29
 * @description：订单Controller
 * @modified By：
 * @version: $
 */
@Api(value = "订单模块", tags = "订单管理", description = "订单的增删改查", protocols = "http")
@RequestMapping("/order")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @ApiOperation(value = "创建订单", notes = "根据Order对象保存订单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "订单id", name = "id", required = true, defaultValue = "1", dataTypeClass = Long.class,
                    paramType = "query"),
            @ApiImplicitParam(value = "订单编号", name = "orderNumber", required = true, defaultValue = "780829537365759918",
                    dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(value = "订单描述", name = "orderDescription", required = true, defaultValue = "二两牛肉面，微辣，多放点香菜",
                    dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(value = "订单所属用户id", name = "userId", required = true, defaultValue = "1",
                    dataTypeClass = Long.class, paramType = "query")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "保存订单成功"),
            @ApiResponse(code = 400, message = "无效参数", response = CommonResult.class)})
    @PostMapping("/save")
    public CommonResult<Order> saveOrder(@ApiIgnore Order order) {
        return orderService.saveOrder(order);
    }

    @ApiOperation(value = "查询所有订单", notes = "查询所有订单")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "查询所有订单成功")})
    @GetMapping("/finAll")
    public CommonResult<List<Order>> findOrderAll() {
        return orderService.findOrderAll();
    }

    @ApiOperation(value = "根据id更新订单", notes = "更新指定id订单")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "根据id更新订单成功"),
            @ApiResponse(code = 400, message = "无效参数", response = CommonResult.class),
            @ApiResponse(code = 404, message = "订单不存在", response = CommonResult.class)})
    @PutMapping("/updateById")
    public CommonResult<Order> updateOrderById(@RequestBody Order order) {
        return orderService.updateOrderById(order);
    }

    @ApiOperation(value = "根据id删除订单", notes = "删除指定id订单")
    @ApiImplicitParam(value = "订单id", name = "id", required = true, defaultValue = "1", dataTypeClass = Long.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "根据id删除订单成功"),
            @ApiResponse(code = 400, message = "无效参数", response = CommonResult.class),
            @ApiResponse(code = 404, message = "订单不存在", response = CommonResult.class)})
    @DeleteMapping("/deleteById/{id}")
    public CommonResult<Order> deleteOrderById(@PathVariable(value = "id") Long id) {
        return orderService.deleteOrderById(id);
    }
}
