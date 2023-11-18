package com.kenshine.compiler;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;
import org.junit.Test;

import java.io.File;

/**
 * @author by kenshine
 * @Classname CompilerTest
 * @Description 动态编译测试
 * @Date 2023-11-18 9:24
 * @modified By：
 * @version: 1.0$
 */
public class CompilerTest {

    /**
     * 基本编译使用
     */
    @Test
    public void test01() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = "com.kenshine.compiler.MyClass";
        String javaCode = "package com.kenshine.compiler;\n" +
                "public class MyClass implements Runnable {\n" +
                "    public void run() {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}\n";
        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
        Runnable runner = (Runnable) aClass.newInstance();
        runner.run();
    }

    /**
     * CachedCompiler
     */
    @Test
    public void test02() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = "com.kenshine.compiler.MyClass";
        String javaCode = "package com.kenshine.compiler;\n" +
                "public class MyClass implements Runnable {\n" +
                "    public void run() {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}\n";
        // 是否debug
        CachedCompiler JCC = CompilerUtils.DEBUGGING ?
                // 源目录与目标目录
                new CachedCompiler(new File("test", "src/main/java/com/kenshine/compiler"), new File("test", "target/compiled")) :
                CompilerUtils.CACHED_COMPILER;
        Class aClass =JCC.loadFromJava(className,javaCode);
        Runnable runner = (Runnable) aClass.newInstance();
        runner.run();
    }
}
