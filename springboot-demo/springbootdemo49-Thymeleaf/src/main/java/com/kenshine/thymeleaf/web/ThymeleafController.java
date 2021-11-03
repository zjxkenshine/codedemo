package com.kenshine.thymeleaf.web;

import com.kenshine.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 9:41
 * @description：测试
 * @modified By：
 * @version: $
 */
//@RestController
@Controller
public class ThymeleafController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "<h1>Hello Thymeleaf</h1>");
        return "hello";
    }

    /**
     * 如果Controller类上使用的是@RestController注解，则需要将视图添加到ModelAndView对象中并返回
     * @return
     */
//    @GetMapping("/hello")
//    public ModelAndView hello() {
//        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject("hello", "<h1>hello thymeleaf</h1>");
//        return modelAndView;
//    }

    /**
     * 变量表达式
     * @param model
     * @return
     */
    @GetMapping("/variable")
    public String variable(Model model) {
        model.addAttribute("user", new User(1L, "赵云", "qwe123"));
        return "variable";
    }

    /**
     * *{} 测试
     * @param model
     * @return
     */
    @GetMapping("/asterisk")
    public String star(Model model) {
        model.addAttribute("user", new User(1L, "赵云", "qwe123"));
        return "asterisk";
    }

    /**
     * url测试
     * @param model
     * @return
     */
    @GetMapping("/url")
    public String url(Model model) {
        model.addAttribute("user", new User(1L, "赵云", "qwe123"));
        model.addAttribute("url", "/user/update");
        return "url";
    }

    /**
     * 字面量
     * @param model
     * @return
     */
    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("flag", false);
        return "literal";
    }

    /**
     * 文本操作
     * @param model
     * @return
     */
    @GetMapping("/text")
    public String text(Model model) {
        model.addAttribute("user", new User(1L, "赵云", "qwe123"));
        return "text";
    }

    /**
     * 运算符
     * @param model
     * @return
     */
    @GetMapping("/operation")
    public String operator(Model model) {
        model.addAttribute("x", 10);
        model.addAttribute("y", 3);
        return "operation";
    }

    /**
     * 条件表达式
     * @param model
     * @return
     */
    @GetMapping("/conditional/expr")
    public String conditionExpr(Model model) {
        model.addAttribute("grade", 85);
        model.addAttribute("age", null);
        return "conditional-expr";
    }

    /**
     * 属性设置
     * @param model
     * @return
     */
    @GetMapping("/attr")
    public String attr(Model model) {
        model.addAttribute("success", "成功");
        model.addAttribute("active", true);
        return "attr";
    }

    /**
     * 条件判断
     * @param model
     * @return
     */
    @GetMapping("/conditional")
    public String condition(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 10);
        map.put("userLevel", 6);
        map.put("rank", 5);
        model.addAllAttributes(map);
        return "conditional";
    }

    /**
     * 迭代list
     * @param model
     * @return
     */
    @GetMapping("/each/list")
    public String eachList(ModelMap model) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1L, "刘备", "123132"));
        users.add(new User(2L, "关羽", "321231"));
        users.add(new User(3L, "张飞", "213312"));
        model.addAttribute("users", users);
        return "each-list";
    }

    /**
     * 迭代Map
     * @param model
     * @return
     */
    @GetMapping("/each/map")
    public String eachMap(Model model) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("user1", new User(1L, "刘备", "123132"));
        map.put("user2", new User(2L, "关羽", "321231"));
        map.put("user3", new User(3L, "张飞", "213312"));
        model.addAttribute("userMap", map);
        return "each-map";
    }

    /**
     * 迭代Array
     * @param model
     * @return
     */
    @GetMapping("/each/array")
    public String eachArray(Model model) {
        User[] users = {new User(1L, "刘备", "123132"), new User(2L, "关羽", "321231"), new User(3L, "张飞", "213312")};
        model.addAttribute("users", users);
        return "each-array";
    }

    /**
     * 引用模板片段
     * @param model
     * @return
     */
    @GetMapping("/layout")
    public String layout(Model model) {
        model.addAttribute("flag", true);
        model.addAttribute("var1", "参数1");
        model.addAttribute("var2", "参数2");
        model.addAttribute("user", new User(1L, "赵云", "qwe123"));
        return "layout";
    }

    /**
     * 灵活布局测试
     * @param model
     * @return
     */
    @GetMapping("/layout/home")
    public String layoutHome(Model model) {
        model.addAttribute("condition", false);
        return "layout-home";
    }

    /**
     * 局部变量
     * @param model
     * @return
     */
    @GetMapping("/local")
    public String local(Model model) {
        User[] users = {new User(1L, "刘备", "123132"), new User(2L, "关羽", "321231"), new User(3L, "张飞", "213312")};
        model.addAttribute("users", users);
        return "local";
    }

    /**
     * th:block 注释
     * @param model
     * @return
     */
    @GetMapping("/block")
    public String block(Model model) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1L, "刘备", "123132"));
        users.add(new User(2L, "关羽", "321231"));
        users.add(new User(3L, "张飞", "213312"));
        model.addAttribute("users", users);
        return "block";
    }

    /**
     * 内联
     * @param model
     * @return
     */
    @GetMapping("/inline")
    public String inline(Model model) {
        model.addAttribute("user", new User(1L, "<b>赵云</b>", "this is \"pass\" word"));
        Map<String, Object> map = new HashMap<>(16);
        map.put("user1", new User(1L, "刘备", "123132"));
        map.put("user2", new User(2L, "关羽", "321231"));
        map.put("user3", new User(3L, "张飞", "213312"));
        model.addAttribute("userMap", map);

        model.addAttribute("element", "h1");
        model.addAttribute("align", "center");
        model.addAttribute("color", "#2876A7");
        return "inline";
    }

    /**
     * 国际化测试
     * @return
     */
    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "i18n";
    }

    /**
     * 日期工具类
     * @param model
     * @return
     */
    @GetMapping("/dates")
    public String dates(Model model) {
        model.addAttribute("date", new Date());
        return "date";
    }

    /**
     * 数字工具类
     * @param model
     * @return
     */
    @GetMapping("/numbers")
    public String numbers(Model model) {
        Integer[] numArray = {1000, 666, 88888};
        model.addAttribute("num", 99999);
        model.addAttribute("num2", 66.6658932);
        model.addAttribute("nums", numArray);
        return "number";
    }

    /**
     * 字符串工具类
     * @param model
     * @return
     */
    @GetMapping("/strings")
    public String strings(Model model) {
        model.addAttribute("user", new User(1L, "SpringBoot-Thymeleaf-Strings-Test", ""));
        model.addAttribute("str", "SpringBoot Thymeleaf Strings Test");
        model.addAttribute("strs", new String[] {"SpringBoot", "Thymeleaf", "Strings", "Test"});
        return "strings";
    }













}
