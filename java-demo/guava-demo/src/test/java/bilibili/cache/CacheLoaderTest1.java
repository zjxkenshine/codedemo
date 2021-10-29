package bilibili.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 22:55
 * @description：CacheLoader测试
 * @modified By：
 * @version: $
 */
public class CacheLoaderTest1 {

    /**
     * 基本使用测试
     */
    @Test
    public void testBasic() throws ExecutionException, InterruptedException {
        //基本cache
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterAccess(30, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, Employee>() {
                    @Override
                    public Employee load(String s) throws Exception {
                        return getEmployee(s);
                    }
                });

        Employee employee = cache.get("Alex");
        System.out.println(employee.hashCode());
        TimeUnit.MILLISECONDS.sleep(50);
        Employee employee2 = cache.get("Alex");
        System.out.println(employee2.hashCode());
    }

    public Employee getEmployee(final String name){
        return new Employee(name,name,name);
    }

    /**
     * 删除/逐出
     * @return
     */
    @Test
    public void testEvictionBySize(){
        CacheLoader<String,Employee> cacheLoader = getCacheLoader();
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .maximumSize(2).build(cacheLoader);
        cache.getUnchecked("kenshine");
        cache.getUnchecked("qin");
        cache.getUnchecked("666");
        cache.getUnchecked("777");
        System.out.println(cache.size());
        System.out.println(cache.asMap());
    }

    private CacheLoader<String, Employee> getCacheLoader() {
        return new CacheLoader<String, Employee>() {
            @Override
            public Employee load(String s) throws Exception {
                return getEmployee(s);
            }
        };
    }


    /**
     * 通过权重逐出
     */
    @Test
    public void testEvictionByWeight(){
        CacheLoader<String,Employee> cacheLoader = getCacheLoader();

        //权重称
        Weigher<String,Employee> weigher = (key,employee)->
          employee.getDept().length()+employee.getName().length()+employee.getEmpID().length();
        //缓存
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .maximumWeight(45)
                .concurrencyLevel(1)
                .weigher(weigher)
                .build(cacheLoader);

        cache.getUnchecked("kenshine");

        cache.getUnchecked("xaaaaaaa");

        cache.getUnchecked("qin");
        //所有元素权重之和超过配置的权重，则开始逐出
        System.out.println(cache.asMap());


    }




}
