package com.kenshine.javafaker;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Locale;

/**
 * @author by kenshine
 * @Classname FakerTest
 * @Description fake数据生成
 * @Date 2023-12-22 9:27
 * @modified By：
 * @version: 1.0$
 */
public class FakerTest{
    /**
     * 随机数据生成
     */
    @Test
    public void test01(){
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();
        System.out.println(name);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(streetAddress);
    }

    /**
     *  本地化 仅部分数据支持中文
     */
    @Test
    public void test02(){
        Faker faker = new Faker(new Locale("zh-CN"));
        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String animal = faker.animal().name();
        String weather = faker.weather().description();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String company = faker.company().name();
        String color = faker.color().name();
        String country = faker.country().name();
        System.out.println(name);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(animal);
        System.out.println(weather);
        System.out.println(phoneNumber);
        System.out.println(company);
        System.out.println(color);
        System.out.println(country);
    }


}
