package com.kenshine.rsaencrypt.controller;

import cn.shuibo.annotation.Decrypt;
import cn.shuibo.annotation.Encrypt;
import com.kenshine.rsaencrypt.model.TestBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试控制器
 * @Date 2024-04-09 9:29
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {

    /**
     * 加密
     * http://localhost:8080/encryption
     */
    @Encrypt
    @GetMapping("/encryption")
    public TestBean encryption(){
        TestBean testBean = new TestBean();
        testBean.setName("kenshine");
        testBean.setAge(18);
        return testBean;
    }

    /**
     * 解密
     * http://localhost:8080/decryption
     */
    @PostMapping("/decryption")
    @Decrypt
    @ResponseBody
    public String Decryption(@RequestBody TestBean user){
        System.out.println(user.toString());
        return user.toString();
    }

}
