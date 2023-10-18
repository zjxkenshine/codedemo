package com.kenshine.sliverspi;

import com.kenshine.sliverspi.print2.IPrint;
import com.yihui.silver.spi.SpiLoader;
import com.yihui.silver.spi.exception.SpiProxyCompileException;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 动态适配
 * @Date 2023-10-18 13:42
 * @modified By：
 * @version: 1.0$
 *
 * 主要是新增了一个接口 adaptivePrint
 */
public class Test02 {

    /**
     * 动态适配测试
     */
    @Test
    public void test() throws SpiProxyCompileException {
        IPrint print = SpiLoader.load(IPrint.class).getAdaptive();
        // 动态适配实现类
        print.adaptivePrint("FilePrint", "[file print]");
        print.adaptivePrint("ConsolePrint", "[console print]");
    }
}
