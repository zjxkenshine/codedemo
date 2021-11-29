package com.kenshine.powermock.demo02.service;

import com.kenshine.powermock.common.User;
import com.kenshine.powermock.demo02.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 9:16
 * @description：
 * @modified By：
 * @version: $
 *
 * 注意需要这几个注解
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
@PowerMockIgnore("javax.management.*")
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        try {
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);

            whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();
            int result = userService.queryUserCount();
            //断言
            assertEquals(10,result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSaveUser() {
        try{
            User user = new User();
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);

            whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            doNothing().when(userDao).insertUser(user);
            userService.saveUser(user);

            Mockito.verify(userDao, Mockito.times(1)).insertUser(user);
        }catch (Exception e){
           fail();
        }
    }
}






