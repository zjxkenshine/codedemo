package com.kenshine.sliverspi.test03;

import com.yihui.silver.spi.exception.NoSpiMatchException;
import com.yihui.silver.spi.selector.api.ISelector;
import com.yihui.silver.spi.selector.api.SpiImplWrapper;

import java.util.Map;

/**
 * 自定义选择器
 */
public class UserSelector implements ISelector<UserDO> {

    @Override
    public <K> K selector(Map<String, SpiImplWrapper<K>> map, UserDO conf) throws NoSpiMatchException {

        if (conf == null || conf.getMarket() == null) {
            throw new IllegalArgumentException("userDo or userDO#market should not be null!");
        }


        String name = conf.getMarket().getName();
        if (map.containsKey(name)) {
            return map.get(name).getSpiImpl();
        }


        throw new NoSpiMatchException("no spiImp matched marked: " + conf.getMarket());
    }
}