package com.kenshine.onenio;

import one.nio.mem.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;

import static one.nio.util.JavaInternals.byteArrayOffset;
import static one.nio.util.JavaInternals.unsafe;

/**
 * @author by kenshine
 * @Classname Test09_Mem
 * @Description 堆外内存管理工具测试
 * @Date 2023-11-15 9:15
 * @modified By：
 * @version: 1.0$
 */
public class Test09_Mem {

    /**
     * DirectMemory：直接操作堆外内存
     */
    @Test
    public void testDirectMemory(){
        // 分配堆外内存
        long address=DirectMemory.allocate(8,new Object());
        System.out.println(address);
        // 回收内存
        DirectMemory.freeRaw(address);

        // 分配并格式化
        long address2=DirectMemory.allocateAndClear(8,new Object());
        System.out.println(address2);
        // 回收内存
        DirectMemory.freeRaw(address2);

        // 包装为ByteBuffer
        long address3=DirectMemory.allocate(8,new Object());
        ByteBuffer bf=DirectMemory.wrap(address3,8);
        System.out.println(DirectMemory.getAddress(bf));
        DirectMemory.freeRaw(address3);
    }

    /**
     * MappedFile 将文件映射和解映射到RAM
     */
    @Test
    public void testMappedFile() throws IOException {
        MappedFile mmap = new MappedFile("D:\\Github\\codedemo\\springbootdemos05\\springbootdemo482-One-Nio\\file\\1.txt",8);
        long address=mmap.getAddr();
        System.out.println(address);

        // 映射到本地
        Long address1=MappedFile.map(mmap.getFile(),mmap.getMode(),0,8);
        System.out.println(address1);
        MappedFile.unmap(address1,8);
    }

    /**
     * Malloc分配堆外内存
     */
    @Test
    public void testMalloc(){
        Malloc malloc=new Malloc(8*1024);
        long address= malloc.allocatedSize(1);
        System.out.println(address);
        System.out.println(malloc.getTotalMemory());
        System.out.println(malloc.getUsedMemory());
        System.out.println(malloc.getFreeMemory());

        // 分配堆外空间
        long address1= malloc.malloc(1);
        System.out.println(address1);
        System.out.println(malloc.getTotalMemory());
        System.out.println(malloc.getUsedMemory());
        System.out.println(malloc.getFreeMemory());
        // calloc 小数组更快分配
        long address2=malloc.calloc(1);
        System.out.println(address2);
        System.out.println(malloc.getTotalMemory());
        System.out.println(malloc.getUsedMemory());
        System.out.println(malloc.getFreeMemory());
    }

    /**
     * MallocMT 多线程Malloc
     */
    @Test
    public void testMallocMT(){
        // 默认8个线程
        MallocMT malloc=new MallocMT(8*1024,4);
        long address= malloc.allocatedSize(1);
        System.out.println(address);
        System.out.println(malloc.getTotalMemory());
        System.out.println(malloc.getUsedMemory());
        System.out.println(malloc.getFreeMemory());
    }

    /**
     * FixedSizeAllocator 无锁分配器
     */
    @Test
    public void testFixedSizeAllocator(){
        long entrySize = 4096;
        int count = 10;
        long totalMemory = entrySize * count;

        long addr = DirectMemory.allocateAndClear(totalMemory, this);
        FixedSizeAllocator allocator = new FixedSizeAllocator(addr, totalMemory, entrySize);
        Assert.assertEquals(count, allocator.totalPages());
        Assert.assertEquals(count, allocator.freePages());
        Assert.assertEquals(0, allocator.usedPages());
        Assert.assertEquals(0, allocator.usedMemory());

        long mem1 = allocator.malloc();
        Assert.assertEquals(count, allocator.totalPages());
        Assert.assertEquals(count - 1, allocator.freePages());
        Assert.assertEquals(1, allocator.usedPages());
        Assert.assertEquals(entrySize, allocator.usedMemory());

        Assert.assertEquals(1, new FixedSizeAllocator(addr, totalMemory, entrySize, allocator.head()).usedPages());
        allocator.free(mem1);
        Assert.assertEquals(0, allocator.usedPages());
    }

    /**
     * LongHashSet, LongLongHashMap, LongObjectHashMap：具有64位键的堆外无锁哈希表
     */
    @Test
    public void testHashMap(){
        LongHashSet longHashSet=new LongHashSet(8);
        longHashSet.putKey(1L);
        longHashSet.putKey(2L);
        longHashSet.putKey(3L);
        longHashSet.putKey(4L);
        System.out.println(longHashSet.size());
        longHashSet.clear();

        LongObjectHashMap<String> longObjectHashMap=new LongObjectHashMap<>(8);
        longObjectHashMap.put(1L,"kenshine");
        longObjectHashMap.put(2L,"pig");
        longObjectHashMap.put(3L,"dog");
        longObjectHashMap.put(4L,"lin");
        System.out.println(longObjectHashMap.get(1));
        longObjectHashMap.clear();
        System.out.println(longObjectHashMap.get(1));
    }

    /**
     * 堆外Map
     * SharedMemoryStringMap
     * SharedMemoryLongMap
     * SharedMemoryMap
     */
    @Test
    public void testOffHeapMap() throws IOException {
        // 最小2MB
        SharedMemoryMap<String,String> map= new SharedMemoryStringMap<>(8, "test", 4*1024 * 1024);
        // 添加序列化
        map.setSerializer(String.class);
        map.put("name","kenshine");
        map.put("age","18");
        map.put("sex","man");
        System.out.println(map.get("name"));
    }

}
