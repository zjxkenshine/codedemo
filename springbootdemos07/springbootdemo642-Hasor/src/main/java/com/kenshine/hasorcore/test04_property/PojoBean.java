package com.kenshine.hasorcore.test04_property;

import lombok.Data;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态添加name属性
 * @author kenshine
 */
@Data
public class PojoBean {
    private String uuid;


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 创建容器，并且注册Bean
        AppContext appContext = Hasor.create().build(apiBinder -> {
            // 注册Bean。
            apiBinder.bindType(PojoBean.class)
                    // 增加名称为 name 类型为 String 的属性。以及对应的get/set方法
                    .dynamicProperty("name", String.class);
        });

        // 创建Bean
        PojoBean pojoBean = appContext.getInstance(PojoBean.class);

        // 获取 get/set方法
        Method getMethod = pojoBean.getClass().getMethod("getName");
        Method setMethod = pojoBean.getClass().getMethod("setName", String.class);

        // 反射的方式注入 name 属性
        setMethod.invoke(pojoBean, "Hello");

        // 反射方式获取 name 属性
        System.out.println("data = " + getMethod.invoke(pojoBean));
    }
}