package com.kenshine.msgsimple;

import com.github.fge.msgsimple.source.MapMessageSource;
import com.github.fge.msgsimple.source.MessageSource;
import com.github.fge.msgsimple.source.PropertiesMessageSource;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname MessageSourceTest
 * @Description MessageSource 属性源
 * @Date 2024-04-21 8:59
 * @modified By：
 * @version: 1.0$
 */
public class MessageSourceTest {

    /**
     * 两种构建方式
     * 1. map构建
     * 2. properties文件构建
     */
    public static void main(String[] args) throws IOException {
        //1. map构建
        MessageSource source1 = MapMessageSource.newBuilder()
                .put("key1", "value1").put("key2", "value2")
                .build();
        //2. properties文件构建
        MessageSource source2 = PropertiesMessageSource.fromPath("D:\\Github\\codedemo\\springbootdemos08\\springbootdemo783-Msg-Simple\\src\\main\\resources\\msg\\test.properties");
        System.out.println(source1.getKey("key1"));
        System.out.println(source2.getKey("key"));
    }
}
