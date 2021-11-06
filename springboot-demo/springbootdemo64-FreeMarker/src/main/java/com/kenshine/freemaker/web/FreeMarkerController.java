package com.kenshine.freemaker.web;

import com.kenshine.freemaker.model.Account;
import com.kenshine.freemaker.model.Order;
import com.kenshine.freemaker.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:39
 * @description：
 * @modified By：
 * @version: $
 */
@RequestMapping("/fm")
@Controller
public class FreeMarkerController {

    /**
     * hello world
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "<h1>Hello FreeMarker</h1>");
        return "hello";
    }

    /**
     * 数据模型测试一
     * @param model
     * @return
     */
    @GetMapping("/model/test1")
    public String dataModel1(Model model) {
        List<Order> orders = new ArrayList<>();
        Account account = new Account().setAccountId(1L).setAccountName("MyAccount").setAccountPassword("123456")
                .setUser(new User(1L, "kenshine", "123456"));
        orders.add(new Order().setOrderId(1L).setOrderNumber("785698232657798568").setOrderDescription("二两麻辣牛肉面")
                .setAccount(account));
        orders.add(new Order().setOrderId(2L).setOrderNumber("785938232669132551").setOrderDescription("三两三鲜米线")
                .setAccount(account));
        orders.add(new Order().setOrderId(3L).setOrderNumber("793382623157348612").setOrderDescription("二两老麻抄手")
                .setAccount(account));
        account.setOrders(orders);
        model.addAttribute("account", account);
        return "model1";
    }

    /**
     * 数据模型测试二
     * @param map
     * @return
     */
    @GetMapping("/model/test2")
    public String dataModel2(Map<String, Object> map) {
        List<Order> orders = new ArrayList<>();
        Account account = new Account().setAccountId(1L).setAccountName("MyAccount").setAccountPassword("123456")
                .setUser(new User(1L, "kenshine", "654321"));
        orders.add(new Order().setOrderId(1L).setOrderNumber("785698232657798568").setOrderDescription("二两麻辣牛肉面")
                .setAccount(account));
        orders.add(new Order().setOrderId(2L).setOrderNumber("785938232669132551").setOrderDescription("三两三鲜米线")
                .setAccount(account));
        orders.add(new Order().setOrderId(3L).setOrderNumber("793382623157348612").setOrderDescription("二两老麻抄手")
                .setAccount(account));
        map.put("accountId", account.getAccountId());
        map.put("accountName", account.getAccountName());
        map.put("accountPassword", account.getAccountPassword());
        map.put("user", account.getUser());
        map.put("orders", orders);
        return "model2";
    }

    /**
     * 数据模型三
     * @param map
     * @return
     */
    @GetMapping("/model/test3")
    public String dataModel3(Map<String, Object> map) {
        List<Order> orders = new ArrayList<>();
        Account account = new Account().setAccountId(1L).setAccountName("MyAccount").setAccountPassword("123456")
                .setUser(new User(1L, "kenshine", "654321"));
        orders.add(new Order().setOrderId(1L).setOrderNumber("785698232657798568").setOrderDescription("二两麻辣牛肉面")
                .setAccount(account));
        orders.add(new Order().setOrderId(2L).setOrderNumber("785938232669132551").setOrderDescription("三两三鲜米线")
                .setAccount(account));
        orders.add(new Order().setOrderId(3L).setOrderNumber("793382623157348612").setOrderDescription("二两老麻抄手")
                .setAccount(account));
        account.setOrders(orders);
        map.put("account", account);
        return "model3";
    }


