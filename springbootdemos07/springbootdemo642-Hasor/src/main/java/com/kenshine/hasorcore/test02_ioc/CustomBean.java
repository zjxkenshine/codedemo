package com.kenshine.hasorcore.test02_ioc;

import net.hasor.core.AppContext;
import net.hasor.core.ConstructorBy;
import net.hasor.core.Hasor;
import net.hasor.core.Inject;

/**
 * @author by kenshine
 * @Classname CustomBean
 * @Description 构造注入
 * @Date 2023-12-30 10:03
 * @modified By：
 * @version: 1.0$
 */
public class CustomBean {
    // funbean中有且仅有一个无参构造函数，可以注入
    private FunBean funBean;


    @ConstructorBy
    public CustomBean(@Inject() FunBean funBean) {
        this.funBean = funBean;
    }

    public void callFoo() {
        this.funBean.call();
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        CustomBean myBean = appContext.getInstance(CustomBean.class);
        myBean.callFoo();
    }
}
