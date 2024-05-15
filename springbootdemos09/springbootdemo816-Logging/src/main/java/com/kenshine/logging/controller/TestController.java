package com.kenshine.logging.controller;

import idea.verlif.spring.logging.LogLevel;
import idea.verlif.spring.logging.LogService;
import idea.verlif.spring.logging.api.LogIt;
import idea.verlif.spring.logging.api.impl.DefaultApiLogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 日志测试
 * @Date 2024-05-15 8:41
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private LogService logService;

    /**
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public void test01(){
        logService.debug("debug");
        logService.info("info");
        logService.warn("warn");
        logService.error("error");
        logService.log(LogLevel.INFO, "info");
    }

    /**
     * 在api方法上或是controller类上标记@LogIt注解（方法上的注解优先于类上的注解），即可完成此接口访问或是其下所有接口的访问日志接入。
     * 注解的必填项是message，可选项为
     *      type（类型），用于区分日志类型
     *      sync（同步模式），使用当前线程同步调用日志处理器方法。默认true。
     *      order（排序模式），同一个请求会再处理完onLog方法后再执行onReturn方法，仅在sync为false的情况下生效。默认false。
     *      handler（日志处理器），用于选择日志处理方法
     *
     * localhost:8080/test02
     */
    @LogIt(message = "有人登录啦", type = Login.class, handler = DefaultApiLogHandler.class)
    @GetMapping("/test02")
    public void test02(){
    }
}
