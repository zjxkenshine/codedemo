# 参考地址
- https://blog.csdn.net/qq_44654974/article/details/127348214
- https://www.jb51.net/article/264152.htm

JSch 是 SSH2 的一个纯 Java 实现。它允许你连接到一个 sshd 服务器，使用端口转发，X11 转发，文件传输等等

windows开启ssh
- https://www.cnblogs.com/Wei-Ting/p/17266540.html

使用方式
1. 创建JSch的对象
2. 创建会话，并进行连接会话（HOST、PORT，通信的本质是进程之间的通信，可以联系JDBC、Netty等通信设计）
3. 进行验证、设置密码（可同第二步）
4. 进行请求连接、
5. 获取通道，通信的过程实则为IO的连接过程
6. 进行sftp的操作，例如get\put等，sftp协议提供的相应指令
