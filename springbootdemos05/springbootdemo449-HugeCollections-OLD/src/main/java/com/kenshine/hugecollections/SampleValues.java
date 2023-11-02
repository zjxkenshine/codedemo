package com.kenshine.hugecollections;

import lombok.Data;
import net.openhft.lang.io.Bytes;
import net.openhft.lang.io.serialization.BytesMarshallable;
import net.openhft.lang.model.constraints.NotNull;

/**
 * @author by kenshine
 * @Classname SampleValues
 * @Description 测试类
 * @Date 2023-11-02 12:24
 * @modified By：
 * @version: 1.0$
 */
@Data
public class SampleValues implements BytesMarshallable {
    String aa = "aaaaaaaaaa";
    String bb = "bbbbbbbbbb";
    BuySell cc = BuySell.Buy;
    BuySell dd = BuySell.Sell;
    int ee = 123456;
    int ff = 654321;
    double gg = 1.23456789;
    double hh = 9.87654321;
    long ii = 987654321;
    long jj = 123456789;

    @Override
    public void readMarshallable(@NotNull Bytes in) throws IllegalStateException {
        aa = in.readEnum(String.class);
        bb = in.readEnum(String.class);
        cc = in.readEnum(BuySell.class);
        dd = in.readEnum(BuySell.class);
        ee = in.readInt();
        ff = in.readInt();
        gg = in.readDouble();
        hh = in.readDouble();
        ii = in.readLong();
        jj = in.readLong();
    }

    @Override
    public void writeMarshallable(@NotNull Bytes out) {
        out.writeUTFΔ(aa);
        out.writeUTFΔ(bb);
        out.writeEnum(cc);
        out.writeEnum(dd);
        out.writeInt(ee);
        out.writeInt(ff);
        out.writeDouble(gg);
        out.writeDouble(hh);
        out.writeLong(ii);
        out.writeLong(jj);
    }
}

enum BuySell {
    Buy, Sell
}
