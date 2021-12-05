package com.kenshine.servlet.async.web;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 23:36
 * @description：asyncContext.setTimeout设置超时时间
 * @modified By：
 * @version: $
 *
 * 会抛出异常The request associated with the AsyncContext has already completed processing
 */
@WebServlet(name = "AsyncServlet3",urlPatterns = "/test03", asyncSupported = true)
public class AsyncServlet3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        long st = System.currentTimeMillis();
        System.out.println("主线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-start");
        AsyncContext asyncContext = request.startAsync(request, response);
        //设置异步处理超时时间为1秒
        asyncContext.setTimeout(1000);
        asyncContext.start(() -> {
            long stSon = System.currentTimeMillis();
            System.out.println("子线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-start");
            try {
                TimeUnit.SECONDS.sleep(2);
                asyncContext.getResponse().getWriter().write(System.currentTimeMillis() + ",ok");
                asyncContext.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("子线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-end,耗时(ms):" + (System.currentTimeMillis() - stSon));
        });
        System.out.println("主线程：" + Thread.currentThread() + "-" + System.currentTimeMillis() + "-end,耗时(ms):" + (System.currentTimeMillis() - st));
    }

}
