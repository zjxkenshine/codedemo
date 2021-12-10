# 1.简介
- Spring Boot内置了jackson来完成JSON的序列化和反序列化操作。
- Jackson使用ObjectMapper类将POJO对象序列化成JSON字符串，也能将JSON字符串反序列化成POJO对象

# 2.JackSon支持三种层次的序列化和反序列化方式：
- 采用JsonParser来解析JSON，解析结果是一串Tokens，采用JsonGenerator来生成JSON，这是最底层的方式
- 采用树遍历方式，JSON被读入到JsonNode对象中，可以像操作XML DOM那样读取JSON
- 采用DataBind方式，将POJO序列化成JSON，或者反序列化到POJO，这是最直接和最简单的一种方式
    - 有时需要注解或其他实现类的辅助

# 3.方法简介
- `readValue`：反序列化JSON字符串
- `writeValueAsString`：对象转JSON字符串
- `mapper.getTypeFactory().constructCollectionType(..)`：readValue参数,json转集合
- `TypeReference`：readValue参数,转换为任意复杂类型

# 4.Jackson相关注解
- `@JsonProperty("userName")`：作用在属性上，用来为JSON Key指定一个别名
- `@JsonIgnore`：作用在属性上，用来忽略此属性
- `@JsonIgnoreProperties`：忽略一组属性，作用于类上
    ```
    @JsonIgnoreProperties({"id","photo"})
    ```
- `@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")`：用于日期格式化
- `@JsonView`：定义序列化组，如某些情况下需要返回name属性，某些情况下不需要name属性
    - 类似校验组
- `@JsonSerialize`：指定一个实现类来自定义序列化。类必须实现JsonSerializer接口

# 5.Springboot定义的JsonSerializer实现类
- 很多，具体看源码


