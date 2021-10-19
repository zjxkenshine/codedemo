package com.kenshine.cors.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:37
 * @description：测试
 * @modified By：
 * @version: $
 *
 * 注解方式，多种方式则采用就近原则
 *
 *
 * CORS是一个W3C标准，全称是"跨域资源共享"（Cross-origin resource sharing）。
 * 它允许浏览器向跨源(协议 + 域名 + 端口)服务器，发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制。
 *
 * 浏览器将CORS请求分成两类:
 * 简单请求:
 *      浏览器发出CORS简单请求，只需要在头信息之中增加一个Origin字段。
 * 非简单请求:
 *      浏览器发出CORS非简单请求，会在正式通信之前，增加一次OPTIONS查询请求，称为"预检"请求（preflight）。浏览器先询问服务器，当前网页所在的域名是否在服务器的许可名单之中，以及可以使用哪些HTTP动词和头信息字段。只有得到肯定答复，浏览器才会发出正式的XMLHttpRequest请求，否则就报错。
 *      Content-Type只限于三个值application/x-www-form-urlencoded、multipart/form-data、text/plain 反之，就是非简单请求
 *
 * 如果在开发中，发现每次发起请求都是两条，一次OPTIONS，一次正常请求。注意是每次，那么就需要配置Access-Control-Max-Age，避免每次都发出预检请求
 */
@RestController
public class TestController {

    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/msg")
    public String showMsg() throws Exception {
        return "success";
    }

}
