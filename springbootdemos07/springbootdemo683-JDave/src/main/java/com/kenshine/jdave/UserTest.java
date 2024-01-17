package com.kenshine.jdave;

import com.kenshine.jdave.model.User;
import jdave.Group;
import jdave.Specification;
import jdave.junit4.JDaveRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


/**
 * @author by kenshine
 * @Classname UserTest
 * @Description 用户测试
 * @Date 2024-01-17 10:47
 * @modified By：
 * @version: 1.0$
 */
@RunWith(JDaveRunner.class)
@Group("user")
public class UserTest extends Specification<User> {

    @Test
    public void test01(){
        User user = new User();
        user.setId(1);
        user.setName("kenshine");
        // 测试
        specify(user.getName(),contain("kenshine"));
        specify(user.getId(),equal(1));
    }
}
