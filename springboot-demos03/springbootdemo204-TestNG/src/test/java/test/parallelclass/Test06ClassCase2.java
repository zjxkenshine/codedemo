package test.parallelclass;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 10:22
 * @description：方法级别多线程测试
 * @modified By：
 * @version: $
 */
public class Test06ClassCase2 {
    @Test
    public void test21(){
        System.out.println("test21---Thread Id :  " + Thread.currentThread().getId());
    }

    @Test
    public void test22(){
        System.out.println("test22---Thread Id :  " + Thread.currentThread().getId());
    }

    @Test
    public void test23(){
        System.out.println("test23---Thread Id :  " + Thread.currentThread().getId());
    }

}
