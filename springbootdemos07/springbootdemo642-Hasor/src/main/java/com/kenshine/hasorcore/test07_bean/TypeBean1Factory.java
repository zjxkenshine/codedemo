package com.kenshine.hasorcore.test07_bean;

import java.util.function.Supplier;

/**
 *
 * @author kenshine
 */
public class TypeBean1Factory implements Supplier<TypeBean1> {
    private TypeBean1 target = new TypeBean1();

    @Override
    public TypeBean1 get() {
        //工厂方式创建 TypeBean1
        return target;
    }
}