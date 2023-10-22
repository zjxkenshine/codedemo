package com.kenshine.jacksonyaml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/22 14:57
 * @description：对象与yaml字符串互转工具
 * @modified By：
 * @version: $
 */
public class YamlUtil {
    /**
     * 将yaml字符串转成类对象
     * @param yamlStr 字符串
     * @param clazz 目标类
     * @param <T> 泛型
     * @return 目标类
     */
    public static <T> T toObject(String yamlStr, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            return mapper.readValue(yamlStr, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将类对象转yaml字符串
     * @param object 对象
     * @return yaml字符串
     */
    public static String toYaml(Object object){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        StringWriter stringWriter = new StringWriter();
        try {
            mapper.writeValue(stringWriter, object);
            return stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * （此方法非必要）
     * json 2 yaml
     * @param jsonStr json
     * @return yaml
     * @throws JsonProcessingException Exception
     */
    public static String json2Yaml(String jsonStr) throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree(jsonStr);
        return new YAMLMapper().writeValueAsString(jsonNode);
    }
}
