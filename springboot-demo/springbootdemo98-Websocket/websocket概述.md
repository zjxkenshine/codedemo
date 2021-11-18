# 1.WebSockets简介
- WebSocket是HTML5的一种新的网络通信协议，它实现了服务端与客户端的全双工通信，建立在传输层TCP协议之上，即浏览器与服务端需要先建立TCP协议，再发送WebSocket连接建立请求。
- http协议有一个缺陷，通信只能由客户端发起请求，服务器端返回查询结果
- WebSocket创建连接过程：
   - 客户端发送请求信息，服务端接收到这个请求并返回响应信息。
   - 当连接建立后，客户端发送http请求时，通过Upgrade:webSocket Connection:Upgrade 告知服务器需要建立的是WebSocket连接，并且还会传递WebSocket版本号、协议的字版本号、原始地址、主机地址， WebSocket相互通信的Header很小，大概只有2Bytes
- WebSocket的优点：
    - 服务器可以主动向客户端推送消息，客户端也可以主动向服务器端发送消息
    - 使用WebSockets可以在服务器与客户端之间建立一个非http的双向连接。这个连接是实时的，也是永久的(除非被关闭)
