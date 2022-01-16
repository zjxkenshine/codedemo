# 1.简介
一个用于高效处理堆和堆外内存的 Java 库
- 类似NIO中的ByteBuffer

# 2.主要使用者
- trino(Presto)

# 3.主要类
- Slice：核心类，代表一个内存切片
- Slices：构建Slice
- SliceUtf8：UTF8切片工具类
- SliceInput：输入流
    - BasicSliceInput
    - ChunkedSliceInput：分片输入
    - FixedLengthSliceInput
    - InputStreamSliceInput
- SliceOutput：输出流
    - BasicSliceOutput
    - DynamicSliceOutput
    - OutputStreamSliceOutput

# 4.Slices一些方法:
- allocate：堆分配
- allocateDirect：直接内存分配，数据量很大时性能好
- copyOf：复制Slice
- wrappedBuffer：包装NIO中的ByteBuffer
- wrappedxxxArray：包装各种类型数组
- mapFileReadOnly：返回一个只读文件Slice,底层是NIO FileChannel.map