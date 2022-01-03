package com.kenshine.qdox.demo05;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:13
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaMethodTest {
    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo05\\Demo05.java"));
        //获取具体的javaclass
        JavaClass cls = builder.getClassByName("com.kenshine.qdox.demo05.Demo05");

        JavaMethod m = cls.getMethods().get(0);

        String mName = m.getName(); // "doStuff";
        System.out.println(mName);

        JavaType mReturns = m.getReturns(); // "java.util.Date";
        System.out.println(mReturns);

        boolean mArray = m.getReturns().isArray(); // true
        System.out.println(mArray);

        boolean mStatic = m.isStatic(); // true
        System.out.println(mStatic);

        boolean mPublic = m.isPublic(); // true
        System.out.println(mPublic);

        String doc = m.getTagByName("returns").getValue();  // "Lots of dates"
        System.out.println(doc);

        List<JavaType> exceptions = m.getExceptionTypes();// {"java.lang.RuntimeException", "java.io.IOException"}
        System.out.println(exceptions);

        JavaParameter numberParam = m.getParameters().get(0);   //参数1
        System.out.println(numberParam);

        JavaParameter stuffParam = m.getParameters().get(1);    //参数2
        System.out.println(stuffParam);

        JavaClass javaClass = m.getDeclaringClass();
        System.out.println(javaClass);
    }
}
