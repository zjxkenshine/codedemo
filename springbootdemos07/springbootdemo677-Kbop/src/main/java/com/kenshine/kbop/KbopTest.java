package com.kenshine.kbop;

import com.kenshine.kbop.model.MyClient;
import org.junit.Test;
import org.pacesys.kbop.*;

import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname KbopTest
 * @Description kbop对象池使用测试
 * @Date 2024-01-12 15:40
 * @modified By：
 * @version: 1.0$
 */
public class KbopTest {

    /**
     * IKeyedObjectPool 对象池使用示例
     */
    @Test
    public void test01() throws Exception {
        IPoolObjectFactory<String, MyClient> factory = new IPoolObjectFactory<String,MyClient>() {
            @Override
            public MyClient create(PoolKey<String> key) {
                System.out.println("创建了key="+key.get());
                MyClient myClient=new MyClient();
                myClient.setKey(key.get());
                return myClient;
            }

            @Override
            public void activate(MyClient object) {
                // 重新初始化
                System.out.println("重新初始化"+object);
            }

            @Override
            public void passivate(MyClient object) {
                // 归还给池
                System.out.println("归还给池"+object);
            }

            @Override
            public void destroy(MyClient object) {
                // 销毁池
            }
        };
        // 单个对象池
        IKeyedObjectPool.Single<String,MyClient> pool1 = Pools.createPool(factory);
        // 单key多对象对象池
        IKeyedObjectPool.Multi<String, MyClient> pool2= Pools.createMultiPool(factory, 10);

        // 借a
        IPooledObject<MyClient> a = pool1.borrow("a");
        IPooledObject<MyClient> b = pool1.borrow("b");
        IPooledObject<MyClient> a2 = pool1.borrow("a", 1, TimeUnit.SECONDS);
        // 释放
        a2.release();
        IPooledObject<MyClient> a3 = pool1.borrow("a");

        // 销毁对象，会重新创建
        IPooledObject<MyClient> a4 = pool1.borrow("a");
        // 归还并移除对象
        pool1.invalidate(a4);
        // 会重新创建
        IPooledObject<MyClient> a5 = pool1.borrow("a");

        // 多对象
        IPooledObject<MyClient> aa = pool1.borrow("aa");
        IPooledObject<MyClient> aa1 = pool1.borrow("aa");
        IPooledObject<MyClient> aa2 = pool1.borrow("aa");
    }

}
