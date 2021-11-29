package com.kenshine.powermock.demo03.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo03.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 9:35
 * @description：
 * @modified By：
 * @version: $
 *
 * 需要在这里加上静态方法所在的类
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class,User.class})
@PowerMockIgnore("javax.management.*")
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        mockStatic(UserDao.class);
        when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int result = userService.queryUserCount();
        assertEquals(10,result);
    }

    /**
     * TODO 2.0.9版本 verifyStatic
     */
    @Test
    public void saveUser() {
        mockStatic(UserDao.class);
        User user = new User();
        doNothing().when(UserDao.class);

        UserService userService = new UserService();
        userService.saveUser(user);

        //测试调用了一次静态方法
        PowerMockito.verifyStatic(UserDao.class);
        UserDao.insertUser(Mockito.any(User.class));
    }
}