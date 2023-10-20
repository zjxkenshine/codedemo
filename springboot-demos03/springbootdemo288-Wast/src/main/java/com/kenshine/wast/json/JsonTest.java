package com.kenshine.wast.json;

import io.github.wycst.wast.json.JSON;
import io.github.wycst.wast.json.JSONReader;
import io.github.wycst.wast.json.options.WriteOption;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JsonTest
 * @Description json测试
 * @Date 2023-10-20 14:06
 * @modified By：
 * @version: 1.0$
 */
public class JsonTest {
    /**
     * 常用对象json序列化
     */
    @Test
    public void test01(){
        Map map = new HashMap();
        map.put("msg", "hello, light json !");
        String result = JSON.toJsonString(map);
        System.out.println(result);
    }

    /**
     * 对象序列化到文件
     */
    @Test
    public void test02(){
        Map map = new HashMap();
        map.put("msg", "hello, light json !");
        JSON.writeJsonTo(map, new File("E:\\test\\test.json"));
    }

    /**
     * 格式序列化
     */
    @Test
    public void test03(){
        Map map = new HashMap();
        map.put("name", "kenshine");
        map.put("msg", "hello, light json !");
        // WriteOption 序列化配置
        String json =JSON.toJsonString(map, WriteOption.FormatOut);
        System.out.println(json);
    }

    /**
     * 反序列化
     */
    @Test
    public void test04(){
        String json = "{\"msg\":\"hello, light json !\",\"name\":\"kenshine\"}";
        Map map = (Map) JSON.parse(json);
        System.out.println(map);
    }

    /**
     * 指定类型反序列化
     */
    @Test
    public void test05(){
        String json = "{\"msg\":\"hello, light json !\",\"name\":\"kenshine\"}";
        Map map = JSON.parseObject(json, Map.class);
        System.out.println(map);
    }

    /**
     * 基于输入流的读取解析
     */
    @Test
    public void test06() throws IOException {
        Map result = null;

        // 1 读取网络资源 GET
        result = JSON.read(new URL("https://developer.aliyun.com/artifact/aliyunMaven/searchArtifactByGav?groupId=spring&artifactId=&version=&repoId=all&_input_charset=utf-8"), Map.class);
        System.out.println(result);

        // 2 读取输入流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test.json");
        result = JSON.read(inputStream, Map.class);
        System.out.println(result);

        // 3 读取文件
        result = JSON.read(new File("E:\\test\\test.json"), Map.class);
        System.out.println(result);
    }

    /**
     * 基于输入流的按需解析
     */
    @Test
    public void test07(){
        final JSONReader reader = JSONReader.from(new File("E:\\test\\test.json"));
        reader.read(new JSONReader.ReaderCallback(JSONReader.ReadParseMode.ExternalImpl) {
            @Override
            public void parseValue(String key, Object value, Object host, int elementIndex, String path) throws Exception {
                super.parseValue(key, value, host, elementIndex, path);
                if(path.equals("/features/[100000]/properties/STREET")) {
                    // 终止读取;
                    abort();
                }
            }
        }, true);
    }


}
