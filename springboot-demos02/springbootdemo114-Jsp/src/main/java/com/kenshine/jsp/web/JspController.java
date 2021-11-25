package com.kenshine.jsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/25 14:37
 * @description：Jsp测试
 * @modified By：
 * @version: $
 */
@Controller
public class JspController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg","kenshine jsp学习!");
        //要跳转到的页面视图名称
        return "index";
    }


    @RequestMapping(value = "/say")
    public ModelAndView say() {
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","Hello , SpringBoot!!!");
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping(value = "/speak")
    public String speak(Model model) {
        model.addAttribute("msg","Hello , World!!!");
        return "result";
    }

}
