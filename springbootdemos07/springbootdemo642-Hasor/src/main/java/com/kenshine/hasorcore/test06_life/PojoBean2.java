package com.kenshine.hasorcore.test06_life;

import net.hasor.core.*;

/**
 * @author by kenshine
 * @Classname PojoBean2
 * @Description 注解启动创建bean
 * @Date 2023-12-30 13:44
 * @modified By：
 * @version: 1.0$
 */
@Singleton
public class PojoBean2 {
    @Init
    public void init(){
        System.out.println("PojoBean2创建");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule1());
        appContext.getInstance(PojoBean2.class);
    }
}


