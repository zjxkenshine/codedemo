package com.kenshie.web;

import com.kenshie.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 9:16
 * @description：日志测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/log")
public class LogController {
   private final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/test")
    public void testLog(){
        User user = new User();
        user.setName("kenshine");
        user.setIDCard("513436200010277271");
        logger.info("IDCard："+user.getIDCard());
    }

}
