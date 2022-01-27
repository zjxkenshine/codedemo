# 1.包概述
- client：客户端
- message：消息
- protocol：协议相关的编解码器
- server：服务端
    - service：用户管理
    - session：会话管理

# 2.业务相关
重点在ChatClient和ChatServer

- 登录：LoginRequestMessageHandler
- 单聊：ChatRequestMessageHandler
- 创建群：GroupCreateRequestMessageHandler
- 群聊：GroupChatRequestMessageHandler
- 加群：GroupJoinMessageHandler
- 退群：GroupQuitMessageHandler
- 查看群成员：GroupMembersMessageHandler
- 退出登录：QuitHandler

# 3.空闲检测
## 连接假死
原因
- 网络设备出现故障，例如网卡，机房等，底层的 TCP 连接已经断开了，但应用程序没有感知到，仍然占用着资源
- 公网网络不稳定，出现丢包。如果连续出现丢包，这时现象就是客户端数据发不出去，服务端也一直收不到数据，会白白地消耗资源
- 应用程序线程阻塞，无法进行数据读写

问题
- 假死的连接占用的资源不能自动释放
- 向假死的连接发送数据，得到的反馈是发送超时

解决方法 ChatServer中
- 添加IdleStateHandler对空闲时间进行检测，通过构造函数可以传入三个参数
    - readerIdleTimeSeconds 读空闲经过的秒数
    - writerIdleTimeSeconds 写空闲经过的秒数
    - allIdleTimeSeconds 读写空闲经过的秒数
- 使用双向处理器ChannelDuplexHandler对入站与出站事件进行处理
    - IdleStateHandler中的事件为特殊事件，需要实现ChannelDuplexHandler的userEventTriggered方法，判断事件类型并自定义处理方式，来对事件进行处理

# 4.心跳检测
- 为避免因非网络等原因引发的READ_IDLE事件
    - 如网络情况良好，只是用户本身没有输入数据，这时发生READ_IDLE事件，直接让服务器断开连接是不可取的
- 需要在客户端向服务器发送心跳包，发送频率要小于服务器设置的IdleTimeSeconds，一般设置为其值的一半

