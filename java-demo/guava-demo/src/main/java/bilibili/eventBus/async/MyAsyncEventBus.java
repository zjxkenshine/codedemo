package bilibili.eventBus.async;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.SubscriberExceptionHandler;

import java.util.concurrent.Executor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 22:55
 * @description：异步事件
 * @modified By：
 * @version: $
 *
 * 可以指定那个线程来执行事件
 */
public class MyAsyncEventBus extends AsyncEventBus {

    public MyAsyncEventBus(String identifier, Executor executor) {
        super(identifier, executor);
    }

    public MyAsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(executor, subscriberExceptionHandler);
    }

    public MyAsyncEventBus(Executor executor) {
        super(executor);
    }
}
