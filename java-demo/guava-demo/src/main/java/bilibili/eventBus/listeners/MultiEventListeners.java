package bilibili.eventBus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:14
 * @description：多事件监听器
 * @modified By：
 * @version: $
 */
@Slf4j
public class MultiEventListeners {

    @Subscribe
    public void task1(String event){
        if(log.isInfoEnabled()){
            log.info("事件[{}]被监听,方法task1",event);
        }
    }

    @Subscribe
    public void task2(String event){
        if(log.isInfoEnabled()){
            log.info("事件[{}]被监听,方法task2",event);
        }
    }

    /**
     * 必须写为Integer 否则不会执行
     * @param event
     */
    @Subscribe
    public void intTask(Integer event){
        if(log.isInfoEnabled()){
            log.info("事件[{}]被监听,方法intTask",event);
        }
    }

}
