package com.kenshine.jmustache;

import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/29 13:04
 * @description：使用测试
 * @modified By：
 * @version: $
 */
public class JmustacheTest {

    /**
     * 简单使用
     */
    @Test
    public void test01(){
        String text = "One, two, {{three}}. Three sir!";
        Template tmpl = Mustache.compiler().compile(text);
        Map<String, String> data = new HashMap<>();
        data.put("three", "five");
        System.out.println(tmpl.execute(data));
    }

    /**
     * 循环处理
     */
    @Test
    public void test02(){
        String tmpl = "{{#persons}}{{name}}: {{age}}\n{{/persons}}";
        String result=  Mustache.compiler().compile(tmpl).execute(new Object() {
            // persons区块
            Object persons = Arrays.asList(new Person("Elvis", 75), new Person("Madonna", 52));
        });
        System.out.println(result);
    }

    class Person {
        public final String name;
        public Person (String name, int age) {
            this.name = name;
            _age = age;
        }
        public int getAge () {
            return _age;
        }
        protected int _age;
    }

    /**
     * 子模块
     */
    @Test
    public void test03(){
        final String templateDir = "src\\main\\resources";
        // 读取subtmpl
        Mustache.Compiler c = Mustache.compiler().withLoader(name -> new FileReader(new File(templateDir, name)));
        String tmpl = "...{{>subtmpl.txt}}...";
        // 使用模板执行
        Map<String, String> data = new HashMap<>();
        data.put("bb", "666");
        String s=c.compile(tmpl).execute(data);
        System.out.println(s);
    }

    /**
     * 生成java代码
     */
    @Test
    public void test04() throws IOException {
        final String templateDir = "src\\main\\resources";
        // 读取helloword.java
        Mustache.Compiler c = Mustache.compiler().withLoader(name -> new FileReader(new File(templateDir, name)));
        String tmpl = "{{>helloword.java}}";
        // 使用模板执行
        Map<String, String> data = new HashMap<>();
        data.put("a", "kenshine");
        String content=c.compile(tmpl).execute(data);
        System.out.println(content);
        // 写入
        FileWriter fileWriter = new FileWriter("F:\\IDEAworkespace\\codedemo\\springbootdemos05\\springbootdemo435-Jmustache\\src\\main\\java\\com\\kenshine\\jmustache\\HelloWord.java");
        fileWriter.write(content);
        fileWriter.close();
    }

    /**
     * Mustache.Lambda
     * excute中使用lambda表达式
     */
    @Test
    public void test05(){
        String tmpl = "{{#bold}}{{name}} is awesome.{{/bold}}";
        String s=Mustache.compiler().compile(tmpl).execute(new Object() {
            String name = "Willy";
            Mustache.Lambda bold = (frag, out) -> {
                out.write("<b>");
                frag.execute(out);
                out.write("</b>");
            };
        });
        System.out.println(s);
    }

    /**
     * defaultValue 默认值
     */
    @Test
    public void test06(){
        String tmpl = "{{exists}} {{nullValued}} {{doesNotExist}}?";
        String s=Mustache.compiler().defaultValue("what").compile(tmpl).execute(new Object() {
            String exists = "Say";
            String nullValued = null;
            // String doesNotExist
        });
        System.out.println(s);
    }

    /**
     * 不转义HTML
     */
    @Test
    public void test07(){
        String s=Mustache.compiler().escapeHTML(false).compile("{{foo}}").execute(new Object() {
            String foo = "<bar>";
        });
        System.out.println(s);
    }

    /**
     * 自定义格式
     */
    @Test
    public void test08(){
       String s= Mustache.compiler().withFormatter(new Mustache.Formatter() {
            @Override
            public String format (Object value) {
                if (value instanceof Date){
                    return _fmt.format((Date)value);
                } else {
                    return String.valueOf(value);
                }
            }
            protected DateFormat _fmt = new SimpleDateFormat("yyyy/MM/dd");
        }).compile("{{msg}}: {{today}}").execute(new Object() {
            String msg = "Date";
            Date today = new Date();
        });
        System.out.println(s);
    }

    /**
     * 更改转义行为
     */
    @Test
    public void test09(){
        String[][] escapes = {{ "[", "[[" }, { "]", "]]" }};
        String s=Mustache.compiler().withEscaper(Escapers.simple(escapes)).
                compile("{{foo}}").execute(new Object() {
            String foo = "[bar]";
        });
        System.out.println(s);
    }



}
