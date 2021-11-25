# 参考地址
Java-Thread-Affinity框架使用及原理分析
- https://blog.csdn.net/w57685321/article/details/111350424
- https://github.com/OpenHFT/Java-Thread-Affinity

# 线程亲和性概述
- 有时候我们在多核机器上，需要将线程(或进程)绑定到给定的某个核心上，让它独享一核心，比如队列的BusySpin忙等策略中、或者netty的eventLoop，将这个忙等的线程绑定到一个cpu核上，可以确保该进程的最大执行速度，实现低延迟，消除操作系统进行调度过程导致线程迁移所造成的抖动影响，还可以避免由于缓存失效而导致的性能开销
- 这种绑定关系叫做线程(或进程)亲和（affinity），也叫线程(或进程)的亲缘性屏蔽，就是进程要在某个给定的 CPU 上尽量长时间地运行而不被迁移到其他处理器的倾向性


