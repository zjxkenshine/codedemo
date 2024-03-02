# 参考地址
Jodd-Db ORM框架,简化jdbc代码
- https://db.jodd.org/

# 简介
## 1.DbQuery jdbc的增强包装
DbQueryTest
- test01：基本使用
- test02：传参
- test03：debug模式，会打印实际值
- test04：通过bean设置参数
- test05：设置自增长
- test06：调用存储过程

## 2.DbSession 数据库连接的封装
DbSessionTest
- test01：DbSession基本使用
- test02：DbThreadSession 分配给线程
- test03：自动session设置
- test04：设置事务

## 3.DbOom 对象映射类
DbOomTest
- test01：实例化
- test02：单数据库模式

## 4.DbOomQuery 结果集映射辅助类
DbOomQueryTest
- test01：find方法 查找对象集
- test02：find 查找单个类型
- test03：list、listSet 查询列表对象
- test04：一对一映射，设置内部值

BadBoy：@DbTable @DbColumn 标记表名与字段

## 5.Mapping 映射，匹配数据库字段与Java字段
BooSqlType：扩展sql类型

Foo：自定义映射

MappingTest
- test01：注册sql类型与自定义类型

DbOomManager 管理类

## 6.Template SQL 模板SQL
1. 表名宏`$T`
`select * from $T{Foo f}`
   
2. 字段宏`$C`
`select $C{f.bar} from $T{Foo f}`
   
3. 引用宏`$`
`select $C{f.bar} from $T{Foo f} where $f.zap=173`
   
4. 数学宏`$M`
`select * from $T{boy} where $M{boy=boy}`
   
TSqlTest
- test01：数学宏
- test02：对象内联引用
- test03：DbEntitySql 简化Sql操作

## 更多操作查看官方文档
- 一对多，一对一关联
- 配置
- 使用hint注入值
- 映射到bean
- jtx事务
