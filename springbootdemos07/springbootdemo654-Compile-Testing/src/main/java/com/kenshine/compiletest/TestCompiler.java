package com.kenshine.compiletest;

import com.google.common.truth.Truth;
import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import com.google.testing.compile.JavaSourceSubjectFactory;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Collections;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

/**
 * @author by kenshine
 * @Classname TestCompiler
 * @Description 编译测试
 * @Date 2024-01-06 10:57
 * @modified By：
 * @version: 1.0$
 */
public class TestCompiler {

    /**
     * 编译测试
     */
    @Test
    public void test01() throws MalformedURLException {
        // 编译注解处理器
        final MyProcessor processor = new MyProcessor();
        // 编译源文件
        File source = new File("src\\main\\java\\com\\kenshine\\compiletest\\MyProcessor.java");
        // 编译测试
        Truth.assertAbout(JavaSourceSubjectFactory.javaSource())
                .that(JavaFileObjects.forResource(source.toURI().toURL()))
                .processedWith(Collections.singleton(processor))
                .compilesWithoutError();
    }

    /**
     * 基本编译
     */
    @Test
    public void test02(){
        Compilation compilation = javac().compile(JavaFileObjects.forSourceString("HelloWorld", "final class HelloWorld {}"));
        // 测试编译成功
        assertThat(compilation).succeeded();
    }
}
