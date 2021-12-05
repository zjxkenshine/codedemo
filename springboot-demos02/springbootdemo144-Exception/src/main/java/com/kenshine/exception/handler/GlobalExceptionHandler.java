package com.kenshine.exception.handler;

import com.kenshine.exception.exception.MyException;
import com.kenshine.exception.exception.PageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 9:58
 * @description：全局异常处理器
 * @modified By：
 * @version: $
 */
@Slf4j
//配置拦截的包
@RestControllerAdvice(basePackages = "com.kenshine.exception.web")
//多个异常处理器冲突，将该异常处理器配置为最高等级
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    //  捕获全局异常，处理所有不可知的异常
    //  这里的Object使用时换成Result结果封装类
    @ExceptionHandler(value = Exception.class)
    // @ResponseBody
    public Object handleException(Exception e, HttpServletRequest request) {
        log.error("url {}, msg {}", request.getRequestURL(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", "500");
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    /**
     * 自定义异常，返回异常结果
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public Object handleMyException(MyException e) {
        log.error("自定义异常MyException处理");
        Map<String, Object> map = new HashMap<>();
        map.put("code", "501");
        map.put("msg", e.getMessage());
        return map;
    }


    /**
     * 自定义异常，跳转到错误页面
     * @param e
     * @return
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView handlePageException(PageException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        return modelAndView;
    }





}
