package com.kenshine.fastpool;

import cn.danielw.fop.ObjectFactory;
import cn.danielw.fop.ObjectPool;
import cn.danielw.fop.PoolConfig;
import cn.danielw.fop.Poolable;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname FopTest
 * @Description fast-object-pool 使用测试
 * @Date 2024-01-10 13:51
 * @modified By：
 * @version: 1.0$
 */
public class FopTest {
    /**
     * FOP 使用测试
     */
    @Test
    public void test01() throws InterruptedException {
        // FOP 配置
        PoolConfig config = new PoolConfig();
        config.setPartitionSize(5);
        config.setMaxSize(10);
        config.setMinSize(5);
        config.setMaxIdleMilliseconds(60 * 1000 * 5);
        // 定义工厂
        ObjectFactory<StringBuilder> factory = new ObjectFactory<StringBuilder>() {
            @Override public StringBuilder create() {
                return new StringBuilder();
            }
            @Override
            public void destroy(StringBuilder stringBuilder) {
            }
            @Override
            public boolean validate(StringBuilder stringBuilder) {
                return true;
            }
        };
        // 使用配置与工厂创建对象池
        ObjectPool<StringBuilder> pool = new ObjectPool<>(config, factory);
        // 使用对象池
        try (Poolable<StringBuilder> obj = pool.borrowObject()) {
           StringBuilder sb = obj.getObject();
           sb.append("kenshine");
           System.out.println(sb);
        }
        // 关闭对象池
        pool.shutdown();
    }
}
