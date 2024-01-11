# 参考地址
Javaslang 介绍
- https://www.cnblogs.com/snifferhu/p/6841594.html

相关项目：
- springbootdemo213-Vavr

# 目录
- Option：类似于 Java 8里的Optional 的对象容器，null校验
- Tuple：元组，支持Tuple1~Tuple8
- Try：用于计算的容器，可能返回异常
- Functional Interfaces：Javaslang 通过最多支持八个参数来扩展Java 中的functional interfaces（函数式接口）的概念
    - memoization（备忘录模式）
    - composition（函数组合）
    - curry（柯里化）
    - Function0~Function8
- Conllections：扩展了java集合API
- Validation：错误信息收集，项目继续运行
- Lazy：惰性求值容器
- Pattern Matching：模式匹配