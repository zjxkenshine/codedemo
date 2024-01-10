package com.kenshine.pool;

import nf.fr.eraasoft.pool.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname PoolTest
 * @Description 对象池使用
 * @Date 2024-01-10 13:27
 * @modified By：
 * @version: 1.0$
 */
public class PoolTest {

    /**
     * 使用对象池
     */
    @Test
    public void test01(){
        // 使用PoolableObject实例创建PoolSettings
        PoolSettings<StringBuilder> poolSettings = new PoolSettings<>(
                new PoolableObjectBase<StringBuilder>() {
                    @Override
                    public StringBuilder make() {
                        return new StringBuilder();
                    }

                    @Override
                    public void activate(StringBuilder t) {
                        t.setLength(0);
                    }
                });
        // 添加配置
        poolSettings.min(0).max(10);
        // 单例模式创建ObjectPool
        ObjectPool<StringBuilder> objectPool = poolSettings.pool();
        // 使用对象池
        StringBuilder buffer = null;
        try {
            // 操作对象
            buffer = objectPool.getObj();
            System.out.println(buffer);
            buffer.append(" aaaa");
            // 归还对象
            objectPool.returnObj(buffer);
            System.out.println(buffer);
        } catch (PoolException e) {
            e.printStackTrace();
        } finally {
            // 返回池对象
            objectPool.returnObj(buffer);
        }
        PoolSettings.shutdown();
    }

}
