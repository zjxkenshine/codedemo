package com.kenshine.jacksonsmile;

import com.fasterxml.jackson.dataformat.smile.databind.SmileMapper;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JacksonSmileTest
 * @Description jackson smile测试
 */
public class JacksonSmileTest {

    public static void main(String[] args) throws IOException {
        SmileMapper mapper = new SmileMapper();
        // 序列化与反序列化
        User user = new User(1, "kenshine", 18);
        byte[] smileData = mapper.writeValueAsBytes(user);
        User user1 = mapper.readValue(smileData, User.class);
        System.out.println(user1);
    }
}
