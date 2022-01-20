# 1.三大组件简介
Channel、Buffer、Selector

Java NIO系统的核心在于：通道(Channel)和缓冲区(Buffer)
-  通道负责传输，缓冲区负责存储

Selector作用：配合一个线程来管理多个 channel
- 适合连接数多，但流量较少的场景
- 传统模式socket连接未断开，则无法处理其他socket连接

# 2.ByteBuffer
## 2.1 核心属性
- capacity：缓冲区的容量。
- limit：缓冲区的界限。
- position：下一个读写位置的索引。缓冲区的位置不能为负，并且不能大于limit
- mark：记录当前position的值。position被改变后，可以通过调用reset() 方法恢复到mark的位置

## 2.2 核心方法
- put：将一个数据放入到缓冲区中
- flip：切换对缓冲区的操作模式，由写->读 / 读->写
- get：读取缓冲区中的一个值,并且position+1
- rewind：只能在读模式下使用，恢复position、limit和capacity的值
- clean：将缓冲区中的各个属性恢复为最初的状态，position = 0, capacity = limit
    - 缓冲区数据依然存在，下次写会进行覆盖
- mark：将position的值保存到mark属性中
- reset：将position的值改为mark中保存的值
- compact：ByteBuffer的方法，而不是Buffer的方法
    - 把未读完的数据向前压缩，然后切换到写模式，比clear更耗费性能

## 2.3 粘包与半包
粘包
- 发送方在发送数据时，并不是一条一条地发送数据，而是将数据整合在一起，当数据达到一定的数量后再一起发送。这就会导致多条信息被放在一个缓冲区中被一起发送出去

半包
- 接收方的缓冲区的大小是有限的，当接收方的缓冲区满了以后，就需要将信息截断，等缓冲区空了以后再继续放入数据。这就会发生一段完整的数据最后被截断的现象


