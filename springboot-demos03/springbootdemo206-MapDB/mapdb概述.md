# 1.简介
- MapDB 结合了嵌入式数据库引擎和 Java 集合
- 它提供地图、集合、列表、队列、位图、范围查询、过期、压缩、堆外存储和流
- MapDB 可能是最快的 Java 数据库，其性能可与java.util集合相媲美

# 2.作用
- 替换Maps, Lists, Queues和其他集合。
- 不受垃圾收集器影响的堆外收集
- 具有过期和磁盘溢出的多级缓存。
- 用事务、MVCC、增量备份等替换 RDBMs
- 本地数据处理和过滤。MapDB 具有在合理时间内处理大量数据的实用程序

# 3.DB 和 DBMaker
- DBMaker类处理数据库配置，DB实例代表一个打开的数据库（单个事务）
- DBMaker不同模式：xxDB
    - `memoryDB()`：打开一个由byte[]数组支持的内存数据库
    - `appendFileDB()`：打开一个使用仅附加日志文件的数据库
    - `fileDB()`：使用文件的数据库
- DB构建集合或其他类型数据：
    - 集合以集合类型开头，map，treeSet..等
    - 原子值`db.atomicVar...`
- DB结束方法：
    - create()：创建新集合
    - open()：打开现有集合
    - createOrOpen()：存在则打开，不存在则创建
- DB事务处理方法：`commit()`,`rollback()`和`close()`

# 4.HTreeMap
- 为 MapDB 提供HashMap和HashSet集合
- Serializers：序列化器，不建议使用通用序列化器
- HashCode： 
    - Serializer.STRING使用XXHash,冲突更少
    - Serializer.STRING_ORIGHASH使用String.hashCode()
    - `hashSeed()`：定义hash种子
- HTreeMap布局：由layout控制
    - 并发是通过使用多个段来实现的
    - HTreeMap使用索引树而不是Object[]为其哈希表增长
- 其他参数：
    - `.counterEnable()`：大小计数器
    - `.valueLoader(..)`：找不到计数器则创建
- Sharded HTreeMap：分片HTreeMap
- 过期：`expireAfterCreate()、expireAfterUpdate()和expireAfterGet()`

# 5.BTreeMap
- 为 MapDB提供TreeMap和TreeSet，基于无锁并发B-Linked-Tree
- `db.treeMap()....`
- 与HTreeMap相比，BTreeMap 更适合较小的键

# 6.SortedTableMap
- 将文件（或内存存储）中的键存储在固定大小的表中，并使用二进制搜索。
- 比BTreeMap更快，零碎片，但只读，不支持更新
- SortedTableMap不使用DB对象，而是直接操作Volume

# 7.其他
- `.transactionEnable()`：开启事务
- `.closeOnJvmShutdown()`：自动关闭钩子
- `.fileMmapEnable()`：内存文件映射
- `.fileChannelEnable()`：通道模式,基于FileChannel访问磁盘
- 内存模式：
    - `.heapDB()`：堆中存储，小数据集非常快，受GC影响
    - `.memoryDB()`：基于byte[]，仍在堆上
    - `.memoryDirectDB()`：堆外存储
    - 分配选项：
       - `.allocateStartSize(..)`：初始化大小
       - `.allocateIncrement(..)`：自增大小
