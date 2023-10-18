package com.kenshine.classmate;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname Test01
 * @Descriptio 测试1
 * @Date 2023-10-18 10:21
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {
    public class StringIntMap extends HashMap<String,Integer> { }

    @Test
    public void test01(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType type = typeResolver.resolve(StringIntMap.class);

        // 多个泛型参数
        List<ResolvedType> mapParams = type.typeParametersFor(Map.class);
        ResolvedType keyType = mapParams.get(0);    //String
        ResolvedType valueType = mapParams.get(1);      //Integer

        System.out.println(type);
        System.out.println(keyType);
        System.out.println(valueType);
    }


}
