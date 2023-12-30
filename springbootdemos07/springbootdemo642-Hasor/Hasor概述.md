# 简介
Hasor 本身是由多个不同系列框架组合而成的一个框架体系。这些子框架的能力涵盖了 IoC、Aop、WebMVC、数据库以及其它方方面面

## 三种启动模式
- Full：Hasor.create().asFull().build();完整加载框架和可以发现的所有插件模块。
- Core：Hasor.create().asCore().build();只完整的加载 hasor-core。
- Tiny：Hasor.create().asTiny().build();最小化启动。放弃一切插件加载包括 hasor-core 中的内置插件。
- 指定配置文件：`Hasor.create().mainSettingWith("my-hconfig.xml").build();`

## IOC
- `@ConstructorBy`+参数前`@Inject()`：构造方法创建bean及参数注入
- `@Inject`：属性注入
- `@ImplBy(PayServiceImpl.class)`：接口注入
- 实现InjectMembers接口自动注入
- apiBinder.bindType()：声明式注入
- 注入配置：`@InjectSettings("jdbcSettings.jdbcDriver")` 接收
    - `AppContext appContext = Hasor.create().mainSettingWith("<config-file-name>").build();`
- 注入环境变量：`@InjectSettings("${db.user}")`
- 注入特殊类型：
  ```
      @Inject()
      private AppContext appContext
  ```

## 动态代理
- https://www.hasor.net/docs/guides/aop/
- @Aop(SimpleInterceptor.class)注解，实现MethodInterceptor接口
- 全局拦截器：apiBinder.bindInterceptor
- `@Aop({SimpleInterceptorA.class, SimpleInterceptorB.class })`：多拦截器

## 动态属性
- 一个 Bean 在类型定义之后，通过动态代理的能力为其动态的添加一个原本不存在的属性

## 作用域
- 单例
- 原型

## 生命周期
- 初始化
- 创建
- 销毁

## Bean管理
- bean id
- bean name

## 事件监听器
- 同步事件
- 异步事件