package com.kenshine.freemaker.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:42
 * @description：
 * @modified By：
 * @version: $
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("hello", "<h1>hello freemarker</h1>");
        return modelAndView;
    }
}
