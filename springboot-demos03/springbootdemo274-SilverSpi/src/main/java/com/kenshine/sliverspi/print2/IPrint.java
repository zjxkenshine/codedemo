package com.kenshine.sliverspi.print2;

import com.yihui.silver.spi.api.Spi;

@Spi
public interface IPrint {

    void print(String str);


    void adaptivePrint(String conf, String str);

}
