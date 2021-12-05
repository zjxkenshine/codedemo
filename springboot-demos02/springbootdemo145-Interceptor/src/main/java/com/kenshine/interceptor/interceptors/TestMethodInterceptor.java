package com.kenshine.interceptor.interceptors;

import com.kenshine.interceptor.annotation.TestMethod;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 11:55
 * @description：测试注解拦截器
 * @modified By：
 * @version: $
 */
@Order(1)
@Component
public class TestMethodInterceptor implements HandlerInterceptor {
    //可以在这里使用service bean进行各种业务操作

    /**
     * 在调用方法前处理（Controller方法调用之前）
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("调用了testMethod拦截器preHandle方法");
        if (handler instanceof HandlerMethod) {
            //是否有TestMethod注解
            if(((HandlerMethod) handler).hasMethodAnnotation(TestMethod.class)){
                //可以在这里操作 request, response 等
                System.out.println(request.getRequestURL());
                return true;
            }
            //这里需要抛出业务异常，
            return false;
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了TestMethodInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
         System.out.println("执行了TestMethodInterceptor的afterCompletion方法");
    }


}
