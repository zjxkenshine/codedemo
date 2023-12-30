package com.kenshine.hasorcore.test08_event;

import com.alibaba.fastjson.JSON;
import net.hasor.core.AppContext;
import net.hasor.core.EventContext;
import net.hasor.core.EventListener;
import net.hasor.core.Hasor;

/**
 * @author by kenshine
 * @Classname MyListener2
 * @Description 只执行一次的事件
 * @Date 2023-12-30 15:13
 * @modified By：
 * @version: 1.0$
 */
public class MyListener2 implements EventListener<Object> {

    @Override
    public void onEvent(String event, Object eventData) throws Throwable {
        Thread.sleep(500);
        System.out.println("Receive Message:" + JSON.toJSONString(eventData));
    }

    public static void main(String[] args) throws Throwable {
        AppContext appContext = Hasor.create().build();
        EventContext eventContext = appContext.getInstance(EventContext.class);
        // pushListener 注册监听器 仅执行一次
        eventContext.pushListener("listener2",new MyListener2());
        eventContext.fireAsyncEvent("listener2","eventData-async");
    }
}
