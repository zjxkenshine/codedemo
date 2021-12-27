package test.parallelclass;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 10:22
 * @description：方法级别多线程测试
 * @modified By：
 * @version: $
 */
public class Test06ClassCase3 {
    @Test
    public void test31(){
        System.out.println("test31---Thread Id :  " + Thread.currentThread().getId());
    }

    @Test
    public void test32(){
        System.out.println("test32---Thread Id :  " + Thread.currentThread().getId());
    }
    @Test
    public void test33(){
        System.out.println("test33---Thread Id :  " + Thread.currentThread().getId());
    }

}
