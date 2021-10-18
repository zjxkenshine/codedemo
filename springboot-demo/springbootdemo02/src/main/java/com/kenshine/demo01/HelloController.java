package com.kenshine.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 9:17
 * @description：theamleaf测试类
 * @modified By：
 * @version: 1.0$
 */
@Controller
public class HelloController {


    @RequestMapping("/")
    public String index(ModelMap map) {
        // 添加一个属性,用来在模板中根据这个key来读取对应的值
        map.addAttribute("msg", "学习SpringBoot");
        // return 模板文件的名称-->对应src/main/resources/templates/index.html
        //跳转到index页面
        return "index";
    }
}
