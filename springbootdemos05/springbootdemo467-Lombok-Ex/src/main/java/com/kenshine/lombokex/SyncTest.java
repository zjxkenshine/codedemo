package com.kenshine.lombokex;

import com.github.houbb.lombok.ex.annotation.Sync;

/**
 * @author by kenshine
 * @Classname SyncTest
 * @Description 测试@Sync
 * @Date 2023-11-09 8:36
 * @modified By：
 * @version: 1.0$
 */
public class SyncTest {
    @Sync
    public void syncTest() {
        System.out.println("sync");
    }
}
