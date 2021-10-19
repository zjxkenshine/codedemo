package com.kenshine.freeMaker.web;

import com.kenshine.freeMaker.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:14
 * @description：测试
 * @modified By：
 * @version: $
 */
@Controller
public class HelloController {

    @Autowired
    private User user;

    @GetMapping("/learn/freemaker")
    public String show(Model model) {
        model.addAttribute("user", user);
        //ftl是.ftl模板文件所在文件夹，index是模板名称.
        return "ftl/index";
    }

}
