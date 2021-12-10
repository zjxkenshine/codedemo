package com.kenshine.jackson.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 9:25
 * @description：
 * @modified By：
 * @version: $
 */
public class JsonUtils {
    public static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 对象转换为json字符串
     * @param obj
     * @return
     */
    @Nullable
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    @Nullable
    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User{
        private String name;
        private Integer age;
    }

    public static void main(String[] args) {
        String json="{\"namge\":\"kenshine\",\"age\":\"21\"}";
        Map<String, String> map = toMap(json, String.class, String.class);
        System.out.println("map:"+map);
        String j="[{\"namge\":\"qin\",\"age\":\"21\"},{\"namge\":\"zax\",\"age\":\"32\"}]";
        List<Map<String, String>> maps = nativeRead(j, new TypeReference<List<Map<String, String>>>() {
        });
        for(Map<String,String> map1:maps){
            System.out.println("map1"+map1);
        }
    }

}
