package com.kenshine.disroute.process;

import cn.langpy.disroute.core.Route;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 使用测试
 * @Date 2023-12-04 16:24
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    @GetMapping("/test01")
    public String test01(){
        JSONObject j1 = JSONObject.of("cmd",0);
        /*会根据message里面的cmd的值调用不同的方法*/
        return Route.dispatch("test",j1);
    }

    @GetMapping("/test02")
    public String test02(){
        JSONObject j2 = JSONObject.of("cmd",1);
        /*会根据message里面的cmd的值调用不同的方法*/
        return Route.dispatch("test",j2);
    }

    @GetMapping("/test03")
    public String test03(){
        JSONObject j3 = JSONObject.of("cmd",2);
        /*会根据message里面的cmd的值调用不同的方法*/
        return Route.dispatch("test",j3);
    }
}
