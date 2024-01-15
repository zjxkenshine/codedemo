package com.kenshine.litepool.listener;

import cn.nextop.lite.pool.PoolEvent;
import cn.nextop.lite.pool.PoolListener;
import com.kenshine.litepool.model.MyObject;

/**
 * @author by kenshine
 * @Classname MyListener
 * @Description 自定义监听器
 * @Date 2024-01-15 8:39
 * @modified By：
 * @version: 1.0$
 */
public class MyListener implements PoolListener<MyObject> {
    @Override
    public void onEvent(PoolEvent<MyObject> event) {
        MyObject item = event.getItem();
        switch (event.getType()) {
            case ACQUIRE:
                System.out.println("获取了");
                break;
            case RELEASE:
                System.out.println("归还了");
                break;
            case LEAKAGE:
                System.out.println("泄露了");
                break;
            default:
                throw new AssertionError();
        }
    }
}
