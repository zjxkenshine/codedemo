package com.kenshine.typetools.demo05;

import net.jodah.typetools.TypeResolver;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 9:09
 * @description：测试05
 * @modified By：
 * @version: $
 */
public class test05 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        //解析字段泛型类型
        Type fieldType = Entity.class.getDeclaredField("id").getGenericType();
        //解析方法泛型类型
        Type mutatorType = Entity.class.getDeclaredMethod("setId", Serializable.class).getGenericParameterTypes()[0];

        assert TypeResolver.resolveRawClass(fieldType, SomeEntity.class) == Long.class;
        assert TypeResolver.resolveRawClass(mutatorType, SomeEntity.class) == Long.class;

    }
}
