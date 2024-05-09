package com.kenshine.varsparser;

import idea.verlif.parser.vars.PartContext;
import idea.verlif.parser.vars.VarsContext;
import idea.verlif.parser.vars.VarsHandler;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname VarParserTest
 * @Description 解析测试
 * @Date 2024-05-09 8:32
 * @modified By：
 * @version: 1.0$
 */
public class VarParserTest {

    /**
     * VarsContext：区域变量上下文
     * 这里的区域变量是指被左右标识符包裹的变量，例如${name}。
     * VarsContext默认以@{开头，以}结尾。
     * 可以通过VarsContext.setStart(String)和VarsContext.setEnd(String)进行修改。
     */
    @Test
    public void test01(){
        String s =
                "<!--   <script src=\"/js/jquery.min.js\"></script>\n" +
                        "       <script src=\"/js/bootstrap.min.js\"></script>\n" +
                        "       <script src=\"/ajax/libs/bootstrap-select/bootstrap-select.min.js\"></script>\n" +
                        "       <script src=\"/ajax/libs/bootstrap-select/bootstrap-select.js\"></script>\n" +
                        "-->";
        VarsContext context = new VarsContext();
        context.setStart("<");
        context.setEnd(">");
        // 或者使用
        context.setAreaTag("<", ">");
        // 过滤一些符号，例如下一行代码则会过滤“<!”。过滤只对左标识生效。
        context.addIgnoredPrefix('!');
        context.addIgnoredPrefix('/');
        context.addIgnoredSuffix('-');
        String result = context.build(s, new VarsHandler() {

            /**
             * 处理变量
             *
             * @param position 全变量名的第一个字符在整个内容的位置，从0开始
             * @param var      全变量名，包括了左右标识
             * @param content  变量内部名称，去除了左右标识
             * @return 变量处理后的用于替换全变量名的字符，只会改变build(VarsHandler)方法返回值
             */
            @Override
            public String handle(int position, String var, String content) {
                System.out.println(content);
                return var;
            }
        });
        System.out.println("\n处理结果: \n" + result);
    }


    /**
     * PartContext:部件变量上下文
     * 一般的整体变量，例如name，对应的是一个确切的字符串
     *
     * 从字符串最左端依次判定，避免replaceAll出现的匹配不可控性
     * 非正则匹配，只是单纯的字符串替换，不需要担心变量名是否符合正则要求。
     * 速度极快（ 20000 长度字符串使用 2000 个变量参数替换，时间在 50ms 以下）
     * 避免replaceAll过程中，替换后的字符串再次被命中的问题
     */
    @Test
    public void test02(){
        String s = "abcdefg";
        Map<String, String> map = new HashMap<>();
        map.put("abd", "哈哈");
        map.put("bcd", "哈哈");
        map.put("cde", "哈哈");
        map.put("efg", "哈哈");

        PartContext context = new PartContext(s);
        System.out.println(context.apply(map));
        // 由于结果词相同，所以上述的方式等效于以下方法
        context.replaceWith("哈哈", "abc", "bcd", "cde", "efg");
    }


    /**
     * PartContext.place 替换
     */
    @Test
    public void test03(){
        String s = "你好?，我是?";
        PartContext context = new PartContext(s);
        System.out.println(context.replace("?", "Lin", "Kenshine"));
    }
}
