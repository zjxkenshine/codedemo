package com.kenshine.jscc;

import com.javax0.jscc.Compiler;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname JsccTest
 * @Description jscc使用测试
 * @Date 2023-12-13 8:24
 * @modified By：
 * @version: 1.0$
 */
public class JsccTest {

    /**
     * 编译测试
     */
    @Test
    public void test01() throws Exception {
        String source = loadJavaSource("Test1.java");
        Compiler compiler = new Compiler();
        Class<?> newClass = compiler.compile(source, "com.kenshine.jscc.Test1");
        Object object = newClass.newInstance();
        // 带参数方法
        Method f = newClass.getMethod("testMethod",String.class);
        String s = (String) f.invoke(object, "kenshine");
        System.out.println(s);
    }


    private String loadJavaSource(String name) throws IOException {
        InputStream is = new FileInputStream("src/main/resources/"+name);
        byte[] buf = new byte[3000];
        int len = is.read(buf);
        is.close();
        return new String(buf, 0, len, "utf-8");
    }

}
