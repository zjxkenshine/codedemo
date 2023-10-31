# 参考地址
Java高并发测试框架JCStress详解
- https://www.zhangshengrong.com/p/ERNnq8wQa5/

【多线程&高并发】jcstress并发测试工具使用教程详解
- https://blog.csdn.net/Kevinnsm/article/details/121685052

# 踩坑
和springboot冲突，需要排除springboot依赖

如何在IDEA中使用jcstress进行并发压力测试 
- https://www.cnblogs.com/dalianpai/p/14175292.html

```
java -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -XX:-RestrictContended -jar jcstress.jar
```

两种方式运行：
- 打包为jar运行
- idea进行配置运行(推荐)

# 注解：
- @JCStressTest：标记一个类为并发测试的类
- @State：标记一个类是有状态的，即拥有可以读写的数据
- @Actor：中心测试注解，它标记的方法会被一个特定的线程调用，每一个对象的方法只能被调用一次
- @Arbiter：和@Actor差不多，但是Arbiter标记的方法调用是在所有@Actor标记的方法调用之后
- @Signal：在JCStressTest的Termination模式下工作的，它的调用是在所有Actor之后
- @Result：它标记的类被作为测试结果的类，JCStress自带的org.openjdk.jcstress.infra.results包下就有大量的测试结果类，不同的类可以用来保持不同的结果。
