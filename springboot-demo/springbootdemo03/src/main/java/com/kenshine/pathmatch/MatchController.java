package com.kenshine.pathmatch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 10:12
 * @description：路径匹配Controller
 * @modified By：
 * @version: 1.0$
 */
@Controller
public class MatchController {


    /**
     * produces="application/json;charset=UTF-8":解决继承WebMvcConfigurationSupport类时中文乱码的问题.
     */
    @ResponseBody
    @GetMapping(value="/show",produces="application/json;charset=UTF-8")
    public String showMsg() {
        return "URL访问路径配置";
    }
}
