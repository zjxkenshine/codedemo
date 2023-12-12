package com.kenshine.redisx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.redisx.RedisClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname DemoTest
 * @Description 使用测试
 * @Date 2023-12-12 9:05
 * @modified By：
 * @version: 1.0$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisxApp.class)
public class DemoTest {

    @Resource
    RedisClient client;

    @Test
    public void test() {
        //写操作:: key().expire().xxx()
        client.open(session -> {
            session.key("order:1").expire(10).set("hello");
        });

        //读操作:: key().xxx();
        String tmp = client.openAndGet(session -> session.key("order:1").get());
        assert tmp != null;

        //写操作:: key().expire().xxx()
        client.open(session -> {
            session.key("user:1").expire(10)
                    .hashSet("name", "kenshine")
                    .hashSet("sex", "1");
        });

        //延时操作:: key().delay()
        client.open(session -> {
            session.key("user_link:1").delay(10);
        });

        assert true;
    }
}
