package com.kenshine.jmespath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.burt.jmespath.Expression;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.jackson.JacksonRuntime;

/**
 * @author by kenshine
 * @Classname JmesPathTest
 * @Description jmespath使用测试
 * @Date 2023-12-22 15:46
 * @modified By：
 * @version: 1.0$
 */
public class JmesPathTest {

    /**
     * JmesPath基本使用
     */
    public static void main(String[] args) throws JsonProcessingException {
        JmesPath<JsonNode> jmespath = new JacksonRuntime();
        String expressionString = "name";
        // 表达式
        Expression<JsonNode> expression = jmespath.compile(expressionString);
        // json数据
        String jsonString = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonObject = objectMapper.readValue(jsonString, JsonNode.class);
        // 应用表达式
        Object result = expression.search(jsonObject);
        System.out.println(result);
    }
}
