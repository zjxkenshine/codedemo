package com.kenshine.hasorcore.test06_life;

import com.kenshine.hasorcore.test05_scope.MyModule;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Init;

/**
 * 生命周期初始化 方式一
 * @author kenshine
 */
public class PojoBean {
    @Init
    public void init(){
        System.out.println("PojoBean初始化");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        appContext.getInstance(PojoBean.class);
    }
}