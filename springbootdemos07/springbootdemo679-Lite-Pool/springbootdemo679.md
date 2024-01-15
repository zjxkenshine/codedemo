# 参考地址
lite-pool 快速轻量级对象池
- https://github.com/nextopcn/lite-pool

# 概述
PoolBuilder：配置
- minimus：最少对象数 0
- maximum：最大对象数 16
- tti：生存时间，可选的最大池对象生存时间，单位为ms 默认15分
- ttl：生存时间，可选池对象的最大生存时间，单位为ms 默认60分
- tenancy：泄漏检测超时，单位为ms（MUST>=间隔）1分
- timeout：默认获取超时，单位为ms 8秒
- interval：默认内务调度程序的间隔，单位为ms 15秒
- local：是否将ThreadAllocator用作一级缓存 true
- verbose：是否打印 false
- fifo：池分配策略，false具有更好的性能 false
- allocator：池分配器，可以通过扩展AbstractAllocator进行自定义 DefaultAllocator
- supplier：创建池对象所需的回调
- consumer：用于销毁池对象的可选回调
- validator：用于验证池对象的可选回调
- validation：验证器的前提条件 PULSE

# 目录 LitePoolTest 
- test01：基本使用 PoolBuilder
- test02：PoolListener
- test03：自定义分配器PoolAllocator

