package com.kenshine.powermock.demo08;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 13:40
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void testLog(){
        //spy：满足条件用mock，不满足调用真实方法
        UserService userService = PowerMockito.spy(new UserService());
        String arg = "hello";
        PowerMockito.doNothing().when(userService).foo(arg);

        userService.foo("hello");
        //不满足mock条件，调用真实方法
        userService.foo("world");
    }

    @Test
    public void testCheck() throws Exception {
        UserService userService = PowerMockito.spy(new UserService());
        //只有传递kenshine为true，否则抛异常
        PowerMockito.doReturn(true).when(userService,"checkExist","kenshine");
        //私有方法mock测试
        assertTrue(userService.exist("kenshine"));
    }

}
