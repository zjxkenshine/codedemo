package com.kenshine.buildtest.test;

import fi.luontola.buildtest.PartiallyParameterized;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname UserTest
 * @Description 参数化测试
 * @Date 2023-12-16 9:49
 * @modified By：
 * @version: 1.0$
 */
public class UserTest {
    @PartiallyParameterized.NonParameterized
    public static String getName(){
        return "kenshine";
    }

    @Parameterized.Parameters
    public static List<String> test(){
        return Arrays.asList("kenshine","test");
    }

    @Test
    public void test01(){
    }
}
