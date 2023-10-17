package com.kenshine.jsoniter;

import com.jsoniter.JsonIterator;
import com.jsoniter.ValueType;
import com.jsoniter.any.Any;
import com.jsoniter.output.JsonStream;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname JsoniterTest
 * @Description 测试Jsoniter
 * @Date 2023-10-17 12:24
 * @modified By：
 * @version: 1.0$
 */
public class JsoniterTest {

    // 基本使用
    @Test
    public void test01(){
        String str = JsonStream.serialize(new int[]{1,2,3});
        System.out.println(str);
        int[] a= JsonIterator.deserialize("[1,2,3]", int[].class);
        Arrays.stream(a).forEach(System.out::println);
    }

    // 流式处理解析
    @Test
    public void test02() throws IOException {
        JsonIterator iter = JsonIterator.parse(new BufferedInputStream(new FileInputStream("src/main/java/com/kenshine/jsoniter/a.json")),1024); // input stream
        User user1=new User();
        while(iter.whatIsNext() != ValueType.INVALID) {
            Any users = iter.readAny(); // lazy
            int userId = users.toInt(0); // weakly typed
            System.out.println(userId);
            users.get(0).bindTo(user1); // data binding
        }
        System.out.println(user1);
    }


}
