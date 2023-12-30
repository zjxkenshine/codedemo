package com.kenshine.hasorcore.test03_aop;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.exts.aop.Aop;

/**
 * aop使用示例
 * 方法级拦截器
 * @author kenshine
 */
public class AopBean {
    public String print() {
        System.out.println("aop方法");
        return "aopBean";
    }

    @Aop(SimpleInterceptor.class)
    public String echo(String sayMessage) {
        System.out.println("echo :" + sayMessage);
        return "echo :" + sayMessage;
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        appContext.getInstance(AopBean.class).echo("kenshine");
    }
}