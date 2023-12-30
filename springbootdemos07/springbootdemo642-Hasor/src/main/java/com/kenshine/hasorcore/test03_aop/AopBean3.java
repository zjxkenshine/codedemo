package com.kenshine.hasorcore.test03_aop;

import com.kenshine.hasorcore.test02_ioc.FunBean;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.IgnoreProxy;

/**
 * @author by kenshine
 * @Classname AopBean3
 * @Description 忽略动态代理
 * @Date 2023-12-30 10:50
 * @modified By：
 * @version: 1.0$
 */
@IgnoreProxy
public class AopBean3 {

    public void test(){
        System.out.println("忽略动态代理测试");
    }

    public static void main(String[] args) {
        // 全局动态代理
        AppContext appContext = Hasor.create().build(new MyModule());
        // 忽略动态代理
        appContext.getInstance(AopBean3.class).test();
        // 未忽略
        appContext.getInstance(FunBean.class).call();
    }
}
