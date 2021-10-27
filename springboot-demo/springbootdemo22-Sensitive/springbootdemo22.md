# 日志脱敏框架Sensitive
参考地址
- https://github.com/houbb/sensitive


# 目录：
测试类：
- sensitiveTest01 脱敏测试
    - test01   基本使用方法
    - test02   单字段脱敏
    

主类
- domain        实体类,在字段上加上Sensitive注解开启脱敏
- condition     自定义脱敏策略生效的场景
   
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
- 暂时不能整合日志框架