package com.kenshine.immutator;

import com.javax0.immutator.Immutable;
import com.javax0.immutator.ImmutableExtender;
import com.kenshine.immutator.model.User;
import org.junit.Test;

import javax.management.Query;

/**
 * @author by kenshine
 * @Classname ImmutatorTest
 * @Description Immutator转换为不可变对象
 * @Date 2023-12-11 16:13
 * @modified By：
 * @version: 1.0$
 */
public class ImmutatorTest {

    /**
     * Immutable.of转换为不可变对象
     * 加上@Accessors(chain = true)注解后，setName变为流式方法后，失效
     */
    @Test
    public void test01() throws Exception {
        User user = new User();
        user.setName("kenshine");

        User user1 = Immutable.of(user);
        System.out.println(user1.getName());
        // 加上@Accessors(chain = true)注解后，setName变为流式方法后，失效
        // Immutable.of仅支持void方法
        user1.setName("kenshine1");
        System.out.println(user1.getName());
    }

    /**
     * Immutable.of.fluence 转换为不可变对象
     * fluent方法也不能修改对象
     */
    @Test
    public void test02() throws Exception {
        User user = new User();
        user.setName("kenshine");

        User user1 = Immutable.of.fluent(user);
        System.out.println(user1.getName());
        user1.setName("kenshine1");
        System.out.println(user1.getName());
    }

    /**
     * 不满足void方法或者fluent方法，可以修改
     * 需要使用通用方法创建
     * new ImmutableExtender().using(User.class).of(obj)
     */
    @Test
    public void test03() throws Exception {
        User user = new User();
        user.setName("kenshine");
        User user1 = Immutable.of.fluent(user);
        user1.setTrueName("kenshine1");
        System.out.println(user1.getName());
        // 会拒绝User所有方法，包括获取方法
        User user2 = new ImmutableExtender().using(User.class).of(user);
        System.out.println(user2.getName());
        user2.setTrueName("pig");
    }

}
