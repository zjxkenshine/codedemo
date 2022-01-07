package com.kenshine.scope.demo01;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 9:54
 * @description：
 * @modified By：
 * @version: $
 */
@Component
//@Scope("prototype")
//@Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
public class TestD1 implements TestD{
    public TestD1() {
        System.out.println("TestD1被实例化了");
    }
}
