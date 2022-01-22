# 1.概述
一种二进制序列化格式，比JSON更紧凑的替代方案
- MessagePack v7（或更高版本）是先前版本v06的更快实现，不兼容
- msgpack-java 通过jackson-databind支持 Java 对象的序列化和反序列化

# 2.结构，主要API
- core：核心
    - annotations：注解包
    - buffer：缓冲区包
    - MessagePack：消息包
    - MessagePacker：打包器
    - MessageUnpacker：解包器
    - MessageFormat：消息格式化
    - Preconditions：将对象转换为二进制序列
    - ExtensionTypeHeader：扩展类型头
- value：值

# 3.目录
- demo01：官方demo
- demo02：打包/解包对象TabsJson


