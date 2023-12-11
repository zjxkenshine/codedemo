package com.kenshine.functional;

import fj.*;
import fj.data.*;
import org.junit.Test;

import java.io.IOException;

import static fj.data.IOFunctions.*;

/**
 * @author by kenshine
 * @Classname OtherTest
 * @Description 其他概念测试
 * @Date 2023-12-11 10:46
 * @modified By：
 * @version: 1.0$
 */
public class OtherTest {

    /**
     * Monoid 抽象代数中的幺半群
     */
    @Test
    public void test01Monoid(){
        Monoid<String> monoid = Monoid.stringMonoid;
        F<String,String> f=monoid.sum("a");
        System.out.println(f.f("kenshine"));
    }

    /**
     * Semigroup 抽象代数中的半群
     */
    @Test
    public void test02Semigroup(){
        Semigroup<String> semigroup = Semigroup.stringSemigroup;
        F<String,String> f=semigroup.sum("test02_");
        System.out.println(f.f("kenshine"));
        String sum=semigroup.sumNel(NonEmptyList.nel("a","b","c","d","e"));
        System.out.println(sum);
    }

    /**
     * Natural 自然数
     */
    @Test
    public void test03Natural(){
        Natural natural =Natural.natural(100).some();
        System.out.println(natural.doubleValue());
    }

    /**
     * LcgRng 线性同余发生器(Linear Congruential Generator, LCG)算法
     * 伪随机数生成
     */
    @Test
    public void test04LcgRng(){
        LcgRng lcgRng=new LcgRng();
        System.out.println(lcgRng.getSeed());
    }

    /**
     *  Reader 阅读器，类似F接口
     *  Writer\State
     */
    @Test
    public void test05ReaderWriterState(){
        Reader<String,String> reader = Reader.unit(s -> "test1"+s);
        System.out.println(reader.f("kenshine"));
        //  Writer
        Writer<String,String> writer = Writer.unit("test2");
        System.out.println(writer.tell("kenshine").log());
        System.out.println(writer.tell("kenshine").value());
        // State
        State<String,String> state = State.init();
        System.out.println(state.exec("kenshine"));
    }

    /**
     * IO Input/Output
     * IOFunctions IO函数
     */
    @Test
    public void test06IO() throws IOException {
        IO<String> io=IOFunctions.fromF(() -> "kenshine");
        System.out.println(io.run());

        F<String, String> f = String::toUpperCase;
        stdoutPrintln("What's your name again?")
                .append(stdoutPrint("Name: "))
                .append(stdinReadLine())
                .bind(f.andThen(IOFunctions::stdoutPrintln));
    }

}
