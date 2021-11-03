# derby的优缺点
优点：
1. 支持的数据库小于50GB，嵌入式数据库，对于小型网站不错
2. Derby支持标准SQL92, SQL1999, SQL2003, 支持临时表, 索引, 触发器, 视图, 存储过程, 外键, 约束, 并行, 事务, 加密与安全等
3. Derby的安全性也做得很到位, 包括用户鉴权和加密解密
4. Derby的性能也是不错的.但比不上mysql和oracle
5. hsqldb快但稳定性不足所以要是长时间运行的业务系统建议用derby

缺点：[derby的三大缺陷](https://blog.csdn.net/weixin_29781865/article/details/113226246)
1. 没有boolean数据类型
2. 没有LIMIT和OFFSET子句(或相同功能的子句)，10.5后有分页
    ```
    select * FROM (select ROW_NUMBER() OVER() AS R, customer_id, zip from CUSTOMER) AS T where R>0 and R<5 order by customer_id desc;
    ```
3. 外键关联 ON UPDATE 只支持 NO ACTION 和 REDIRECT


# 两种连接模式 与h2类似
- 内嵌模式
    - `connect 'jdbc:derby:dedb;user=db_user1;password=111111;create=true';`
- 服务器模式
    - `connect 'jdbc:derby://127.0.0.1:1527/debryDB;user=db_user1;password=111111;create=true'`