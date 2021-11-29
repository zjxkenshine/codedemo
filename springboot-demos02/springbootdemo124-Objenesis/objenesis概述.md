# 1.objenesis概述
- Objenesis是一个小的Java库，作用是实例化一个特定类的新对象。
- Java已经支持使用`class.newInstance()`的类动态实例化，但是不支持以下方式：、
    - 构造函数需要参数
    - 有副作用的构造函数
    - 会抛出异常的构造函数

# 2.快速入门
1. Objenesis中有两个主要接口：
    - ObjectInstantiator：实例化一个类的多个实例
    - InstantiatorStrategy：根据特定策略实例化
2. 实例化策略：
    - 针对基于JVM供应商、JVM版本、安全管理和实例化类对象，Objenesis 实例化对象有许多不同的策略
    - 已经默认设置了两种策略
        - Stardard：没有调用任何构造函数（ObjenesisStd）
        - Serializable compliant：类似于由java标准序列化实例化的对象 (ObjenesisSerializer)
3. ObjectInstantiator 缓存
    -  ObjenesisBase提供一个默认激活的内置缓存。这个缓存保留了每个类的objectinator实例。当相同的类经常被实例化时，这会极大地提高性能。
    - `Objenesis o = new ObjenesisStd(false);`可以禁用缓存
4. 自定义策略：
    - 默认策略支持所有的jvm，有性能成本，可以自定义实现
5. ObjenesisHelper类：不建议使用
    - 类保持静态状态，则会出现类加载问题、内存泄漏、模块依赖关系等问题
    - `Object o1 = ObjenesisHelper.newInstance(MyClass.class);`  


        




