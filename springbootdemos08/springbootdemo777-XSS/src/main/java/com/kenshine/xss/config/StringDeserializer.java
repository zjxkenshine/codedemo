package com.kenshine.xss.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.kenshine.xss.exception.CustomerException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author kenshine
 * 检验请求体的参数
 */
@Component
public class StringDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String str = jsonParser.getText().trim();
        //sql注入拦截
        if (sqlInject(str)) {
          throw new CustomerException("参数含有非法攻击字符，已禁止继续访问！");
        }
 
        return xssClean(str);
 
    }
 
    public boolean sqlInject(String str) {
 
        if (StringUtils.isEmpty(str)) {
            return false;
        }
 
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");
 
        //转换成小写
        str = str.toLowerCase();
 
        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert","alter", "drop"};
 
        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                return true;
            }
        }
        return false;
    }
 
    //xss攻击拦截
 
    public String xssClean(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
 
        //非法字符
        String[] keywords = {"<", ">", "<>", "()", ")", "(", "javascript:", "script","alter", "''","'"};
        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (value.contains(keyword)) {
               throw new CustomerException("参数含有非法攻击字符，已禁止继续访问！");
            }
        }
        return value;
    }
}