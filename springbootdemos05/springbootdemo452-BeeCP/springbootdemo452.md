# 参考地址
BeeCP-Starter 1.3.1 发布，Spring Boot 上的启动器
- https://www.codercto.com/a/114404.html

gitee
- https://gitee.com/Chris2018998/BeeCP-Starter

# 简介
一款小型数据库连接池

# 监控地址
http://IP:port/xxxx/beecp

# 注解
- @EnableMultiDs：多数据源启用标签，一定要配置在@SpringBootApplication之前
- @EnableDsMonitor：连接池监控启用标签，否则监控界面无法打开
- @DsId：组合数据源应用时，可指定数据源id

# 数据源配置项
- dsId：数据源id
- type：数据源类名
- primary：是否注册为默认数据标记
- jndiName：数据源Jndi名

# 监控项配置 进不去
- spring.datasource.monitorUserId：监控登陆用户Id，此项不配置则表示无需登陆
- spring.datasource.monitorPassword：监控登陆用户口令
- spring.datasource.sql-trace：sql执行监控开关，true则表示打开
- spring.datasource.sql-show：后端是否打印sql的开关
- spring.datasource.sql-trace-max-size：sql监控池的大小（1000以内）
- spring.datasource.sql-trace-timeout：sql处于监控池的最大时间，单位：毫秒
- spring.datasource.sql-exec-slow-time：低效SqL执行的时间阀值，单位：毫秒
- spring.datasource.sql-trace-timeout-scan-period：sql监控池定时扫描间隔时间，在池中时间大于sql-trace-timeout则被清理，单位：毫秒
- spring.datasource.sql-exec-alert-action：sql执行预警触发类名（需要扩展类：cn.beecp.boot.datasource.statement.StatementTraceAlert），低效与错误sql触发