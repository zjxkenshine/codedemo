package com.kenshine.qdox.demo02;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaPackage;
import com.thoughtworks.qdox.model.JavaSource;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 9:24
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaPackageTest {

    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource src = builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo02\\Demo02.java"));

        JavaPackage pkg = src.getPackage();

        Collection<JavaClass> classes = pkg.getClasses();
        String name = pkg.getName();
        String toString = pkg.toString();
        JavaPackage parent = pkg.getParentPackage();

        System.out.println(classes);
        System.out.println(name);
        System.out.println(toString);
        System.out.println(parent);
    }
}
