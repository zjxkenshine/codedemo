package com.kenshine.scope.demo02;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 10:19
 * @description：
 * @modified By：
 * @version: $
 */
public class MyBean {
    @Autowired
    private ScopeProxyBean proxyBean;

    public void test(){
        proxyBean.code();
    }
}
