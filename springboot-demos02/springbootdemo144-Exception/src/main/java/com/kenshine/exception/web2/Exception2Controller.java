package com.kenshine.exception.web2;

import com.kenshine.exception.exception.MyException;
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
public class Exception2Controller {

    @GetMapping("/test2/exception")
    public Object testException() {
        int n = 1/0;
        return "test exception";
    }

    @GetMapping("/test2/myexception")
    public Object testMyException() {
        throw new MyException("自定义异常");
    }


}
