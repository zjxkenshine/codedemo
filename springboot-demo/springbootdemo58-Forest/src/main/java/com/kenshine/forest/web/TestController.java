package com.kenshine.forest.web;

import com.kenshine.forest.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 22:15
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String helloTest(){
        return "hello world";
    }

    @PostMapping("/test03")
    public Map<String,String> test03(@RequestBody User user) throws Exception {
        System.out.println(user);
        if(user.getAge()>35){
            throw new Exception("年龄太大了");
        }else{
            return new HashMap<String,String>(){{put("message","成功");}};
        }
    }

    @PostMapping("/test04")
    public String test04(){
        System.out.println("接收到了异步请求");
        return "接收到了异步请求";
    }


}
