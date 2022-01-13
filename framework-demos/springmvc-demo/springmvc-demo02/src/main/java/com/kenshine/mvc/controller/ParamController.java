package com.kenshine.mvc.controller;

import com.kenshine.mvc.controller.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/13 21:25
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    /**
     * 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
     * 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
     * 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    /**
     * RequestParam
     */
    @RequestMapping("/testParam")
    public String testParam1(
            @RequestParam(value ="user_name",required = false)
            String username,
            String password,
            String[] hobby){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    //最终结果-->User{id=null, username='张三', password='123', age=23, sex='男', email='123@qq.com'}
    @RequestMapping("/testpojo")
    public String testPOJO(User user){
        System.out.println(user);
        return "success";
    }


}
