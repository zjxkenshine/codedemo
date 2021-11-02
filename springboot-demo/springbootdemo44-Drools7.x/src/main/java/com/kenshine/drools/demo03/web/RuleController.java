package com.kenshine.drools.demo03.web;

import com.kenshine.drools.demo03.entity.Calculation;
import com.kenshine.drools.demo03.service.RuleService03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 17:40
 * @description：规则接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService03 ruleService;

    @RequestMapping("/calculate")
    public Calculation calculate(double wage){
        Calculation calculation = new Calculation();
        calculation.setWage(wage);
        calculation = ruleService.calculate(calculation);
        System.out.println(calculation);
        return calculation;
    }
}