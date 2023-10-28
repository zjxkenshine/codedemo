# 参考地址
基于fluent-hc快速构建Http请求，结合failsafe实现异常重试
- https://blog.csdn.net/Shangxingya/article/details/114118352

Apache下基于HttpClient的流式组件fluent-hc
- https://blog.csdn.net/tengxing007/article/details/99826391

# 优点
- fluent-hc本质是对HttpClient的封装，链式操作简便，易于解读不必处理连接管理和资源分配，连接池技术减少资源开销增强性能
- Executor执行器的对象是从连接池中获取的HttpClient对象。采用HTTP连接池技术降低了频繁建立HTTP连接的时间开销，减少了TCP连接建立和释放时socket通信服务器端资源的浪费，同时支持更高的并发量。
