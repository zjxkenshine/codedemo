package com.kenshine.useragent.web;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 22:20
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test01")
    public void test01(HttpServletRequest request){
        String agentStr = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(agentStr);
        //浏览器信息
        Browser browser = userAgent.getBrowser();
        //浏览器名称
        System.out.println(browser.getName());
        //浏览器版本
        System.out.println(userAgent.getBrowserVersion());
        //操作系统
        System.out.println(userAgent.getOperatingSystem());
        //浏览器类型
        System.out.println(browser.getBrowserType().getName());
        //渲染引擎
        System.out.println(browser.getRenderingEngine().getName());
        //制造商
        System.out.println(browser.getManufacturer().getName());
    }
}
