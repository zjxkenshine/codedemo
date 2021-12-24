# 1.ArangoDB简介
 - ArangoDB是一个开源的分布式多模型NoSQL数据库，支持Key-Value、Document、Graph存储。使用AQL语言进行查询
 - 特点：
    - 多模型
    - 分布式
    - AQL查询
    - 可通过JavaScript进行扩展
    - Foxx -构建自己的API
    - 空间利用率高：元数据模式
    - 多OS支持

# 2.下载安装
- https://blog.csdn.net/perpetualtime/article/details/103430633 
- 可视化页面地址: http://localhost:8529/，账号root，密码为空

# 3.ArangoDB自带程序
- arangod - ArangoDB数据库的守护程序，运行后就是ArangoDB数据库服务器的守护进程
- arangosh - ArangoDB的Shell环境
- arangoimp - ArangoDB数据库导入工具
- arangoexport - ArangoDB数据库导出工具
- arangodump - ArangoDB数据库的备份工具
- arangorestore - ArangoDB数据库的恢复工具
- foxx-manager - 管理Foxx应用程序
- arango-dfdb - ArangoDB的数据文件调试器
- arangobench - ArangoDB的测试和评分工具

# 4. ArangoDB数据模型与索引
## 数据模型
- 分为数据库(databse)、集合(collection)、文档(document)，对应库，表，行
- Collection：分为document和edge
- Document：展示使用JSON格式，存储使用二进制的VelocyPack
    - document由一个主键(_key)、_id、_rev、0个或者多个属性组成
    - _key作为sharding的依据
- Edge比Document多两个属性：_from、_to

## 索引
- ArangoDB中的索引类型分为：Primary、Edge、Hash、Skiplist、Persistent、Geo、Fulltext。
- ArangoDB会自动对文档中的_id、_key、_from、_to字段建立索引

# 5.ArangoDB集群组成
1. ArangoDB集群使用满足CP的master/master模式，牺牲了一定的集群可用性。集群内部之间采用HTTP+ VelocyPack的方式进行通讯。
2. ArangoDB集群由3部分组成：agent、coordinator、dbserver：
    - Agent：类似注册中心
    - Coordinator：ArangoDB集群中直接面向客户端对外提供服务的角色
    - DBserver：负责数据的物理存储以及响应Coordinator的查询请求
        - 又可以分为Primary、Secondary两种
        
# 6.ArangoDB存储引擎
- MMFILES：内存文件映射
- RocksDB：Facebook开源的嵌入式KV存储引擎，基于LSMTree构建