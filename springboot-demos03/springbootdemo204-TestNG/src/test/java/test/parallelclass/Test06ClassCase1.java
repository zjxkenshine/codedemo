package test.parallelclass;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 10:22
 * @description：方法级别多线程测试
 * @modified By：
 * @version: $
 */
public class Test06ClassCase1 {
    @Test
    public void test1(){
        System.out.println("test1---Thread Id :  " + Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println("test2---Thread Id :  " + Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println("test3---Thread Id :  " + Thread.currentThread().getId());
    }

}
