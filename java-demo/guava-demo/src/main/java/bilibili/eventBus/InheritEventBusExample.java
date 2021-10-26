package bilibili.eventBus;

import bilibili.eventBus.events.Apple;
import bilibili.eventBus.events.Fruit;
import bilibili.eventBus.listeners.FruitEaterListener;
import com.google.common.eventbus.EventBus;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:38
 * @description：继承事件示例
 * @modified By：
 * @version: $
 */
public class InheritEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new FruitEaterListener());
        eventBus.post(new Apple("苹果1"));
        System.out.println("======================================================");
        eventBus.post(new Fruit("香蕉"));
    }

}
