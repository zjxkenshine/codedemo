# 参考地址
Apache Avro 格式序列化与反序列化
- https://github.com/FasterXML/jackson-dataformats-binary/tree/2.18/avro

Avro介绍
- https://blog.csdn.net/hellozhxy/article/details/90451123

# avor介绍
Avro所提供的属性：
1. 丰富的数据结构
2. 使用快速的压缩二进制数据格式
3. 提供容器文件用于持久化数据
4. 远程过程调用RPC
5. 简单的动态语言结合功能

## 简单类型：
```
null	没有值
boolean	布尔值
int	32位有符号整数
long	64位有符号整数
float	单精度（32位）的IEEE 754浮点数
double	双精度（64位）的IEEE 754浮点数
bytes	8位无符号字节序列
string	字符串
```

## 复杂类型：
Record:
```
name：字段名字(必填)
doc：字段说明文档(可选)
type：一个schema的json对象或者一个类型名字(必填)
default：默认值(可选)
order：排序(可选)，只有3个值ascending(默认)，descending或ignore
aliases：别名，字符串数组(可选)
```
Enum: 
```
name：枚举类型的名字(必填)
namespace：命名空间(可选)
aliases：字符串数组，别名(可选)
doc：说明文档(可选)
symbols：字符串数组，所有的枚举值(必填)，不允许重复数据。
```
Array:
```
items：数组元素的schema
```
Map:
```
values：map值的schema
```
Union:
```
组合类型，表示各种类型的组合，使用数组进行组合。比如[“null”, “string”]表示类型可以为null或者string
```
Fixed:
```
name：名字(必填)
namespace：命名空间(可选)
aliases：字符串数组，别名(可选)
size：一个整数，表示每个值的字节数(必填)
```

# Avor schema示例
```
{
"namespace": "example.avro",
 "type": "record",
 "name": "User",
 "fields": [
     {"name": "name", "type": "string"},
     {"name": "favorite_number",  "type": "int"},
     {"name": "favorite_color", "type": "string"}
 ]
}
```

# Avor时间类型与Java对照
```
java.time.OffsetDateTime {"type": "long", "logicalType": "timestamp-millis"}
java.time.ZonedDateTime {"type": "long", "logicalType": "timestamp-millis"}
java.time.Instant  {"type": "long", "logicalType": "timestamp-millis"}
java.time.LocalDate {"type": "int", "logicalType": "date"}
java.time.LocalTime {"type": "int", "logicalType": "time-millis"}
java.time.LocalDateTime {"type": "long", "logicalType": "timestamp-millis"}
```

# 目录
- Test01：序列化与反序列化
- Test02：java时间类型处理
- Test03：根据POJO定义生成avor schema

