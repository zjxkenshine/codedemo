package bilibili.eventBus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:21
 * @description：抽象监听器
 * @modified By：
 * @version: $
 */
@Slf4j
public abstract class AbstractListener {

    /**
     * 通用监听器
     */
    @Subscribe
    public void commonTask(String event){
        if(log.isInfoEnabled()){
            log.info("事件[{}]被监听,方法{}.{}",event,this.getClass().getSimpleName(),"commonTask");
        }
    }

}
