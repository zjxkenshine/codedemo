package com.kenshine.hasorcore.test06_life;

import net.hasor.core.AppContext;
import net.hasor.core.Destroy;
import net.hasor.core.Hasor;
import net.hasor.core.Singleton;

/**
 * @author by kenshine
 * @Classname PojoBean4
 * @Description 销毁bean
 * @Date 2023-12-30 13:50
 * @modified By：
 * @version: 1.0$
 */
@Singleton
public class PojoBean4 {
    @Destroy
    public void destroy(){
        System.out.println("销毁PojoBean4,注解方式");
    }

    public void destroy1(){
        System.out.println("销毁PojoBean4,代码方式");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule3());
        appContext.getInstance(PojoBean4.class);
    }
}
