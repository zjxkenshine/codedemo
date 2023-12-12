package com.kenshine.redisx.controller;

import com.kenshine.redisx.model.OrderDo;
import org.junit.Test;
import org.noear.redisx.RedisClient;
import org.noear.redisx.plus.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 使用测试
 * @Date 2023-12-12 9:32
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private RedisClient client;

    /**
     * 使用测试
     */
    @GetMapping("/test01")
    public String test01(){
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
        return "success";
    }


    /**
     * bucket 存储桶
     */
    @GetMapping("/test02")
    public String test02() throws InterruptedException {
        //--- bucket 使用
        RedisBucket bucket = client.getBucket();
        //存储
        bucket.store("item:1", "hello", 2);
        //获取
        System.out.println(bucket.get("item:1"));
        //延时
        bucket.delay("item:1", 1);
        Thread.sleep(4 * 1000);
        System.out.println(bucket.get("item:1"));
        return "success";
    }

    /**
     * RedisHash - 哈希表(兼容标准Map接口)
     */
    @GetMapping("/test03")
    public String test03(){
        //--- hash 使用
        RedisHash redisHash = client.getHash("user:121");

        redisHash.put("id", 1);
        redisHash.put("name", "demo");

        OrderDo orderDo = new OrderDo();
        orderDo.setId(10001);
        orderDo.setTraceId("demo");
        orderDo.setNote("test demo");
        redisHash.putAndSerialize("order", orderDo);
        System.out.println(redisHash.getAsInt("id"));

        OrderDo orderDo1 = redisHash.getAndDeserialize("order", OrderDo.class);
        System.out.println(orderDo1);
        OrderDo orderDo2 = redisHash.getAndDeserialize("order", OrderDo.class);
        System.out.println(orderDo2);
        return "success";
    }

    /**
     * RedisId - Id生成器
     */
    @GetMapping("/test04")
    public String test04(){
        //--- id 使用
        RedisId redisId = client.getId("id:user");
        long user_id = 10000 + redisId.generate();
        long order_id = 1000000 + redisId.generate();
        System.out.println(user_id);
        System.out.println(order_id);
        return "success";
    }

    /**
     * RedisLock - 分布式锁
     */
    @GetMapping("/test05")
    public String test05(){
        //--- lock 使用
        if (client.getLock("user:121212").tryLock()) {
            System.out.println("true");
            //业务处理
        } else {
            System.out.println("false");
            //提示：请不要频繁提交
        }
        return "success";
    }

    /**
     * RedisAtomic - 原子数字
     */
    @GetMapping("/test06")
    public String test06(){
        //--- atomic 使用
        RedisAtomic atomic = client.getAtomic("user_count");
        long num = atomic.get();
        System.out.println(num);
        atomic.increment();
        atomic.incrementBy(2);
        System.out.println(atomic.get());
        return "success";
    }

    /**
     * RedisList 列表
     */
    @GetMapping("/test07")
    public void test07(){
        //--- list 使用
        RedisList list = client.getList("list:test");
        list.clear();
        list.add("1");
        list.add("2");
        assert "1".equals(list.get(0));
        assert "2".equals(list.get(1));
        assert list.get(2) == null;
        list.add("3");
        list.add("4");
        assert "3".equals(list.get(2));
        assert "4".equals(list.get(3));
        list.removeAt(3);
        assert list.get(3) == null;
        for (String item : list.getAll()) {
            System.out.println("test_list: " + item);
        }
    }

    /**
     * RedisQueue - 队列
     */
    @GetMapping("test08")
    public void test08(){
        //--- queue 使用
        RedisQueue queue = client.getQueue("queue:test");
        queue.clear();
        queue.add("1");
        queue.add("2");
        assert "1".equals(queue.pop());
        assert "2".equals(queue.pop());
        assert queue.pop() == null;
        queue.add("3");
        queue.add("4");
        assert "3".equals(queue.peek());
        assert "3".equals(queue.peek());
        queue.popAll(item -> {
            System.out.println("test_queue: " + item);
        });
    }

    /**
     *RedisBus - 总线
     */
    @GetMapping("test09")
    public void test09(){
        //--- bus 使用
        RedisBus bus = client.getBus();
        //发消息 （如果没有订阅者，好像消息会白发）
        new Thread(() -> {
            for (int i=0;i<1000;i++) {
                try {
                    Thread.sleep(100);
                    bus.publish("topic:test", "event-" + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //订阅消息（这个函数会卡住线程）
        bus.subscribe((topic, message) -> {
            System.out.println(topic + " = " + message);
        }, "topic:test");
    }
}
