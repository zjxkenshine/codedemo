package com.kenshine.contentnego.web;

import com.kenshine.contentnego.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 10:36
 * @description：内容协商测试
 * @modified By：
 * @version: 1.0$
 *
 * 内容协商优先级
 * 扩展名 > format请求参数 > HTTP的Accept请求头
 */
@Slf4j
@Controller
public class NegotiationController {


    @ResponseBody
    @GetMapping(value = "/show")
    public User showUser() {
        User user = new User();
        user.setName("kenshine");
        user.setSex("男");
        user.setDesc("内容协商机制");
        return user;
    }

    /**
     * 此时请求的Accept为application/xml的话会报错
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/showMsg",produces = MediaType.APPLICATION_JSON_VALUE)
    public User showMsg() {
        User user = new User();
        user.setName("kenshine");
        user.setSex("男");
        user.setDesc("内容协商机制");
        return user;
    }

    /**
     * http://localhost:8080/show/a.json
     * http://localhost:8080/show/a.pdf
     * http://localhost:8080/show/a.html
     * @param type
     * @return
     */
    @GetMapping(value = "/show/{type}")
    public String showUser(@PathVariable("type") String type) {
        log.warn("type={}", type);
        return "学习ContentNegotiatingViewResolver";
    }



}
