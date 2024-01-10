# 参考地址
fast-object-pool FOP 一个轻量级的分区对象池，您可以使用它来池化昂贵的对象，如jdbc连接、thrift 客户端等。
- https://github.com/DanielYWoo/fast-object-pool

# 简介
- FOP是用分区实现的，以避免线程争用，性能测试表明它比Apache公共池快得多
- 该项目不是为了取代Apache commons池，该项目没有提供像commons池这样丰富的功能，该项目主要针对
    - 零依赖项（唯一可选的依赖项是disrutpor） 
    - 具有许多并发请求/线程的高吞吐量 
    - 代码更少，这样每个人都可以阅读和理解它。
    