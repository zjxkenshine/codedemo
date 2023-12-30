package com.kenshine.hasorcore.test03_aop;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.exts.aop.Aop;

/**
 * @author by kenshine
 * @Classname AopBean1
 * @Description 类拦截器
 * @Date 2023-12-30 10:33
 * @modified By：
 * @version: 1.0$
 */
@Aop(SimpleInterceptor.class)
public class AopBean1 {
    public String echo(String sayMessage) {
        System.out.println("echo :" + sayMessage);
        return "echo :" + sayMessage;
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        appContext.getInstance(AopBean.class).echo("kenshine");
    }
}
