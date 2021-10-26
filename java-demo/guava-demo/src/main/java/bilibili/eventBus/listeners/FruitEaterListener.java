package bilibili.eventBus.listeners;

import bilibili.eventBus.events.Apple;
import bilibili.eventBus.events.Fruit;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:36
 * @description：吃水果监听
 * @modified By：
 * @version: $
 */
@Slf4j
public class FruitEaterListener {

    @Subscribe
    public void eat(Fruit event){
        if(log.isInfoEnabled()){
            log.info("Fruit水果事件[{}]被监听",event.getName());
        }
    }

    @Subscribe
    public void eat(Apple event){
        if(log.isInfoEnabled()){
            log.info("Apple苹果事件[{}]被监听",event.getName());
        }
    }


}
