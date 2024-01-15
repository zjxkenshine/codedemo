package com.kenshine.litepool;

import cn.nextop.lite.pool.Pool;
import cn.nextop.lite.pool.PoolBuilder;
import com.kenshine.litepool.allocator.MyPoolAllocator;
import com.kenshine.litepool.listener.MyListener;
import com.kenshine.litepool.model.MyObject;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname LitePoolTest
 * @Description litepool使用
 * @Date 2024-01-15 8:31
 * @modified By：
 * @version: 1.0$
 */
public class LitePoolTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        Pool<MyObject> pool = new PoolBuilder<MyObject>()
                //使用thread local
                .local(true)
                .supplier(MyObject::new)
                .build("object pool");
        pool.start();
        try {
            for(int i = 0; i < 1000; i++) {
                MyObject object = null;
                try {
                    // 获取对象
                    object = pool.acquire();
                    if (object != null) {
                        System.out.println(object);
                    }
                } finally {
                    if (object != null) {
                        // 归还对象
                        pool.release(object);
                    }
                }
            }
        } finally {
            pool.stop();
        }
    }

    /**
     * 监听器使用
     */
    @Test
    public void test02(){
        Pool<MyObject> pool = new PoolBuilder<MyObject>()
                //使用thread local
                .local(true)
                .supplier(MyObject::new)
                .build("listened pool");
        // 注册监听器
        pool.addListener(new MyListener());
        pool.start();
        MyObject object = pool.acquire();
        pool.release(object);
        pool.stop();
    }

    /**
     * 自定义分配器
     */
    @Test
    public void test03(){
        Pool<MyObject> pool = new PoolBuilder<MyObject>()
                .allocator(new MyPoolAllocator.Factory<>())
                //使用thread local
                .local(true)
                .supplier(MyObject::new)
                .build("my allocator pool");
        // 注册监听器
        pool.addListener(new MyListener());
        pool.start();
        MyObject object = pool.acquire();
        pool.release(object);
        pool.stop();
    }
}
