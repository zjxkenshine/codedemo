# guava的一些demo
学习地址 
- https://ifeve.com/google-guava/
- https://www.bilibili.com/video/BV1R4411s7GX
- https://blog.csdn.net/qq_17200461/article/details/114239824
- https://blog.csdn.net/wuyuxing24/article/details/95505102


包目录：
- ifeve: https://ifeve.com/google-guava/  学习demo
- bilibili: https://www.bilibili.com/video/BV1R4411s7GX  学习demo
    - https://blog.csdn.net/qq_17200461/article/details/114239824

## bilibili 学习demo目录

- utilities guava工具集的demo
    - JoinerTest            Joiner 合并测试
    - SplitterTest          Splitter 拆分测试
    - PreconditionsTest     Preconditions 断言测试
    - StringsTest           Strings/Charsets 字符串测试
    - CharMatcherTest       CharMatcher 字符匹配测试
    - StopWatch         
- functional    函数式接口，与java8类似，跳过 
- io                    io相关demo
    - FilesTest         Files文件工具类测试
    - CharSourceTest    字符流输入/输出测试(CharSource/Sink)
    - ByteSourceTest    字节输入/输出(ByteSource/Sink)
    - CloserTest        Closer关闭器
    - BaseEncodingTest      Base编码
- eventBus      事件总线
    - events        事件及注册
    - listeners     事件监听器
    - SimpleEventBus            简单事件监听器示例
    - MultipleEventExample      多事件监听器示例
    - InheritListenersEventBusExample    继承监听器
    - InheritEventBusExample        继承事件
    - ExceptionEventBusExample      异常事件监听器
    - DeadEventBusExample           可获取事件信息的监听器
    - async                         AsyncEventBus 异步事件总线
- concurrent    guava并发包
    - MonitorExample         Monitor实现生产者消费者
    - RateLimitExample       RateLimit的基本使用
    - BucketTest             RateLimit在漏桶算法中的使用
    - TokenBucketExample        RateLimit在令牌桶中的使用
    - ListenableFutureExample       ListenableFuture的使用
- cache         guava缓存
    - ReferenceExample      java引用示例
    - CacheLoaderTest1      CacheLoader基本用法及size,weight逐出策略
    - CacheLoaderTest2      AccessTime和WriteTime逐出，软引用和弱引用
    - CacheLoaderTest3         