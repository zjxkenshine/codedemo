# 参考地址
one-nio github
- https://github.com/odnoklassniki/one-nio

# 组件
- one.nio.async：异步执行的实用程序函数
- one.nio.cluster：集群框架
- one.nio.gen：使用ASM框架帮助生成动态字节码的实用程序函数
- one.nio.http：http服务端跟客户端
- one.nio.lock：读写锁升级
- one.nio.mem：一系列用于管理堆外内存的工具
    - DirectMemory：直接操作堆外内存
    - MappedFile：将文件映射和解映射到RAM
    - Malloc：分配堆外内存
    - MallocMT：用于多线程应用程序的特殊版本Malloc
    - FixedSizeAllocator：非常快的无锁分配器，用于管理固定大小的块
    - LongHashSet, LongLongHashMap, LongObjectHashMap：具有64位键的堆外无锁哈希表
    - OffheapMap：堆外Map
    - SharedMemory*Map：在共享内存或内存映射文件中缓存数据
- one.nio.mgt：注册和注销mxbean的简单API。用于远程访问JMX属性的内置HTTP服务器
- one.nio.net：具有自己的本机库的低级套接字I/O API
- one.nio.lz4：压缩
- one.nio.compiler：编译
- one.nio.os：Java封装了对内存、进程和用户管理的某些Linux系统调用
- one.nio.pool：包含通用资源池以及可用于实现各种网络客户端的套接字池
- one.nio.rpc：利用one-nio库的主要特性的RPC服务器和客户端:快速网络I/O、序列化和类演化支持
- one.nio.serial：序列化
- one.nio.server：基于一对一网络API的TCP Server的可扩展通用实现。
- one.nio.util：一些广泛使用的高性能编解码器等实用功能
    - Base64
    - UTF-8
    - URL
    - ByteArrayBuilder
