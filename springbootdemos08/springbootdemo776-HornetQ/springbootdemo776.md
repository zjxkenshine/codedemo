# 参考地址
官网
- https://hornetq.jboss.org/
  
快速指南
- https://hornetq.sourceforge.net/docs/hornetq-2.1.2.Final/quickstart-guide/zh/html_single/index.html

hornetq 集成 spring
- https://blog.csdn.net/chixie5031/article/details/100649480

HornetQ版的Hello World简单例子
- https://www.jianshu.com/p/3d542bfeff32

HornetQ学习系列
- https://blog.csdn.net/hemingliang1987/article/details/77758720
- https://blog.csdn.net/hemingliang1987/article/details/77805243
- https://blog.csdn.net/hemingliang1987/article/details/77825710

HornetQ 单体 – 基本的 JMS 消息传递示例
- https://www.kancloud.cn/apachecn/howtodoinjava-zh/1953285

# 简介
HornetQ是一个开源项目。它的目标是一个多协议、可嵌入、高性能、可集群的异步的消息系统。

# 下载运行
下载地址
- http://downloads.jboss.org/hornetq/hornetq-2.4.0.Final-bin.zip

运行：bin目录下的run.bat/run.sh，默认端口5445

# 配置文件概述
- hornetq-beans.xml：定义了HornetQ中用到的各个bean,以及各个bean之间的依赖关系
- hornetq-configuration.xml：主要针对HornetQ做配置的。包括队列大小，队列满时应采用的策略等等
- hornetq-jms.xml：配置JMS服务，包括JMS Queue, Topic和ConnectionFactory,这些配置会被部署到JNDI服务中
- hornetq-users.xml：配置用户
- jndi.properties：这个是配置JNDI服务的
- logging.properties：HornetQ自己独立的日志框架