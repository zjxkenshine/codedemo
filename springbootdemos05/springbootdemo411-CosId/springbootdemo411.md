# 参考地址
CosId 通用、灵活、高性能的分布式 ID 生成器
- https://zhuanlan.zhihu.com/p/386239033
- https://gitee.com/AhooWang/CosId

官网
- https://cosid.ahoo.me/guide

- https://blog.51cto.com/u_15076218/4391812

需要切换Springboot3环境及java17版本
默认会生成__share__SnowflakeId的共享id生成器

# 分布式ID分配方案
- UUID/GUID
    - 不依赖任何第三方中间件
    - 性能高
    - 完全无序
    - 空间占用大，需要占用128位存储空间
- SnowflakeId
    - 性能高
    - 需要配置
    - 受全局时钟同步/时钟回拨影响
    - 机器号分配问题，machineId需要手动设置
    - JavaScript数值溢出问题
- SegmentId：号段模式
    - 强依赖第三方号段分发器
    - 每次号段用完时获取NextMaxId需要进行网络IO请求
    - ID乱序程度受到Step长度以及集群规模影响
- SegmentChainId：号段链模式
    - 稳定
    - 高性能
    - 适应性强
  
# 组成：
- CosIdGenerator
- SnowflakeId
- SegmentId
- SegmentChainId

