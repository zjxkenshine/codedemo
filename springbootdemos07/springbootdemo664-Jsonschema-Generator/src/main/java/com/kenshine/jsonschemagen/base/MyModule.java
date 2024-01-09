package com.kenshine.jsonschemagen.base;

import com.github.victools.jsonschema.generator.Module;
import com.github.victools.jsonschema.generator.Option;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;

/**
 * @author by kenshine
 * @Classname MyModule
 * @Description 自定义模块
 * @Date 2024-01-09 15:18
 * @modified By：
 * @version: 1.0$
 */
public class MyModule implements Module {
    @Override
    public void applyToConfigBuilder(SchemaGeneratorConfigBuilder schemaGeneratorConfigBuilder) {
        schemaGeneratorConfigBuilder.with(Option.ADDITIONAL_FIXED_TYPES,Option.DEFINITION_FOR_MAIN_SCHEMA,Option.SCHEMA_VERSION_INDICATOR);
    }
}
