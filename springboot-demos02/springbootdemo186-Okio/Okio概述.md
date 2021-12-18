# 1.简介
- Okio 是一个库，可以补充java.io并简化java.nio访问、存储和处理数据的过程
- 原本是OkHttp的一个组件

# 2.组成
1. Okio两种基本类型：ByteString与Buffer
    - ByteString：不可变的字节序列
        - 可以轻松地将二进制数据视为值，自动编/解码为十六进制、base64 和 UTF-8
    - Buffer：缓冲区，可变的字节序列
        - 将数据写入末尾并从前面读取，不用管理位置和容量
2. Okio两种流类型：Source和Sink
    - 超时：提供超时访问，包括读写操作
    - 易于实现：Source声明三种方法：`read()`，`close()`，和`timeout()`
    - 使用方便：BufferedSource和BufferedSink接口
    - 没有字符流与字节流的区别
    - 易于测试
    - Souce类似InputStream，Sink类似OutputStream
3. FakeFileSystem：假文件系统
    - 用于测试的完全内存文件系统
4. NodeJsFileSystem：NodeJs文件系统

