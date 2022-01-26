# 1.协议的作用
- TCP/IP 中消息传输基于流的方式，没有边界
- 协议的目的就是划定消息的边界，制定通信双方要共同遵守的通信规则

# 2.Redis协议
详见netty-demo04/demo01

# 3.HTTP协议
- HTTP协议在请求行请求头中都有很多的内容，自己实现较为困难
- 可以使用`HttpServerCodec`作为服务器端的解码器与编码器，来处理HTTP请求
- 详见netty-demo04/demo02

# 4.自定义协议与解析
## 组成要素
- 魔数：用来在第一时间判定接收的数据是否为无效数据包
- 版本号：可以支持协议的升级
- 序列化算法：消息正文到底采用哪种序列化反序列化方式
    - 如：json、protobuf、hessian、jdk
- 指令类型：是登录、注册、单聊、群聊… 跟业务相关
- 请求序号：为了双工通信，提供异步能力
- 正文长度
- 消息正文

## 编码器与解码器
- 编码器与解码器方法源于父类ByteToMessageCodec，通过该类可以自定义编码器与解码器
- 编码器负责将附加信息与正文信息写入到ByteBuf中，其中附加信息总字节数最好为2n，不足需要补齐。
    - 正文内容如果为对象，需要通过序列化将其放入到ByteBuf中
- 解码器负责将ByteBuf中的信息取出，并放入List中，该List用于将信息传递给下一个handler

## @Sharable注解
TestMessageCodec03
- 为了提高handler的复用率，可以将handler创建为handler对象，然后在不同的channel中使用该handler对象进行处理
- 只有带有该注解的handler，才能通过对象的方式被共享，否则无法被共享
- LengthFieldBasedFrameDecoder不能共享


