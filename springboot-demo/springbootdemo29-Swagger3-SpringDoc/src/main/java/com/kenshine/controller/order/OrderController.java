package com.kenshine.controller.order;

import com.kenshine.domain.CommonResult;
import com.kenshine.domain.Order;
import com.kenshine.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:32
 * @description：订单接口
 * @modified By：
 * @version: $
 */
@Tag(name = "订单管理", description = "订单的增删改查")
@RequestMapping("/order")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @Operation(summary = "创建订单", description = "根据Order对象保存订单")
    @Parameters(value = {
            @Parameter(name = "id", description = "订单id", required = true, example = "1",
                    schema = @Schema(implementation = Long.class), in = ParameterIn.QUERY),
            @Parameter(name = "orderNumber", description = "订单编号", required = true, example = "780829537365759918",
                    schema = @Schema(implementation = String.class), in = ParameterIn.QUERY),
            @Parameter(name = "OrderDescription", description = "订单描述", required = true, example = "二两牛肉面，微辣，多放点香菜",
                    schema = @Schema(implementation = String.class), in = ParameterIn.QUERY),
            @Parameter(name = "userId", description = "订单所属用户id", required = true, example = "1",
                    schema = @Schema(implementation = Long.class), in = ParameterIn.QUERY)})
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "保存订单成功"),
            @ApiResponse(responseCode = "400", description = "无效参数")})
    @PostMapping("save")
    public CommonResult<Order> saveOrder(@Parameter(hidden = true) Order order) {
        return orderService.saveOrder(order);
    }

    @Operation(summary = "查询所有订单", description = "查询所有订单")
    @ApiResponse(responseCode = "200", description = "查询所有订单成功")
    @GetMapping("/finAll")
    public CommonResult<List<Order>> findOrderAll() {
        return orderService.findOrderAll();
    }

    @Operation(summary = "根据id更新订单", description = "更新指定id订单")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "根据id更新订单成功"),
            @ApiResponse(responseCode = "400", description = "无效参数"),
            @ApiResponse(responseCode = "404", description = "订单不存在")})
    @PutMapping("/updateById")
    public CommonResult<Order>
    updateOrderById(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "订单参数", required = true,
            content = @Content(schema = @Schema(implementation = Order.class))) @RequestBody Order order) {
        return orderService.updateOrderById(order);
    }

    @Operation(summary = "根据id删除订单", description = "删除指定id订单")
    @Parameter(name = "id", description = "订单id", required = true, example = "1")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "根据id删除订单成功"),
            @ApiResponse(responseCode = "400", description = "无效参数"),
            @ApiResponse(responseCode = "404", description = "订单不存在")})
    @DeleteMapping("/deleteById/{id}")
    public CommonResult<Order> deleteOrderById(@PathVariable(value = "id") Long id) {
        return orderService.deleteOrderById(id);
    }

}
