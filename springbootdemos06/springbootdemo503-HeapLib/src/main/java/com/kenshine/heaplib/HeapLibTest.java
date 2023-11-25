package com.kenshine.heaplib;

import org.gridkit.jvmtool.heapdump.HeapHistogram;
import org.gridkit.jvmtool.heapdump.StringCollector;
import org.junit.Test;
import org.netbeans.lib.profiler.heap.Heap;
import org.netbeans.lib.profiler.heap.HeapFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author by kenshine
 * @Classname HeapLibTest
 * @Description 测试
 * @Date 2023-11-25 17:12
 * @modified By：
 * @version: 1.0$
 */
public class HeapLibTest {

    @Test
    public void printHistogram() throws IOException {
        Heap heap = HeapFactory.createFastHeap(new File("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo503-HeapLib\\hprof\\test.hprof"));
        StringCollector collector = new StringCollector();
        HeapHistogram histo = new HeapHistogram();
        collector.collect(heap, histo);
        List<HeapHistogram.ClassRecord> ht = new ArrayList<>(histo.getHisto());
        ht.add(collector.asClassRecord());
        Collections.sort(ht, HeapHistogram.BY_SIZE);
        TextTable tt = new TextTable();
        int n = 0;
        for(HeapHistogram.ClassRecord cr: ht.subList(0, 500)) {
            tt.addRow("" + (++n), " " + cr.getTotalSize(), " " + cr.getInstanceCount(), " " + cr.getClassName());
        }
        System.out.println(tt.formatTextTableUnbordered(1000));
    }
}
