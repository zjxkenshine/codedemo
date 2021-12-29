package com.kenshine.roaring.test;

import org.roaringbitmap.buffer.ImmutableRoaringBitmap;
import org.roaringbitmap.buffer.MutableRoaringBitmap;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 22:34
 * @description： ImmutableRoaringBitmap和MutableRoaringBitmap
 * @modified By：
 * @version: $
 */
public class MutableTest {
    public static void main(String[] args) throws IOException {
        MutableRoaringBitmap rr1 = MutableRoaringBitmap.bitmapOf(1, 2, 3, 1000);
        MutableRoaringBitmap rr2 = MutableRoaringBitmap.bitmapOf( 2, 3, 1010);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        //序列化
        rr1.serialize(dos);
        rr2.serialize(dos);
        dos.close();
        ByteBuffer bb = ByteBuffer.wrap(bos.toByteArray());
        ImmutableRoaringBitmap rrback1 = new ImmutableRoaringBitmap(bb);
        bb.position(bb.position() + rrback1.serializedSizeInBytes());
        ImmutableRoaringBitmap rrback2 = new ImmutableRoaringBitmap(bb);

        System.out.println(rrback1);
        System.out.println(rrback2);
    }
}
