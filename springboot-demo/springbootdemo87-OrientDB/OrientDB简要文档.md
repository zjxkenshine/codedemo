# 1.简要文档
1. OrientDB是一个开源NoSQL数据库管理系统
2. 基本概念：
    - 文档模型
    - 图形模型
    - 键/值模型
    - 对象模型
    - 记录:可以从数据库加载并存储在数据库中的最小单位
        - 文件
        - 记录字节
        - 顶点
        - 边缘
    - 记录ID:生成记录时，数据库服务器自动为记录分配单位标识符，称为 RecordID(RID)
    - 文件,文档
    - RecordBytes：与BLOB类似，OrientDB可以加载和存储文档记录类型以及二进制数据
    - 顶点：图数据库中，最基本的数据单位是节点，在OrientDB中称为顶点，存储数据库信息
    - 边缘：有一个单独的记录类型称为Edge，将一个顶点连接到另一个顶点。边是双向的，只能连接两个顶点
        - 规则边
        - 轻量级边
    - 类：该类是一种数据模型和从面向对象编程范例绘制的概念
    - 簇：简单来说，Cluster是存储一组记录的地方，默认情况下，OrientDB将为每个类创建一个集群
    - 关系：OrientDB支持两种关系：引用和嵌入
    - 数据库：访问实际存储的接口
3. 数据库命令
    - 创建数据库：`CREATE DATABASE <database-url> [<user> <password> <storage-type> [<db-type>]]` 
    - 更改数据库：`ALTER DATABASE <attribute-name> <attribute-value>`
    - 备份数据库：`./backup.sh <dburl> <user> <password> <destination> [<type>]`
    - 还原数据库：`orientdb> RESTORE DATABSE <url of the backup zip file>`
    - 连接数据库：`CONNECT <database-url> <user> <password>`
    - 断开数据库：`DISCONNECT`
    - 获取数据库信息：`info`
    - 列出数据库: `LIST DATABASES`
    - 冻结数据库：`FREEZE DATABASE`
    - 从冻结状态释放数据库：`RELEASE DATABASE`
    - 配置数据库：`CONFIG`
    - 导出数据库：`EXPORT DATABASE <output file>`
    - 导入数据库：`IMPORT DATABASE <input file>`
    - 提交数据库：`COMMIT`,保存对数据库的所有更改来关闭事务
    - 数据库回滚：`ROLLBACK`
    - 优化数据库：`OPTMIZE DATABASE [-lwedges] [-noverbose] `
    - 删除数据库：`DROP DATABASE [<database-name> <server-username> <server-user-password>]`
4. 记录命令
    - 插入记录：
       ```
        INSERT INTO [class:]<class>|cluster:<cluster>|index:<index> 
           [(<field>[,]*) VALUES (<expression>[,]*)[,]*]| 
           [SET <field> = <expression>|<sub-command>[,]*]| 
           [CONTENT {<JSON>}] 
           [RETURN <expression>]  
           [FROM <query>] 
       ```
    - 显示记录:
        ```
        SELECT [ <Projections> ] [ FROM <Target> [ LET <Assignment>* ] ] 
           [ WHERE <Condition>* ] 
           [ GROUP BY <Field>* ] 
           [ ORDER BY <Fields>* [ ASC|DESC ] * ] 
           [ UNWIND <Field>* ] 
           [ SKIP <SkipRecords> ] 
           [ LIMIT <MaxRecords> ] 
           [ FETCHPLAN <FetchPlan> ] 
           [ TIMEOUT <Timeout> [ <STRATEGY> ] ]
           [ LOCK default|record ] 
           [ PARALLEL ] 
           [ NOCACHE ] 
        ```
    - 加载记录：`LOAD RECORD <record-id>`
    - 重载记录：`RELOAD RECORD <record-id>`
    - 导出记录：`EXPORT RECORD <format>`
    - 更新记录：
        ```
         UPDATE <class>|cluster:<cluster>|<recordID> 
         [SET|INCREMENT|ADD|REMOVE|PUT <field-name> = <field-value>[,]*] |[CONTENT| MERGE <JSON>] 
         [UPSERT] 
         [RETURN <returning> [<returning-expression>]] 
         [WHERE <conditions>] 
         [LOCK default|record] 
         [LIMIT <max-records>] [TIMEOUT <timeout>] 
        ```
    - 截断记录：
        ```
      TRUNCATE RECORD <rid>* 
        ```
    - 删除记录：
        ```
        DELETE FROM <Class>|cluster:<cluster>|index:<index> 
         [LOCK <default|record>] 
         [RETURN <returning>] 
         [WHERE <Condition>*] 
         [LIMIT <MaxRecords>] 
         [TIMEOUT <timeout>]
        ```
