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
