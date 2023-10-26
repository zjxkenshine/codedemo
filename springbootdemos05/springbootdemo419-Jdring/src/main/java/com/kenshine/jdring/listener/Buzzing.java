package com.kenshine.jdring.listener;

import com.kenshine.jdring.AlarmEntry;
import com.kenshine.jdring.AlarmListener;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/27 0:28
 * @description：测试
 * @modified By：
 * @version: $
 */
public class Buzzing implements AlarmListener {
    private String buzz;

    public Buzzing(String buzz) {
        this.buzz = buzz;
    }

    @Override
    public void handleAlarm(AlarmEntry entry) {
        System.err.println("11111111111");
        System.err.println(buzz);
    }
}
