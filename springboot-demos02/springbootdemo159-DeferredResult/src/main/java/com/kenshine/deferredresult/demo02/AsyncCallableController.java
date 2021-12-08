package com.kenshine.deferredresult.demo02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 9:24
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@Slf4j
public class AsyncCallableController {

    private final TaskService taskService;

    @Autowired
    public AsyncCallableController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/callable", method = RequestMethod.GET, produces = "text/html")
    public Callable<String> executeSlowTask() {
        log.info("接收到请求");
        Callable<String> callable = taskService::execute;
        //可以处理其他业务
        log.info("Servlet主线程释放");
        return callable;
    }
}
