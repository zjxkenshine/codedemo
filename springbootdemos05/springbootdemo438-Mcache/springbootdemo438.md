# 参考地址
mcache
- https://gitee.com/msimw/mcache

@ImportSource Spring本地配置文件引入

# 注解
- @Cached：用在类上，用于标记需要缓存的类
    - 属性value用于标示缓存分组，默认值cache
- @Cacheable：用在需要缓存的方法上
    - 属性cache 标示使用哪一种缓存方式。目前支持redis，memcache
    - 属性value 用于标示缓存分组，默认值bst
    - 属性String[]  keys用于标示用那几个字段作为缓存key
    - 属性survivalTime缓存存活时间，默认30分钟，单位是秒。-1标示永不过期
- @CacheEvict/@CacheEvicts：清空缓存,用在缓存有更新的方法上
- CacheSupport接口：部分不满足统一缓存的需求

## 扩展：
1. 实现CacheHandler接口或继承AbstractCacheHandler类
2. 将新的缓存处理器注入到CacheInterceptor 拦截器中
3. 就可以在Cacheable注解上选择相应缓存处理器了。  
