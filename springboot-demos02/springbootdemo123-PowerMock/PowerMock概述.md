# 1.PowerMock概述
- PowerMock基于Mockito开发，语法规则与Mockito一致，加强版的Mockito
- 主要区别在于使用方面，以实现完成对private/static/final等方法(也支持mock的对象是在方法内部new出来的)的Mock（模拟）

# 2.重要注解
```
// 告诉JUnit使用PowerMockRunner进行测试
@RunWith(PowerMockRunner.class) 

 // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
@PrepareForTest({RandomUtil.class})

//为了解决使用powermock后，提示classloader错误
@PowerMockIgnore("javax.management.*") 
```




