# 1.概述
Netty 是一个异步的、基于事件驱动的网络应用框架，用于快速开发可维护、高性能的网络服务器和客户端

# 2.Netty的优势
- 传统NIO工作量大，使用麻烦
- Netty 对 API 进行增强，使之更易用，如
    - FastThreadLocal => ThreadLocal
    - ByteBuf => ByteBuffer

# 3.组件
## 3.1 EventLoop
事件循环对象 EventLoop
- 本质是一个单线程执行器（同时维护了一个 Selector），里面有 run 方法处理一个或多个 Channel 上源源不断的 io 事件
- 可以处理普通事件，也可以处理循环事件

事件循环组 EventLoopGroup
- 一组 EventLoop，Channel 一般会调用 EventLoopGroup 的 register 方法来绑定其中一个 EventLoop
- 后续这个 Channel 上的 io 事件都由此 EventLoop 来处理（保证了 io 事件处理时的线程安全）

绑定多个NioEventLoopGroup
![](netty-demo02/img/NioEventLoopGroup.jpg)

绑定自定义EventLoopGroup
![](netty-demo02/img/自定义EventLoopGroup.jpg)

## 3.2 Channel 通道
Channel 的常用方法
- close()
- closeFuture()
- sync 方法作用是同步等待 Channel 关闭
- 而 addListener 方法是异步等待 Channel 关闭
- pipeline() 方法用于添加处理器
- write() 方法将数据写入
    - 因为缓冲机制，数据被写入到 Channel 中以后，不会立即被发送
    - 只有当缓冲满了或者调用了flush()方法后，才会将数据通过 Channel 发送出去
- writeAndFlush() 方法将数据写入并立即发送（刷出）

ChannelFuture：connect连接后的异步对象
- 连接处理
- 关闭处理

## 3.3 Future与Promise
netty 的 Future 继承自 jdk 的 Future，而 Promise 又对 netty Future 进行了扩展
- jdk Future 只能同步等待任务结束（或成功、或失败）才能得到结果
- netty Future 可以同步等待任务结束得到结果，也可以异步方式得到结果，但都是要等任务结束
- netty Promise 不仅有 netty Future 的功能，而且脱离了任务独立存在，只作为两个线程间传递结果的容器
    - 两个线程都可以往其间设置结果

## 3.4 Handler和Pipeline
handler需要放入通道的pipeline中，才能根据放入顺序来使用handler
- pipeline是结构是一个带有head与tail指针的双向链表，其中的节点为handler
    - 要通过ctx.fireChannelRead(msg)等方法，将当前handler的处理结果传递给下一个handler
- 当有入站（Inbound）操作时，会从head开始向后调用handler，直到handler不是处理Inbound操作为止
- 当有出站（Outbound）操作时，会从tail开始向前调用handler，直到handler不是处理Outbound操作为止

EmbeddedChannel可以用于测试各个handler


