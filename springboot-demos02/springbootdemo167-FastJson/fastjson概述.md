# 1.fastjson简介
- 阿里巴巴的开源JSON解析库，它可以解析JSON格式的字符串，支持将Java Bean序列化为JSON字符串，也可以从JSON字符串反序列化到JavaBean
- 速度快，使用广泛

# 2.相关类库
- JSON：常用的序列化操作，入口类
- JSONArray：fastJson提供json数组对象
- JSONObject: fastJson提供的json对象

# 3.JSON类常用方法
- `Object parse(String text)`：把JSON文本parse为JSONObject或者JSONArray 
- `JSONObject parseObject(String text)`: 把JSON文本parse成JSONObject    
- `T parseObject(String text, Class<T> clazz)`: 把JSON文本parse为JavaBean 
- `JSONArray parseArray(String text)`: 把JSON文本parse成JSONArray 
- `List<T> parseArray(String text, Class<T> clazz)`：把JSON文本parse成JavaBean集合 
- `String toJSONString(Object object)`：将JavaBean序列化为JSON文本 
- `String toJSONString(Object object, boolean prettyFormat)`：将JavaBean序列化为带格式的JSON文本 
- `Object toJSON(Object javaObject)`：将JavaBean转换为JSONObject或者JSONArray

