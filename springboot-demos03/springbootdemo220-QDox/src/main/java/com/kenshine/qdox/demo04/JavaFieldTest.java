package com.kenshine.qdox.demo04;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.DocletTag;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaType;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:07
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaFieldTest {
    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo04\\Demo04.java"));
        //获取具体的javaclass
        JavaClass cls = builder.getClassByName("com.kenshine.qdox.demo04.Demo04");
        //email
        JavaField e = cls.getFields().get(0);

        JavaType eType = e.getType(); // "java.lang.String";
        System.out.println(eType);

        String eName   = e.getName(); // "email";
        System.out.println(eName);

        List<DocletTag> eTag = e.getTagsByName("magic"); // @magic
        System.out.println(eTag);

        boolean eArray = e.getType().isArray(); // false;
        System.out.println(eArray);

        System.out.println("==============================================");

        //dates
        JavaField d = cls.getFields().get(1);
        JavaType dType  = d.getType(); // "java.util.Date";
        System.out.println(dType);

        String dName = d.getName(); // "dates";
        System.out.println(dName);

        List<DocletTag> dTag = d.getTagsByName("magic"); // []
        System.out.println(dTag);

        boolean dArray = d.getType().isArray(); // true;
        System.out.println(dArray);

        int dDimensions= d.getType().getDimensions(); // 2; 数组深度
        System.out.println(dDimensions);

        boolean dStatic= d.isStatic(); // true; 是否静态
        System.out.println(dStatic);

        JavaClass javaClass = d.getDeclaringClass();
        System.out.println(javaClass);
    }
}
