# 1.Mina概述
- Apache MINA是一个网络通信应用框架，可帮助用户轻松开发高性能和高可扩展性的网络应用程序;
- 它通过Java NIO在各种传输上提供抽象的，事件驱动的异步API
- Netty作者早期产品

# 2.MINA 基础
## 2.1 NIO
- NIO非阻塞IO流
- 结构:
    - Buffers - 数据容器
    - Chartsets - 用于字节和Unicode的容器转换器
    - Channels - 表示与能够进行IO操作的实体的连接
    - Selectors - 提供可选择的多路复用非阻塞IO
    - Regexps - 提供一些工具来操作正则表达式
- NIO与BIO
    - BIO:阻塞
    - NIO:非阻塞

## 2.2 结构简介
1. Mina包
![](img/mina包.jpg)

2. Mina结构图：
![](img/mina架构图.jpg)
    - I/O Service ：负责处理I/O。
    - I/O Filter Chain ：负责编码处理，字节到数据结构或数据结构到字节的转换等，即非业务逻辑的操作。
    - I/O Handle ：负责处理业务逻辑

3. 几个重要接口: 
    - IoServiece ：这个接口在一个线程上负责套接字的建立，拥有自己的 Selector，监听是否有连接被建立。
    - IoProcessor ：这个接口在另一个线程上负责检查是否有数据在通道上读写(拥有自己的 Selector)，负责调用注册在 IoService 上的过滤器，并在过滤器链之后调用 IoHandler。
        - NIO只用一个Selector,不区分IoService与IoProcessor
    - IoAccepter ：相当于网络应用程序中的服务器端
    - IoConnector ：相当于客户端
    - IoSession ：当前客户端到服务器端的一个连接实例
    - IoHandler ：这个接口负责编写业务逻辑，也就是接收、发送数据的地方。需要自己编写的部分代码。
    - IoFilter ：定义一组过滤器，这些过滤器可以包括日志输出、黑名单过滤、数据的编码与解码(最重要)。 
4. Mina核心
    - IoBuffer：ByteBuffer的替代品
    - Codec Filter：没有该过滤器可能发送和接收的消息数不相等
    - Executor Filter：它包含一个Executor，用于将传入的事件传播到线程池(适合CPU密集型任务)
    - SSL Filter：负责管理通过安全连接发送的数据的加密和解密的过滤器
    - Logging Filter：指定触发日志记录的IoHandler事件以及执行日志记录的级别