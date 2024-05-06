package com.kenshine.exceptionCapture.controller;

import com.kenshine.exceptionCapture.exception.DuplicateKeyException;
import com.kenshine.exceptionCapture.exception.OtherException;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试controller
 * @Date 2024-05-06 9:28
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 捕获异常处理
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public void test01() throws DuplicateKeyException {
        throw new DuplicateKeyException("duplicate key");
    }

    /**
     * 未捕获异常处理
     * localhost:8080/test02
     */
    @GetMapping("/test02")
    public void test02() throws OtherException {
        throw new OtherException("other exception");
    }

}
