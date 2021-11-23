package com.kenshine.slor.web;

import com.kenshine.slor.entity.User;
import com.kenshine.slor.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/23 10:51
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Resource
    private UserRepository userRepository;

    //查询用户
    @RequestMapping("/query")
    public List<User> queryUsers(){
        //name字段以kenshine开头的数据
        return userRepository.findByNameStartingWith("kenshine");
    }

}
