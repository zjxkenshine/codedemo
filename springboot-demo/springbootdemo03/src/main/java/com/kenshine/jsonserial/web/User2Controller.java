package com.kenshine.jsonserial.web;

import com.kenshine.jsonserial.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 8:56
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@Slf4j
@RestController
public class User2Controller {


    /**
     * 将对象转为json字符串-->序列化
     */
    @GetMapping("/user/{salary}")
    public User home(@PathVariable("salary") Long salary) {
        return new User("kenshine", 25, true, new Date(), "码农", salary);
    }

    /**
     * 将一个json转化为对象-->反序列化
     */
    @RequestMapping(value = "user")
    public String getValue(@RequestBody User user) {
        log.warn("user=" + user.toString());
        return user.toString();
    }

}