5. 类命令：
    - 创建类：
       ```
      CREATE CLASS <class> 
      [EXTENDS <super-class>] 
      [CLUSTER <cluster-id>*] 
      [CLUSTERS <total-cluster-number>] 
      [ABSTRACT]
        ```
    - 改变类：`ALTER CLASS <class> <attribute-name> <attribute-value> `
    - 截断类：`TRUNCATE CLASS <class> [ POLYMORPHIC ] [ UNSAFE ]`
    - 删除类：`DROP CLASS <class> `
6. 集群命令:
    - 创建集群：`CREATE CLUSTER <cluster> [ID <cluster-id>] `
    - 改变集群：`ALTER CLUSTER <cluster> <attribute-name> <attribute-value>`
    - 截断集群：`TRUNCATE CLUSTER <cluster-name>`
    - 丢弃群集：`DROP CLUSTER <cluster-name>|<cluster-id>`
7. 属性命令：
    - 创建属性：`CREATE PROPERTY <class-name>.<property-name> <property-type> [<linked-type>][ <linked-class>]`
    - 改变属性：`ALTER PROPERTY <class>.<property> <attribute-name> <attribute-value>`
    - 拖放属性：`DROP PROPERTY <class>.<property> [FORCE]`
8. 顶点命令：
    - 创建顶点：`CREATE VERTEX [<class>] [CLUSTER <cluster>] [SET <field> = <expression>[,]*]`
    - 移动顶点：
        ```
        MOVE VERTEX <source> TO <destination> 
        [SET [<field>=<value>]* [,]] 
        [MERGE <JSON>] 
        [BATCH <batch-size>] 
        ```
    - 删除顶点:
        ```
        DELETE VERTEX <vertex> [WHERE <conditions>] 
        [LIMIT <MaxRecords>>] [BATCH <batch-size>]
        ```
9. 边缘命令：
    - 创建边缘：
        ```
      CREATE EDGE <class> [CLUSTER <cluster>] FROM <rid>|(<query>)|[<rid>]* TO <rid>|(<query>)|[<rid>]* 
           [SET <field> = <expression>[,]*]|CONTENT {<JSON>} 
           [RETRY <retry> [WAIT <pauseBetweenRetriesInMs]] [BATCH <batch-size>]
        ```
     - 更新边缘:
         ```
       UPDATE EDGE <edge>  
          [SET|INCREMENT|ADD|REMOVE|PUT <field-name> = <field-value> [,]*]|[CONTENT|MERGE <JSON>] 
          [RETURN <returning> [<returning-expression>]] 
          [WHERE <conditions>] 
          [LOCK default|record] 
          [LIMIT <max-records>] [TIMEOUT <timeout>]
        ```
     - 删除边缘：
        ```
       DELETE EDGE  
          ( <rid> 
             | 
             [<rid> (, <rid>)*] 
             | 
             ( [ FROM (<rid> | <select_statement> ) ] [ TO ( <rid> | <select_statement> ) ] ) 
             | 
             [<class>]  
          ( 
             [WHERE <conditions>] 
             [LIMIT <MaxRecords>]  
             [BATCH <batch-size>]
          ))
        ```
       
# 2.高级概念
1. OrientDB功能
    - 图形函数
    - 数学函数
    - 集合函数
    - 其他功能
2. OrientDB序列: 序列通常用于自动递增人的id值
    - 创建序列：
       ```
      CREATE SEQUENCE <sequence> TYPE <CACHED|ORDERED> [START <start>]  
      [INCREMENT <increment>] [CACHE <cache>]
       ```
    - 更改序列：
        ```
       ALTER SEQUENCE <sequence> [START <start-point>] 
       [INCREMENT <increment>] [CACHE <cache>]
        ```
   - 丢弃序列：
        ```
        DROP SEQUENCE <sequence>
        ```


# 3.其他
1. 可视化管理地址
- http://localhost:2480/





