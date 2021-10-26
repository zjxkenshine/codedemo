package bilibili.eventBus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:25
 * @description：默认监听器
 * @modified By：
 * @version: $
 */
@Slf4j
public class BaseListener extends AbstractListener {
    /**
     * BASE监听器
     */
    @Subscribe
    public void baseTask(String event){
        if(log.isInfoEnabled()){
            log.info("事件[{}]被监听,方法{}.{}",event,this.getClass().getSimpleName(),"baseTask");
        }
    }


}
