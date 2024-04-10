package com.kenshine.lightsecurity.controller;

import com.itmuch.lightsecurity.annotation.PreAuthorize;
import com.itmuch.lightsecurity.jwt.JwtOperator;
import com.itmuch.lightsecurity.jwt.User;
import com.itmuch.lightsecurity.jwt.UserOperator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author kenshine
 * 测试controller
 */
@RequestMapping
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final UserOperator userOperator;
    private final JwtOperator operator;

    /**
     * 演示如何获取当前登录用户信息
     * - 该路径需要具备user或admin权限才可访问，详见application.yml
     * @return 用户信息
     */
    @GetMapping("/user")
    public User user() {
        return userOperator.getUser();
    }

    @GetMapping("/user-no-access")
    public User userNoAccess() {
        return userOperator.getUser();
    }

    /**
     * 演示基于注解的权限控制
     * @return 如果有权限返回 亲，你同时有user、admin角色..
     */
    @GetMapping("/annotation-test")
    @PreAuthorize("hasAllRoles('user','admin')")
    public String annotationTest() {
        return "亲，你同时有user、admin角色..";
    }

    @GetMapping("/annotation-test-no-access")
    @PreAuthorize("hasAllRoles('user','admin','xx')")
    public String annotationTestNoAccess() {
        return "亲，你同时有user、admin、xx角色..";
    }

    /**
     * 模拟登录，颁发token
     * @return token字符串
     */
    @GetMapping("/login")
    public String loginReturnToken() {
        User user = User.builder()
                .id(1)
                .username("张三")
                .roles(Arrays.asList("user", "admin"))
                .build();
        return operator.generateToken(user);
    }
}