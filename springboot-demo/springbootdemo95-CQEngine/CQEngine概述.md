# 1.简介
- CQEngine全名为Collection Query Engine，一个集合查询引擎。
- 有了CQEngine，我们能使用SQL-like语句高效率地查询 Java 集合
- CQEngine拥有如下特点：
    - 查询吞吐量达到 百万/秒
    - 查询响应速度为微秒级
    - 可以减轻数据库的压力
    - 性能表现胜过普通数据库
    - 支持堆内持久化，堆外内存持久化，磁盘持久化
    - 支持MVCC事务隔离。
- CQEngine比普通遍历快 330187.50%

# 2.CQEngine的基本概念
1. index：索引
- CQEngine通过为集合类内部的Object的fields建立indexes索引以及应用了依据为集合理论的规则的算法来减少搜索时间复杂度，在可扩展性和延时上胜过遍历
- CQEngine的索引集合有三种支持不同并发和事务隔离的实现：
    - ConcurrentIndexedCollection
    - ObjectLockingIndexedCollection
    - TransactionalIndexedCollection
2. Attributes：属性
    - CQEngine 需要访问Object中的field来添加index和检索值，但并非是通过反射而是通过一种叫attributes的概念
    - 如果数据包含null，那应该使用 SimpleNullableAttribute 或 MultiValueNullableAttribute，而不是SimpleAttribute,MultiValueAttribute
3. 持久化
    -  数据的持久化：
        - 数据持久化默认在堆内 On-heap
        - Off-heap
        - tmp-file
        - 存在指定路径的文件中
    - 索引的持久化：索引也有on-heap, off-heap, on disk 三种持久化方式
        - 可以一个集合类不同索引使用不同持久化方式
# 3.常用API
1. IndexedCollection：包含索引的集合
2. ResultSet：结果集
3. Grouping and Aggregation：
    - 因为CQEngine整合了Java8+的 Stream API ，所以本身的CQEngine API不支持分组和聚合，而是用lambda表达式来实现
4. OnHeap Index：堆内索引
    - NavigableIndex：在Java 堆内持久化的索引
    - ReversedRadixTreeIndex
    - SuffixTreeIndex
    - HashIndex

# 4.查询方式
CQEngine支持SQL和CQN(CQEngine 语言)的查询格式
    



