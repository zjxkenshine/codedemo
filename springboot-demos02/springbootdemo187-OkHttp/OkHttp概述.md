# 1.OkHttp简介
OkHttp 是一个默认高效的 HTTP 客户端
- HTTP/2 支持允许对同一主机的所有请求共享一个套接字
- 连接池减少了请求延迟（如果 HTTP/2 不可用）
- 透明 GZIP 可缩小下载大小
- 响应缓存完全避免网络重复请求

# 2.相关特性
## 2.1 调用
- 重写请求：可以添加页眉，标头等
- 重写响应
- 跟进请求：返回一个url，OkHttp将跟随重定向来检索最终响应
- 调用：支持同步与异步方式
- Dispatcher调度：
    - 同步调用，您可以使用自己的线程并负责管理您同时发出的请求数
    - 异步调用，Dispatcher实现最大并发请求的策略。您可以设置每个网络服务器的最大值

## 2.2 缓存
OkHttp 实现了一个可选的、默认关闭的缓存
```
new OkHttpClient.Builder().build().cache()
```

## 2.3 连接 Connection
OkHttp支持三种类型的连接：URL，地址和路由
- URL：如`https://github.com/square/okhttp`
- 地址：地址指定网络服务器和连接到该服务器所需的所有静态配置：端口号、HTTPS 设置和首选网络协议
- 路由：路由提供实际连接到网络服务器所需的动态信息（IP地址，代理服务器，TLS版本等）

## 2.4 事件 Event
- 可以对Http进行监控：
    - HTTP 调用的大小和频率
    - 调用的性能
- 主要接口：EventListener
- 监听工厂：EventListener.Factory，多个调用同时执行时创建不同监听
- 事件失败：
    - connectFailed()：连接失败
    - callFailed()：调用失败
- 事件重试

## 2.5 HTTPS
OkHttp 试图平衡两个相互冲突的问题：
- 连接到尽可能多的主机
- 连接的安全性

ConnectionSpec实现了特定的安全性与连接性决策，OkHttp 包含四个内置连接规范：
- RESTRICTED_TLS 是一种安全配置，旨在满足更严格的合规性要求。
- MODERN_TLS 是连接到现代 HTTPS 服务器的安全配置。默认
- COMPATIBLE_TLS 是连接到安全但不是当前的 HTTPS 服务器的安全配置。
- CLEARTEXT是用于http://URL的不安全配置

回退连接等级：
```
OkHttpClient client = new OkHttpClient.Builder()
    .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
    .build();
```


## 2.6 Interceptor拦截器
拦截器是一种强大的机制，可以监视、重写和重试调用
- 应用拦截：`new OkHttpClient.Builder().addInterceptor(...)`
    - 无需担心重定向和重试等中间响应。
    - 始终调用一次，即使 HTTP 响应是从缓存中提供的。
    - 遵守应用程序的原始意图。不关心 OkHttp 注入的标头.
    - 允许短路而不是调用Chain.proceed()
    - 允许重试并多次调用Chain.proceed()
    - 可以使用 withConnectTimeout、withReadTimeout、withWriteTimeout 控制超时。
- 网络拦截：`new OkHttpClient.Builder().addNetworkInterceptor(...)`
    - 能够对重定向和重试等中间响应进行操作
    - 不会为使网络短路的缓存响应而调用
    - 观察数据
    - 访问携带的请求的Connection
- 重写请求：参考GzipRequestInterceptor
- 重写响应：类似重写请求