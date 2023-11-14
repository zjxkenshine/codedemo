package com.kenshine.onenio;

import one.nio.compiler.CompilationException;
import one.nio.compiler.Javac;
import one.nio.gen.BytecodeGenerator;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test03_Compiler
 * @Description java编译工具
 * @Date 2023-11-14 11:48
 * @modified By：
 * @version: 1.0$
 */
public class Test03_Compiler {

    @Test
    public void testJavac() throws CompilationException {
        String code =
                "package com.kenshine.onenio;\n" +
                        "public class GeneratedRunnable implements Runnable {\n" +
                        "    public void run() {\n" +
                        "        System.out.println(\"Hello \" + getClass().getClassLoader());\n" +
                        "    }\n" +
                        "}\n";
        long startMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        // 编译的字节
        byte[] classData = new Javac(Test03_Compiler.class.getClassLoader()).compile(code);
        // 编译时间
        long compilationTime = System.currentTimeMillis();
        // 字节码生成 byte转class
        Runnable runnable = new BytecodeGenerator().instantiate(classData, Runnable.class);
        // 类加载时间
        long loadingTime = System.currentTimeMillis();
        long endMemory = Runtime.getRuntime().freeMemory();
        runnable.run();
        System.out.println("Compilation time = " + (compilationTime - startTime) +
                ", loading time = " + (loadingTime - compilationTime) +
                ", memory = " + (startMemory - endMemory) / 1024 + " KB");
    }
}
