# 1.Guice简介
- guice 是轻量级的依赖注入框架，依赖注入是类将他们的依赖声明为参数，而不是直接创建依赖的一种设计模式
- Maven 就是使用Guice进行依赖注入的
# 2.Guice核心概念
- `@Inject`：java 类的构造器被@Inject注解，可以被 Guice 通过一种被称作 constructor injection 的进程调用，在此过程中 Guice 会创建并提供构造器参数
- `Guice modules`：应用包含在其他对象上声明依赖关系的对象，并且这些依赖关系形成图
- `Guice injectors`：injector 将所有 modules 作为构造器参数准备好，对需要获取实例的类进行注入
- `bindings`：绑定

# 3.文档概述
- `Scopes`：范围
    - `@Singleton`作用域，它在单个注入器内的应用程序的生命周期内重用相同的实例
    - `@RequestScoped`：请求作用域
    - `@SessionScoped`：会话作用域
    - Scopes.NO_SCOPE：自定义作用域范围
- Bindings：绑定
    - Linked Bindings：@Provides注解添加到Module中返回特定类型的方法上
    - Binding Annotations：注解绑定，详情查看GuiceDemo
    - Instance Bindings：实例绑定
        - `bind(String.class).annotatedWith(...).toInstance(...);`
        - `bindConstant().annotatedWith(HttpPort.class).to(8080);`
    - @Provides：提供注入对象
    - Provider Bindings：提供者绑定，自定义Provider实现`Provider`接口,Module中使用`bind(class).toProvider`绑定提供者
    - Untargeted Bindings：无目标绑定，`bind().in(...)`
    - Constructor Bindings：构造器绑定，`bind().toConstructor(...)`
    - Built-in Bindings：内置绑定，如logger
    - Just-in-time Bindings：即时绑定，也叫隐式绑定
        - `@ImplementedBy`：默认实现类
        - `@ProvidedBy`：提供者
    - Multibindings：复杂绑定
    