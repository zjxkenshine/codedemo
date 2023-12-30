package com.kenshine.hasorcore.test04_property;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname PojoBean3
 * @Description 全局动态属性
 * @Date 2023-12-30 11:30
 * @modified By：
 * @version: 1.0$
 */
public class PojoBean3 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        AppContext appContext = Hasor.create().build(apiBinder -> {
            // t -> true 表示对所有类都生效
            apiBinder.dynamicProperty(
                    t -> true,  // 匹配的类，类型为：Predicate<Class<?>>
                    "name",     // 属性名
                    String.class// 属性类型
            );
        });

        // 创建Bean
        PojoBean3 pojoBean = appContext.getInstance(PojoBean3.class);

        // 获取 get/set方法
        Method getMethod = pojoBean.getClass().getMethod("getName");
        Method setMethod = pojoBean.getClass().getMethod("setName", String.class);

        // 反射的方式注入 name 属性
        setMethod.invoke(pojoBean, "Hello");

        // 反射方式获取 name 属性
        System.out.println("data = " + getMethod.invoke(pojoBean));
    }
}
