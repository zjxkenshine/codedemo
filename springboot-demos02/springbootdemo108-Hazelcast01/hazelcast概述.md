# 1.Hazelcast简介
- Hazelcast 是由Hazelcast公司开发的一款开源的分布式内存级别的缓存数据库，可以为基于JVM环境运行的各种应用提供分布式集群和分布式缓存服务
- Hazelcast提供了对很多Java接口的分布式实现，如Map, Queue, ExecutorService, Lock以及 JCache。它以一个 JAR 包的形式提供服务，并且提供了 Java, C/C++, .NET 以及 REST 客户端

# 2.Hazelcast版本区别
- Hazelcast 分为开源版和商用版,商用版本提供了数据的高密度存储

# 3.Hazelcast的特性
- 自治集群(无中心化)
- 数据按应用分布式存储
- 抗单点故障
- 简单易用
- Hazelcast 还支持服务器/客户端模型，支持脚本管理、能够和 Docker 快速整合等

# 4.Hazelcast功能
- 提供了分布式id生成器(IdGenerator)；
- 提供了分布式事件驱动（Distributed Events）；
- 提供了分布式计算(Distributed Computing)；
- 提供了分布式查询（Distributed Query）。
- 提供java.util.{Queue, Set, List, Map}分布式实现。
- 提供java.util.concurrency.locks.Lock分布式实现。
- 提供java.util.concurrent.ExecutorService分布式实现。
- 提供用于一对多关系的分布式MultiMap。
- 提供用于发布/订阅的分布式Topic（主题）。
- 通过JCA与J2EE容器集成和事务支持。
- 提供用于安全集群的Socket层加密。
- 支持同步和异步持久化。
- 为Hibernate提供二级缓存Provider 。
- 通过JMX监控和管理集群。
- 支持动态HTTP Session集群。
- 利用备份实现动态分割。
- 支持动态故障恢复

# 5.Hazelcast原理
- https://yiyige.blog.csdn.net/article/details/105729427

# 6.Hazelcast可视化管理中心
- https://hazelcast.org/download/archives/#management-center
- 下载IMDG,需要与Hazelcast版本一致（Hazelcast-Spring中的一致）
- management-center默认8080端口