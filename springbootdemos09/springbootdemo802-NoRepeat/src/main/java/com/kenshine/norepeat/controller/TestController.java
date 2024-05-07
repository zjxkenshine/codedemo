package com.kenshine.norepeat.controller;

import idea.verlif.spring.norepeat.NoRepeat;
import idea.verlif.spring.norepeat.judgment.RepeatJudgment;
import idea.verlif.spring.norepeat.judgment.impl.DefaultRepeatJudgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试controller
 * @Date 2024-05-07 17:34
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * localhost:8080/test01?test=kenshine
     * @NoRepeat有四个参数：
     * interval - 重复请求间隔时长，单位毫秒。
     * isIgnored - 当判定重复时，当此值为true时，则忽略请求；否则返回message()的值。
     * message - 当判定重复且isIgnored为false时，返回此字符串到客户端。
     * judgment - 指定自定义判定类。默认DefaultRepeatJudgment，自定义需要实现 RepeatJudgment 接口
     */
    @NoRepeat(judgment = DefaultRepeatJudgment.class, interval = 10000, message = "禁止重复提交")
    @GetMapping("/test01")
    public String norepeat1(String test) {
        System.out.println(test);
        return "success";
    }

}
