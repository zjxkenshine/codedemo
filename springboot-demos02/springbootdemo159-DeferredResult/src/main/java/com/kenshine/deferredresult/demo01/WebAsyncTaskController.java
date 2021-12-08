package com.kenshine.deferredresult.demo01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 8:56
 * @description：WebAsyncTask处理异步任务
 * @modified By：
 * @version: $
 */
@RestController
public class WebAsyncTaskController {

    @RequestMapping("/async")
    @ResponseBody
    public WebAsyncTask<String> asyncTask(){

        // 1000 为超时设置为1秒
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(1000, () -> {
            //业务逻辑处理
            Thread.sleep(5000);
            String message = "username:kenshine";
            return message;
        });

        webAsyncTask.onCompletion(() -> System.out.println("调用完成"));

        webAsyncTask.onTimeout(() -> {
            System.out.println("业务处理超时");
            return "<h1>Time Out</h1>";
        });

        return webAsyncTask;
    }
}
