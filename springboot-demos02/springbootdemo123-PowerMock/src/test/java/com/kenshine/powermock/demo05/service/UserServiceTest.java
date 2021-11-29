package com.kenshine.powermock.demo05.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo05.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 10:55
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    @Test
    public void saveOrUpdate() throws Exception {
        User user = PowerMockito.mock(User.class);

        UserDao userDao = PowerMockito.mock(UserDao.class);

        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.getCount(user)).thenReturn(0);

        UserService userService = new UserService();
        userService.saveOrUpdate(user);

        //verify的用法
        Mockito.verify(userDao).insertUser(user);
        Mockito.verify(userDao,Mockito.never()).updateUser(user);
    }
}