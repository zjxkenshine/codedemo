# 参考地址
log-record 使用注解优雅记录系统日志，操作日志，后端埋点等，支持SpEL表达式，自定义上下文，自定义函数，实体类DIFF等其他高阶处理。
- https://github.com/qqxx6661/log-record

# 日志实体
```
logId：生成的UUID
bizId：业务唯一ID
bizType：业务类型
exception：函数执行失败时写入异常信息
operateDate：操作执行时间
success：函数是否执行成功
msg：日志内容
tag：自定义标签
returnStr: 方法执行成功后的返回值（字符串或JSON化实体）
executionTime：方法执行耗时（单位：毫秒）
extra：额外信息
operatorId：操作人ID
List<diffDTO>: 实体类对象Diff数据，包括变更的字段名，字段值，类名等
```