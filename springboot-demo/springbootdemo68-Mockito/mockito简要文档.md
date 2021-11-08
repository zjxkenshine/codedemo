# 1.Mock 测试
- Mock 测试就是在测试过程中，对于某些不容易构造（如 HttpServletRequest 必须在Servlet 容器中才能构造出来）或者不容易获取比较复杂的对象（如 JDBC 中的ResultSet 对象），用一个虚拟的对象（Mock 对象）来创建以便测试的测试方法
- Mock 最大的功能是帮你把单元测试的耦合分解开,如果你的代码对另一个类或者接口有依赖，它能够帮你模拟这些依赖，并帮你验证所调用的依赖的行为

# 2.Mock 与 Stub 的区别
- 前者被称为 mockist TDD，而后者一般称为 classic TDD ；
- 前者是基于行为的验证，后者是基于状态的验证；
- 前者使用的是模拟的对象，而后者使用的是真实的对象
- stub：可以简单理解为生成虚拟调用

# 3.Mockito概述
- Mockito 拥有的非常少的 API，所有开始使用 Mockito，几乎没有时间成本
- Mockito 并不需要“expectation（期望）”的概念。只有 stub 和验证

# 4.Mockito的使用
https://blog.csdn.net/shensky711/article/details/52771493

详见mockitoTest01
1. 模拟对象
2. 模拟方法调用的返回值
3. 模拟方法调用抛出异常
4. 模拟调用方法时的参数匹配
5. 模拟方法调用次数
6. 校验行为
7. 模拟方法调用(Stubbing)
8. 参数匹配
9. 校验方法调用次数
10. 模拟无返回方法抛出异常
11. 校验方法调用顺序
12. 校验方法是否从未调用
13. 快速创建Mock对象
14. 自定义返回不同结果
15. 对返回结果进行拦截

详见mockitoTest02
1. 暗中调用真实对象
2. 改变默认返回值
3. 捕获函数的参数值
4. 部分Mock
5. 重置Mock
6. 序列化
7. 超时验证
8. 查询Mock详情
9. 其他注解
    - `@Captor`：创建ArgumentCaptor
    - `@Spy`: 代替spy(Object)
    - `@InjectMocks`: 自动实例化mock或spy



