package com.kenshine.hazelcast.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/24 8:51
 * @description：Hazelcast配置
 * @modified By：
 * @version: $
 */
@Configuration
public class HazelcastConfiguration {

    @Bean
    public Config hazelCastConfig() {
        Config config = new Config();
        //解决同网段下，不同库项目
        GroupConfig gc=new GroupConfig("hazelGroup");
        config.setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig()
                        .setName("configuration")
                        // Map中存储条目的最大值[0~Integer.MAX_VALUE]。默认值为0。
                        .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                        /**数据释放策略[NONE|LRU|LFU]。这是Map作为缓存的一个参数，用于指定数据的回收算法。默认为NONE。LRU：“最近最少使用“策略。
                         * NONE：当设置为NONE时，不会发生数据回收，同时max-size会失效。但是任然可以使用time-to-live-seconds和max-idle-seconds参数来控制数据留存时间。
                         * LRU：“最近最少使用“策略。
                         * LFU：“最不常用的使用”策略。
                         */
                        .setEvictionPolicy(EvictionPolicy.LRU)
                        //数据留存时间[0~Integer.MAX_VALUE]。缓存相关参数，单位秒，默认为0。
                        .setTimeToLiveSeconds(-1))
                .setGroupConfig(gc);
        return config;
    }

}
