package com.kenshine.onenio;

import one.nio.os.bpf.BpfMap;
import one.nio.os.bpf.BpfProg;
import one.nio.os.bpf.MapType;
import one.nio.os.perf.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname Test12_Os
 * @Description OS 系统操作 Java封装了对内存、进程和用户管理的某些Linux系统调用
 * @Date 2023-11-15 12:26
 * @modified By：
 * @version: 1.0$
 *
 * 仅支持Linux
 */
public class Test12_Os {

    /**
     * linux bpf 过滤器
     */
    @Test
    public void TestBpf() throws IOException {
        BpfMap map = BpfMap.newMap(MapType.PERCPU_HASH, 4, 8, 1, null, 0);
        assert map.totalValueSize == 8 * BpfMap.CPUS;
        assert map.get(BpfMap.bytes(1)) == null;

        ByteBuffer buf = ByteBuffer.allocate(map.totalValueSize).order(ByteOrder.nativeOrder());
        LongBuffer lbuf = buf.asLongBuffer();
        for (int i = 0; i < BpfMap.CPUS; i++) {
            lbuf.put(i);
        }

        map.put(BpfMap.bytes(1), buf.array());

        byte[] value = map.get(BpfMap.bytes(1));
        LongBuffer lbuf2 = BpfMap.longs(value);
        for (int i = 0; i < BpfMap.CPUS; i++) {
            assert i == lbuf2.get();
        }

        map.remove(BpfMap.bytes(1));
        assert map.get(BpfMap.bytes(1)) == null;

        map.close();
    }

    /**
     * Bpf
     */
    @Test
    public void testBpfList() throws IOException {
        for (int id : BpfProg.getAllIds()) {
            BpfProg prog = BpfProg.getById(id);
            System.out.printf("Prog %d: %s %s, maps: %s %n", prog.id, prog.name, prog.type, Arrays.toString(prog.getMapIds()));
        }

        for (int id : BpfMap.getAllIds()) {
            BpfMap map = BpfMap.getById(id);
            System.out.printf("Map %d: %s %s, key size: %d, value size: %d, max elements: %d, flags: %d%n", map.id, map.name, map.type, map.keySize, map.valueSize, map.maxEntries, map.flags);
        }
    }

    /**
     * Linux Perf 性能分析
     */
    @Test
    public void testPerf() throws IOException, InterruptedException {
        long period = 10_000;

        PerfCounter counter = Perf.open(PerfEvent.HW_CPU_CYCLES, Perf.ANY_PID, 0,
                PerfOption.period(period),
                PerfOption.SAMPLE_TID,
                PerfOption.SAMPLE_TIME,
                PerfOption.SAMPLE_READ,
                PerfOption.FORMAT_GROUP,
                PerfOption.DISABLED);

        PerfCounter attached = Perf.open(PerfEvent.HW_INSTRUCTIONS, Perf.ANY_PID, 0, PerfOption.group(counter));

        counter.enable();

        for (int i = 0; ; i++) {
            System.out.println(i);
            for (PerfSample sample; (sample = counter.nextSample()) != null; ) {
                System.out.printf(" - pid=%d, tid=%d, time=%d, values=%d, %d\n",
                        sample.pid, sample.tid, sample.time, sample.values[0], sample.values[1]);
            }
            Thread.sleep(1000);
        }
    }
}
