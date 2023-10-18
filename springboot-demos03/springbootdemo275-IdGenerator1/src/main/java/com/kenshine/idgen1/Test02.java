package com.kenshine.idgen1;

import com.wujunshen.core.service.SnowflakeIdWorker;
import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 雪花算法id生成
 * @Date 2023-10-18 14:50
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {
    Logger logger = LoggerFactory.getLogger(Test02.class);

    private Set<Long> set;

    @Before
    public void setUp() {
        set = new HashSet<>();
    }

    @After
    public void tearDown() {
        set = null;
    }

    @Test
    public void test() {
        List<SnowflakeIdWorker> snowflakeIdWorkers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                //i:机器id,j:数据中心id
                SnowflakeIdWorker idWorker = new SnowflakeIdWorker(i, j);
                snowflakeIdWorkers.add(idWorker);
            }
        }

        // 32*32 个线程
        for (SnowflakeIdWorker snowflakeIdWorker : snowflakeIdWorkers) {
            IdWorkThread idWorkThread = new IdWorkThread(set, snowflakeIdWorker);
            Thread t = new Thread(idWorkThread);
            t.setDaemon(true);
            t.start();
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 压测
    @Test
    public void stressTest() throws Exception {
        loop(50000000);
        loop(50000000);
        loop(50000000);
    }

    private void loop(int idNum) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < idNum; i++) {
            long id = idWorker.nextId();
        }
        long duration = System.currentTimeMillis() - start;
        logger.info("total time:{}ms,speed is:{}/ms", duration, idNum / duration);
    }


    @AllArgsConstructor
    public class IdWorkThread implements Runnable {
        private Set<Long> set;
        private SnowflakeIdWorker snowflakeIdWorker;

        @Override
        public void run() {
            while (true) {
                long id = snowflakeIdWorker.nextId();
                logger.info("{}", id);
                if (!set.add(id)) {
                    logger.info("duplicate:{}", id);
                }
            }
        }
    }
}
