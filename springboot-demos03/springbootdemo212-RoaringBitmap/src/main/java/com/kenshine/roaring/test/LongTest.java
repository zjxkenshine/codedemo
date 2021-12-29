package com.kenshine.roaring.test;

import org.roaringbitmap.longlong.LongBitmapDataProvider;
import org.roaringbitmap.longlong.LongIterator;
import org.roaringbitmap.longlong.Roaring64Bitmap;
import org.roaringbitmap.longlong.Roaring64NavigableMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 22:46
 * @description：
 * @modified By：
 * @version: $
 */
public class LongTest {
    public static void main(String[] args) {
        //Roaring64NavigableMap
        LongBitmapDataProvider r = Roaring64NavigableMap.bitmapOf(1,2,100,1000);
        r.addLong(1234);
        System.out.println(r.contains(1)); // true
        System.out.println(r.contains(3)); // false
        LongIterator i = r.getLongIterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }


        //Roaring64Bitmap
        Roaring64Bitmap bitmap1 = new Roaring64Bitmap();
        Roaring64Bitmap bitmap2 = new Roaring64Bitmap();
        int k = 1 << 16;
        long i1 = Long.MAX_VALUE / 2;
        long base = i1;
        for (; i1 < base + 10000; ++i1) {
            bitmap1.add(i1 * k);
            bitmap2.add(i1 * k);
        }
        bitmap1.and(bitmap2);
        System.out.println(bitmap1.getLongCardinality());
        System.out.println(bitmap2.getLongCardinality());
    }
}
