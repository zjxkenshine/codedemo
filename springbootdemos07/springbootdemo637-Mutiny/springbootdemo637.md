# 参考地址
官网 smallrye-mutiny 事件驱动的响应式编程框架
- https://smallrye.io/smallrye-mutiny
- https://github.com/smallrye/smallrye-mutiny

2.x版本java11环境
1.x版本java8环境

# 简介
- Uni：Uni表示只能发出项或失败事件的流
- Multi：表示一个数据流。流可以发出0、1、n或无限数量的项
- invoke：事件调用同步观察
- call：异步事件调用观察
- transform：数据转换
- onFailure：失败处理
- onFailure().retry()：失败重试