package com.kenshine.jsonutil;

import io.github.yidasanqian.json.JsonEnum;
import io.github.yidasanqian.json.JsonUtil;
import io.github.yidasanqian.json.TypeReference;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JsonUtilTest
 * @Description 测试
 * @Date 2023-11-01 9:21
 * @modified By：
 * @version: 1.0$
 */
public class JsonUtilTest {
    @Test
    public void test01(){
        JsonUtil.initJson(JsonEnum.JACKSON);
        String json = "[1, 2, 4, 5]";
        List result = JsonUtil.toList(json);
        System.out.println(result);

        json = "[{\"id\": 1,\"username\": \"yidasanqian\"},{\"id\": 2,\"username\": \"yidasanqian2\"}]";
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
        List<User> result1 = JsonUtil.toList(json, typeReference.getType());
        System.out.println(result1);
    }

    @Test
    public void test02(){
        String json = "{\"id\":1, \"username\":\"yidasanqian\"}";
        TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String, Object>>() {};
        Map<Integer,String> result = JsonUtil.toMap(json, typeReference.getType());
        System.out.println(result);
    }
}
