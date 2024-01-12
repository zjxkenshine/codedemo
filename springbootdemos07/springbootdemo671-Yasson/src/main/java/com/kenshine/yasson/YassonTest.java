package com.kenshine.yasson;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname YassonTest
 * @Description yasson基本使用
 * @Date 2024-01-12 8:35
 * @modified By：
 * @version: 1.0$
 */
public class YassonTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        User user = new User();
        user.setId(1);
        user.setName("KENSHINE");
        Jsonb jsonb=  JsonbBuilder.create();
        String result = jsonb.toJson(user);
        System.out.println(result);
        // 反序列化
        User user1 = jsonb.fromJson(result,User.class);
        System.out.println(user1);
    }

    /**
     * JSONB配置
     */
    @Test
    public void test02(){
        User user = new User();
        user.setId(2);
        user.setName("kenshine");
        JsonbConfig config = new JsonbConfig()
                .withNullValues(true)
                .withFormatting(true);
        // 使用配置进行创建
        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(user);
        System.out.println(result);
        // 反序列化
        User user1 = jsonb.fromJson(result,User.class);
        System.out.println(user1);
    }

    /**
     * 基本类型映射
     */
    @Test
    public void test03(){
        Apartment apartment = new Apartment();
        apartment.setRented(true);
        apartment.setRooms((byte) 4);
        apartment.setPrice(7800000);
        apartment.setId(234L);
        apartment.setLoan(3580000.4f);
        apartment.setArea(432.45);
        apartment.setDistrict('S');
        apartment.setOwnerName("kenshine");

        Jsonb jsonb = JsonbBuilder.create();
        String jsonString = jsonb.toJson(apartment);
        System.out.println(jsonString);
    }
}
