package com.kenshine.imcache;

import com.cetsoft.imcache.cache.*;
import com.cetsoft.imcache.cache.builder.CacheBuilder;
import com.cetsoft.imcache.cache.search.CacheQuery;
import com.cetsoft.imcache.cache.search.criteria.BetweenCriteria;
import com.cetsoft.imcache.cache.search.criteria.ETCriteria;
import com.cetsoft.imcache.cache.search.filter.LTFilter;
import com.cetsoft.imcache.cache.search.index.IndexType;
import com.cetsoft.imcache.offheap.bytebuffer.OffHeapByteBufferStore;
import com.kenshine.imcache.dao.UserDao;
import com.kenshine.imcache.pojo.User;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname ImcacheTest
 * @Description 测试
 * @Date 2023-11-02 9:08
 * @modified By：
 * @version: 1.0$
 */
public class ImcacheTest {
    UserDao userDAO = new UserDao();

    /**
     * 基本使用
     * CacheBuilder
     * cacheLoader
     * evictionListener
     */
    @Test
    public void test01(){
        // CacheBuilder创建缓存
        final Cache<String, User> cache = CacheBuilder.heapCache().
                cacheLoader(new CacheLoader<String, User>() {
                    // 加载缓存时调用
                    @Override
                    public User load(String key) {
                        return userDAO.get(key);
                    }
                }).evictionListener(new EvictionListener<String, User>() {
            // 驱逐缓存市调用
            @Override
            public void onEviction(String key, User user) {
                userDAO.save(key, user);
            }
        }).capacity(10000).build();

        final User user = cache.get("1");
        System.out.println(user);
        final User newUser = new User(4,"kenshine4");
        cache.put("4", newUser);

        final User user1 = cache.get("4");
        System.out.println(user1);
        // 移除 调用EvictionListener
        System.out.println("移除");
        cache.invalidate("4");

        //System.out.println("清空");
        //cache.clear();
    }

    /**
     * 堆外缓存 缓冲区建议为8M
     */
    @Test
    public void test02(){
        //8388608 is 8 MB and 10 buffers. 8MB*10 = 80 MB.
        final OffHeapByteBufferStore bufferStore = new OffHeapByteBufferStore(8388608, 10);
        final Cache<Integer,String> offHeapCache = CacheBuilder.offHeapCache().
                storage(bufferStore).build();

        offHeapCache.put(1,"kenshine1");
        offHeapCache.put(2,"kenshine2");

        System.out.println(offHeapCache.get(1));
        System.out.println(offHeapCache.get(2));
    }


    /**
     * 版本管理堆外缓存
     */
    @Test
    public void test03(){
        //8388608 is 8 MB and 10 buffers. 8MB*10 = 80 MB.
        final OffHeapByteBufferStore bufferStore = new OffHeapByteBufferStore(8388608, 10);
        final Cache<Integer, VersionedItem<String>> offHeapCache = CacheBuilder.versionedOffHeapCache().storage(bufferStore).build();
        offHeapCache.put(1,new SimpleItem<String>("kenshine"));
        System.out.println(offHeapCache.get(1));

        offHeapCache.put(1,new SimpleItem<String>(1,"kenshine1"));
        System.out.println(offHeapCache.get(1));
    }

    /**
     * 使用Redis
     */
    @Test
    public void test04(){
        Cache<Integer, String> cache = CacheBuilder.redisCache().
                hostName("127.0.0.1").port(6379).build();
        cache.put(1, "apple");
        System.out.println(cache.get(1));
    }

    /**
     * 可搜索的缓存
     */
    @Test
    public void test05(){
        // 添加索引
        SearchableCache<Integer, User> cache = CacheBuilder.heapCache().
                addIndex("id", IndexType.RANGE_INDEX).build();
        cache.put(0, new User(0,"jkenshine"));
        cache.put(1, new User(1,"jkenshine1"));
        cache.put(2, new User(2,"jkenshine2"));
        cache.put(3, new User(3,"jkenshine3"));
        cache.put(4, new User(4,"jkenshine3"));
        cache.put(5, new User(5,"jkenshine4"));
        List<User> objects = cache.execute(CacheQuery.newQuery().
                // 判定接口 0-2
                setCriteria(new BetweenCriteria("id",1,3).
                        // 是给定值 =3
                        or(new ETCriteria("id", 3))).
                // 过滤器 过滤小于给定值的项 <3
                setFilter(new LTFilter("id", 3)));
        for (User user : objects) {
            System.out.println(user);
        }
    }

}
