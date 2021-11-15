# Quasar概述
- Quasar提供了高性能轻量级的线程
- Quasar fiber依赖java instrumentation修改你的代码，可以在运行时通过java Agent实现，也可以在编译时使用ant task实现
- Fiber实质上是 continuation,可以捕获一个计算的状态，可以暂停当前的计算，等隔一段时间可以继续执行
- Fiber调度器FiberScheduler是一个高效的、work-stealing、多线程的调度器
- 默认的调度器是FiberForkJoinScheduler,但是你可以使用自己的线程池去调度(参考FiberExecutorScheduler)