package com.kenshine.jacksonavor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroMapper;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.dataformat.avro.jsr310.AvroJavaTimeModule;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;
import org.apache.avro.Schema;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JacksonAvorTest
 * @Description JacksonAvor测试
 * @Date 2024-03-30 8:36
 * @modified By：
 * @version: 1.0$
 */
public class JacksonAvorTest {

    /**
     * 序列化与反序列化
     */
    @Test
    public void test01() throws IOException {
        // 创建AvorSchema
        String SCHEMA_JSON = "{\n"
                +"\"type\": \"record\",\n"
                +"\"name\": \"Employee\",\n"
                +"\"fields\": [\n"
                +" {\"name\": \"name\", \"type\": \"string\"},\n"
                +" {\"name\": \"age\", \"type\": \"int\"},\n"
                +" {\"name\": \"emails\", \"type\": {\"type\": \"array\", \"items\": \"string\"}},\n"
                +" {\"name\": \"boss\", \"type\": [\"Employee\",\"null\"]}\n"
                +"]}";
        Schema raw = new Schema.Parser().setValidate(true).parse(SCHEMA_JSON);
        AvroSchema schema = new AvroSchema(raw);
        System.out.println(schema);
        Employee employee = new Employee("kenshine",18,new String[]{"kenshine@163.com"},new Employee("lin",16,new String[]{"lin@163.com"},null));

        AvroMapper mapper = AvroMapper.builder().build();
        // 序列化
        byte[] avroData = mapper.writer(schema)
                .writeValueAsBytes(employee);
        // 反序列化
        Employee employee1 = mapper.reader(Employee.class)
                .with(schema)
                .readValue(avroData);
        System.out.println(employee1);
    }

    /**
     * java时间类型处理
     * LogicalType类型启用
     * AvroJavaTimeModule 可以更好的支持java时间类型
     */
    @Test
    public void test02() throws JsonMappingException {
        // AvroJavaTimeModule 可以更好的支持java时间类型
        AvroMapper mapper = AvroMapper.builder()
                .addModule(new AvroJavaTimeModule())
                .build();
//        AvroMapper mapper = AvroMapper.builder()
//                .build();
        AvroSchemaGenerator gen = new AvroSchemaGenerator();
        // LogicalTypes本地类型开启
        gen.enableLogicalTypes();
        mapper.acceptJsonFormatVisitor(RootType.class, gen);
        Schema actualSchema = gen.getGeneratedSchema().getAvroSchema();
    }

    /**
     * 根据POJO定义生成avor schema
     */
    @Test
    public void test03() throws JsonMappingException {
        ObjectMapper mapper = new ObjectMapper();
        AvroSchemaGenerator gen = new AvroSchemaGenerator();
        mapper.acceptJsonFormatVisitor(Employee.class, gen);
        AvroSchema schemaWrapper = gen.getGeneratedSchema();
        Schema avroSchema = schemaWrapper.getAvroSchema();
        String asJson = avroSchema.toString(true);
        System.out.println(asJson);
    }
}
