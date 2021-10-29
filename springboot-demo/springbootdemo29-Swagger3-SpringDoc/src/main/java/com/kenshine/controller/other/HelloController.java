package com.kenshine.controller.other;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:30
 * @description：测试
 * @modified By：
 * @version: $
 */
@Tag(name = "Hello World", description = "用于简单测试的API")
@RequestMapping("/hello")
@RestController
public class HelloController {
    @Operation(summary = "hello", description = "一个简单的测试接口")
    @Parameter(name = "name", description = "名称", required = true, example = "world")
    @GetMapping("/world/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return "hello " + name;
    }
}