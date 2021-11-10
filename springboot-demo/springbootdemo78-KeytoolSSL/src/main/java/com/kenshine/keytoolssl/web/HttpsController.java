package com.kenshine.keytoolssl.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 12:17
 * @description：Https接口
 * @modified By：
 * @version: $
 */
@RestController
public class HttpsController {

    @RequestMapping("/test")
    public String https(){
        return "success";
    }

}
