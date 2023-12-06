package com.kenshine.quickperf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quickperf.annotation.DebugQuickPerf;
import org.quickperf.junit4.QuickPerfJUnitRunner;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.jvm.allocation.AllocationUnit;
import org.quickperf.jvm.annotations.*;
import org.quickperf.jvm.gc.GC;
import org.quickperf.jvm.heap.HeapDumper;
import org.quickperf.jvm.jfr.annotation.ExpectNoJvmIssue;
import org.quickperf.jvm.jfr.annotation.ProfileJvm;
import org.quickperf.writer.WriterFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author by kenshine
 * @Classname QuickPerfJvmTest
 * @Description Jvm测试
 * @Date 2023-12-06 14:19
 * @modified By：
 * @version: 1.0$
 *
 * junit5方式 @QuickPerfTest
 */
@RunWith(QuickPerfJUnitRunner.class)
@DebugQuickPerf
public class QuickPerfJvmTest {

    /**
     * 指定堆大小
     */
    @HeapSize(value = 20, unit = AllocationUnit.MEGA_BYTE)
    @Test
    public void test01() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 最大/最小堆大小
     */
    @Xms(value = 18, unit = AllocationUnit.MEGA_BYTE)
    @Xmx(value = 21, unit = AllocationUnit.MEGA_BYTE)
    @Test
    public void test02() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 指定GC算法
     */
    @UseGC(GC.ZGC)
    @Test
    public void test03() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 打印GC日志
     */
    @EnableGcLogging
    @Test
    public void test04() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 设置JVM参数
     */
    @EnableGcLogging
    @JvmOptions("-XX:+UseG1GC")
    @Test
    public void test05() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    /**
     * 输出堆分配信息
     * [QUICK PERF] Measured heap allocation (test method thread): 440 bytes
     */
    @MeasureHeapAllocation
    @JvmOptions("-XX:+UseCompressedOops -XX:+UseCompressedClassPointers")
    @Test
    public void test06(){
        ArrayList<Object> data = new ArrayList<>(100);
    }

    /**
     * 格式化并输出到文件
     */
    @MeasureHeapAllocation(writerFactory = FileWriterBuilder.class, format = "Heap allocation: %s\n")
    @Test
    public void test07() {
        ArrayList<Object> data = new ArrayList<>(100);
    }

    /**
     * 最大分配堆大小
     */
    @ExpectMaxHeapAllocation(value = 440, unit = AllocationUnit.BYTE)
    @Test
    public void test08() {
        ArrayList<Object> data = new ArrayList<>(100);
    }

    /**
     * 输出堆信息
     */
    @HeapSize(value = 50, unit = AllocationUnit.MEGA_BYTE)
    @Test
    public void test09() {
        ArrayList<Object> data = new ArrayList<>(100);
        HeapDumper.dumpHeap("temp/test09.hprof");

    }

    /**
     * 常驻集信息 仅支持Linux
     */
    @MeasureRSS
    @Test
    public void test10(){
        ArrayList<Object> data = new ArrayList<>(100);
    }

    /**
     * 期望 仅支持Linux
     */
    @ExpectMaxRSS(value = 10,unit = AllocationUnit.BYTE)
    @Test
    public void test11(){
        ArrayList<Object> data = new ArrayList<>(100);
    }


    /**
     * 打印JVM信息 需要openjdk支持
     */
    @Test
    @ProfileJvm
    public void test12() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    @Test
    @ExpectNoJvmIssue
    public void test13() throws InterruptedException {
        System.out.println("begin");
        Thread.sleep(1000);
        System.out.println("end");
    }

    public static class FileWriterBuilder implements WriterFactory {
        @Override
        public Writer buildWriter() throws IOException {
            return new FileWriter("temp/Allocation.txt", true);
        }
    }



}
