package com.kenshine.typetools.demo04;

import net.jodah.typetools.TypeResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 9:02
 * @description：测试4
 * @modified By：
 * @version: $
 */
public class test04 {
    public static void main(String[] args) {

        //多层泛型类型
        Type typeArgs = TypeResolver.reify(Foo.class, Bar.class);

        ParameterizedType paramType = (ParameterizedType) typeArgs;
        //多层取出内部泛型类型
        Type[] actualTypeArgs = paramType.getActualTypeArguments();
        ParameterizedType arg = (ParameterizedType)actualTypeArgs[0];

        //getRawType() 获取外部类型
        assert paramType.getRawType() == Foo.class;
        assert arg.getRawType() == List.class;
        assert arg.getActualTypeArguments()[0] == Integer.class;
    }
}
