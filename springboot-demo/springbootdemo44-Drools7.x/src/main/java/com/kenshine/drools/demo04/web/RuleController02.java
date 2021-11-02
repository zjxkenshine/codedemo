package com.kenshine.drools.demo04.web;

import com.kenshine.drools.demo02.service.RuleService;
import com.kenshine.drools.demo04.entity.CreditCardApplyInfo;
import com.kenshine.drools.demo04.service.RuleService04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 18:01
 * @description：规则测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/rule")
public class RuleController02 {
    @Autowired
    private RuleService04 ruleService;

    @RequestMapping("/creditCardApply")
    public CreditCardApplyInfo creditCardApply(@RequestBody CreditCardApplyInfo creditCardApplyInfo){
        creditCardApplyInfo = ruleService.creditCardApply(creditCardApplyInfo);
        return creditCardApplyInfo;
    }

}
