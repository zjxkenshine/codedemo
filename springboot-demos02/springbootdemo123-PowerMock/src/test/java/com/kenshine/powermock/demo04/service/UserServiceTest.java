package com.kenshine.powermock.demo04.service;

import com.kenshine.powermock.demo04.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 10:42
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
@PowerMockIgnore("javax.management.*")
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);

        UserService userService = new UserService(userDao);
        int result = userService.queryUserCount();

        assertEquals(10,result);
    }
}