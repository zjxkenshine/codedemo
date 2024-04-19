package com.kenshine.csrf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author 配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserDetailsService userDetailsService;

    //实现用户身份认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置url的访问权限
        http.authorizeRequests()
                .antMatchers("/userLogin").permitAll()
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated();

        //关闭csrf保护功能
        //http.csrf().disable();

        //使用自定义的登录窗口
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/toUpdate")
                .failureUrl("/userLogin?error");
    }
}