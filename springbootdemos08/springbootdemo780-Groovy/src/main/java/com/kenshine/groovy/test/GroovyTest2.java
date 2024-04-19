package com.kenshine.groovy.test;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.util.HashMap;
import java.util.Map;

/**
 * 向Groovy脚本中传入变量，以及获取返回值
 * @author ：kenshine
 */
public class GroovyTest2 {
    public static void main(String[] args) {
        //创建GroovyShell
        GroovyShell groovyShell = new GroovyShell();
        //装载解析脚本代码
        Script script = groovyShell.parse("package groovy\n" +
                "\n" +
                "/**\n" +
                " * 简易加法\n" +
                " * @param a 数字a\n" +
                " * @param b 数字b\n" +
                " * @return 和\n" +
                " */\n" +
                "def add(int a, int b) {\n" +
                "    return a + b\n" +
                "}\n" +
                "\n" +
                "/**\n" +
                " * map转化为String\n" +
                " * @param paramMap 参数map\n" +
                " * @return 字符串\n" +
                " */\n" +
                "def mapToString(Map<String, String> paramMap) {\n" +
                "    StringBuilder stringBuilder = new StringBuilder();\n" +
                "    paramMap.forEach({ key, value ->\n" +
                "        stringBuilder.append(\"key:\" + key + \";value:\" + value)\n" +
                "    })\n" +
                "    return stringBuilder.toString()\n" +
                "}");
        //执行加法脚本
        Object[] params1 = new Object[]{1, 2};
        int sum = (int) script.invokeMethod("add", params1);
        System.out.println("a加b的和为:" + sum);
        //执行解析脚本
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("科目1", "语文");
        paramMap.put("科目2", "数学");
        Object[] params2 = new Object[]{paramMap};
        String result = (String) script.invokeMethod("mapToString", params2);
        System.out.println("mapToString:" + result);
    }
}