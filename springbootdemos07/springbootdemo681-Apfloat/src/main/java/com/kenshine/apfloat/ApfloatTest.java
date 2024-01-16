package com.kenshine.apfloat;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author by kenshine
 * @Classname ApfloatTest
 * @Description apfloat使用测试
 * @Date 2024-01-16 8:44
 * @modified By：
 * @version: 1.0$
 */
public class ApfloatTest {

    /**
     * 使用测试1 加减乘除计算
     */
    @Test
    public void test01(){
        // 值，精度
        Apfloat a = new Apfloat(2, 15);
        System.out.println(a);
        Apfloat b = new Apfloat("1.342526234142152",15);
        System.out.println(b);
        // a-b
        System.out.println("a-b="+a.subtract(b));
        // a+b
        System.out.println("a+b="+a.add(b));
        // a*b
        System.out.println("a*b="+a.multiply(b));
        // a/b
        System.out.println("a/b="+a.divide(b));
        // 向上取整
        System.out.println(b.ceil());
        // 向下取整
        System.out.println(b.floor());
    }

    @Test
    public void test02(){
        // 长度，精度与半径
        Apfloat a= new Apfloat(1025, 10, 2);
        System.out.println(a);
    }

    /**
     * ApfMath计算
     */
    @Test
    public void test03(){
        // pi
        System.out.println(ApfloatMath.pi(100));
        // sin
        System.out.println(ApfloatMath.tan(new Apfloat(45,20)));
        // pow
        System.out.println(ApfloatMath.pow(new Apfloat(2,10),2));
    }

    /**
     * 转bigDecimal
     */
    @Test
    public void test04(){
        BigDecimal bigDecimal=BigDecimal.valueOf(new Apfloat("3.141592653589793238462643383279502884197169",10).floatValue());
        System.out.println(bigDecimal);
    }
}
