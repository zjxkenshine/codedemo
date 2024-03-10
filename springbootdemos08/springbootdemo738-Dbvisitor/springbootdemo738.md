# 参考地址
dbVisitor 是一个数据库 ORM工具，提供对象映射、丰富的类型处理、动态SQL、存储过程、内置分页方言20+、支持嵌套事务、多数据源、条件构造器、INSERT 策略、多语句/多结果。兼容 Spring 及 MyBatis 用法。它不依赖任何其它框架，因此可以很方便的和任意一个框架整合在一起使用。
- https://gitee.com/zycgit/dbvisitor

官网：
- https://www.dbvisitor.net/

# 功能特性
- 兼容其他框架
    - JdbcTemplate 接口方式（高度兼容 Spring JDBC）
    - Mapper 文件方式（高度兼容 MyBatis）
    - LambdaTemplate （高度接近 MyBatis Plus、jOOQ 和 BeetlSQL）
    - @Insert、@Update、@Delete、@Query、@Callable 注解（类似 JPA）
- 事务支持
    - 支持 5 个事务隔离级别、7 个事务传播行为（与 Spring tx 相同）
    - 提供 TransactionTemplate、TransactionManager 接口方式声明式事务控制能力（用法与 Spring 相同）
- 其他特性：
    - 支持 分页查询 并且提供多种数据库方言（20+）
    - 支持 INSERT 策略（INTO、UPDATE、IGNORE）
    - 更加丰富的 TypeHandler（MyBatis 40+，dbVisitor 60+）
    - Mapper XML 支持多语句、多结果
    - 提供独特的 @{xxx, expr , xxxxx } 规则扩展机制，让动态 SQL 更加简单
    - 支持 存储过程
    - 支持 JDBC 4.2 和 Java8 中时间类型
    - 支持多数据源


# 目录
DbVisitorTest
- test01：简单使用
- test02：绑定对象
- test03：单表CRUD
- test04：通用Mapper
- test05：注解化Mapper
- test06：分页查询
- test07：BaseMapper分页
- test08：事务
