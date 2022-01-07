# 1.参考
- https://mybatis.org/mybatis-3/zh/getting-started.html
- https://www.cnblogs.com/tjlstudy/p/12991574.html

# 2.基础概念
- SqlSessionFactoryBuilder：用于创建SqlSessionFactory的构建器
- SqlSessionFactory：用于创建SqlSession 实例
    - 是否自动提交
    - 事务级别
    - 执行操作类型等
- SqlSession：类似JDBC的Connection对象，四个重要对象
    - Execute：执行器，调度执行StatementHandler、ParameterHandler、ResultHandler执行相应的SQL语句
    - StatementHandler：使用数据库中Statement（PrepareStatement）执行操作，即底层是封装好了的prepareStatement
    - ParameterHandler：处理SQL参数
    - ResultHandler：结果集ResultSet封装处理返回。

## 3.Mapper.xml文件相关
- namespace：命名空间，包名要和接口一致
- select标签：
    - id：就是对应的namespace的方法名
    - resultType：sql语句的返回值
    - parameterType： 参数类型


## 4.配置文件
mybatis-config.xml
```
configuration（配置）
    properties（属性）
    settings（设置）
    typeAliases（类型别名）
    typeHandlers（类型处理器）
    objectFactory（对象工厂）
    plugins（插件）
        environments（环境配置）
            environment（环境变量）
            transactionManager（事务管理器）
    dataSource（数据源）
    databaseIdProvider（数据库厂商标识）
    mappers（映射器）
```
## 5.Mybatis详细执行流程
- Resource获取全局配置文件
- 实例化SqlsessionFactoryBuilder
- 解析配置文件流XMLCondigBuilder
- Configration所有的配置信息
- SqlSessionFactory实例化
- trasactional事务管理
- 创建executor执行器
- 创建SqlSession
- 实现CRUD
- 查看是否执行成功
- 提交事务
- 关闭


## 6.其他知识点
- resultMap：结果集映射
- 关联 - association 多对一
- 集合 - collection 一对多
    - javaType & ofType
    - JavaType用来指定实体中属性类型
    - ofType映射到list中的类型，泛型中的约束类型
- 动态Sql语句：
    - `<if test="">`
    - choose、when、otherwise：
        - if标签是与(and)的关系，而 choose 是或(or)的关系
        - 相当于java 语言中的 switch
    - trim、where、set：去除空格，and和逗号
    - sql片段：在使用的地方使用include标签
    - for-each：
        ```
          <foreach collection="ids" item="id" open="and (" close=")" separator="or">
        ```

## 7.缓存
- 一级缓存，一级缓存默认开启，只在一次sqlseesion中有效
- 缓存失效：
    - 映射语句文件中的所有 insert、update 和 delete 语句会刷新缓存。
    - 查询不同的mapper.xml
    - 手动清除缓存
- 只有开启了二级缓存，在Mapper下有效
    - 所有数据都会先放在一级缓存
    - 只有当回话提交，或者关闭的时候，才会提交到二级缓存
