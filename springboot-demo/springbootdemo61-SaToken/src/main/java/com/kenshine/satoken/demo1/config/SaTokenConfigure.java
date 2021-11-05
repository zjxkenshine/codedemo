package com.kenshine.satoken.demo1.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 17:30
 * @description：注解式鉴权
 * @modified By：
 * @version: $
 */
//@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");


        // 注册Sa-Token的路由拦截器
        registry.addInterceptor(new SaRouteInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/doLogin");


        // 注册路由拦截器，自定义认证规则
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {

            // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
            SaRouter.match("/**", "/user/doLogin", r -> StpUtil.checkLogin());

            // 角色认证 -- 拦截以 admin 开头的路由，必须具备 admin 角色或者 super-admin 角色才可以通过认证
            SaRouter.match("/admin/**", r -> StpUtil.checkRoleOr("admin", "super-admin"));

            // 权限认证 -- 不同模块认证不同权限
            SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
            SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
            SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
            SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));
            SaRouter.match("/notice/**", r -> StpUtil.checkPermission("notice"));
            SaRouter.match("/comment/**", r -> StpUtil.checkPermission("comment"));

            // 甚至你可以随意的写一个打印语句
            SaRouter.match("/**", r -> System.out.println("----啦啦啦----"));

            // 连缀写法
            SaRouter.match("/**").check(r -> System.out.println("----啦啦啦----"));

            // 基础写法样例：匹配一个path，执行一个校验函数
            SaRouter.match("/user/**").check(r -> StpUtil.checkLogin());


            // 根据 path 路由匹配   ——— 支持写多个path，支持写 restful 风格路由
            //SaRouter.match("/user/**", "/goods/**", "/art/get/{id}").check( /* 要执行的校验函数 */ );

            // 根据 path 路由排除匹配
            // SaRouter.match("/**").notMatch("*.html", "*.css", "*.js").check( /* 要执行的校验函数 */ );

            // 根据请求类型匹配
            //SaRouter.match(SaHttpMethod.GET).check( /* 要执行的校验函数 */ );

            // 根据一个 boolean 条件进行匹配
            //SaRouter.match( StpUtil.isLogin() ).check( /* 要执行的校验函数 */ );

            // 根据一个返回 boolean 结果的lambda表达式匹配
            //SaRouter.match( r -> StpUtil.isLogin() ).check( /* 要执行的校验函数 */ );

            // 多个条件一起使用
            //SaRouter.match(SaHttpMethod.GET).match("/**").check( /* 要执行的校验函数 */ );

        })).addPathPatterns("/**");


        //提前退出匹配链
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {
            SaRouter.match("/**").check(r -> System.out.println("进入1"));
            SaRouter.match("/**").check(r -> System.out.println("进入2")).stop();
            SaRouter.match("/**").check(r -> System.out.println("进入3"));
        })).addPathPatterns("/**");




        // 进入 free 独立作用域
        SaRouter.match("/**").free(s -> {
            SaRouter.match("/a/**").check(r -> System.out.println("进入1"));
            SaRouter.match("/a/**").check(r -> System.out.println("进入2")).stop();
            SaRouter.match("/a/**").check(r -> System.out.println("进入3"));
        });
        // 执行 stop() 函数跳出 free 后继续执行下面的 match 匹配
        SaRouter.match("/**").check(r -> System.out.println("进入3"));
    }
}
