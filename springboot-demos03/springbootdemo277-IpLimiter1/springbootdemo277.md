# 参考地址
https://gitee.com/fanwentaomayun/ip-limite


# 配置黑白名单
```
my.white.ip.list=172.16.50.21,172.16.50.22,172.16.50.23

// 代码中使用时
@IpLimit(limitType = LimitType.WHITE_LIST, whiteList = "${my.white.ip.list}")
// 或
@IpLimit(limitType = LimitType.WHITE_LIST, whiteList = {"${my.white.ip.list}","172.16.50.35"})
```

# 核心限流类-LimitType
- DEFAULT - 走默认限流策略,不考虑黑白名单参数
- WHITE_LIST - 只考虑白名单策略,非白名单的请求全部回绝
- BLACK_LIST - 只考虑黑名单策略,非黑名单请求不做限流措施
- DEFAULT_WITH_WHITE_LIST - 在默认限流策略的基础上,白名单内的IP不做限流
- DEFAULT_WITH_BLACK_LIST - 在默认限流策略的基础上,直接403黑名单
- DEFAULT_WITH_WHITE_AND_BLACK_LIST - 在默认限流策略的基础上,直接403黑名单,再让白名单内的IP直接同行

# 测试
- TokenDefaultLimiterTypeController：令牌桶默认模式
- TokenWhiteLimiterTypeController：令牌桶白名单模式
- WhiteLimiterTypeController：滑动窗口白名单
- DynamicIpListController：滑动动态黑白名单
- DefaultLimiterTypeController：滑动窗口默认模式
- BlackLimiterTypeController：滑动窗口黑名单模式