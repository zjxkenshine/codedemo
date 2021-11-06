package com.kenshine.docker.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 18:41
 * @description：Docker测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/docker")
public class DockerController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Docker";
    }

}
