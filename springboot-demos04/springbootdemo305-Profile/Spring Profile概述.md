# 1.简介
- Profile的意思是配置，对于应用程序来说，不同的环境需要不同的配置
- Spring框架提供了多profile的管理功能，我们可以使用profile功能来区分不同环境的配置

# 2.相关接口，类，注解
- `@Profile(value)`：当一个或多个指定的配置文件处于活动状态时，表示组件有资格注册
- `@Conditional`：表示只有在所有指定条件都匹配时，组件才有资格注册
    - 可以传入一个Condition.class
- `@ProfileCondition`：主要判断@Profile与环境是否匹配的类，matches方法
    - `ConditionContext`：用于Condition的上下文，从中获取Environment，再从Environment中获取activeProfiles
    - `AnnotatedTypeMetadata`：元注解，对注解元素的封装适配，获取Profile注解
- 之后的处理与其他Condition接口相同