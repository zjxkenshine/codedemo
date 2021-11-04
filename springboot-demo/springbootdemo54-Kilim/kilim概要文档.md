# 1.协程（Coroutine）/纤程（Fiber）概念
- 协程，又称微线程，纤程，指在一个线程内进行任务切换
- 协程间也没有锁和同步的概念，复杂性也比多线程低

协程与多线程：
- 子程序切换不是线程切换，而是由程序自身控制，因此，没有线程切换的开销，和多线程比，线程数量越多，协程的性能优势就越明显
- 不需要多线程的锁机制，因为只有一个线程，也不存在同时写变量冲突，在协程中控制共享资源不加锁，只需要判断状态就好了，所以执行效率比多线程高很多

# 2.Kilim中的关键概念
1. Task：协程任务(execute()执行)，和thread相同
2. Mailbox：消息传递,协程间通信载体
    - Mailbox的基本原则为可以有多个消息发送者，但只能有一个消息接收者
    - mailbox.put(messageObject); // 同步发送
    - mailbox.putnb(messageObject); // 异步发送
    - mailbox.putb(messageObject); // 阻塞线程方式发送
3. Fiber：保存和管理任务执行堆栈
4. weaver字节码织入：Kilim框架在开发后期需要使用工具将协程代码织入(weaver)原始代码，以支持协程的正常工作

# 3.Maven织入
- 使用maven插件，在编译期间通过运行kilim.tools.Weaver
- 运行时调用`kilim.tools.Kilim com.yourcompany.yourclass`
- 在main方法开头调用`(kilim.tools.Kilim.trampoline(false,args)) return;`
- 参考demo01






