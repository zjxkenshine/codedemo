package bilibili.eventBus;

import bilibili.eventBus.listeners.SimpleListener;
import com.google.common.eventbus.EventBus;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:10
 * @description：简单事件总线
 * @modified By：
 * @version: $
 */
public class SimpleEventBus {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new SimpleListener());
        System.out.println("注册了简单监听器");
        eventBus.post("执行事件");
    }

}
