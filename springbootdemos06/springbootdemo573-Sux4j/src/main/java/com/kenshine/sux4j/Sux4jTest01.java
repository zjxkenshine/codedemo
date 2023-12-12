package com.kenshine.sux4j;


import it.unimi.dsi.bits.BitVector;
import it.unimi.dsi.bits.LongArrayBitVector;
import it.unimi.dsi.bits.TransformationStrategies;
import it.unimi.dsi.sux4j.bits.*;
import it.unimi.dsi.sux4j.io.BucketedHashStore;
import it.unimi.dsi.sux4j.io.FileLinesList;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Sux4jTest01
 * @Description bits包使用测试
 * @Date 2023-12-12 16:18
 * @modified By：
 * @version: 1.0$
 */
public class Sux4jTest01 {

    /**
     * Rank 位排名
     */
    @Test
    public void test01(){
        BitVector bitVector = LongArrayBitVector.of(1, 0, 1, 1, 1, 0, 0);
        Rank9 rank9 = new Rank9(bitVector);
        System.out.println(rank9.lastOne());
        // 总共1的个数
        System.out.println(rank9.count());
        // 返回指定位置前1的个数
        System.out.println(rank9.rank(3));

        Rank11 rank11 = new Rank11(new long[1], 64);
        System.out.println(rank11.numBits());
        // 20到30位置1的个数
        System.out.println(rank11.rank(20,33));
        System.out.println(rank11.count());
    }

    /**
     * Select 位选择结构
     */
    @Test
    public void test02(){
        SimpleSelect select;
        select = new SimpleSelect(LongArrayBitVector.of(1, 0, 1, 1, 0, 0, 1).bits(), 7);
        // 返回一个位置，为1，且前面有3个1
        System.out.println(select.select(3));
        // 返回前面有0个1的1
        System.out.println(select.select(0));

        // 选择0
        SimpleSelectZero select1;
        select1 = new SimpleSelectZero(LongArrayBitVector.of(1, 0, 1, 1, 0, 0, 1).bits(), 7);
        System.out.println(select1.selectZero(0));
        System.out.println(select1.selectZero(1));
        System.out.println(select1.selectZero(2));
    }

    /**
     * FileLinesList 文件行转List
     */
    @Test
    public void test03() throws IOException {
        File t = File.createTempFile(Sux4jTest01.class.getName(), "tmp");
        t.deleteOnExit();

        FileWriter fw = new FileWriter(t);
        fw.write("\naa\naaaa\n\naa\n".toCharArray());
        fw.close();
        FileLinesList fll = new FileLinesList(t.toString(), "ASCII");

        System.out.println(fll.get(0));
        System.out.println(fll.get(1));
        System.out.println(fll.get(2));
        System.out.println(fll.get(3));
        System.out.println(fll.get(4));
    }

    /**
     * BucketedHashStore 签名的临时存储区，实际上分为多个桶
     */
    @Test
    public void test04() throws IOException {
        for(final int s: new int[] { 0, 1, 10, 100, 1000, 1000000 }) {
            final BucketedHashStore<Long> b = new BucketedHashStore<>(TransformationStrategies.fixedLong());
            for(int i = 0; i < s; i++) {
                b.add((long) i);
            }
            b.bucketSize(35);
            long t = 0;
            for(final BucketedHashStore.Bucket bucket: b) {
                t += bucket.size();
            }
            System.out.println(t);
            System.out.println(s);
            b.close();
        }
    }


}
