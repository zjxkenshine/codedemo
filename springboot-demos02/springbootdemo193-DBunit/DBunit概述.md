# 1.DbUnit简介
- 数据库一般的测试方式：mock和stubs，隔离数据库访问类
- 某些特殊的系统Dao对象很隐蔽，就需要使用DBunit
- DbUnit设计理念：备份数据库->使用测试数据测试—>回溯

# 2.DbUnit测试基本概念
- 主要接口IDataSet，IDataSet代表一个或多个表的数据
    - FlatXmlDataSet：数据的简单平面文件 XML 表示 
    - QueryDataSet：用 SQL 查询获得的数据 
    - DatabaseDataSet：数据库表本身内容的一种表示 
    - XlsDataSet ：数据的excel表示

# 3.DBUnit测试流程
1. 根据业务，做好测试用的准备数据和预想结果数据，通常准备成xml格式文件。
2. 在setUp()方法里边备份数据库中的关联表。
3. 在setUp()方法里边读入准备数据。
4. 对测试类的对应测试方法进行实装:执行对象方法，把数据库的实际执行结果和预想结果进行比较
5. 在tearDown()方法里边,把数据库还原到测试前状态

