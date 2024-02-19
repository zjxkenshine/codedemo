# 参考地址
日交易额百亿级交易系统的超轻量日志实现
- https://www.cnblogs.com/cyfonly/p/6139049.html

基于双缓冲队列、多刷盘机制的超轻量级 java 日志
- https://github.com/cyfonly/FLogger

# 特性
- 双缓冲队列
- 多种刷盘机制，支持时间触发、缓存大小触发、服务关闭强制触发等刷盘方式
- 多种 RollingFile 机制，支持文件大小触发、按天触发等 Rolling 方式
- 多日志级别，支持 debug、info、warn、error和 fatal 等日志级别
- 热加载，由日志事件触发热加载
- 超轻量，不依赖任何第三方库
- 性能保证，成功用于日交易额百亿级交易系统

