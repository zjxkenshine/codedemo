package com.kenshine.powermock.demo07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testFindWithAnswer() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName(Mockito.anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                String arg = (String) invocationOnMock.getArguments()[0];
                switch (arg){
                    case "kenshine":
                        return "kenshine1";
                    case "qin":
                        return "qin1";
                    default:
                        throw new RuntimeException("Not support "+arg);
                }
            }
        });

        UserService userService = new UserService();
        assertEquals("kenshine1",userService.queryByName("kenshine"));
        assertEquals("qin1",userService.queryByName("qin"));
    }



}
