package com.kenshine.hasorcore.test04_property;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.aop.PropertyDelegate;
import net.hasor.utils.BeanUtils;

/**
 * @author by kenshine
 * @Classname SimplePropertyDelegate
 * @Description 属性委托
 * @Date 2023-12-30 11:08
 * @modified By：
 * @version: 1.0$
 */
public class SimplePropertyDelegate implements PropertyDelegate {
    private Object value;
    public SimplePropertyDelegate(Object value){
        this.value=value;
    }

    /** 该委托属性的get方法，参数是属性所处的对象 */
    @Override
    public Object get(Object o) {
        System.out.println(o.getClass().getSimpleName());
        return value;
    }

    /** 该委托属性的set方法，第一个参数是属性所处的对象，第二个参数代表设置的新值 */
    @Override
    public void set(Object o, Object o1) {
        System.out.println("设置对象："+o.getClass().getSimpleName());
        System.out.println("设置值："+o1);
        this.value=o1;
    }

    public static void main(String[] args) {
        // 注册两个 Bean 并且共享同一个 name 属性。
        AppContext appContext = Hasor.create().build(apiBinder -> {
            SimplePropertyDelegate delegate = new SimplePropertyDelegate("helloWord");
            apiBinder.bindType(PojoBean1.class).dynamicProperty("name", String.class, delegate);
            apiBinder.bindType(PojoBean2.class).dynamicProperty("name", String.class, delegate);
        });

        // 创建两个 Bean
        PojoBean1 pojoBean1 = appContext.getInstance(PojoBean1.class);
        PojoBean2 pojoBean2 = appContext.getInstance(PojoBean2.class);
        System.out.println(BeanUtils.readProperty(pojoBean1, "name"));
        System.out.println(BeanUtils.readProperty(pojoBean1, "name"));
        BeanUtils.writeProperty(pojoBean1, "name", "newValue");
        System.out.println(BeanUtils.readProperty(pojoBean1, "name"));
        System.out.println(BeanUtils.readProperty(pojoBean2, "name"));
    }
}
