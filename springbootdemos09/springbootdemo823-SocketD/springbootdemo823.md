# 参考地址
socket.d 基于"事件"和"语义消息""流"的网络应用协议（在微服务、移动应用、物联网等场景，可替代 http、websocket 等）
- https://gitee.com/noear/socket.d
- https://socketd.noear.org/article/692

# 特性
- 基于事件，每个消息都可事件路由
- 所谓语义，通过元信息进行语义描述
- 流关联性，有相关的消息会串成一个流
- 语言无关，使用二进制输传数据（支持 tcp, ws, udp）。支持多语言、多平台
- 断线重连，自动连接恢复
- 多路复用，一个连接便可允许多个请求和响应消息同时运行
- 双向通讯，单链接双向互听互发
- 自动分片，数据超出 16Mb（大小可配置），会自动分片、自动重组（udp 除外）
- 接口简单，是响应式但用回调接口

# 基于事件的语义消息
`[len:int][flag:int][sid:str(<64)][\n][event:str(<512)][\n][metaString:str(<4k)][\n][data:byte(<16m)]`
- sid：流标识（streamId）
- event：事件，类似`demo, demo.test`
- metaString：语义（即元信息描述）

# 配置类
## 公共配置
```
//客户模式
private final boolean clientMode;
//串行发送
private boolean serialSend;
//无锁发送
private boolean nolockSend;
//流管理器
private final StreamManger streamManger;
//编解码器
private final Codec codec;

//id生成器
private IdGenerator idGenerator;
//分片处理
private FragmentHandler fragmentHandler;
//分片大小
private int fragmentSize;

//ssl 上下文
private SSLContext sslContext;
//字符集
protected Charset charset;


//io线程数
protected int ioThreads;
//解码线程数
protected int codecThreads;
//交换线程数
protected int exchangeThreads;

//交换执行器
private volatile ExecutorService exchangeExecutor;
private volatile ExecutorService exchangeExecutorSelfNew;

//读缓冲大小
protected int readBufferSize;
//写缓冲大小
protected int writeBufferSize;

//连接空闲超时
protected long idleTimeout;
//请求默认超时
protected long requestTimeout;
//消息流超时（从发起到应答结束）
protected long streamTimeout;
//最大udp包大小
protected int maxUdpSize;
//使用最大内存限制
private boolean useMaxMemoryLimit;
//最大内存比例
protected float maxMemoryRatio;
```

## 客户端配置
```
//通讯架构（tcp, ws, udp）
private final String schema;

//连接地址
private final String linkUrl;
private final String url;
private final URI uri;
private int port;

//心跳间隔（毫秒）
private long heartbeatInterval;

//连接越时（毫秒）
private long connectTimeout;

//是否自动重链
private boolean autoReconnect;
```

## 服务端配置
```
private final String schema;
//主机名
private String host;
//端口
private int port;
```

# Broker模式
连接时为自己命名
```
sd:tcp://127.0.0.1:8602?@=demoapp
```
转发方式：
```
session.send("test", new StringEntity("hello").at("demoapp")); // 单播
session.send("test", new StringEntity("hello").at("demoapp!")); // 单播
session.send("test", new StringEntity("hello").at("demoapp*")); // 组播
session.send("test", new StringEntity("hello").at("*")); // 广播
```

# 目录
- test01：基本使用
- test02：监听器
- test03：Broker模式
- test04：消息互发、相互监听
- test05：消息队列实现
- test06：聊天实现