# 1.EhCache
1. EhCache是一个纯Java的进程内缓存框架，具有快速、上手简单等特点，是Hibernate中默认的缓存提供方
2. Hibernate三级缓存:
    - 一级缓存Session级别，缓存对象信息
    - 二级缓存SessionFactory,手动开启,依赖ehcache
    - 三级缓存sql结果
3. EhCache缓存特点：
    - 快速，简单，并且提供多种缓存策略；
    - 缓存数据有两级：内存和磁盘，无需担心容量问题；
    - 缓存数据会在虚拟机重启的过程中写入磁盘；
    - 可以通过RMI、可插入API等方式进行分布式缓存；
    - 具有缓存和缓存管理器的侦听接口；
    - 支持多缓存管理器实例，以及一个实例的多个缓存区域；
    - 提供Hibernate的缓存实现；
4.对比redis:
   - Ehcache：直接在Jvm虚拟机中缓存，速度快，效率高，不适合处理大规模缓存数据，在分布式环境下，缓存数据共享操作复杂
   - Redis：作为独立的缓存中间件，在分布式缓存系统中非常好用，成熟方案


# 2.Cache相关注解
- `@Cacheable`: 应用到读取数据的方法上，即可缓存的方法
    - value、cacheNames:缓存集合名
    - key:缓存对象存储在Map集合中的key值
    - condition:满足条件缓存，函数调用前判断
    - unless:函数被调用之后才做判断
    - keyGenerator: 指定key生成器，与key参数互斥，KeyGenerator接口
    - cacheManager：指定缓存管理器
    - cacheResolver：指定缓存解析器
    - 示例：`@Cacheable(value = "user", key = "#id")`
- `@CachePut`: 用到写数据的方法上，如新增/修改方法，会把返回数据写入缓存
    - `@CachePut(value = "user", key = "#user.id")  `
- `@CacheEvict `:移除数据的方法,调用方法时会从缓存中移除相应的数据
    - allEntries:默认false,移除所有数据
    - beforeInvocation:默认false,在调用方法后，true在之前
    - `@CacheEvict(value = "user", key = "#id")`
- `@Caching`: 组合注解

# 3.缓存策略
- FIFO (First in First Out) 先进先出策略，即先放入缓存的数据先被移除
- LRU (Least Recently Used) 最久未使用策略， 即使用时间距离现在最久的那个数据被移除
- LFU (Least Frequently Used)  最少使用策略，即一定时间内使用次数（频率）最少的那个数据被移除
- TTL（Time To Live）存活期，即从缓存中创建时间点开始至到期的一个时间段（不管在这个时间段内有没被访问过都将过期）
- TTI （Time To Idle）空闲期，即一个数据多久没有被访问就从缓存中移除的时间。