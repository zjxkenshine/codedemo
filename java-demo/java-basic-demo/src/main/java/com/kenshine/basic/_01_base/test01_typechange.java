package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 22:06
 * @description：自动类型转换
 * @modified By：
 * @version: $
 *
 * 隐式数据类型转换：
 * 数据范围从小到大（并非字节数相关，float比long范围大）
 *
 */
public class test01_typechange {
    public static void main(String[] args) {
        long num1=100; //int——>long
        double num2=2.5F; //float——>double
        float num3=30L; //long——>float

        /**类型转换编译器优化
         * 对于byte，short，char三种类型来说，如果右侧赋值没有超过范围，javac编译器会自动隐含的补上(byte)，(short)，(char)
         */
        byte a=30; //正确
        char b=65; //正确

        /**
         * 右侧表达式全是常量，没有变量，javac会直接将若干个常量表达式直接计算得到结果：（编译器的常量优化）
         */
        short a1=1; short b1=2;
        //short result1=a1+b1; //错误
        short result2=1+2; //正确，short result2=3;
    }
}
