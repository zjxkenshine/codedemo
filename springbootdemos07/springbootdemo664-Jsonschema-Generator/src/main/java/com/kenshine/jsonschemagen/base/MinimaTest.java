package com.kenshine.jsonschemagen.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname MinimaTest
 * @Description 最小示例
 * @Date 2024-01-09 14:40
 * @modified By：
 * @version: 1.0$
 */
public class MinimaTest {

    /**
     * 基本使用
     * json模式
     */
    @Test
    public void test01(){
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);
        // 生成的schema
        System.out.println(jsonSchema.toPrettyString());
    }

    /**
     * java对象模式
     */
    @Test
    public void test02(){
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09, OptionPreset.JAVA_OBJECT);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);
        // 生成的schema
        System.out.println(jsonSchema.toPrettyString());
    }

    /**
     * 自定义选项
     */
    @Test
    public void test03(){
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09)
                //将遇到的枚举类型视为｛“type”：“string”｝架构，枚举常量的名称列为其枚举值
                .with(Option.FLATTENED_ENUMS)
                // NULLABLE_FIELDS_BY_DEFAULT 默认情况下，字段的模式类型允许为null，除非某些配置明确表示它不可为null
                // NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT 默认情况下，方法返回类型的模式类型允许为null，除非某些配置明确表示它不能为null。
                .without(Option.NULLABLE_FIELDS_BY_DEFAULT, Option.NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);
        System.out.println(jsonSchema.toPrettyString());
    }

    /**
     * 添加自定义模块
     * 可自定义配置
     */
    @Test
    public void test04(){
        Module separateModule = new MyModule();
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09)
                .with(separateModule);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);
        System.out.println(jsonSchema.toPrettyString());
    }

    /**
     * 单个配置定义所需行为
     */
    @Test
    public void test05(){
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2019_09);
        configBuilder.forTypesInGeneral()
                // 用java类型的描述填充所有模式的“title”
                .withTitleResolver(TypeScope::getSimpleTypeDescription);
        configBuilder.forFields()
                // 将原始字段名显示为“description”（可能与模式中重写的属性名不同）
                .withDescriptionResolver(FieldScope::getDeclaredName);
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(ClassA.class);
        System.out.println(jsonSchema.toPrettyString());
    }
}
