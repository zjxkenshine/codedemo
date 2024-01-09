# 参考地址
jsonschema-generator jsonschema生成器（Draft 6, Draft 7, Draft 2019-09, or Draft 2020-12）
- https://github.com/victools/jsonschema-generator
- https://victools.github.io/jsonschema-generator/

# 1.三种预设选项
- OptionPreset.FULL_DOCUMENTATION：显示包含所有字段和所有公共方法的大小写
- OptionPreset.PLAIN_JSON：提供JSON数据结构的表示，包括所有非静态字段，没有方法
- OptionPreset.JAVA_OBJECT：满足Java对象的表示，包括所有公共字段（静态和非静态）和所有公共方法（静态/非静态）

# 2.单独切换选项，不使用预设选项
Option类下：所有选项介绍在这里
- https://victools.github.io/jsonschema-generator/#generator-options
  
部分配置项：
- Option.SCHEMA_VERSION_INDICATOR:设置适当的$schema属性
- Option.ADDITIONAL_FIXED_TYPES:类型转换为{ "type": "string" }这种形式
- Option.STANDARD_FORMATS：格式设置
- Option.EXTRA_OPEN_API_FORMAT_VALUES：额外格式设置
- Option.SIMPLIFIED_ENUMS：枚举作为对象
- Option.FLATTENED_ENUMS：枚举作为{ "type": "string" }这种形式
- Option.FLATTENED_ENUMS_FROM_TOSTRING：枚举常量的toString（）值列为其枚举值
- Option.SIMPLIFIED_OPTIONALS：视为对象，仅包括get（）、orElse（）和isPresent（）方法
- ...

# 3.添加单独模块
可选模块 Module
- victools/jsonschema-module-jackson
- victools/jsonschema-module-jakarta-validation
- victools/jsonschema-module-javax-validation 
- victools/jsonschema-module-swagger-1.5
- victools/jsonschema-module-swagger-2 

# 4.单个配置定义所需行为
- test05

# 5.支持的json schema
- `$schema`：schema版本，Option.SCHEMA_VERSION_INDICATOR
- `$id`：SchemaGeneratorGeneralConfigPart.withIdResolver()
- `$anchor`：SchemaGeneratorGeneralConfigPart.withAnchorResolver()
- `definitions`：Option.DEFINITIONS_FOR_ALL_OBJECTS
- `$defs`：Option.DEFINITIONS_FOR_ALL_OBJECTS
- `$ref`：definitions
- `type`：SchemaGeneratorConfigPart.withNullableCheck()
- `properties`：列出对象中所有检测到的字段和/或方法
- `items`
- `required`：SchemaGeneratorConfigPart.withRequiredCheck()
- `allOf`
- `anyOf`：SchemaGeneratorGeneralConfigPart.withSubtypeResolver()
- `oneOf`
- `title`：SchemaGeneratorConfigPart.withTitleResolver()
- `description`：SchemaGeneratorConfigPart.withDescriptionResolver()
- `const`：SchemaGeneratorConfigPart.withEnumResolver()
- `enum`：SchemaGeneratorConfigPart.withEnumResolver()
- `default`：SchemaGeneratorConfigPart.withDefaultResolver()
- `additionalProperties`：SchemaGeneratorConfigPart.withAdditionalPropertiesResolver()
- `patternProperties`：SchemaGeneratorConfigPart.withPatternPropertiesResolver()
- `minLength`：SchemaGeneratorConfigPart.withStringMinLengthResolver()
- `maxLength`：SchemaGeneratorConfigPart.withStringMaxLengthResolver()
- `format`：SchemaGeneratorConfigPart.withStringFormatResolver()
- `pattern`：SchemaGeneratorConfigPart.withStringPatternResolver()
- `minimum`：SchemaGeneratorConfigPart.withNumberInclusiveMinimumResolver()
- `exclusiveMinimum`：SchemaGeneratorConfigPart.withNumberExclusiveMinimumResolver()
- `maximum`：SchemaGeneratorConfigPart.withNumberInclusiveMaximumResolver()
- `exclusiveMaximum`：SchemaGeneratorConfigPart.withNumberExclusiveMaximumResolver()
- `multipleOf`：SchemaGeneratorConfigPart.withNumberMultipleOfResolver()
- `minItems`：SchemaGeneratorConfigPart.withArrayMinItemsResolver()
- `maxItems`：SchemaGeneratorConfigPart.withArrayMaxItemsResolver()
- `uniqueItems`：SchemaGeneratorConfigPart.withArrayUniqueItemsResolver()
- `dependentRequired`：SchemaGeneratorConfigPart.withDependentRequiredResolver()

