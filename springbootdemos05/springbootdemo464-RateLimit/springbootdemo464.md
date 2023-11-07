# 0.参考地址
github
- https://github.com/houbb/rate-limit

# 1.`@RateLimit`注解属性
- value：每一次方法请求消耗的令牌数
- timeUnit：时间单位
- interval：时间间隔
- count：调用次数
- enable：是否启用
- 默认为 60S 内，可以调用 1000 次

# 2.`@RateLimits`注解
可同时做多个限制
- 一分钟不超过 10 次
- 一小时不超过 30 次

`@RateLimits({@RateLimit(interval = 2, count = 5)})`

# 3.RateLimitBs,引导类，便于用户自定义配置
    方法	                  说明	                        默认值
    rateLimit	    限流策略	        RateLimits.tokenBucket() 令牌桶算法
    timer	            时间策略	        Timers.system() 系统时间
    cacheService	    缓存策略	        CommonCacheServiceMap 基于本地 map 的缓存策略
    cacheKeyNamespace   缓存KEY命名空间	RATE-LIMIT 避免不同的应用，命名冲突。
    configService	    限制配置策略	    RateLimitConfigService 默认基于方法上的注解
    tokenService	    身份标识策略	    RateLimitTokenService 默认基于 IP
    methodService	    方法标识策略	    RateLimitMethodService 默认基于方法名+参数类型
    rejectListener	    拒绝策略	        RateLimitRejectListenerException 限流时抛出异常
spring中通过bean配置

# 4.内置限流策略,RateLimits工具中的策略：
    方法	           说明
    fixedWindow()	固定窗口
    slideWindow(int windowNum)	滑动窗口，可指定窗口大小
    slideWindow()	滑动窗口，默认为 10
    slideWindowQueue()	滑动窗口，基于队列的实现
    leakyBucket()	漏桶算法
    tokenBucket()	令牌桶算法