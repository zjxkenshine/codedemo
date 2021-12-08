package com.kenshine.deferredresult.demo04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 10:07
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class WebAsyncController {
    private final WebAsyncService asyncService;
    private final static String ERROR_MESSAGE = "Task error";
    private final static String TIME_MESSAGE = "Task timeout";

    @Autowired
    public WebAsyncController(WebAsyncService asyncService) {
        this.asyncService = asyncService;
    }

    /**
     * 正常简单异步任务
     * @return
     */
    @GetMapping("/completion")
    public WebAsyncTask<String> asyncTaskCompletion() {
        // 打印处理线程名
        System.out.println(format("请求处理线程：%s", currentThread().getName()));

        // 模拟开启一个异步任务，超时时间为10s
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            System.out.println(format("异步工作线程：%s", currentThread().getName()));
            // 任务处理时间5s，不超时
            sleep(5 * 1000L);
            return asyncService.generateUUID();
        });

        // 任务执行完成时调用该方法
        asyncTask.onCompletion(() -> System.out.println("任务执行完成"));
        System.out.println("继续处理其他事情");
        return asyncTask;
    }

    /**
     * 异常异步任务
     * @return
     */
    @GetMapping("/exception")
    public WebAsyncTask<String> asyncTaskException() {
        // 打印处理线程名
        System.out.println(format("请求处理线程：%s", currentThread().getName()));

        // 模拟开启一个异步任务，超时时间为10s
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            System.out.println(format("异步工作线程：%s", currentThread().getName()));
            // 任务处理时间5s，不超时
            sleep(5 * 1000L);
            throw new Exception(ERROR_MESSAGE);
        });

        // 任务执行完成时调用该方法
        asyncTask.onCompletion(() -> System.out.println("任务执行完成"));
        asyncTask.onError(() -> {
            System.out.println("任务执行异常");
            return ERROR_MESSAGE;
        });

        System.out.println("继续处理其他事情");
        return asyncTask;
    }


    /**
     * 超时异步任务
     * @return
     */
    @GetMapping("/timeout")
    public WebAsyncTask<String> asyncTaskTimeout() {
        // 打印处理线程名
        System.out.println(format("请求处理线程：%s", currentThread().getName()));

        // 模拟开启一个异步任务，超时时间为10s
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            System.out.println(format("异步工作线程：%s", currentThread().getName()));
            // 任务处理时间15s，超时
            sleep(15 * 1000L);
            return TIME_MESSAGE;
        });

        // 任务执行完成时调用该方法
        asyncTask.onCompletion(() -> System.out.println("任务执行完成"));
        asyncTask.onTimeout(() -> {
            System.out.println("任务执行超时");
            return TIME_MESSAGE;
        });

        System.out.println("继续处理其他事情");
        return asyncTask;
    }


    @Autowired
    @Qualifier("taskExecutor")
    private ThreadPoolTaskExecutor executor;

    /**
     * 线程池处理
     * @return
     */
    @GetMapping("/threadPool")
    public WebAsyncTask<String> asyncTaskThreadPool() {
        return new WebAsyncTask<>(10 * 1000L, executor,
                () -> {
                    System.out.println(format("异步工作线程：%s", currentThread().getName()));
                    return asyncService.generateUUID();
                });
    }

}
