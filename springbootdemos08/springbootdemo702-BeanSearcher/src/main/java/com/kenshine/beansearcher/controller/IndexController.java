package com.kenshine.beansearcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kenshine
 * 首页
 */
@Controller
public class IndexController {

    /**
     * Demo 首页
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
