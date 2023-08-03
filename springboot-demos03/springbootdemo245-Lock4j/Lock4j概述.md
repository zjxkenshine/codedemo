# 1、概述：
- lock4j是一个分布式锁组件，其提供了多种不同的支持以满足不同性能和环境的需求
- 支持redission,redisTemplate,zookeeper。可混用，支持扩展

# 2、使用：
## 1. 基本使用
` @Lock4j`,`@Lock4j(keys = {"#user.id", "#user.name"}, expire = 60000, acquireTimeout = 1000)`
   
## 2. 配置全局默认的获取锁超时时间和锁过期时间
```yaml
lock4j:
  acquire-timeout: 3000 #默认值3s，可不设置 超时时间，超时报错
  expire: 30000 #默认值30s，可不设置 过期时间
  primary-executor: com.baomidou.lock.executor.RedisTemplateLockExecutor #默认redisson>redisTemplate>zookeeper，可不设置
  lock-key-prefix: lock4j #锁key前缀, 默认值lock4j，可不设置
```

## 3. 自定义执行器
```
    //可在方法级指定使用某种执行器，若自己实现的需要提前注入到Spring。
    @Lock4j(executor = RedissonLockExecutor.class)
```

## 4. 自定义锁key生成器
默认的锁key生成器为`com.baomidou.lock.DefaultLockKeyBuilder`

自定义生成器参考：MyLockKeyBuilder

## 5. 自定义锁获取失败策略
参考：MyLockFailureStrategy

## 6. 手动上锁解锁
参考：ProgrammaticService

## 7. 指定时间内不释放锁(限流)
参考：XlService

