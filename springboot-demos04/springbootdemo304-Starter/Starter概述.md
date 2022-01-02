# 1.Starter简介
- Starter机制抛弃了以前xml中繁杂的配置，将各种配置统一集成进了Starter中
- 开发人员只需要在maven中引入Starter依赖，SpringBoot就能自动扫描出要加载的配置信息并按相应的默认配置来启动项目

# 2.Starter的优点
- Starter可以让我们摆脱开发过程中对各种依赖库的冲突处理
- 可以简化原有xml中各种负载的配置信息
- SpringBoot提供了针对一般研发中各种场景的spring-boot-starter依赖，所有这些依赖模块都遵循着约定成俗的默认配置(”约定大于配置“)，并允许我们调整这些配置

# 3.Starter的组成
- autoconfigure模块: 包含自动配置的代码
- starter模块: 提供对autoconfigure模块的依赖，以及一些其它的依赖

# 4.自动配置原理
见springboot自动配置原理概述.md

# 5.自定义Starter
## 1.场景
独立于业务之外的配置模块，如日志，动态数据源等

## 2.自定义Starter命名规范
第三方开发者自定义的starter则以xxxx-spring-boot-starter的规则来命名

## 3.几个重要注解
- @Configuration: 表明此类是一个配置类，将变为一个bean被Spring进行管理。
- @EnableConfigurationProperties: 启用属性配置，将读取指定类里面的属性。
- @ConditionalOnClass: 当类路径下面有指定的类时，进行自动配置。
- @ConditionalOnProperty: 判断指定的属性是否具备指定的值。
- @ConditionalOnMissingBean:当容器中没有指定bean是，创建此bean。
- @Import: 引入其他的配置类