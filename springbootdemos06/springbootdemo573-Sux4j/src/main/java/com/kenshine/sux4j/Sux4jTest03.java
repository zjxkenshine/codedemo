package com.kenshine.sux4j;

import it.unimi.dsi.bits.LongArrayBitVector;
import it.unimi.dsi.bits.TransformationStrategies;
import it.unimi.dsi.fastutil.io.BinIO;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;
import it.unimi.dsi.fastutil.longs.LongBigList;
import it.unimi.dsi.sux4j.util.EliasFanoLongBigList;
import it.unimi.dsi.sux4j.util.TwoSizesLongBigList;
import it.unimi.dsi.sux4j.util.ZFastTrie;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author by kenshine
 * @Classname Sux4jTest03
 * @Description 存储结构使用测试
 * @Date 2023-12-12 23:28
 * @modified By：
 * @version: 1.0$
 */
public class Sux4jTest03 {

    /**
     * EliasFanoLongBigList 压缩长链表
     */
    @Test
    public void test01(){
        LongBigArrayBigList l=new LongBigArrayBigList(new long[][] { { 0, 0, 0 } });
        // offline 离线
        EliasFanoLongBigList list= new EliasFanoLongBigList(l.iterator(), 0, true);
        System.out.println(list);

        LongBigArrayBigList l1 = new LongBigArrayBigList(new long[][] { { 128, 2000, 50000000, 200, 10 } });
        EliasFanoLongBigList list1= new EliasFanoLongBigList(l1.iterator(), 0, false);
        System.out.println(list1);
    }

    /**
     * ZFastTrie
     */
    @Test
    public void test02() throws IOException, ClassNotFoundException {
        final String[] s = { "a", "b", "c" };
        ZFastTrie<String> zft = new ZFastTrie<>(Arrays.asList(s), TransformationStrategies.prefixFreeIso());
        for (int i = s.length; i-- != 0;) {
            assertTrue(s[i], zft.contains(s[i]));
        }
        zft = testSerialization(zft);
        for (int i = s.length; i-- != 0;) {
            assertTrue(zft.contains(s[i]));
        }

        for (int i = s.length; i-- != 0;) {
            assertTrue(zft.remove(s[i]));
        }
    }

    /**
     * TwoSizesLongBigList
     */
    @Test
    public void test03(){
        final LongBigList l = LongArrayBitVector.getInstance().asLongBigList(10);
        for (int i = 0; i < 1024; i++) {
            l.add(i);
        }
        TwoSizesLongBigList ts = new TwoSizesLongBigList(l);
        assertEquals(ts, l);

        l.clear();
        for (int i = 0; i < 512; i++) {
            l.add(2);
        }
        for (int i = 0; i < 512; i++) {
            l.add(i);
        }
        ts = new TwoSizesLongBigList(l);
        assertEquals(ts, l);
    }

    private <T> ZFastTrie<T> testSerialization(final ZFastTrie<T> zft) throws IOException, ClassNotFoundException {
        final File temp = File.createTempFile(getClass().getSimpleName(), "test");
        temp.deleteOnExit();
        BinIO.storeObject(zft, temp);
        @SuppressWarnings("unchecked")
        final ZFastTrie<T> deserialized = (ZFastTrie<T>)BinIO.loadObject(temp);
        return deserialized;
    }
}
