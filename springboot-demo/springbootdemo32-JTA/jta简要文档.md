# 1.JTA基本概念
- JTA即Java-Transaction-API，JTA允许应用程序执行分布式事务处理，即在两个或多个网络计算机资源上访问并且更新数据。JDBC驱动程序对JTA的支持极大地增强了数据访问能力。

- XA协议是数据库层面的一套分布式事务管理的规范,JTA是XA协议在Java中的实现,多个数据库或是消息厂商实现JTA接口,开发人员只需要调用SpringJTA接口即可实现JTA事务管理功能。

- JTA事务比JDBC事务更强大。一个JTA事务可以有多个参与者，而一个JDBC事务则被限定在一个单一的数据库连接。

# 2.分布式事务
- 分布式事务（DistributedTransaction）包括事务管理器（TransactionManager）和一个或多个支持 XA 协议的资源管理器 ( Resource Manager )。

- 资源管理器是任意类型的持久化数据存储容器，例如在开发中常用的关系型数据库：MySQL，Oracle等，消息中间件RocketMQ、RabbitMQ等。

- 事务管理器提供事务声明，事务资源管理，同步，事务上下文传播等功能，并且负责着所有事务参与单元者的相互通讯的责任。JTA规范定义了事务管理器与其他事务参与者交互的接口，其他的事务参与者与事务管理器进行交互。

# 3.代码流程
1. 配置动态切换
    - 自定义注解DataSource与aop
2. 配置多数据源
    - DataSourceFactory：用于不同的数据源DataSource的信息配置，使用DruidXADataSource创建，支持jta事务
    - CustomSqlSessionTemplate：重写SqlSessionTemplate
3. 配置XA事务
    - XATransactionManagerConfig：xat分布式事务管理器
4. 启动类去除自动加载Datasource
    - `@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})`
    