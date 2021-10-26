package bilibili.eventBus;

import bilibili.eventBus.listeners.ConcreteListener;
import bilibili.eventBus.listeners.MultiEventListeners;
import com.google.common.eventbus.EventBus;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:29
 * @description：继承事件监听器示例
 * @modified By：
 * @version: $
 */
public class InheritListenersEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        //测试父类和祖宗类会不会处理消息
        eventBus.register(new ConcreteListener());
        //string event
        eventBus.post("aaaaa");
    }

}
