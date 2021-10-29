package com.kenshine.web;

import com.kenshine.entity1.User;
import com.kenshine.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 11:21
 * @description：用户Controller
 * @modified By：
 * @version: $
 *
 * ## 注意：当注册WebSecurityManager时候，我们不需要利用
 * SecurityUtils注册
 * WebSecurityManager。因为当配置WebSecurityManager的时候。
 * 会自动注册到SecurityUtils
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用来处理身份认证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            return  "redirect:/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误!");
        }
        return "redirect:login";
    }


    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//退出用户
        return "redirect:login";
    }

    /**
     * 用户注册
     */
    @RequestMapping("register")
    public String register(User user) {
        try {
            userService.register(user);
            return "redirect:/login";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:login";
        }
    }



}
