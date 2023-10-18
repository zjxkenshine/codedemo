package com.kenshine.sliverspi;

import com.kenshine.sliverspi.print.IPrint;
import com.yihui.silver.spi.SpiLoader;
import com.yihui.silver.spi.exception.NoSpiMatchException;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 静态适配 java spi
 * @Date 2023-10-18 13:37
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {
    @Test
    public void testPrint() throws NoSpiMatchException {
        SpiLoader<IPrint> spiLoader = SpiLoader.load(IPrint.class);

        IPrint print = spiLoader.getService("ConsolePrint");
        print.print("console---->");


        print = spiLoader.getService("FilePrint");
        print.print("file---->");


        // 找不到spi实现类
        try {
            print = spiLoader.getService("undefine");
            print.print("undefine----");
        } catch (Exception e) {
            System.out.println("type error-->" + e);
        }


        try {
            print = spiLoader.getService(123);
            print.print("type error----");
        } catch (Exception e){
            System.out.println("type error-->" + e);
        }
    }
}
