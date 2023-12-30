package com.kenshine.hasorcore.test02_ioc;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Inject;

/**
 * @author by kenshine
 * @Classname CustomBean2
 * @Description 属性注入
 * @Date 2023-12-30 10:10
 * @modified By：
 * @version: 1.0$
 */
public class CustomBean2 {
    @Inject
    private FunBean funBean;

    public void callFoo(){
        funBean.call();
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        CustomBean2 myBean = appContext.getInstance(CustomBean2.class);
        myBean.callFoo();
    }
}
