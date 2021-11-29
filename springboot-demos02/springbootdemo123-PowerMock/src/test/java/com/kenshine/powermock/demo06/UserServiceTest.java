package com.kenshine.powermock.demo06;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 11:08
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void testFind() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName("kenshine")).thenReturn("kenshine");
        UserService userService = new UserService();
        String result = userService.queryByName("kenshine");
        assertEquals("kenshine",result);

        PowerMockito.when(userDao.queryByName("123456")).thenReturn("kenshine");
        String result1 = userService.queryByName("123456");
        assertEquals("kenshine",result1);

        PowerMockito.when(userDao.queryByName("666")).thenReturn("kenshine");
        String result2 = userService.queryByName("666");
        assertEquals("kenshine",result2);
    }

    @Test
    public void testFindWithMatch() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName(argThat(new MyArgumentMatcher()))).thenReturn("kenshine");
        UserService userService = new UserService();
        assertEquals("kenshine",userService.queryByName("666"));
        assertEquals("kenshine",userService.queryByName("kenshine"));
        assertEquals("kenshine",userService.queryByName("123456"));
        assertEquals("kenshine",userService.queryByName("Alex"));
    }

    static class MyArgumentMatcher implements ArgumentMatcher<String> {

        @Override
        public boolean matches(String s) {
            String arg = s;
            switch (arg){
                case "kenshine":
                case "666":
                case "123456":
                case "Alex":
                    return true;
                default:
                    return false;
            }
        }
    }


}
