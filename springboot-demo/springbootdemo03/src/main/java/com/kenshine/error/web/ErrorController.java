package com.kenshine.error.web;

import com.kenshine.error.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:22
 * @description：自定义错误页面
 * @modified By：
 * @version: 1.0$
 */
@Controller
@RequestMapping("/error")
public class ErrorController {


    @ResponseBody
    @GetMapping("/show")
    public String showMsg() {
        return "success";
    }

    @GetMapping("/showError")
    public void showError() {
        throw new RuntimeException("自定义异常...");
    }

    /**
     * 测试全局异常处理
     * @return
     * @throws CustomException
     */
    @RequestMapping("/json")
    public String handleJsonException() throws CustomException {
        throw new CustomException("json格式的异常处理方案...");
    }
}
