package com.kenshine.roaring.test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoDataInput;
import com.esotericsoftware.kryo.io.KryoDataOutput;
import com.esotericsoftware.kryo.io.Output;
import org.roaringbitmap.RoaringBitmap;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 22:38
 * @description： Kryo序列化
 * @modified By：
 * @version: $
 */
public class RoaringKryoSerializer extends Serializer<RoaringBitmap> {

    @Override
    public void write(Kryo kryo, Output output, RoaringBitmap bitmap) {
        try {
            bitmap.serialize(new KryoDataOutput(output));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    @Override
    public RoaringBitmap read(Kryo kryo, Input input, Class<? extends RoaringBitmap> type) {
        RoaringBitmap bitmap = new RoaringBitmap();
        try {
            bitmap.deserialize(new KryoDataInput(input));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return bitmap;
    }
}
