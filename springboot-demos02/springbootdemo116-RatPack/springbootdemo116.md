# 参考地址
官方案例
- https://github.com/ratpack/ratpack/tree/master/ratpack-spring-boot/src/test/groovy/ratpack/spring

ratpack框架_使用Ratpack和Spring Boot构建高性能JVM微服务
- https://blog.csdn.net/cunfu6353/article/details/107229013

ratpack相关配置
- https://github.com/ratpack/ratpack/blob/master/ratpack-spring-boot/src/main/java/ratpack/spring/config/RatpackProperties.java

官方文档
- https://ratpack.io/manual/current/

高性能异步HTTP服务器 - Ratpack
- https://cs.xieyonghui.com/architecture/134.html


# Ratpack概述
- Ratpack是一套java应用程序类库，能快速构建高效的HTTP应用，基于高性能的netty引擎
- Ratpack Handler是HTTP请求的处理程序，处理程序是可组合的，很少有应用程序只包含一个处理程序。
  - 大多数应用服务器都是复合处理程序，常用handlers(Action)方法创建，使用Chain DSL创建复合处理程序

