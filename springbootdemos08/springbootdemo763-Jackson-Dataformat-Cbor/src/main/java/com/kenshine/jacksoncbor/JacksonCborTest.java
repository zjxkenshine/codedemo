package com.kenshine.jacksoncbor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JacksonCborTest
 * @Description 使用测试
 * @Date 2024-04-01 8:38
 * @modified By：
 * @version: 1.0$
 */
public class JacksonCborTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new CBORMapper();
        User user= new User(1,"kenshine",18);
        // 序列化
        byte[] cborData = mapper.writeValueAsBytes(user);
        // 反序列化
        User user1 = mapper.readValue(cborData, User.class);
        System.out.println(user1);
    }
}
