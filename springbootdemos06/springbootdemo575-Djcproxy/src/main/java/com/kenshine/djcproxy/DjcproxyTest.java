package com.kenshine.djcproxy;

import com.javax0.djcproxy.ProxyFactory;
import com.kenshine.djcproxy.interceptor.UserInterceptor;
import com.kenshine.djcproxy.model.User;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname DjcproxyTest
 * @Description Djcproxy 动态代理测试
 * @Date 2023-12-13 8:44
 * @modified By：
 * @version: 1.0$
 */
public class DjcproxyTest {

    /**
     * 创建用户代理
     */
    @Test
    public void test() throws Exception {
        User a = new User();
        ProxyFactory<User> factory = new ProxyFactory<>();
        User s = factory.create(a, new UserInterceptor());
        s.setName("kenshine");
        System.out.println(s.getName());
    }

}
