# 参考地址
MyPerf4J一个高性能、无侵入的Java性能监控和统计工具
- http://xiaoyuge.work/myperf4j/index.html

github
- https://github.com/LinShunKang/MyPerf4J
- https://github.com/LinShunKang/MyPerf4J/wiki/Chinese-Doc

# 指标
```
Method Metrics
RPS: 每秒请求数
Count: 总请求数
RT: 方法响应时间
Avg: 方法平均响应时间
Min: 方法最小响应时间
Max: 方法最大响应时间
StdDev: 方法响应时间的标准差
TP50, TP90, TP95, TP99, TP999, TP9999, TP100
TP: Top 百分数(Top Percentile)
TP90: 在一个时间段内（如1分钟），统计该方法每次调用所消耗的时间，并将这些时间按从小到大的顺序进行排序，取第 90% 的那个值作为 TP90 值

JVM GC Metrics
YoungGcCount: 一个时间片内累计 YoungGC 次数
YoungGcTime: 一个时间片内累计 YoungGC 时间
AvgYoungGcTime: 一个时间片内 YoungGC 平均时间
FullGcCount: 一个时间片内累计 OldGC 次数
FullGcTime: 一个时间片内累计 OldGC 时间

JVM Memory Metrics
EdenUsed: 当前已经使用的Eden区内存量（以 KB 为单位）
EdenUsedPercent: 当前已经使用的Eden区内存量占比
SurvivorUsed: 当前已经使用的Survivor区内存量（以 KB 为单位）
SurvivorUsedPercent: 当前已经使用的Survivor区内存量占比
OldGenUsed: 当前已经使用的老年代内存量（以 KB 为单位）
OldGenUsedPercent: 当前已经使用的老年代内存量占比
HeapUsed: 当前已经使用的堆内内存量（以 KB 为单位）
HeapUsedPercent: 当前已经使用的堆内内存量占比
NonHeapUsed: 当前已经使用的非堆内内存量（以 KB 为单位）
NonHeapUsedPercent: 当前已经使用的非堆内内存量占比
PermGenUsed: 当前已经使用的永久代内存量（以 KB 为单位）
PermGenUsedPercent: 当前已经使用的永久代内存量占比
MetaspaceUsed: 当前已经使用的元数据区内存量（以 KB 为单位）
MetaspaceUsedPercent: 当前已经使用的元数据区内存量占比
CodeCacheUsed: 当前已经使用的 CodeCache区 内存量（以 KB 为单位）
CodeCacheUsedPercent: 当前已经使用的 CodeCache区 内存量占比

JVM Thread Metrics
TotalStarted: 自 JVM 启动以来启动过的线程数
Active: 当前存活的线程数，包括守护线程和非守护线程
Daemon: 当前存活的守护线程数
Runnable: 正在 JVM 中执行的线程
Blocked: 受阻塞并等待某个监视器锁的线程数
Waiting: 无限期地等待另一个线程来执行某一特定操作的线程数
TimedWaiting: 等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态数
Terminated: 已退出的线程数
Peak: 自 JVM 启动或峰值重置以来峰值活动线程计数
New: 至今尚未启动的线程数

JVM ByteBuff Metrics
Name: 缓存池名称
Count: 缓存池中 buffer 的数量
MemoryUsed: JVM 用于此缓冲池的内存估计值
MemoryCapacity: 缓存池中所有 buffer 的总容量估计值

JVM Class Metrics
Total: 自 JVM 开始执行到目前已经加载的类的总数
Loaded: 当前加载到 JVM 中的类的数量
Unloaded: 自 JVM 开始执行到目前已经卸载的类的总数

JVM Compilation Metrics
Time: 一个时间片内累计编译时间
TotalTime: 自 JVM 开始执行到目前累计的的总编译时间

JVM FileDescriptor Metrics
OpenCount: 当前打开的文件句柄数
OpenPercent: 当前打开的文件句柄数占最大文件句柄数的百分比
```
#  Rough模式 与 Accurate模式
Rough 模式
- 精度略差，会把响应时间超过指定阈值的记录为’阈值+1’
- 更加节省内存，只使用数组来记录响应时间
- 速度略快一些，但计算 Metrics 的速度略慢一些
- 在 MyPerf4JPropFile 配置文件中指定 recorder.mode = rough

Accurate 模式
- 精度高，会记录所有的响应时间
- 相对耗费内存，使用数组 + Map 来记录响应时间
- 速度略慢一些，但计算 Metrics 的速度略快一些
- 默认

# 使用
```
-javaagent:D:\Github\codedemo\springbootdemos05\springbootdemo414-MyPerf4j\lib\MyPerf4J-ASM.jar -DMyPerf4JPropFile=D:\Github\codedemo\springbootdemos05\springbootdemo414-MyPerf4j\lib\MyPerf4J.properties
```