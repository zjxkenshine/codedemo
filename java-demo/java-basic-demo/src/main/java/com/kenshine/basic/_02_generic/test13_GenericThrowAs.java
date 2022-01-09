package com.kenshine.basic._02_generic;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 12:47
 * @description：非受检异常
 * @modified By：
 * @version: $
 */
public class test13_GenericThrowAs {

    //泛型非受检异常 可以将异常转换为非受检异常 RuntimeException
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T{
        throw (T) e;
    }

    public static void main(String[] args) {

        //使用方式
        test13_GenericThrowAs.<RuntimeException>throwAs(new Exception("这是异常"));
    }

}
