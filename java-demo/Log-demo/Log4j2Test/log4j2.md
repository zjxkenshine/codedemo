# 1.Log4j2概述
官网：
- https://logging.apache.org/log4j/2.x/

特点
- 异常处理机制，会感知异常并处理，Logback不会
- 性能提升
- 自动重载配置，动态修改日志级别而无需重启
- 无垃圾机制，可以避免GC

# 2.异步日志
Log4j2提供了两种异步日志实现方式：
- AsyncAppender
- AsyncLogger：性能好，建议使用

AsyncLogger异步配置：
- AsyncLogger全局异步配置：参考log4j2.component.properties
- AsyncLogger混合异步：先关闭全局异步，在log4j.xml下配置AsyncLogger（异步自定义Logger）



