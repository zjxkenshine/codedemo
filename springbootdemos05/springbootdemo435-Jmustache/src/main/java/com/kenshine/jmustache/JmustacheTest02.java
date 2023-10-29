package com.kenshine.jmustache;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.junit.Test;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/29 13:38
 * @description：测试2
 * @modified By：
 * @version: $
 */
public class JmustacheTest02 {

    /**
     * this变量 引用本身，在遍历时很有用
     */
    @Test
    public void test01(){
       String s1= Mustache.compiler().compile("{{this}}").execute("hello");
       String s2=Mustache.compiler().compile("{{#names}}{{this}}{{/names}}").execute(new Object() {
            List<String> names () { return Arrays.asList("Tom", "Dick", "Harry"); }
        });
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * . 和this相同
     */
    @Test
    public void test02(){
        Mustache.compiler().compile("{{.}}").execute("hello");
        String s=Mustache.compiler().compile("{{#names}}{{.}}{{/names}}").execute(new Object() {
            List<String> names () { return Arrays.asList("Tom", "Dick", "Harry"); }
        });
        System.out.println(s);
    }

    /**
     * 可以使用特殊变量-first和-last对列表元素执行特殊处理。
     * -first在处理元素列表中的第一个元素的section中解析为true。它在其他所有时间都为假。
     * -last在处理元素列表最后一个元素的节中解析为true。它在其他所有时间都为假
     *
     * {{^-first}}, {{/-first}}  首位不会添加,
     */
    @Test
    public void test03(){
        String tmpl = "{{#things}}{{^-first}}, {{/-first}}{{this}}{{/things}}";
        String s=Mustache.compiler().compile(tmpl).execute(new Object() {
            List<String> things = Arrays.asList("one", "two", "three");
        });
        System.out.println(s);
    }

    /**
     * index填充 index特殊变量包含1，第一次迭代1，第二次迭代2，第三次迭代3，依此类推。其他时刻都是0
     *
     * My favorite things:
     * 1. Peanut butter
     * 2. Pen spinning
     * 3. Handstands
     */
    @Test
    public void test04(){
        String tmpl = "My favorite things:\n{{#things}}{{-index}}. {{this}}\n{{/things}}";
        String s=Mustache.compiler().compile(tmpl).execute(new Object() {
            List<String> things = Arrays.asList("Peanut butter", "Pen spinning", "Handstands");
        });
        System.out.println(s);
    }

    /**
     * 复合变量
     */
    @Test
    public void test05(){
        String s=Mustache.compiler().compile("Hello {{field.who}}!").execute(new Object() {
            public Object field = new Object() {
                public String who () { return "world"; }
            };
        });
        System.out.println(s);
    }

    /**
     *反射和bean属性风格的查找
     */
    @Test
    public void test06(){
        String s=Mustache.compiler().compile("Hello {{class.name}}!").execute(new Object());
        System.out.println();
    }

    /**
     * 嵌套上下文
     * 如果在嵌套上下文中找不到变量，则在下一个外部上下文中解析它
     */
    @Test
    public void test07(){
        String template = "{{outer}}:\n{{#inner}}{{outer}}.{{this}}\n{{/inner}}";
        String s=Mustache.compiler().compile(template).execute(new Object() {
            String outer = "foo";
            List<String> inner = Arrays.asList("bar", "baz", "bif");
        });
        System.out.println(s);
    }

    /**
     * 可逆lambda
     */
    @Test
    public void test08(){
//        String template = "{{#condition}}result if true{{/condition}}\n" +
//                "{{^condition}}result if false{{/condition}}";
//        Mustache.compiler().compile(template).execute(new Object() {
//            Mustache..InvertibleLambda condition = new Mustache.InvertibleLambda() {
//                public void execute (Template.Fragment frag, Writer out) throws IOException {
//                    // this method is executed when the lambda is referenced in a normal section
//                    out.write("if (condition) {console.log(\"");
//                    out.write(toJavaScriptLiteral(frag.execute()));
//                    out.write("\")}");
//                }
//                public void executeInverse (Template.Fragment frag, Writer out) throws IOException {
//                    // this method is executed when the lambda is referenced in an inverse section
//                    out.write("if (!condition) {console.log(\"");
//                    out.write(toJavaScriptLiteral(frag.execute()));
//                    out.write("\")}");
//                }
//                private String toJavaScriptLiteral (String execute) {
//                    // note: this is NOT a complete implementation of JavaScript string literal escaping
//                    return execute.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
//                }
//            };
//        });
    }

}
