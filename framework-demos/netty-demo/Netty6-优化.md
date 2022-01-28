# 1.拓展序列化算法
相关类：
- Serializer
- SerializerAlgorithm
- MessageCodecSharable 编解码时使用

添加配置类
- Config
- application.properties

测试
- TestSerializer

# 2.Netty参数调优 netty-demo07

## 2.1 参数配置
- 客户端：bootstrap.option配置
- 服务器端：
    - serverBootstrap.option：给 ServerSocketChannel 配置参数
    - serverBootstrap.childOption：给 SocketChannel 配置参数

## 2.2 CONNECT_TIMEOUT_MILLIS
- 属于 SocketChannel 的参数
- 用在客户端建立连接时，如果在指定毫秒内无法连接，会抛出 timeout 异常
- 注意：Netty 中不要用成了SO_TIMEOUT 主要用在阻塞 IO，而 Netty 是非阻塞 IO

## 2.3 SO_BACKLOG
ServerSocketChannel 的参数

### 三次握手与连接队列
- 第一次握手时，因为客户端与服务器之间的连接还未完全建立，连接会被放入半连接队列中
- 当完成三次握手以后，连接会被放入全连接队列中
- 服务器处理Accept事件是在TCP三次握手，也就是建立连接之后。服务器会从全连接队列中获取连接并进行处理

在 linux 2.2 之前，backlog 大小包括了两个队列的大小，在 linux 2.2 之后，分别用下面两个参数来控制
- 半连接队列：sync queue
    - 大小通过 /proc/sys/net/ipv4/tcp_max_syn_backlog 指定，在 syncookies 启用的情况下，逻辑上没有最大值限制，这个设置便被忽略
- 全连接队列：accept queue
    - 其大小通过 /proc/sys/net/core/somaxconn 指定，在使用 listen 函数时，内核会根据传入的 backlog 参数与系统参数，取二者的较小值
- 如果 accpet queue 队列满了，server 将发送一个拒绝连接的错误信息到 client

### SO_BACKLOG作用
- 主要用于设置全连接队列的大小
- 当处理Accept的速率小于连接建立的速率时，全连接队列中堆积的连接数大于 SO_BACKLOG 设置的值是，便会抛出异常

默认值：根据操作系统的不同，来选择不同的默认值
- Windows 200
- Linux/Mac OS 128
- 如果配置文件/proc/sys/net/core/somaxconn存在，会读取配置文件中的值

## 2.4 TCP_NODELAY
- 属于 SocketChannel 参数
- 因为 Nagle 算法，数据包会堆积到一定的数量后一起发送，这就可能导致数据的发送存在一定的延时
- 该参数默认为false，如果不希望的发送被延时，则需要将该值设置为true

## 2.5 SO_SNDBUF & SO_RCVBUF
- SO_SNDBUF 属于 SocketChannel 参数
- SO_RCVBUF 既可用于 SocketChannel 参数，也可以用于 ServerSocketChannel 参数（建议设置到 ServerSocketChannel 上）
- 该参数用于指定接收方与发送方的滑动窗口大小

## 2.6 ALLOCATOR 分配器
TestAllocator 
- 属于 SocketChannel 参数
- 用来配置 ByteBuf 是池化还是非池化，是直接内存还是堆内存

## 2.7 RCVBUF_ALLOCATOR RCV分配器
- 属于 SocketChannel 参数
- 控制 Netty 接收缓冲区大小
- 负责入站数据的分配，决定入站缓冲区的大小（并可动态调整），统一采用 direct 直接内存
    - 具体池化还是非池化由 allocator 决定

