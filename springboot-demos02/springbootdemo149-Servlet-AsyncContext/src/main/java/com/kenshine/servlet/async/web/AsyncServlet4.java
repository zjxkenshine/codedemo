package com.kenshine.servlet.async.web;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 23:40
 * @description：为异步处理添加监听器，当异步处理完成、发生异常错误、出现超时的时候，会回调监听器中对应的方法
 * @modified By：
 * @version: $
 *
 * localhost:8080/test04?timeout=5000
 */
@WebServlet(name = "AsyncServlet4", urlPatterns = "/test04", asyncSupported = true)
public class AsyncServlet4 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long st = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-start");
        //2、启动异步处理：调用req.startAsync(request,response)方法，获取异步处理上下文对象AsyncContext
        AsyncContext asyncContext = request.startAsync(request, response);
        response.setContentType("text/html;charset=UTF-8");
        //@1:设置异步处理超时时间
        long timeout = Long.parseLong(request.getParameter("timeout"));
        asyncContext.setTimeout(timeout);

        //添加监听器
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                //异步处理完成会被回调
                System.out.println(Thread.currentThread() + "-" + System.currentTimeMillis() + "-onComplete()");
                event.getAsyncContext().getResponse().getWriter().write("onComplete");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                //超时会被回调
                System.out.println(Thread.currentThread() + "-" + System.currentTimeMillis() + "-onTimeout()");
                event.getAsyncContext().getResponse().getWriter().write("onTimeout");
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                //发生错误会被回调
                System.out.println(Thread.currentThread() + "-" + System.currentTimeMillis() + "-onError()");
                event.getAsyncContext().getResponse().getWriter().write("onError");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                //开启异步请求调用的方法
                System.out.println(Thread.currentThread() + "-" + System.currentTimeMillis() + "-onStartAsync()");
                event.getAsyncContext().getResponse().getWriter().write("onStartAsync");
            }
        });


        //3、调用start方法异步处理，调用这个方法之后主线程就结束了
        asyncContext.start(() -> {
            long stSon = System.currentTimeMillis();
            System.out.println("子线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-start");
            try {
                //@2:这里休眠2秒，模拟业务耗时
                TimeUnit.SECONDS.sleep(2);
                //这里是子线程，请求在这里被处理了
                asyncContext.getResponse().getWriter().write(System.currentTimeMillis() + ",ok");
                //4、调用complete()方法，表示异步请求处理完成
                asyncContext.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("子线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-end,耗时(ms):" + (System.currentTimeMillis() - stSon));
        });
        System.out.println("主线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-end,耗时(ms):" + (System.currentTimeMillis() - st));

    }
}
