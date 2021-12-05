package com.kenshine.servlet.async.web;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 23:05
 * @description：异步Servlet基本用法 使用 asyncContext.start 处理异步请求
 * @modified By：
 * @version: $
 * 1.设置@WebServlet的asyncSupported属性为true，表示支持异步处理
 */
@WebServlet(name = "AsyncServlet1", urlPatterns = "/test01", asyncSupported = true)
public class AsyncServlet1 extends HttpServlet {

    /**
     * 处理请求
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        long st = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-start");
        //2、启动异步处理，获取异步处理上下文对象AsyncContext
        AsyncContext asyncContext = request.startAsync(request, response);
        //3、调用start方法异步处理
        asyncContext.start(() -> {
            //异步请求处理
            long stSon = System.currentTimeMillis();
            System.out.println("子线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-start");
            try {
                //这里休眠2秒，模拟业务耗时
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
