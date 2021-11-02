package com.kenshine.drools.demo02.service;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 17:29
 * @description：规则service
 * @modified By：
 * @version: $
 */
@Service
public class RuleService {
    @Autowired
    private KieBase kieBase;

    public void rule(){
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
