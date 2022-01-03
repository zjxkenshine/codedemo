# 1.简介
- Profile的意思是配置，对于应用程序来说，不同的环境需要不同的配置
- Spring框架提供了多profile的管理功能，我们可以使用profile功能来区分不同环境的配置

# 2.@Profile相关
- `@Profile(value)`：当一个或多个指定的配置文件处于活动状态时，表示组件有资格注册
- `@Conditional`：表示只有在所有指定条件都匹配时，组件才有资格注册
    - 可以传入一个Condition.class
- `ProfileCondition`：主要判断@Profile与环境是否匹配的类，matches方法
    - `ConditionContext`：用于Condition的上下文，从中获取Environment，再从Environment中获取activeProfiles
    - `AnnotatedTypeMetadata`：元注解，对注解元素的封装适配，获取Profile注解
- `ProfileCondition.matches()`的判断结果最终会成为是否实例化bean的条件之一
    - 与其他Condition接口族相同，之后学习

# 3.Profile相关
- `Profiles`接口：
    - matches()：是否与active profile相同
        - 会在Environment中调用该方法
    - of：静态方法，创建一个新的Profiles
       - 通过该方法解析@Profile中的注解值并获取profiles
- `ProfilesParser`：解析Profile
    - parse：根据表达式解析Profiles，供Profiles.of使用

# 4.Enviroment加载特定Profile
主要在抽象类AbstractEnvironment中实现
- AbstractEnvironment中的部分方法：
    - customizePropertySource：自定义PropertySource相关
    - getReservedDefaultProfiles：返回默认保留的配置文件名称，默认名称为default
    - getActiveProfiles：获取激活的profile，配置文件spring.profiles.active指定
    - setActiveProfiles：重新设置激活的profile
    - addActiveProfile：添加激活的profile
    - getDefaultProfiles：获取spring.profiles.default指定的配置
    - setDefaultProfiles：设置默认配置
    - acceptsProfiles：判断是否是激活配置
    - isProfileActive：判断某个配置是否激活啊

# 5.配置文件
- `spring.profiles.include`：叠加profile
- `spring.profiles.active`：激活的配置

# 6.指定Profile
- 多profile文件形式
- yml文档块指定
- 在configuration中的program arguments 中写入--spring.profiles.active=dev
- 在configuration中的VM options配置项中填写：-Dspring.profiles.active=dev
- 在configuration中的Enviroment variables 配置项上写入：spring.profiles.active=dev

优先级：
```
program arguments  >  VM options  >  Enviroment variables  >proties 文件> yml文件
```
