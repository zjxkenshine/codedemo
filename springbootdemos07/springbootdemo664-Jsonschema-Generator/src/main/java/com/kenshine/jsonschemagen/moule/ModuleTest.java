package com.kenshine.jsonschemagen.moule;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.*;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationModule;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationOption;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption;
import com.github.victools.jsonschema.module.swagger15.SwaggerModule;
import com.github.victools.jsonschema.module.swagger2.Swagger2Module;
import com.kenshine.jsonschemagen.base.ClassA;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ModuleTest
 * @Description 模块测试
 * @Date 2024-01-09 16:48
 * @modified By：
 * @version: 1.0$
 */
public class ModuleTest {

    /**
     * JacksonModule
     */
    @Test
    public void test01(){
        JacksonModule module = new JacksonModule();
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);

        System.out.println(jsonSchema.toString());
    }

    /**
     * JakartaValidationModule
     */
    @Test
    public void test02(){
        JakartaValidationModule module = new JakartaValidationModule(JakartaValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);

        System.out.println(jsonSchema.toString());
    }

    /**
     * JavaxValidationModule
     */
    @Test
    public void test03(){
        JavaxValidationModule module = new JavaxValidationModule(JavaxValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);

        System.out.println(jsonSchema.toString());
    }

    /**
     * SwaggerModule
     */
    @Test
    public void test04(){
        SwaggerModule module = new SwaggerModule();
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);

        System.out.println(jsonSchema.toString());
    }

    /***
     * Swagger2Module
     */
    @Test
    public void test05(){
        Swagger2Module module = new Swagger2Module();
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON)
                .with(module);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);

        System.out.println(jsonSchema.toString());
    }
}
