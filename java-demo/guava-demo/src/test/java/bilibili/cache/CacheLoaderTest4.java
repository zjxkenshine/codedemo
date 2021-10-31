package bilibili.cache;

import com.google.common.cache.*;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 9:46
 * @description：cache测试4
 * @modified By：
 * @version: $
 *
 *
 */
public class CacheLoaderTest4 {

    /**
     * CacheStats 缓存统统计
     */
    @Test
    public void testCacheStat(){
        CacheLoader<String,String> loader = CacheLoader.from(String::toUpperCase);
        //recordStats() 产生记录统计
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().recordStats().build(loader);

        System.out.println(cache.getUnchecked("kenshine"));
        CacheStats stats1 = cache.stats();
        System.out.println(cache.getUnchecked("kenshine"));
        //CacheStat 参数不可变，需要重新获取
        CacheStats stats2 = cache.stats();
        System.out.println(stats1);
        System.out.println(stats2);
    }

    /**
     * CacheSpec 通过配置字符串构建cache
     */
    @Test
    public void testCacheSpec(){
        String spec="maximumSize=2,recordStats";
        CacheBuilderSpec builderSpec = CacheBuilderSpec.parse(spec);

        CacheLoader<String,String> loader = CacheLoader.from(String::toUpperCase);
        //recordStats() 产生记录统计
        LoadingCache<String,String> cache = CacheBuilder.from(builderSpec).build(loader);

        System.out.println(cache.getUnchecked("kenshine"));
        CacheStats stats1 = cache.stats();
        System.out.println(cache.getUnchecked("kenshine"));
        //CacheStat 参数不可变，需要重新获取
        CacheStats stats2 = cache.stats();
        System.out.println(stats1);
        System.out.println(stats2);
    }

}
