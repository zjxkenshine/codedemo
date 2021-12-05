package com.kenshine.argumentresolver.web;

import com.kenshine.argumentresolver.annotation.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 13:46
 * @description：测试参数校验器
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    @GetMapping("/test01")
    public String test01(@Phone String phone){
        return "success";
    }

}
