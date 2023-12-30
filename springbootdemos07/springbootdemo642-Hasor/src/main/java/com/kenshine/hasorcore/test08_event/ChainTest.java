package com.kenshine.hasorcore.test08_event;

import net.hasor.core.AppContext;
import net.hasor.core.EventContext;
import net.hasor.core.EventListener;
import net.hasor.core.Hasor;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ChainTest
 * @Description 执行链
 * @Date 2023-12-30 15:16
 * @modified By：
 * @version: 1.0$
 */
public class ChainTest {
    @Test
    public void syncEventTest() throws InterruptedException {
        System.out.println("--->>syncEventTest<<--");
        AppContext appContext = Hasor.create().build();
        EventContext ec = appContext.getEnvironment().getEventContext();

        //事件链的终端
        final String EventName = "MyEvent";
        //种子事件
        final String SeedEvent = "SeedEvent";

        //1.添加事件监听器
        ec.addListener(EventName, new MyListener());
        ec.addListener(SeedEvent, new EventListener<AppContext>() {
            @Override
            public void onEvent(String event, AppContext app) throws Throwable {
                EventContext localEC = app.getEnvironment().getEventContext();
                System.out.println("before MyEvent.");
                localEC.fireAsyncEvent(EventName, 1);
                localEC.fireAsyncEvent(EventName, 2);
            }
        });

        //2.引发种子事件
        ec.fireAsyncEvent(SeedEvent, appContext);

        //3.由于是异步事件，因此下面这条日志会在所有事件之前喷出
        System.out.println("before All Event.");
        Thread.sleep(1000);
    }
}
