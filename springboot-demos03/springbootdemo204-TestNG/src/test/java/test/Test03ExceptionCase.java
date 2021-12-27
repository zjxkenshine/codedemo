package test;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 9:38
 * @description：TestNG预期异常
 * @modified By：
 * @version: $
 */
public class Test03ExceptionCase {
    //没有预期异常 失败
    @Test
    public void testcase1(){
        throw new RuntimeException();
    }

    // 有预期异常，但是测试方法没有抛出该异常 失败
    @Test(expectedExceptions = RuntimeException.class)
    public void testcase2(){
        System.out.println("这是一个失败的异常测试");
    }

    // 有预期异常，且测试方法抛出了该异常 成功
    @Test(expectedExceptions = RuntimeException.class)
    public void testcase3(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
