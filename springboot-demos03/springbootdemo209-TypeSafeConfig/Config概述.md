# 1.TypeSafeConfig简介
JVM 语言的配置库，操作配置文件的
- 用纯 Java 实现，没有依赖关系
- 支持三种格式：properties, JSON, HOCON
- 支持合并配置文件
- 可以从文件，URL或类路径加载
- 对嵌套支持良好
- 可以使用 Java 系统属性覆盖配置 `java -Dxxx`
- 可以转换长短，大小等单位
- 类型转换

# 2.HOCON概述
- `.conf`结尾，JSON的超集
- 更适合人类阅读的配置文件
- [HOCON详细语法](https://github.com/lightbend/config/blob/master/HOCON.md)
- 可以写注释
- 可以继承

# 3.Config主要编程接口
- ConfigFactory：获取配置Config
- Config：获取配置内容
- `ConfigFactory.load()`：默认加载以下文件(优先级从高到低)
    - 系统设置（如：-Dconfig.file=path/to/config-file）
    - application.conf
    - application.json
    - application.properties
    - reference.conf
- `config.withFallback()`：合并配置树
- ConfigObject：ConfigValue子接口，可以访问json api
- ConfigBeanFactory：转换为JavaBean
    - `ConfigBeanFactory.create(config.getConfig("..."), MyBean.class)`
