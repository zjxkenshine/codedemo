# 参考地址
官网：
- https://github.com/phax/jcodemodel
- https://javaee.github.io/jaxb-codemodel/

使用CodeModel生成Java类
- https://blog.csdn.net/weixin_33719619/article/details/91420381

JCodeModel使用Demo
- https://blog.51cto.com/u_15837916/5779006

# 常用类
- JPackage：包类型，可由JCodeModel#_package方法得到，主要作用是调用_class方法在指定包里生成类
- JDefinedClass：定义类类型，提供各种方法如向定义类里添加方法或者成员等
- JClass：已有类类型，通常为引用已经有的类如String
- JFieldVar：成员变量类型
- JMethod：方法类型
- JBlock：代码块类型，通常由JMethod#_body方法获得，用于向方法中添加代码
- JArray：Java数组类型
- JExpression：Java表达式类型
- JExpr：Java表达式工具类，用于生成JExpression
- Jvar：局部变量类型

# 目录
JCodeModelTest
- test01：生成成员变量
- test02：生成方法与局部变量
- test03：生成构造函数
- test04：类、接口、继承、实现、引用
- test05：生成 if...else
- test06：生成switch case语句
- test07：生成for循环、静态方法调用
- test08：生成while语句
- test09：生成do...while循环