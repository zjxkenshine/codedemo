package com.kenshine.fastjson.web;

import com.kenshine.fastjson.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 10:55
 * @description：测试整合
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public User testFastJson(){
        return new User().setDate(new Date()).setId(1).setName("kenshine");
    }

}
