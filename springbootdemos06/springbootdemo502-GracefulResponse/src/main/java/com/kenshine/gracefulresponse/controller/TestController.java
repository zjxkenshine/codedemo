package com.kenshine.gracefulresponse.controller;

import com.feiniaojin.gracefulresponse.GracefulResponse;
import com.feiniaojin.gracefulresponse.GracefulResponseException;
import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import com.kenshine.gracefulresponse.model.User;
import com.kenshine.gracefulresponse.model.UserInfoQuery;
import com.kenshine.gracefulresponse.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 測試
 * @Date 2023-11-24 13:56
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    /**
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public User test01() {
        return new User().setId(1).setName("kenshine");
    }

    /**
     * 自定义异常 自定义异常类方式
     * @ExceptionMapper 注解
     * http://localhost:8080/test02
     */
    @GetMapping("/test02")
    public User test02(){
        return testService.query1(null);
    }


    /**
     * GracefulResponseException 自定义异常
     * http://localhost:8080/test03
     */
    @GetMapping("/test03")
    public User test03(){
        throw new GracefulResponseException("1405","找不到test03");
    }

    /**
     * GracefulResponse 工具类
     * http://localhost:8080/test04
     */
    @GetMapping("/test04")
    public void test04(){
        GracefulResponse.raiseException("1406","找不到test04");
    }


    /**
     * ValidationStatusCode 自定义校验码
     * http://localhost:8080/test05
     */
    @GetMapping("/test05")
    public String test05(@Validated UserInfoQuery userInfoQuery){
        System.out.println(userInfoQuery);
        return "success";
    }


    /**
     * 直接在Controller方法中进行参数校验
     * http://localhost:8080/test06
     */
    @GetMapping("/test06")
    @ValidationStatusCode(code = "1234")
    public String test06(@NotNull(message = "userId不能为空") String userId,
                         @NotNull(message = "userName不能为空") String userName){
        return "success";
    }

}
