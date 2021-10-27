package bilibili.eventBus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:05
 * @description：简单监听器
 * @modified By：
 * @version: $
 */
@Slf4j
public class SimpleListener {

    /**
     * @Subscribe 注解 订阅事件
     * 只能有一个参数
     * @param event
     */
    @Subscribe
    private void doAction(final String event){
        if(log.isInfoEnabled()){
            log.info("接收到事件[{}]并进行处理",event);
        }
    }



}
