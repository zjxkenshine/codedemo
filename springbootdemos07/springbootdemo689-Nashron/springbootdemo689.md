# 参考地址
Java 8 Nashorn 指南
- https://zhuanlan.zhihu.com/p/33257346

# 简介
Nashron java8默认js引擎

# 1.使用
1. 命令行使用
- `$JAVA_HOME/bin/jjs`

2. 代码使用
```java 
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello World!');");
```

# 2.目录
- test01：简单使用
- test02：执行js文件
- test03：java中调用js方法
- test04：调用java方法
- test05：使用java类型数组
- test06：调用集合和范围遍历
- test07：java lambda表达式
- test08：js 中继承java类
- test09：方法和函数可以通过点运算符或方括号运算符来调用
- test10：js 调用javaBean
- test11：函数字面值、属性绑定、字符串去空白、位置、作用域
- test12：java转js数组
- test13：超类访问
- test14：加载脚本