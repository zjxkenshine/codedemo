package bilibili.eventBus;

import bilibili.eventBus.listeners.DeadEventListener;
import com.google.common.eventbus.EventBus;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 22:37
 * @description：死亡事件示例
 * @modified By：
 * @version: $
 */
public class DeadEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus("DeadEventBus"){
            @Override
            public String toString() {
                return "DEAD-EVENT-BUS";
            }
        };
        eventBus.register(new DeadEventListener());
        eventBus.post("hello");
    }
}
