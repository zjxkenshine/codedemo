# 参考地址
github
- https://github.com/microsoft/gctoolkit

# 简介
GC日志解析工具

需要切换jdk17环境
# 简单使用
1. 定义Aggregator、Aggregation
2. 在module-info.java终止注册
3. serviceLoad spi加载
4. 声明JavaVirtualMachine实例
5. 调用Aggregation处理

