# 参考地址
- https://github.com/ngs-doo/dsl-json

# 1.概述：
一个高性能JVM json解析库

# 2.注解
- `@CompiledJson`：声明转换器，可以配置为处理`@JacksonCreator`或`@JsonbCreator`
- 其他方式：
    - ServiceLoader：spi方式
    - 名称为`package._NAME_DslJsonConverter`

## 3.编译器数据绑定
- `@JsonConverter`：修饰类
- `@JsonConverter`：修饰方法
- 实现JsonObject接口， 并绑定JSON_READER


