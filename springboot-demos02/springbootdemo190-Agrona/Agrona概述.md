# 1.Agrona简介
Agrona 提供了一个数据结构和实用方法库，这是在 Java 中构建高性能应用程序时的常见需求

# 2.相关特性：
- Buffers：原子缓冲区，用于使用内存排序语义处理堆内和堆外内存
- Lists：支持int/long列表，避免装箱
- Maps：可以使用int/long作为键和值
- Sets：可以使用int/long的Set集合
- Cache：可以使用int/long作为键
- Clocks：时钟
- Queues：低延时序列的无锁实现
- Ring/Broadcast Buffers：为IPC(进程间)通信实现的堆外缓存
- 简单的代理
- 支持程序处理`Ctrl + c`信号
- Scalable Timer Wheel：用于在给定的期限内使用 O(1) 注册和取消时间安排计时器
- 从专用于原始类型的带注释的实现生成代码
- 用于应用遥测、位置跟踪和协调的堆外计数器实现
- 可以包装直接缓冲区的 InputStream 和 OutputStream 的实现
- DistinctErrorLog：不同错误的日志
- IdGenerator：采用Twitter雪花算法的无锁实现的并发和分布式唯一 id 生成器

# 3.相关组件
## 3.1 Agents
1. Duty Cycle：在死循环中执行代码的编程模型,示例：
    ```
    while (true) {
        int result = doLogic();
        doIdleStrategies(result);
    }
    ```
2. Agent：代理，被安排在一个线程的duty cycle中执行
    - `doWork()`：处理业务逻辑,返回<=0会执行空闲策略
    - `onStart()`，`onClose`：Agent 启动和关闭时的回调钩子方法
    - `roleName()`：代理名称
3. IdleStrategy：空闲策略，非线程安全
    - SleepingIdleStrategy：基于`parkNanos`实现线程暂停
    - SleepingMillisIdleStrategy：基于`thread.sleep`实现线程暂停
    - YieldingIdleStrategy：使用`thread.yield`让出对线程的控制
    - BackoffIdleStrategy：Aeron Cluster 默认的策略，先使用 spinning 再使用 yield，再根据配置的 parkNanos
    - NoOpIdleStrategy：不做任何处理
    - BusySpinIdleStrategy：对于 Java 9 及以上版本，将会使用`Thread.onSpinWait()`
    - 自定义策略：实现`IdleStrategy`接口
4. AgentRunner：将Agent和IdleStrategy组合并自动运行
    - 获取AgentRunner对象(构造方法看源码)
    - 三种启动方式：
        - AgentRunner.startOnThread(AgentRunner)：创建一个线程并执行
        - AgentRunner#startOnThread(AgentRunner, ThreadFactory)：使用指定ThreadFactory创建线程并执行
        - 多个Agent组成一个CompositeAgent并执行
5. AgentInvoker：手动控制 Agent 的运行
    - 相比AgentRunner去掉了空闲策略，手动运行不需要这个参数
    
## 3.2 Clocks
Agrone提供了一套自己的 Clock API，首先它是基于Epoch Time，顶层接口是EpochClock
   - 主要有两种实现：`SystemEpochClock`和`CachedEpochClock`
   - SystemEpochClock：对 System.currentTimeMillis() 的封装
   - CachedEpochClock：就是一个缓存
        - `update()`：设置时间
        - `advance()`：增加时间
        - `time()`：获取结果

## 3.3 RingBuffer环形缓冲区
1. OneToOneRingBuffer：适用于单生产者单消费者的场景
    - MessageHandler：消费数据需要实现的接口
    - RingBuffer.write：写入数据
    - TryClaim：写入数据时，可直接操作底层数据结构，省去write()方法拷贝的开销
    - ControlledMessageHandler：消费，与MessageHandler的`onMessage()`方法的返回值不同
2. ManyToOneRingBuffer：支持多生产者的场景
3. Broadcast：广播，发送方的生产速度快于消费者的消费能力，消息会被丢弃
    - BroadcastTransmitter：生产者
    - BroadcastReceiver：消费者

## 3.4 数据结构
Agrona 提供了许多集合数据结构，用于解决基础数据类型在集合中需要装箱拆箱的开销
1. HashMaps：
    - Int2IntHashMap：`<int, int>`的 HashMap
    - Int2ObjectHashMap：`<int, object>`的 HashMap
    - Long2LongHashMap：`<long, long>`的 HashMap
    - 其他HashMap详见`org.agrona.collections`包
2. Caches：
    - Int2ObjectCache
    - IntLruCache：固定大小缓存，使用LRU策略清理缓存
3. HashSets：
    - IntHashSet：基础 int 类型的 HashSet，自动扩容
    - ObjectHashSet：object 类型的 HashSet，自动扩容
4. Others：其他集合
    - IntArrayList：基础 int 类型的 ArrayList
    - IntArrayQueue：基础 int 类型的 ArrayQueue
    - BiInt2ObjectMap：将两个 int 类型组合成一个 key，value 为 object 的 Map

## 3.5 Direct Buffer直接缓冲区
具体示例查看ringbuffer中的ReceiveAgent
1. Agrona 定义了 DirectBuffer 接口在用于和 Aeron 交互，它有点类似于 Java NIO ByteBuffer，但更方便一些
    - UnsafeBuffer：堆外固定大小缓冲区，当超出大小时，会抛出 IndexOutOfBoundsException 异常
    - ExpandableDirectByteBuffer：底层使用 ByteBuffer的直接缓冲区，超出大小会创建新ByteBuffer并拷贝
    - ExpandableArrayBuffer：底层使用字节数组（new byte[size]）的直接缓冲区
2. 字序问题：
    - Agrona 默认使用的字节序为 ByteOrder.nativeOrder() 的字节序，读写使用不同的字节序，会导致错误的结果
    - 不同操作系统可能会出现这个问题
3. Chars & Bytes
    - DirectBuffer 提供了读写单个字节或 16 位字符的方法
4. Shorts, Integers & Longs
    - DirectBuffer 提供了对 short、int、long 型数据的读写支持。
    - 对于 int 和 long，还额外提供了 compare-and-set、get-and-add、get-and-set 的工具方法
5. Floats & Doubles
    - DirectBuffer 提供了读写 float 和 double 的方法
    - 通常不推荐使用 float 和 double 进行数据传输，要么使用格式化为字符串的 BigDecimal，要么使用缩放后的 long
6. Strings
    - putStringAscii、putStringUtf8 操作非固定长度字符串，效率较低
    - putStringWithoutLengthAscii、putStringWithoutLengthUtf8 操作固定长度字符串

## 3.6 IdGenerator
基于雪花算法的id生成器