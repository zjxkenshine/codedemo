package test;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 10:15
 * @description：多线程测试
 * @modified By：
 * @version: $
 */
public class Test06ParallelCase {

    //threadPoolSize为线程池内可以使用的线程数
    //使用threadPoolSize个线程，将test方法执行invocationCount次
    //timeOut配置的是每次执行该测试方法所耗费时间的阈值，超过阈值则测试失败
    @Test(invocationCount = 10, threadPoolSize = 3,timeOut = 1000)
    public void test(){
        System.out.println("hello");
        System.out.println("Thread Id: " + Thread.currentThread().getId());
    }


    /**
     * xml方式
     */
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
