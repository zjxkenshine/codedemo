# 参考地址
github
- https://github.com/houbb/sisyphus

# 注解
## @Retry指定重试的相关配置
- retry：重试类实现
- maxAttempt：最大尝试次数，默认3
- condition：重试触发的场景
- listen：监听器
- recover：恢复操作
- waits：等待策略 （RetryWait）

## @RetryWait重试等待策略
- value：默认值
- min：最小值
- max：最大值
- factor：影响因素
- retryWait：等待时间class

