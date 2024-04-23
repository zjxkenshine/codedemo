# 参考地址
socket-point 超简单的socket连接工具，拓展性高且使用简单
- https://github.com/Verlif/socket-point
- https://verlif.top/socket-point/

需要java9以上环境

# 特点
- 无client与server的区别，统一为SocketPoint
- SocketPoint允许接收其他SocketPoint连接或是连接到其他的SocketPoint
- 与原生Socket或是WebSocket互通（请注意ReceiveHolder消息终止方式）
- 同一个SocketPoint可以即是server也是client
- 允许自定义信息传输格式化，多行文本不再会被分成多条信息发送
- 拓展性更高的工厂模式与监听器，可以支持连接过滤、信息加密、限时连接等多种特性。
