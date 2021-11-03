package com.kenshine.derby.listener;

import com.kenshine.derby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 22:24
 * @description：自定义监听创建数据库表
 * @modified By：
 * @version: $
 *
 */
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initCreateDbTable();

    }
    /**
     * 如果数据库表不存在，则创建表
     */
    private void initCreateDbTable(){
        userService.createTableIfNotExist();
    }
}
