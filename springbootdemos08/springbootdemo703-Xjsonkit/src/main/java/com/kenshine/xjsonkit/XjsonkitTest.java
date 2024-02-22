package com.kenshine.xjsonkit;

import cn.zhxu.data.Array;
import cn.zhxu.data.Mapper;
import cn.zhxu.xjson.JsonKit;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname XjsonkitTest
 * @Description 简单使用测试
 * @Date 2024-02-22 17:44
 * @modified By：
 * @version: 1.0$
 */
public class XjsonkitTest {

    /**
     * toMapper 转换为Mapper
     */
    @Test
    public void test01(){
        String json = "{\"name\":\"Jack\",\"age\":20}";
        // 转换为具有映射结构的 Mapper 对象
        Mapper mapper = JsonKit.toMapper(json);

        // 第一层的键集合大小
        int size = mapper.size();
        // 第一层的键值集合
        Set<String> keys = mapper.keySet();
        // 按键名访问 String 属性
        String name = mapper.getString("name");
        // 按键名访问 int 属性
        int age = mapper.getInt("age");
        // 遍历 Mapper 对象
        mapper.forEach((key, data) -> {
            // 依次输出 name 和 age
            System.out.println(key);
            // 依次输出 Jack 和 20
            System.out.println(data);
        });

        // 输出 {"name":"Jack","age":20}
        System.out.println(mapper);
    }

    /**
     * toArray 转数组
     */
    @Test
    public void test02(){
        String json = "[20,{\"name\":\"Jack\"},\"JsonKit\"]";
        // 转换为具有数组结构的 Array 对象
        Array array = JsonKit.toArray(json);
        // 按下标获取 Mapper 数据
        Mapper mapper = array.getMapper(1);
        // 按下标获取 String 数据
        String string = array.getString(2);
        // 遍历 Array 对象
        array.forEach(((index, data) -> {
            System.out.println(index);          // 依次输出 0、 1 和 2
            System.out.println(data);           // 依次输出 20、 {"name":"Jack"} 和 JsonKit
        }));
        System.out.println(array);
    }

    /**
     * toBean 转对象
     */
    @Test
    public void test03(){
        String json = "{\"name\":\"Jack\",\"age\":20}";
        // 根据类型 转换为 Java Bean
        User user = JsonKit.toBean(User.class, json);
        System.out.println(user);
    }

    /**
     * toList 转list
     */
    @Test
    public void test04(){
        String json = "[{\"name\":\"Jack\",\"age\":20}, {\"name\":\"Tom\",\"age\":21}]";
        // 根据类型 转换为 Java List
        List<User> list = JsonKit.toList(User.class, json);
        System.out.println(list);
    }

    /**
     * 转json
     */
    @Test
    public void test05(){
        User user = new User();
        user.setName("Jack");
        user.setAge(20);

        String json = JsonKit.toJson(user);
        System.out.println(json);
    }
}
