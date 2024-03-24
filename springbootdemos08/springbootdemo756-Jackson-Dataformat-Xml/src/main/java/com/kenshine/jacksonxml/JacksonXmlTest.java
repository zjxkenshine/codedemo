package com.kenshine.jacksonxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname JacksonXmlTest
 * @Description Jaconson XML 测试
 * @Date 2024-03-24 10:01
 * @modified By：
 * @version: 1.0$
 */
public class JacksonXmlTest {

    /**
     * 写XML
     */
    @Test
    public void test01() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        User user = new User();
        user.setAge(18);
        user.setName("kenshine");
        String xml = objectMapper.writeValueAsString(user);
        System.out.println(xml);
    }

    /**
     * 读XML
     */
    @Test
    public void test02() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        User user = objectMapper.readValue("<User><name>kenshine</name><age>18</age></User>", User.class);
        System.out.println(user);
    }

    /**
     * jackson通用注解
     */
    @Test
    public void test03() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        Person person = new Person(1, "kenshine", 18, "note");
        String xml = objectMapper.writeValueAsString(person);
        System.out.println(xml);
    }

    /**
     * JacksonXmlProperty 控制渲染元素的一些细节属性
     */
    @Test
    public void test04() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        Person1 person = new Person1("1", "kenshine1", "JacksonXmlProperty");
        String xml = objectMapper.writeValueAsString(person);
        System.out.println(xml);
    }

    /**
     * JacksonXmlRootElement 根元素处理
     */
    @Test
    public void test05() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        Person2 person = new Person2("2", "kenshine2", "JacksonXmlProperty");
        String xml = objectMapper.writeValueAsString(person);
        System.out.println(xml);
    }

    /**
     * @JacksonXmlCData 注释
     * @JacksonXmlText 文本
     */
    @Test
    public void test06() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        Person3 person = new Person3("2", "kenshine2", "JacksonXmlProperty");
        String xml = objectMapper.writeValueAsString(person);
        System.out.println(xml);
    }

    /**
     * @JacksonXmlElementWrapper 包装元素
     */
    @Test
    public void test07() throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        Wrapper wrapper = new Wrapper(Arrays.asList("kenshine","lin","qin"));
        String xml = objectMapper.writeValueAsString(wrapper);
        System.out.println(xml);
    }


}
