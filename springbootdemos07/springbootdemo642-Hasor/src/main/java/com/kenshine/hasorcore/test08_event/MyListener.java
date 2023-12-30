package com.kenshine.hasorcore.test08_event;

import com.alibaba.fastjson.JSON;
import net.hasor.core.AppContext;
import net.hasor.core.EventContext;
import net.hasor.core.EventListener;
import net.hasor.core.Hasor;

/**
 * 事件监听器
 * @author kenshine
 */
public class MyListener implements EventListener<Object> {
    @Override
    public void onEvent(String event, Object eventData) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Receive Message:" + JSON.toJSONString(eventData));
    }

    public static void main(String[] args) throws Throwable {
        AppContext appContext = Hasor.create().build();
        EventContext eventContext = appContext.getInstance(EventContext.class);
        // 注册监听器
        eventContext.addListener("listener1",new MyListener());
        // 执行异步事件
        eventContext.fireAsyncEvent("listener1","eventData-async");
        // 执行同步事件
        eventContext.fireSyncEvent("listener1","eventData-sync");
    }
}