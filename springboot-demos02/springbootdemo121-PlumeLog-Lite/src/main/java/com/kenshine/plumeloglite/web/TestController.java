package com.kenshine.plumeloglite.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/27 8:46
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping("/test01")
    public String test01(){
        log.debug("测试的DEBUG");
        log.info("测试的INFO");
        return "success";
    }

}
