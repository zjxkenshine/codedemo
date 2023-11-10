# 日志脱敏框架Sensitive
参考地址
- https://github.com/houbb/sensitive


# 目录：
测试类：
- sensitiveTest01 脱敏测试 0.0.13版本
    - test01   基本使用方法
    - test02   单字段脱敏
- sensitiveTest02 脱敏测试 1.6.0版本
    - 自定义脱敏注解、引导类、脱敏JSON、整合log4j2、整合logback
  
主类
- domain        实体类,在字段上加上Sensitive注解开启脱敏
  - User：自定义脱敏策略生效的场景
  - UserAnnotationBean：简易脱敏注解
  - 其他注解使用
- condition     自定义脱敏策略生效的场景
- annotation：自定义注解
- strategy：自定义策略

# 其他功能
参考https://github.com/houbb/sensitive
- 属性为集合或者对象 @SensitiveEntry 注解
- 内置脱敏策略 等同于 @Sensitive(strategy = ....)
    - @SensitiveStrategyChineseName
    - @SensitiveStrategyPassword
    - @SensitiveStrategyEmail
    - @SensitiveStrategyCardId
    - @SensitiveStrategyPhone
- 自定义注解/脱敏策略    实现IStrategy接口
- 生成脱敏JSON      SensitiveUtil.desJson()方法