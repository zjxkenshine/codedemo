package com.kenshine.event.listener;

import com.kenshine.event.event.CustomEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 11:08
 * @description：事件监听器 默认order为最大值，最后执行
 * @modified By：
 * @version: $
 */
@Component
public class CustomListener implements ApplicationListener<CustomEvent> {


    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("实现方式事件监听1：即将处理"+event.getMessage()+"业务！");
    }
}
