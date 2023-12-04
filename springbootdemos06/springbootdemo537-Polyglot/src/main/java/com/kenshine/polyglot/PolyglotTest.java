package com.kenshine.polyglot;

import org.junit.Test;
import polyglot.ext.jl.ExtensionInfo;
import polyglot.frontend.Compiler;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/4 21:55
 * @description：简单使用
 * @modified By：
 * @version: $
 */
public class PolyglotTest {

    @Test
    public void test01(){
        // 扩展信息,自定义实现，这里使用julia语言编译器的扩展名.jl
        Compiler compiler = new Compiler(new ExtensionInfo());
        List<String> paths= Arrays.asList("F:\\IDEAworkespace\\codedemo\\springbootdemos06\\springbootdemo537-Polyglot\\jl\\HelloWorld.jl");
        compiler.compile(paths);
    }
}
