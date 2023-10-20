# 参考地址
light-json与当今热门JSON库的评测pk
- https://blog.csdn.net/wangych0112/article/details/122522193

# 方法
## 序列化：
- `JSON.toJsonString`：转换为字符串
- `JSON.writeJsonTo`：写入文件或流

## 反序列化
- `JSON.parse`
- `JSON.parseArray`
- `JSON.parseObject`...

## 指定自定义序列化反序列化器注解
- `@JsonSerialize`
- `@JsonDeserialize`