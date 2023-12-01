package com.kenshine.javacup.test01;

import java_cup.Lexer;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author by kenshine
 * @Classname test01
 * @Description 使用测试，输入解析
 * @Date 2023-12-01 13:27
 * @modified By：
 * @version: 1.0$
 */
public class test01 {


    public static void main(String[] args) {
        Parser parser = new Parser(new Scanner());
        try {
//			parser.parse();
            parser.debug_parse();
        } catch (Exception e) {
            System.out.println("Caught an exception.");
        }
    }

    /**
     * ComplexSymbolFactory
     */
    @Test
    public void test02() throws FileNotFoundException {
        SymbolFactory symbolFactory = new ComplexSymbolFactory();
        Parser parser = new Parser(new Lexer(new FileInputStream("src/main/java/com/kenshine/javacup/test01/lang.l")),symbolFactory);
        try {
            parser.debug_parse();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
