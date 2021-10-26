# 1.支持的缓存
- Generic
- JCache(JSR-107)(EhCache 3, Hazelcast, Infinispan)
- EhCache 2.x
- Hazelcast
- Infinispan
- Couchbase
- Redis
- Caffeine
- Guava
- Simple

# 2.注解
## @Cacheable 开启缓存
用在类或方法上,支持缓存
- 参数
    - value：缓存的名称
    - key：缓存的 key
    - condition：缓存条件
    - unless：排除条件

##  @CachePut      更新缓存
##  @CacheEvict    清空缓存
##  @Caching     可以指定多个注解
```
@Caching(cacheable = @Cacheable("users"), evict = { @CacheEvict("cache2"),@CacheEvict(value = "cache3", allEntries = true) })
public User find(Integer id) {
    return null;
}
```
