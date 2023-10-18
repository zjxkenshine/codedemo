package com.kenshine.sliverspi.test03;

import com.yihui.silver.spi.api.Spi;
import com.yihui.silver.spi.api.SpiAdaptive;

@Spi
public interface IUser {
    @SpiAdaptive(selector = UserSelector.class)
    void welcome(UserDO userDO);
}