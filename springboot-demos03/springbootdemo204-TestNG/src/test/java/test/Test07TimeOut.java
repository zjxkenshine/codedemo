package test;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 10:29
 * @description：超时测试
 * @modified By：
 * @version: $
 */
public class Test07TimeOut {

    @Test(timeOut = 3000)
    public void test1() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 3000)
    public void test2() throws InterruptedException {
        Thread.sleep(3500);
    }

}
