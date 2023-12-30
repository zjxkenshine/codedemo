package com.kenshine.hasorcore.test03_aop;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.exts.aop.Aop;

/**
 * @author by kenshine
 * @Classname AopBean3
 * @Description 多拦截器
 * @Date 2023-12-30 10:40
 * @modified By：
 * @version: 1.0$
 */
@Aop({SimpleInterceptorA.class, SimpleInterceptorB.class })
public class AopBean2 {

    @Aop(SimpleInterceptor.class)
    public String echo(String sayMessage) {
        return "echo :" + sayMessage;
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        appContext.getInstance(AopBean2.class).echo("kenshine");
    }
}
