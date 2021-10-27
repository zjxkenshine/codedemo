package bilibili.eventBus.listeners;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 22:35
 * @description：deadEvent监听
 * @modified By：
 * @version: $
 *
 * 可以得知事件的来源
 */
public class DeadEventListener {

    @Subscribe
    public void handle(DeadEvent event){
        System.out.println(event.getSource());
        System.out.println(event.getEvent());
    }

}
