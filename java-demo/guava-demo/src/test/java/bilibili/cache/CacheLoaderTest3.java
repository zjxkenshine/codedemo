package bilibili.cache;

import com.google.common.base.Optional;
import com.google.common.cache.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 0:06
 * @description：cache测试3
 * @modified By：
 * @version: $
 */
public class CacheLoaderTest3 {

    /**
     * key为空时 会报异常
     */
    @Test
    public void testLoadNullValue(){
        CacheLoader<String,Employee> cacheLoader = CacheLoader.from(
                k->k.equals("null")?null:new Employee(k,k,k)
        );
        LoadingCache<String,Employee> loadingCache = CacheBuilder.newBuilder()
                .build(cacheLoader);

        Employee kenshine = loadingCache.getUnchecked("kenshine");
        Employee nullValue = loadingCache.getUnchecked("null");

        System.out.println(kenshine);
        System.out.println(nullValue);
    }

    /**
     * Optional处理控制 java8也有
     */
    @Test
    public void testLoadNullValueUseOptional(){
        CacheLoader<String, Optional<Employee>> cacheLoader = CacheLoader.from(
                k->{
                    if(k.equals("null")){
                        return Optional.fromNullable(null);
                    }else{
                        return Optional.fromNullable(new Employee(k,k,k));
                    }
                }
        );
        LoadingCache<String,Optional<Employee>> loadingCache = CacheBuilder.newBuilder()
                .build(cacheLoader);

        Employee kenshine = loadingCache.getUnchecked("kenshine").get();
        //默认值
        Employee nullValue = loadingCache.getUnchecked("null").or(new Employee("default","default","default"));

        System.out.println(kenshine);
        System.out.println(nullValue);
    }


    /**
     * 测试刷新
     * guava刷新机制：在数据中存过期时间，过期则访问数据源刷新，而不是另启一个线程进行刷新
     */
    @Test
    public void testRefresh() throws InterruptedException {
        CacheLoader<String,Long> cacheLoader = CacheLoader.from(s -> System.currentTimeMillis());
        LoadingCache<String,Long> cache = CacheBuilder.newBuilder()
                //这里不设置过期时间
                .refreshAfterWrite(2, TimeUnit.SECONDS)
                .build(cacheLoader);

        Long result1 = cache.getUnchecked("kenshine");
        TimeUnit.SECONDS.sleep(1);
        Long result2 = cache.getUnchecked("kenshine");


        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * 预加载缓存
     */
    @Test
    public void testCachePreLoad(){
        CacheLoader<String,String> loader = CacheLoader.from(String::toUpperCase);
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().build(loader);


        Map<String,String> preData = new HashMap<String,String>(){
            {
                //有问题，数据可能与规则不一样
                put("kenshine","KENSHINE");
                put("hello","HELLO");
            }
        };
        cache.putAll(preData);

        System.out.println(cache.size());
     }


    /**
     * 逐出通知
     */
    @Test
     public void testRemoveByNotification(){
         CacheLoader<String,String> loader = CacheLoader.from(String::toUpperCase);
         //监听移除
        RemovalListener<String,String> listener = removalNotification -> {
            //被逐出
            if(removalNotification.wasEvicted()){
                RemovalCause cause = removalNotification.getCause();
                System.out.println(cause);
            }
        };
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().maximumSize(2).removalListener(listener).build(loader);

        cache.getUnchecked("kenshine");
        cache.getUnchecked("a");
        cache.getUnchecked("b");
    }






}
