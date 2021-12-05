package com.kenshine.exception.web;

import com.kenshine.exception.exception.MyException;
import com.kenshine.exception.exception.PageException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 10:03
 * @description：测试全局异常
 * @modified By：
 * @version: $
 */
@RestController
public class ExceptionController {

    @GetMapping("/test/exception")
    public Object testException() {
        int n = 1/0;
        return "test exception";
    }

    @GetMapping("/test/myexception")
    public Object testMyException() {
        throw new MyException("自定义异常");
    }

    @GetMapping("/test/pageexception")
    public Object testPageException() {
        throw new PageException("跳转到页面的错误");
    }


}
