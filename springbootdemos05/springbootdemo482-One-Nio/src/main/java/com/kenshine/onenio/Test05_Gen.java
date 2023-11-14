package com.kenshine.onenio;

import one.nio.compiler.CompilationException;
import one.nio.compiler.Javac;
import one.nio.gen.BytecodeGenerator;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test05_Gen
 * @Description BytecodeGenerator 字节码生成类
 * @Date 2023-11-14 12:31
 * @modified By：
 * @version: 1.0$
 */
public class Test05_Gen {

    /**
     * 字节码生成类
      */
    @Test
    public void testBytecodeGenerator() throws CompilationException {
        String code =
                "package com.kenshine.onenio;\n" +
                        "public class GeneratedRunnable implements Runnable {\n" +
                        "    public void run() {\n" +
                        "        System.out.println(\"Hello BytecodeGenerator\");\n" +
                        "    }\n" +
                        "}\n";
        // 编译的字节
        byte[] classData = new Javac(Test03_Compiler.class.getClassLoader()).compile(code);
        // 字节码生成 byte转class
        Runnable runnable = new BytecodeGenerator().instantiate(classData, Runnable.class);
        runnable.run();
    }
}
