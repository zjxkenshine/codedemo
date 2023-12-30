package com.kenshine.hasorcore.test06_life;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;

/**
 * @author by kenshine
 * @Classname PojoBean3
 * @Description 代码启动创建Bean
 * @Date 2023-12-30 13:47
 * @modified By：
 * @version: 1.0$
 */
public class PojoBean3 {
    public void init(){
        System.out.println("PojoBean3创建");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule2());
        appContext.getInstance(PojoBean3.class);
    }
}
