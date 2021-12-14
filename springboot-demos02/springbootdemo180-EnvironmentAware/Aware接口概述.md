# 1.Aware接口简介
简单来说就是提供Spring 容器底层的一些组件
- ApplicationContextAware：自动注入IOC容器
- ApplicationEventPublisherAware：注入事件派发器
- BeanClassLoaderAware：类加载器
- BeanFactoryAware：Bean工厂
- BeanNameAware：Bean名字
- EmbeddedValueResolverAware：Embedded值解析器
- EnvironmentAware：Environment
- ImportAware：导入相关
- LoadTimeWeaverAware：导入相关
- MessageSourceAware：国际化
- NotificationPublisherAware：通知
- ResourceLoaderAware：资源加载器

# 2.实现方式
- BeanNameAware、BeanClassLoaderAware和BeanFactoryAware这三个是直接在bean的初始化之前就处理了
- 其他接口都是通过BeanPostProcessor接口完成的