package com.kenshine.hugecollections;

import net.openhft.collections.HugeConfig;
import net.openhft.collections.HugeHashMap;

/**
 * @author by kenshine
 * @Classname HugecollectionsTest
 * @Description 测试添加获取并删除1亿个键，不会出现gc
 * @Date 2023-11-02 12:20
 * @modified By：
 * @version: 1.0$
 */
public class HugecollectionsTest {

    public static void main(String[] args) {
        //int count =1000000;
        int count =1000000;
        HugeConfig config = HugeConfig.DEFAULT.clone()
                .setSegments(128)
                .setSmallEntrySize(128)
                .setCapacity(count);

        // HugeHashMap
        final HugeHashMap<CharSequence, SampleValues> map =
                new HugeHashMap<>(config, CharSequence.class, SampleValues.class);

        final SampleValues value = new SampleValues();

        for (int i = 0; i < count; i++) {
            value.ee = i;
            value.gg = i;
            value.ii = i;
            map.put(users( i), value);
        }
        for (int i = 0; i < count; i++) {
            System.out.println(users(i));
            System.out.println(map.get(users(i)));
        }
        for (int i = 0; i < count; i++){
            map.remove(users(i));
        }

    }

    private static CharSequence users(int i) {
        return String.valueOf(i);
    }
}
