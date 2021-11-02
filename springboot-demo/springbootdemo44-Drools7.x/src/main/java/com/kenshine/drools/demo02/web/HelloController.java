package com.kenshine.drools.demo02.web;

import com.kenshine.drools.demo02.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 17:30
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private RuleService ruleService;

    @RequestMapping("/rule")
    public String rule(){
        ruleService.rule();
        return "OK";
    }

}
