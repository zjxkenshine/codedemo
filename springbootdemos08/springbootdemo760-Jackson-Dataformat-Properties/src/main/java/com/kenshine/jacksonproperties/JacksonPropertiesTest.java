package com.kenshine.jacksonproperties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import org.junit.Test;

import java.io.File;

/**
 * @author by kenshine
 * @Classname JacksonPropertiesTest
 * @Description 使用测试
 * @Date 2024-03-29 10:32
 * @modified By：
 * @version: 1.0$
 */
public class JacksonPropertiesTest {

    /**
     * 生成与读取properties字符串
     */
    @Test
    public void test01(){
        ObjectMapper mapper = new JavaPropsMapper();
        try {
            //生成properties字符串
            String props=mapper.writeValueAsString(new User(1, "kenshine",new Address("A","aaaa")));
            System.out.println(props);
            //读取properties字符串
            User user = mapper.readValue(props,User.class);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 生成与读取properties文件
     */
    @Test
    public void test02(){
        ObjectMapper mapper = new JavaPropsMapper();
        try {
            //生成properties字符串
            mapper.writeValue(new File("properties\\test.properties"),new User(1, "kenshine",new Address("A","aaaa")));
            //读取properties字符串
            User user = mapper.readValue(new File("properties\\test.properties"),User.class);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 与yaml互转
     */
    @Test
    public void test03(){
        TransferUtils.properties2Yaml("properties\\test.properties","properties\\test.yaml");
        TransferUtils.yml2Properties("properties\\test.yaml");
    }


}
