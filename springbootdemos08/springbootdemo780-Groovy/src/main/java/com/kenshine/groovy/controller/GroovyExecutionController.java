package com.kenshine.groovy.controller;

import com.kenshine.groovy.service.GroovyScriptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname GroovyExecutionController
 * @Description 测试执行外部groovy
 * @Date 2024-04-19 13:26
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class GroovyExecutionController {

    @Resource
    private GroovyScriptService groovyScriptService;

    /**
     * 路径下脚本文件执行
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public String test01() throws IllegalAccessException, IOException, InstantiationException {
        groovyScriptService.executeScript("D:\\Github\\codedemo\\springbootdemos08\\springbootdemo780-Groovy\\src\\main\\resources\\scripts\\RuleScript.groovy");
        return "success!";
    }

    /**
     * 资源文件下脚本执行
     * localhost:8080/test02
     */
    @GetMapping("/test02")
    public String test02() throws IllegalAccessException, IOException, InstantiationException {
        groovyScriptService.executeScriptFromResource("scripts\\RuleScript.groovy");
        return "success!";
    }
}