    /**
     * 测试assign 创建变量
     * @param model
     * @return
     */
    @GetMapping("/directive/assign")
    public String assignDirective(Model model) {
        User user = new User(1L, "kenshine", "654321");
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order().setOrderId(1L).setOrderNumber("785698232657798568").setOrderDescription("二两麻辣牛肉面"));
        orders.add(new Order().setOrderId(2L).setOrderNumber("785938232669132551").setOrderDescription("三两砂锅三鲜米线"));
        orders.add(new Order().setOrderId(3L).setOrderNumber("793382623157348612").setOrderDescription("二两老麻抄手"));
        model.addAttribute("user", user);
        model.addAttribute("orders", orders);
        return "directive-assign";
    }

    /**
     * 测试 attempt recover 默认值
     * @param model
     * @return
     */
    @GetMapping("/directive/attempt-recover")
    public String attemptAndRecoverDirective(Model model) {
        User user = new User(1L, "kenshine", "654321");
        //不加这句会出错
        model.addAttribute("user", user);
        return "directive-attempt-recover";
    }


    /**
     * 测试compress 删除空白字符串
     * @param model
     * @return
     */
    @GetMapping("/directive/compress")
    public String testCompress(Model model) {
        return "directive-compress";
    }

    /**
     * escape-noescape 转义开启与关闭
     * @param model
     * @return
     */
    @GetMapping("/directive/escape-noescape")
    public String escapeAndNoescapeDirective(Model model) {
        model.addAttribute("hello", "<h1>Hello FreeMarker</h1>");
        return "directive-escape-noescape";
    }

    /**
     * autoesc-noautoesc自动转义开启与关闭
     * @param model
     * @return
     */
    @GetMapping("/directive/autoesc-noautoesc")
    public String autoescDirective(Model model) {
        model.addAttribute("hello", "<h1>Hello FreeMarker</h1>");
        return "directive-autoesc-noautoesc";
    }

    /**
     * 定义函数
     * @param model
     * @return
     */
    @GetMapping("/directive/function-return")
    public String functionAndReturnDirective(Model model) {
        model.addAttribute("num", 5);
        return "directive-function-return";
    }

    /**
     * global 全局变量
     * @param model
     * @return
     */
    @GetMapping("/directive/global")
    public String globalDirective(Model model) {
        model.addAttribute("username", "ZhaoYun");
        return "directive-global";
    }

    /**
     * 条件
     * @param model
     * @return
     */
    @GetMapping("/directive/if")
    public String ifDirective(Model model) {
        model.addAttribute("grade", 85);
        return "directive-if";
    }

    /**
     * 测试import
     * @param model
     * @return
     */
    @GetMapping("/directive/import")
    public String importDirective(Model model) {
        model.addAttribute("user", new User(1L, "kenshine", "123456"));
        return "directive-import";
    }

    /**
     * 测试include
     * @param model
     * @return
     */
    @GetMapping("/directive/include")
    public String includeDirective(Model model) {
        model.addAttribute("user", new User(1L, "kenshine", "654321"));
        return "directive-include";
    }

    /**
     * list链表操作
     * @param model
     * @return
     */
    @GetMapping("/directive/list")
    public String listDirective(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "刘备", "123132"));
        users.add(new User(2L, "关羽", "321231"));
        users.add(new User(3L, "张飞", "213312"));
        users.add(new User(4L, "赵云", "132213"));
        users.add(new User(5L, "马超", "312123"));
        model.addAttribute("users", users);
        //迭代hashMap
        Map<String, Object> map = new HashMap<>(16);
        map.put("user1", new User(1L, "刘备", "123132"));
        map.put("user2", new User(2L, "关羽", "321231"));
        map.put("user3", new User(3L, "张飞", "213312"));
        map.put("user4", new User(4L, "赵云", "132213"));
        map.put("user5", new User(5L, "马超", "312123"));
        model.addAttribute("userMap", map);


        return "directive-list";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/directive/macro")
    public String macroDirective(Model model) {
        model.addAttribute("num", 5);
        return "directive-macro";
    }

    /**
     * switch选择
     * @param model
     * @return
     */
    @GetMapping("/directive/switch")
    public String switchDirective(Model model) {
        model.addAttribute("rank", 3);
        return "directive-switch";
    }




    /**
     * 表达式直接指定值
     * @param model
     * @return
     */
    @GetMapping("/expression/specifyValue")
    public String specifyValue(Model model) {
        return "expression-specify-value";
    }

    /**
     * String操作
     * @param model
     * @return
     */
    @GetMapping("ost")
    public String stringOperations(Model model) {
        model.addAttribute("user", new User(1L, "RtxTitanV", "654321"));
        return "expression-string-operations";
    }


    /**
     * 序列操作
     */
    @GetMapping("/expression/sequence-operations")
    public String sequenceOperations(Model model) {
        List<User> users1 = new ArrayList<>();
        users1.add(new User(1L, "刘备", "123132"));
        users1.add(new User(2L, "关羽", "321231"));
        users1.add(new User(3L, "张飞", "213312"));
        User[] users2 = {new User(4L, "赵云", "132213"), new User(5L, "马超", "312123")};
        model.addAttribute("users1", users1);
        model.addAttribute("users2", users2);
        return "expression-sequence-operations";
    }

    /**
     * hash操作
     * /expression/hash-operations
     * @param model
     * @return
     */
    @GetMapping("/expression/hash-operations")
    public String hashOperations(Model model) {
        Map<String, Object> map1 = new HashMap<>(16);
        map1.put("user1", new User(1L, "刘备", "123132"));
        map1.put("user2", new User(2L, "关羽", "321231"));
        Map<String, Object> map2 = new HashMap<>(16);
        map2.put("user1", new User(3L, "张飞", "213312"));
        map2.put("user4", new User(4L, "赵云", "132213"));
        map2.put("user5", new User(5L, "马超", "312123"));
        model.addAttribute("map1", map1);
        model.addAttribute("map2", map2);
        return "expression-hash-operations";
    }

    /**
     * 运算符
     * @param model
     * @return
     */
    @GetMapping("/expression/operation")
    public String operation(Model model) {
        model.addAttribute("x", 10);
        model.addAttribute("y", 3);
        return "expression-operation";
    }

    /**
     * 不存在的值
     */
    @GetMapping("/expression/missing")
    public String missing(Model model) {
        model.addAttribute("user", new User(1L, null, null));
        return "expression-missing";
    }

    /**
     * 字符串内建函数
     */
    @GetMapping("/built-ins/strings")
    public String builtInsStrings(Model model) {
        model.addAttribute("user",
                new User(1L, "SpringBoot-FreeMarker-Strings-Test", "   SpringBoot _Free-Marker  . Strings,  @Test ? !  "));
        model.addAttribute("str1", "springboot freemarker strings test");
        model.addAttribute("str2", "SpringBoot FreeMarker Strings Test");
        return "built-ins-strings";
    }

    /**
     * 数字内建函数
     * @param model
     * @return
     */
    @GetMapping("/built-ins/numbers")
    public String builtInsNumbers(Model model) {
        model.addAttribute("num", 888888);
        model.addAttribute("num2", 66.6658932);
        return "built-ins-numbers";
    }

    /**
     * 日期内建函数
     * @param model
     * @return
     */
    @GetMapping("/built-ins/date")
    public String builtInsDate(Model model) {
        model.addAttribute("date", new Date());
        return "built-ins-date";
    }

    /**
     * 布尔值内建函数
     * @param model
     * @return
     */
    @GetMapping("/built-ins/booleans")
    public String builtInsBooleans(Model model) {
        model.addAttribute("grade", 85);
        return "built-ins-booleans";
    }


    /**
     * 序列建函数
     * @param model
     * @return
     */
    @GetMapping("/built-ins/sequences")
    public String builtInsSequences(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "刘备", "123132"));
        users.add(new User(2L, "关羽", "321231"));
        users.add(new User(3L, "张飞", "213312"));
        users.add(new User(4L, "赵云", "132213"));
        users.add(new User(5L, "马超", "312123"));
        String[] colors = {"red", "blue", "green", "yellow", "blue", "green", "white", "purple", "cyan", "orange"};
        model.addAttribute("users", users);
        model.addAttribute("colors", colors);
        return "built-ins-sequences";
    }

    /**
     * 哈希内建函数
     */
    @GetMapping("/built-ins/hashes")
    public String builtInsHashes(Model model) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("user1", new User(1L, "刘备", "123132"));
        map.put("user2", new User(2L, "关羽", "321231"));
        map.put("user3", new User(3L, "张飞", "213312"));
        map.put("user4", new User(4L, "赵云", "132213"));
        map.put("user5", new User(5L, "马超", "312123"));
        model.addAttribute("userMap", map);
        return "built-ins-hashes";
    }





















}
