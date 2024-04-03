package com.kenshine.jacksonprotobuf;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufFactory;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;
import com.fasterxml.jackson.dataformat.protobuf.schema.NativeProtobufSchema;
import com.fasterxml.jackson.dataformat.protobuf.schema.ProtobufSchema;
import com.fasterxml.jackson.dataformat.protobuf.schema.ProtobufSchemaLoader;
import com.fasterxml.jackson.dataformat.protobuf.schemagen.ProtobufSchemaGenerator;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JacksonProtobufTest
 * @Description protobuf操作
 * @Date 2024-04-03 13:11
 * @modified By：
 * @version: 1.0$
 */
public class JacksonProtobufTest {

    /**
     * 序列化与反序列化
     */
    @Test
    public void test01() throws IOException {
        //ObjectMapper mapper = new ObjectMapper(new ProtobufFactory());
        ObjectMapper mapper = new ProtobufMapper();
        String protobuf_str = "message Employee {\n"
                +" required string name = 1;\n"
                +" required int32 age = 2;\n"
                +" repeated string emails = 3;\n"
                +" optional Employee boss = 4;\n"
                +"}\n";

        ProtobufSchema schema = ProtobufSchemaLoader.std.parse(protobuf_str);
        Employee employee=new Employee("kenshine",18,new String[]{"kenshine@163.com"},new Employee("lin",16,new String[]{"lin@163.com"},null));
        byte[] protobufData = mapper.writer(schema)
                .writeValueAsBytes(employee);
        Employee empl1 = mapper.readerFor(Employee.class)
                .with(schema)
                .readValue(protobufData);
        System.out.println(empl1);
    }

    /**
     * 根据java雷生成schema文件
     */
    @Test
    public void test02() throws JsonMappingException {
        ObjectMapper mapper = new ObjectMapper(new ProtobufFactory());
        ProtobufSchemaGenerator gen = new ProtobufSchemaGenerator();
        mapper.acceptJsonFormatVisitor(Employee.class, gen);
        ProtobufSchema schemaWrapper = gen.getGeneratedSchema();
        NativeProtobufSchema nativeProtobufSchema = schemaWrapper.getSource();
        String asProtofile = nativeProtobufSchema.toString();
        System.out.println(asProtofile);
    }

    /**
     * 根据java雷生成schema文件 方式二
     */
    @Test
    public void test03() throws JsonMappingException {
        ProtobufMapper mapper = new ProtobufMapper();
        ProtobufSchema schemaWrapper = mapper.generateSchemaFor(Employee.class);
        NativeProtobufSchema nativeProtobufSchema = schemaWrapper.getSource();
        String asProtofile = nativeProtobufSchema.toString();
        System.out.println(asProtofile);
    }
}
