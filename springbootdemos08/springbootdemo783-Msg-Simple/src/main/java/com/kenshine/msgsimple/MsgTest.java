package com.kenshine.msgsimple;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;

import java.util.Locale;

/**
 * @author by kenshine
 * @Classname MsgTest
 * @Description msg-simple简单使用
 * @Date 2024-04-21 8:47
 * @modified By：
 * @version: 1.0$
 */
public class MsgTest {
    public static void main(String[] args) {
        // PropertiesBundle .properties文件需要为UTF-8格式
        MessageBundle bundle = PropertiesBundle.forPath("msg/test.properties");
        // 使用MessageBundle
        String a=bundle.getMessage("key");
        String b=bundle.getMessage(Locale.CHINA, "key");
        String c=bundle.getMessage(Locale.ENGLISH, "key");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
