package com.kenshine.retry.spring.web;

import com.kenshine.retry.spring.service.TestRetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 17:34
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Autowired
    TestRetryService testRetryService;

    @GetMapping("/testRetry")
    public String testRetry() throws Exception {
        int code=0;
        int result = testRetryService.dignifiedTest(code);
        return "result："+result;
    }

}
