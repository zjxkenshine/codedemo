package com.kenshine.groovy.controller;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试
 * @Date 2024-04-19 13:20
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("/groovy")
public class TestController {

    /**
     * http://localhost:8080/groovy/test
     */
    @GetMapping("/test")
    public String test() {
        //创建GroovyShell
        GroovyShell groovyShell = new GroovyShell();
        //装载解析脚本代码
        Script script = groovyShell.parse("package groovy\n" +
                "\n" +
                "import com.kenshine.groovy.service.GroovyTestService\n" +
                "import com.kenshine.groovy.util.SpringContextUtil\n" +
                "\n" +
                "/**\n" +
                " * 静态变量\n" +
                " */\n" +
                "class Globals {\n" +
                "    static String PARAM1 = \"静态变量\"\n" +
                "    static int[] arrayList = [1, 2]\n" +
                "}\n" +
                "\n" +
                "def getBean() {\n" +
                "    GroovyTestService groovyTestService = SpringContextUtil.getBean(GroovyTestService.class);\n" +
                "    groovyTestService.test()\n" +
                "}");
        //执行
        script.invokeMethod("getBean", null);
        return "ok";
    }

}
