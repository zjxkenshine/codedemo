package com.kenshine.logtube.controller;

import io.github.logtube.Logtube;
import io.github.logtube.core.IEventLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试项目
 * @Date 2024-03-06 9:04
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 日志测试
     */
    @GetMapping("/test01")
    public void test01(){
        IEventLogger logger = Logtube.getLogger(TestController.class);

        // 传统纯文本日志
        logger.info("hello world");

        // 传统纯文本日志（带关键字，生产环境要求 INFO 必须有关键字）
        logger.keyword("关键字1", "关键字2").info("hello world");

        // 使用 extra 字段的结构化日志，需要用 commit() 做结束
        logger.topic("custom-topic").extras("key1", "val1", "key2", "val2").message("hello world").commit();
    }

}
