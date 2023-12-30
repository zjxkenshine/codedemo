package com.kenshine.hasorcore.test06_life;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;

/**
 * @author by kenshine
 * @Classname PojoBean1
 * @Description 初始化方式2
 * @Date 2023-12-30 13:39
 * @modified By：
 * @version: 1.0$
 */
public class PojoBean1 {
    public void init(){
        System.out.println("PojoBean1初始化");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule());
        appContext.getInstance(PojoBean1.class);
    }
}
