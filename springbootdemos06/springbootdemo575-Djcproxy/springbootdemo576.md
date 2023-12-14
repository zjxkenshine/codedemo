# 参考地址
djcproxy java类动态代理
- https://github.com/verhas/djcproxy

# 简介
可以在运行时为现有对象创建代理对象，实现
- 测量程序在某些方法中花费的时间
- 禁止对某个对象调用某些方法（创建对象的不可变版本）
- 改变某些方法的行为
- 记录方法的执行
- 其他作用

此库的使用与cglib的使用非常相似，但有以下区别
- 使用这个库，您可以为现有对象创建一个代理，而cglib可以帮助您创建一个新对象以及扩展的代理对象
- 这个库创建Java源代码，不进行JVM字节操作

为了使对象y成为x的代理，y的类必须扩展x的类
