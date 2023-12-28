package com.kenshine.jmockit;

import com.kenshine.jmockit.mock.HelloJMockit;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 基于行为的mock
 */
@RunWith(JMockit.class)
public class ProgramConstructureTest {

    // 这是一个测试属性
    @Mocked
    HelloJMockit helloJMockit;
 
    @Test
    public void test1() {
        // 录制(Record)
        new Expectations() {
            {
                helloJMockit.sayHello();
                result = "hello,david";
            }
        };
        // 重放(Replay)
        String msg = helloJMockit.sayHello();
        Assert.assertTrue(msg.equals("hello,david"));
        // 验证(Verification)
        new Verifications() {
            {
                helloJMockit.sayHello();
                times = 1;
            }
        };
    }
 
    @Test
    public void test2(@Mocked HelloJMockit helloJMockit /* 这是一个测试参数 */) {
        // 录制(Record)
        new Expectations() {
            {
                helloJMockit.sayHello();
                result = "hello,david";
            }
        };
        // 重放(Replay)
        String msg = helloJMockit.sayHello();
        Assert.assertTrue(msg.equals("hello,david"));
        // 验证(Verification)
        new Verifications() {
            {
                helloJMockit.sayHello();
                times = 1; // 验证helloJMockit.sayHello()这个方法调用了1次
            }
        };
    }
}