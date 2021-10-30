package bilibili.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 23:40
 * @description：测试2
 * @modified By：
 * @version: $
 */

public class CacheLoaderTest2 {

    /**
     * AccessTime   读写，修改后的时间
     */
    @Test
    public void TestEvictByAccessTime() throws InterruptedException {
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                //两秒失效  上一次写/读/修改后
                .expireAfterAccess(2, TimeUnit.SECONDS)
                .build(this.createCacheLoader());

        System.out.println(cache.getUnchecked("kenshine").hashCode());

        TimeUnit.SECONDS.sleep(1);
        System.out.println(cache.getUnchecked("kenshine").hashCode());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(cache.getUnchecked("kenshine").hashCode());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(cache.getUnchecked("kenshine").hashCode());

    }

    /**
     * writeTime 写/修改后的时间
     */
    @Test
    public void TestEvictByWriteTime() throws InterruptedException {
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                //两秒失效  上一次写/更新 读取不会重置时间
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .build(this.createCacheLoader());

        System.out.println(cache.getUnchecked("kenshine").hashCode());

        TimeUnit.SECONDS.sleep(1);
        System.out.println(cache.getUnchecked("kenshine").hashCode());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(cache.getUnchecked("kenshine").hashCode());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(cache.getUnchecked("kenshine").hashCode());

    }


    private  CacheLoader<String,Employee> createCacheLoader(){
        return CacheLoader.from(key->new Employee(key,key,key));
    }


    /**
     * 弱引用
     */
    @Test
    public void testWeakKey() throws InterruptedException {
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                //两秒失效  上一次写/更新 读取不会重置时间
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .weakValues()
                .weakKeys()
                .build(this.createCacheLoader());

        System.out.println(cache.getUnchecked("kenshine"));
        System.gc();
        TimeUnit.MILLISECONDS.sleep(100);
        //被回收则weinull,不会创建新的
        System.out.println(cache.getIfPresent("kenshine"));
    }

    /**
     * 软引用
     * 将要OOM时会回收
     * @throws InterruptedException
     */
    @Test
    public void testSoftKey() throws InterruptedException {
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                //两秒失效  上一次写/更新 读取不会重置时间
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .softValues()
                .build(this.createCacheLoader());

        int i = 0;
        for(;;){
            cache.put("kenshine"+i,new Employee("kenshine","kenshine","kenshine"));
            System.out.println("employee"+i+++"将会被缓存");
            TimeUnit.MILLISECONDS.sleep(800);
        }
    }



}
