# 1.Logback三个主要核心
- logback-core：其它两个模块的基础模块
- logback-classic：它是log4j的一个改良版本，完整实现了slf4j的API
- logback-access：访问模块与Servlet容器集成提供通过Http来访问日志的功能

# 2.Logback基础配置文件
- Logger：日志记录器，主要存放日志对象，也可定义日志类型，级别
- Appender：指定日志输出目的地，可以使控制台，文件和数据库
- Layout：负责吧事件转换成字符串，格式化日志信息的输出。
  - 在Logback中Layout对象被封装在encoder中

# 3.配置文件中基本功能 详细参考logback.xml
- 控制台输出：`appender name="STDOUT"`
- 每天生成日志文件：`appender name="FILE"`
- HTML格式日志：FILE2
- 日志拆分归档：FILE3 按照时间及大小拆分
    - Logback过滤器
- 异步日志：ASYNC




