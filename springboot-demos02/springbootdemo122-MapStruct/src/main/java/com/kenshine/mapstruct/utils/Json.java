package com.kenshine.mapstruct.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 11:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Json {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String MapToJson(HashMap<String,Object> map){
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
