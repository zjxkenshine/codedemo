# 1. 并发集合概述
分为三大类：
- 遗留的：HashTable,Vector
- 同步集合：Collections.SynchronizedXXX
- JUC安全集合：java.util.concurrent.*

JUC分为三大类：
- BlockingXXX：大部分基于锁，并提供用来阻塞的方法
- CopyOnWrite 之类容器修改开销相对较重
- Concurrent 类型的容器
    - 内部很多操作使用 cas 优化，一般可以提供较高吞吐量
    - 弱一致性
        - 遍历时弱一致性
        - size弱一致性
        - 读取弱一致性

# 2. ConcurrentHashMap使用
使用代码：
- Test01_ConcurrentHashMap
- Test02_ConcurrentHashMap02

jdk7 HashMap多线程下有并发死链问题

# 3. LinkedBlockingQueue使用
LinkedBlockingQueue通过Node实现了链表存储，链表是可伸缩的
- Test03_LinkedBlockingQueue

# 4. ArrayBlockingQueue使用
LinkedBlockingQueue 与 ArrayBlockingQueue 的性能比较
- Linked 支持有界，Array 强制有界
- Linked 实现是链表，Array 实现是数组
- Linked 是懒惰的，而 Array 需要提前初始化 Node 数组
- Linked 每次入队会生成新 Node，而 Array 的 Node 是提前创建好的
- Linked 两把锁，Array一把锁

- Test04_ArrayBlockingQueue

# 5. ConcurrentLinkedQueue使用
ConcurrentLinkedQueue 的设计与 LinkedBlockingQueue 非常像，也是
- 两把【锁】，同一时刻，可以允许两个线程同时（一个生产者与一个消费者）执行
- dummy 节点的引入让两把【锁】将来锁住的是不同对象，避免竞争
- 只是这【锁】使用了 cas 来实现

- Test05_ConcurrentLinkedQueue

# 6. CopyOnWriteArrayList使用
CopyOnWriteArraySet 是它的马甲 底层实现采用了 写入时拷贝 的思想
- 增删改操作会将底层数组拷贝一份，更改操作在新数组上执行，这时不影响其它线程的并发读，读写分离
- 缺点：写操作很多时占用内存

- Test05_CopyOnWriteArrayList
