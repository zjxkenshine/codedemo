package com.kenshine.powermock.demo01.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo01.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 8:52
 * @description：
 * @modified By：
 * @version: $
 *
 * PowerMock基本用法
 */
public class UserServiceTest {
    /**
     * 模拟一个Dao对象
     */
    @Mock
    private UserDao userDao;


    /**
     * PowerMock的用法
     */
    @Test
    public void testQueryUserCountWithPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        //录制行为 两种写法
        //PowerMockito.when(uDao.getCount()).thenReturn(10);
        PowerMockito.doReturn(10).when(userDao).getCount();
        UserService service = new UserService(uDao);
        int result = service.queryUserCount();

        assertEquals(10,result);
    }



    /**
     * Mockito的用法
     */
    @Test
   public void testQueryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);

        UserService service = new UserService(userDao);
        //录制行为
        Mockito.when(userDao.getCount()).thenReturn(10);
        int result = service.queryUserCount();

        assertEquals(10,result);
    }


    /**
     * PowerMock测试 saveUser
     */
    @Test
    void saveUser() {
        UserDao uDao = PowerMockito.mock(UserDao.class);

        User user = new User();
        PowerMockito.doNothing().when(uDao).insertUser(user);
        UserService userService = new UserService(uDao);
        userService.saveUser(user);

        //相当于断言 调用过一次insertUser
        Mockito.verify(uDao).insertUser(user);
    }
}