package bilibili.eventBus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:28
 * @description：具体监听器
 * @modified By：
 * @version: $
 *
 * 子孙类
 */
@Slf4j
public class ConcreteListener extends BaseListener{

    /**
     * conTask 具体监听
     */
    @Subscribe
    public void conTask(String event){
        if(log.isInfoEnabled()){
            log.info("事件[{}]被监听,方法{}.{}",event,this.getClass().getSimpleName(),"conTask");
        }
    }

}
