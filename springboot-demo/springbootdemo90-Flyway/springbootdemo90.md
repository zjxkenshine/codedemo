# 参考地址
springboot简易集成mybatisPlus+多数据源+flyway
- https://blog.csdn.net/belonghuang157405/article/details/89713268

如何使用Flyway配置来处理多个数据库
- https://qa.1r1g.com/sf/ask/1648196021/

Springboot集成flywaydb支持多数据源
- https://www.cnblogs.com/itfeng813/p/14657415.html

Flyway配置(包含多数据源配置)及使用规范
- https://blog.csdn.net/beautyofmath/article/details/106194433

# 概述：
1. flyway默认执行sql脚本放置：db/migrate
2. sql脚本的格式：V+版本号 +双下划线+功能+_+描述+结束符(.sql)
3. flyway命令
   - migrate：把数据库迁移到最新版本，迁移是根据 db/migration 目录下的脚本 顺序 执行。
   - clean： 清空 数据库中的数据， 请慎重在生产环境使用此命令 。
   - info：打印出版本迁移信息。
   - validate：验证要执行的迁移脚本。
   - baseline：为已经存在的数据库建立基线，迁移数据库将建立在基线的基础上。
   - repair：修复 flyway_schema_history 表。
