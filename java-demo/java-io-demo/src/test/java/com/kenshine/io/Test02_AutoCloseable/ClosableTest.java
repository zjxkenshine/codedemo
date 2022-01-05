package com.kenshine.io.Test02_AutoCloseable;

import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 20:42
 * @description： Closable/Flushable/AutoClosable
 * @modified By：
 * @version: $
 *
 * 1.多Resource AutoClose顺序
 * 2.
 */
public class ClosableTest {

    /**
     * 1.多Resource AutoClose顺序
     *
     * https://zhuanlan.zhihu.com/p/269208361
     * JSR334 jdk9对try-with-resource做了改进
     */
    @Test
    public void test(){
        //try-with-resource
        try(
                MyResource1 resource1 = new MyResource1();
                MyResource2 resource2 = new MyResource2();
        ){
            System.out.println("Try中的内容执行了");
            //有没有这句执行顺序都一样
            throw new Exception("出错了");
        } catch (Exception e) {
            System.out.println("Catch执行了");
        } finally {
            System.out.println("Finally执行了");
        }
    }

}
