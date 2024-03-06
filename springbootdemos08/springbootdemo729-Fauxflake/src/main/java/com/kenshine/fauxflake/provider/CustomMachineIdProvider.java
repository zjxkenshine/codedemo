package com.kenshine.fauxflake.provider;

import com.github.rholder.fauxflake.api.MachineIdProvider;

/**
 * 自定义机器id生成
 * @author kenshine
 */
public class CustomMachineIdProvider implements MachineIdProvider {
    @Override
    public long getMachineId() {
        return Long.parseLong(System.getProperty("my.app.machine.id"));
    }
}