package bilibili.eventBus;

import bilibili.eventBus.listeners.ExceptionListener;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 22:20
 * @description：异常时间
 * @modified By：
 * @version: $
 *
 * SubscriberExceptionHandler 接口处理监听器中的异常
 */
public class ExceptionEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus(new ExceptionHandler());
        eventBus.register(new ExceptionListener());
        eventBus.post("exception post");
    }

    /**
     * 异常处理
     */
    static class ExceptionHandler implements SubscriberExceptionHandler{

        @Override
        public void handleException(Throwable exception, SubscriberExceptionContext context){
            System.out.println(context.getEvent());
            System.out.println(context.getEventBus());
            System.out.println(context.getSubscriber());
            System.out.println(context.getSubscriberMethod());
        }
    }

}
