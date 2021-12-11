# 1.JSqlParser简介
- JSqlParser是一个SQL语句解析器。它将SQL转换为Java类的可遍历层次结构
- JSqlParser就是一个把SQL转换为JAVA对象操作的工具包

# 2.JSqlParser源码包结构
- expression包：SQL构建相关类，比如EqualsTo、InExpression等表达式用于构建SQL
- parser包：SQL解析相关类，比如CCJSqlParserUtil
- schema包：主要存放数据库schema相关的类 ，比如表、列、数据库等
- statement包：封装了数据库操作对象，create、insert、delete、select等
- util包：各种工具类、不同DB版本、SQL标准等处理类，如SelectUtils、DatabaseType等
