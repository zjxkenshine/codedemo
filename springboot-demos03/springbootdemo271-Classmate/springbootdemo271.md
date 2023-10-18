# 参考地址
github
- https://github.com/FasterXML/java-classmate

# 核心方法
- resolve(Class cls)：一个普通类，父类定义了定义了泛型
- resolve(GenericType<T>)：给定泛型类型
- resolve(Class<?> baseType, Class<?> typeParameter1, ... , Class<?> typeParameter2)：指定基类，提供参数
- MemberResolver：解析成员Field/Method/Constructor信息，ResolvedTypeWithMembers
    - Test02/test02：方法解析
    - Test02/test03：属性解析
    - Test02/test04：构造器解析
    - Test02/test05：解析特定方法
    - Test03：注解解析
- Test03:
    - test01：解析父类方法注解
    - test02：解析SomeSubclass注释类型
    - test03：解析SomeSubclass 方法注释类型,包含@Inherited注解
    - test04：解析SomeSubclass 方法注释类型,包括父类注解
    - test06：方法签名相同的汇总



