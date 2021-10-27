package bilibili.eventBus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 21:54
 * @description：异常监听
 * @modified By：
 * @version: $
 */
@Slf4j
public class ExceptionListener {

    @Subscribe
    public void m1(String event){
        log.info("=============m1=========={}",event);
    }

    @Subscribe
    public void m2(String event){
        log.info("=============m2=========={}",event);
    }

    @Subscribe
    public void m3(String event){
        log.info("=============m3=========={}",event);
        throw new RuntimeException();
    }

}
