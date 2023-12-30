package com.kenshine.hasorcore.test07_bean;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;

import java.util.function.Supplier;

/**
 * 委托方式创建Bean
 * @author kenshine
 */
public class TypeBean2Factory implements Supplier<TypeBean2> {
    private TypeBean2 target = new TypeBean2();

    @Override
    public TypeBean2 get() {
        //工厂方式创建 TypeBean2
        return target;
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(apiBinder -> {
            // .创建工厂
            TypeBean1Factory factory1 = new TypeBean1Factory();
            TypeBean2Factory factory2 = new TypeBean2Factory();
            // .注册 Bean，并指明工厂
            apiBinder.bindType(TypeBean1.class).toProvider(factory1);
            apiBinder.bindType(TypeBean2.class).toProvider(factory2);
        });

        // .工厂方式创建 Bean
        TypeBean1 typeBean1 = appContext.getInstance(TypeBean1.class);
        TypeBean2 typeBean2 = appContext.getInstance(TypeBean2.class);
    }
}