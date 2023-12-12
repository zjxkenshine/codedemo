# 参考地址
redisx：一个轻量的redisx客户端
- https://github.com/noear/redisx

# 踩坑
Caused by: java.lang.NoClassDefFoundError: redis/clients/jedis/ConnectionPoolConfig
- jedis及commons-pool2版本问题，GenericObjectPoolConfig的setMaxWait方法

Found multiple occurrences of org.json.JSONObject on the class path
- 与springboottest中的json冲突，排除一个 
- 排除android-json-0.0.20131108.vaadin1.jar的依赖 无效
- 在TestController中进行测试