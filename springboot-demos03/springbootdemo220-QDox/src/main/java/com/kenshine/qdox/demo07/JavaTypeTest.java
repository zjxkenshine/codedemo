package com.kenshine.qdox.demo07;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaType;

import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:27
 * @description：JavaType测试
 * @modified By：
 * @version: $
 */
public class JavaTypeTest {
    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo07\\Demo07.java"));
        //获取具体的javaclass
        JavaClass cls = builder.getClassByName("com.kenshine.qdox.demo07.Demo07");

        JavaMethod m = cls.getMethods().get(0);

        JavaType returns = m.getReturns();
        returns.getValue(); // "void"

        JavaType n = m.getParameters().get(0).getType();
        n.getValue(); // "int"

        JavaType objects = m.getParameters().get(1).getType();
        objects.getValue(); // "java.lang.Object"


        JavaType dates = m.getParameters().get(2).getType();
        dates.getValue(); // "java.util.Date"


        JavaType stringList = m.getParameters().get(3).getType();
        stringList.getValue(); // "java.util.List"
        stringList.getGenericValue(); // "java.util.List<java.lang.String>"
    }
}
