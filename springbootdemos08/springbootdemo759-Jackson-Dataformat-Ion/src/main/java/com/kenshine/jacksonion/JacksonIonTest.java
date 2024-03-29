package com.kenshine.jacksonion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.ion.IonObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JacksonIonTest
 * @Description jacksonion 文件测试
 * @Date 2024-03-29 9:48
 * @modified By：
 * @version: 1.0$
 */
public class JacksonIonTest {

    /**
     * ion与java对象互转
     */
    @Test
    public void test01() throws IOException {
        ObjectMapper mapper = new IonObjectMapper();
        User user = new User(1,"kenshine");
        String data = mapper.writeValueAsString(user);
        System.out.println(data);
        byte[] encoded = mapper.writeValueAsBytes(user);
        User user1 = mapper.readValue(encoded, User.class);
        System.out.println(user1);
    }

    /**
     * 输出、读取ion文件
     */
    @Test
    public void test02() throws IOException {
        ObjectMapper mapper = new IonObjectMapper();
        User user = new User(2,"lin");
        mapper.writeValue(new File("ion\\test.ion"),user);
        User user1 = mapper.readValue(new File("ion\\test.ion"), User.class);
        System.out.println(user1);
    }


}
