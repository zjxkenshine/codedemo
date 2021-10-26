package com.kenshine.controller.other;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:14
 * @description：测试接口
 * @modified By：
 * @version: $
 */
@Api(value = "TestController", tags = "简单测试", description = "用于简单测试的API")
@RequestMapping("/test")
@RestController
public class TestController {

    @ApiOperation(value = "hello", notes = "一个简单的测试接口")
    @ApiImplicitParam(value = "名称", name = "name", required = true, defaultValue = "world")
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return "hello " + name;
    }

}
