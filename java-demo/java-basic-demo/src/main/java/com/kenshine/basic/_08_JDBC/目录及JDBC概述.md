# 目录
- Test01_Base：基本使用
- Test02_CRUD：简单增删改查
- Test03_HMBase：使用步骤
- Test04_Transactional：JDBC事务实现

# JDBC相关概念：
- DriverManager：DriverManager驱动管理类
    - Mysql5之后可以不写注册驱动，使用ServiceLoader自动读取驱动服务
- Connection：数据库连接对象
- Statement：用于执行Sql语句
- ResultSet：结果集
- PreparedStatement：预编译Statement，防止SQL注入
- 事务：
    - `setAutoCommit(false);` 开启
    - `conn.commit();` 提交
    - `conn.rollback();` 回滚
- RowSet：行集
- DatabaseMetaData：元数据 `DatabaseMetaData meta=conn.getMetaData();`
