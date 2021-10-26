package bilibili.eventBus;

import bilibili.eventBus.listeners.MultiEventListeners;
import com.google.common.eventbus.EventBus;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:17
 * @description：多事件监听示例
 * @modified By：
 * @version: $
 */
public class MultipleEventExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        //注册了多个事件监听器
        eventBus.register(new MultiEventListeners());
        //string event
        eventBus.post("aaaaa");
        //int event
        eventBus.post(123456);
    }

}
