package com.kenshine.nutz.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕获
 * Created by kenshine on 2018/7/21
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(AuthorizationException.class)//捕获该异常类
    public String authorizationException(AuthorizationException e, Model model){
        model.addAttribute("msg","您暂时没有权限访问该页面！");
        return "unauthorized.html";
    }

}
