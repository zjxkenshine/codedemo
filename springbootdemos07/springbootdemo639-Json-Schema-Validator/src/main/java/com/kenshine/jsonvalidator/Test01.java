package com.kenshine.jsonvalidator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.load.Dereferencing;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 使用测试1
 * @Date 2023-12-27 8:47
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    /**
     * 简单使用
     */
    @Test
    public void test01() throws ProcessingException, IOException {
        final JsonNode fstabSchema = Utils.loadResource("/fstab.json");
        final JsonNode good = Utils.loadResource("/fstab-good.json");
        final JsonNode bad = Utils.loadResource("/fstab-bad.json");
        final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");
        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        // 创建json schema
        final JsonSchema schema = factory.getJsonSchema(fstabSchema);

        ProcessingReport report;
        // schema校验
        report = schema.validate(good);
        System.out.println(report);

        report = schema.validate(bad);
        System.out.println(report);

        report = schema.validate(bad2);
        System.out.println(report);
    }


    /**
     * LoadingConfiguration 寻址配置
     */
    @Test
    public void test02() throws ProcessingException, IOException {
        final JsonNode fstabSchema = Utils.loadResource("/fstab-inline.json");
        final JsonNode good = Utils.loadResource("/fstab-good.json");
        final JsonNode bad = Utils.loadResource("/fstab-bad.json");
        final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");

        // 加载配置 内联寻址模式
        final LoadingConfiguration cfg = LoadingConfiguration.newBuilder()
                .dereferencing(Dereferencing.INLINE).freeze();
        final JsonSchemaFactory factory = JsonSchemaFactory.newBuilder()
                .setLoadingConfiguration(cfg).freeze();

        final JsonSchema schema = factory.getJsonSchema(fstabSchema);
        ProcessingReport report;
        report = schema.validate(good);
        System.out.println(report);
        report = schema.validate(bad);
        System.out.println(report);
        report = schema.validate(bad2);
        System.out.println(report);
    }

    /**
     * Resource 寻址
     */
    @Test
    public void test03() throws IOException, ProcessingException {
        final JsonNode good = Utils.loadResource("/fstab-good.json");
        final JsonNode bad = Utils.loadResource("/fstab-bad.json");
        final JsonNode bad2 = Utils.loadResource("/fstab-bad2.json");
        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        // 根据Resource寻址
        String SCHEMA_URI = "resource:/fstab-sub.json#/fstab";
        final JsonSchema schema = factory.getJsonSchema(SCHEMA_URI);
        ProcessingReport report;
        report = schema.validate(good);
        System.out.println(report);
        report = schema.validate(bad);
        System.out.println(report);
        report = schema.validate(bad2);
        System.out.println(report);
    }
}
