package com.kenshine.jsonschema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author by kenshine
 * @Classname JsonshcemaTest
 * @Description json-schema使用测试
 * @Date 2024-01-16 15:35
 * @modified By：
 * @version: 1.0$
 */
public class JsonshcemaTest {

    /**
     * json校验示例
     */
    @Test
    public void test01(){
        String json = "{\n" +
                "    \"name\":\"shoulinniao\",\n" +
                "    \"age\":24,\n" +
                "    \"birthday\":\"1998-11-11\"\n" +
                "}";
        JSONObject jsonObject = new JSONObject(json);
        String jsonSchema = "{\n" +
                "  \"$schema\":\"http://json-schema.org/draft-07/schema#\",\n" +
                "  \"type\":\"object\",\n" +
                "  \"properties\":{\n" +
                "    \"name\":{\n" +
                "      \"type\":\"string\"\n" +
                "    },\n" +
                "    \"age\":{\n" +
                "      \"type\":\"integer\"\n" +
                "    },\n" +
                "    \"birthday\":{\n" +
                "      \"type\":\"string\",\n" +
                "      \"format\":\"date\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        JSONObject jsonSchemaObject = new JSONObject(jsonSchema);
        //两种方法确定版本
        // 1、在JsonSchema里把版本定义好了，否则默认加载4版本，如果加载6、7版本的特定内容会失败
        Schema schema = SchemaLoader.load(jsonSchemaObject);
        // 2、没有在JsonSchema里定义版本，声明加载器的版本
        SchemaLoader schemaLoader = SchemaLoader.builder().schemaJson(jsonSchemaObject).draftV7Support().build();
        schema = schemaLoader.load().build();
        // 校验
        schema.validate(jsonObject);
    }

    /**
     * 从文件读取校验
     */
    @Test
    public void test02(){
        try (InputStream inputStream = new FileInputStream("src\\main\\resources\\test-schema.json")) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            Schema schema = SchemaLoader.load(rawSchema);
            schema.validate(new JSONObject(new JSONTokener(new FileInputStream("src\\main\\resources\\test.json"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


