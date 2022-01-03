package com.kenshine.qdox.demo06;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;
import com.thoughtworks.qdox.model.JavaType;

import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:22
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaParameterTest {
    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo06\\Demo06.java"));
        //获取具体的javaclass
        JavaClass cls = builder.getClassByName("com.kenshine.qdox.demo06.Demo06");

        JavaMethod m = cls.getMethods().get(0);

        JavaParameter n = m.getParameters().get(0);
        String nName = n.getName(); // "n"
        System.out.println(nName);
        JavaType nType   = n.getType(); // "int";
        System.out.println(nType);

        JavaParameter o = m.getParameters().get(1);
        String oName   = o.getName(); // "objects"
        System.out.println(oName);
        JavaType oType     = o.getType(); // "java.lang.Object[]";
        System.out.println(oType);

        System.out.println(m.getParameters());
    }
}
