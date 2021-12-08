package com.kenshine.deferredresult.demo02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 9:17
 * @description：执行接口实现
 * @modified By：
 * @version: $
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Override
    public String execute() {
        try {
            Thread.sleep(5000);
            log.info("执行慢任务");
            Thread.sleep(1000);
            return "任务执行完毕";
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
