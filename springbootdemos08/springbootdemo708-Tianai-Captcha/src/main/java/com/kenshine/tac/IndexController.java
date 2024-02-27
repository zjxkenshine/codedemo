package com.kenshine.tac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 跳转接口
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/slider")
    public String slider() {
        return "slider";
    }

    @GetMapping("/rotate")
    public String rotate() {
        return "rotate";
    }

    @GetMapping("/concat")
    public String concat() {
        return "concat";
    }

    @GetMapping("/word-click")
    public String wordClick() {
        return "word-click";
    }

}
