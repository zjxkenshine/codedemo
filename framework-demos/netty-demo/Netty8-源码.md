详见：
https://nyimac.gitee.io/2021/04/25/Netty%E5%9F%BA%E7%A1%80/#%E5%85%AD%E3%80%81%E6%BA%90%E7%A0%81

# 1.启动流程
- 获得选择器Selector，Netty中使用NioEventloopGroup中的NioEventloop封装了线程和选择器
- 创建NioServerSocketChannel，该Channel作为附件添加到ServerSocketChannel中
    - register方法
- 创建ServerSocketChannel，将其设置为非阻塞模式，并注册到Selector中
    - 此时未关注事件，但是添加了附件NioServerSocketChannel
- 绑定端口
- 通过interestOps设置感兴趣的事件

## bind
- 选择器Selector的创建是在NioEventloopGroup中完成的。
- NioServerSocketChannel与ServerSocketChannel的创建，ServerSocketChannel注册到Selector中以及绑定操作都是由bind方法完成的

## doBind
- 真正完成初始化、注册以及绑定的方法是io.netty.bootstrap.AbstractBootstrap.doBind
- doBind()中有两个重要方法
    - `initAndRegister`
    - `doBind0`

## initAndRegister
主要负责
- NioServerSocketChannel和ServerSocketChannel的创建（主线程中完成）
- ServerSocketChannel注册（NIO线程中完成）工作

### init 方法
init主要完成了以下三个操作
- 创建NioServerSocketChannel
- 通过NioServerSocketChannel的构造器，创建了ServerSocketChannel
- 由initChannel方法向NioServerSocketChannel中添加了两个handler，添加操作在register之后被执行
    - 一个handler负责设置配置
    - 一个handler负责发生Accepet事件后建立连接

### Register 方法
- init执行完毕后，便执行ChannelFuture regFuture = config().group().register(channel)操作
    - 该方法最终调用的是promise.channel().unsafe().register(this, promise)方法

Register主要完成了以下三个操作
- 完成了主线程到NIO的线程切换
    - 通过eventLoop.inEventLoop()进行线程判断，判断当前线程是否为NIO线程
    - 切换的方式为让eventLoop执行register的操作
    - register的操作在NIO线程中完成
- 调用doRegister方法
    - 将ServerSocketChannel注册到EventLoop的Selector中
    - 此时还未关注事件
    - 添加NioServerSocketChannel附件
- 通过invokeHandlerAddedIfNeeded调用init中的initChannel方法
    - initChannel方法主要创建了两个handler
        - 一个handler负责设置配置
        = 一个handler负责发生Accept事件后建立连接
        
## doBind0 方法

### 绑定端口
- 在doRegister和invokeHandlerAddedIfNeeded操作中的完成后，会调用safeSetSuccess(promise)方法，向Promise中设置执行成功的结果
- 此时doBind方法中由initAndRegister返回的ChannelFuture对象regFuture便会由NIO线程异步执行doBind0绑定操作

### 关注事件
- 在绑定端口操作完成后，会判断各种所有初始化操作是否已经完成，若完成，则会添加ServerSocketChannel感兴趣的事件
- 最终在AbstractNioChannel.doBeginRead方法中，会为ServerSocketChannel添加Accept事件

# 2.NioEventLoop
## 组成
- Selector
- Thread与TaskQueue：线程与任务队列

Selector创建
- NioEventLoop的构造方法中，调用了openSelector()方法， 该方法会返回一个SelectorTuple对象，该方法是创建Selector的核心方法

两个Selector，selector和unwrappedSelector
- selector中的SelectedKeys是基于数组的（数组的遍历效率要高于HashSet）
- unwrappedSelector中的SelectedKeys是基于HashSet的

## NIO线程启动时机
启动
- NioEventLoop中的线程，在首次执行任务时，才会被创建，且只会被创建一次

唤醒
- NioEventLoop.wakeup方法

SELECT分支
- 当任务队列中没有任务时，才会进入SELECT分支，让NIO线程阻塞，而不是空转。
- 若有任务，则会通过get方法调用selector.selectNow方法，顺便拿到IO事件

## Java NIO空轮询BUG
在NioEventLoop中，因为run方法中存在一个死循环，需要通过selector.select方法来阻塞线程。
- 但是select方法因为BUG，可能无法阻塞线程，导致循环一直执行，使得CPU负载升高

Netty中通过selectCnt变量来检测select方法是否发生空轮询BUG
- 若发生空轮询BUG，那么selectCnt的值会增长是十分迅速

通过rebuildSelector方法重建selector
- 将原selector的配置信息传给新selector，再用新selector覆盖旧selector。同时将selectCnt的值设置为0

## ioRatio
- NioEventLoop可以处理IO事件和其他任务。不同的操作所耗费的时间是不同的
- 想要控制NioEventLoop处理IO事件花费时间占执行所有操作的总时间的比例，需要通过ioRatio来控制
- 代码在`NioEventLoop.run`中

## 处理事件
- IO事件是通过NioEventLoop.processSelectedKeys()方法处理的
- 获取SelectionKey的事件，然后进行相应处理

# 3.Accept事件
## NIO中处理Accept事件流程
- selector.select()阻塞线程，直到事件发生
- 遍历selectionKeys
- 获取一个key，判断事件类型是否为Accept
- 创建SocketChannel，设置为非阻塞
- 将SocketChannel注册到selector中
- 关注selectionKeys的read事件

## SocketChannel的创建与注册
相关方法：
- NioMessageUnsafe.read
- NioSocketChannel.doReadMessages
- ServerBootstrapAcceptor.channelRead
- AbstractUnsafe.register：将SocketChannel注册到了Selector中，过程与启动流程中的Register过程类似
- AbstractChannel.AbstractUnsafe.register0
- AbstractNioChannel.doRegister
- HeadContext.channelActive
- AbstractNioChannel.doBeginRead：通过该方法，SocketChannel关注了read事件

# 4.Read事件
相关方法：
- AbstractNioByteChannel.NioByteUnsafe
- DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle.continueReading


