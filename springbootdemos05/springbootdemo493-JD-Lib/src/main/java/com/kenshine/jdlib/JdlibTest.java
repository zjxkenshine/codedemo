package com.kenshine.jdlib;

import com.github.kwart.jd.JavaDecompiler;
import com.github.kwart.jd.input.JDInput;
import com.github.kwart.jd.input.ZipFileInput;
import com.github.kwart.jd.options.DecompilerOptions;
import com.github.kwart.jd.output.DirOutput;
import com.github.kwart.jd.output.JDOutput;

import java.io.File;

/**
 * @author by kenshine
 * @Classname JdlibTest
 * @Description Jdlib反编译测试
 * @Date 2023-11-18 10:06
 * @modified By：
 * @version: 1.0$
 */
public class JdlibTest {

    public static void main(String[] args) {
        JDInput input = new ZipFileInput("springbootdemo493-JD-Lib/lib/jd-lib-1.2.1.jar");
        JDOutput output = new DirOutput(new File("springbootdemo493-JD-Lib/tmp/jdlib"));
        JavaDecompiler decompiler = new JavaDecompiler(new DecompilerOptions() {

            @Override
            public boolean isSkipResources() {
                return true;
            }

            @Override
            public boolean isEscapeUnicodeCharacters() {
                return false;
            }

            @Override
            public boolean isDisplayLineNumbers() {
                return true;
            }

            @Override
            public boolean isParallelProcessingAllowed() {
                return true;
            }
        });
        input.decompile(decompiler, output);
    }
}
