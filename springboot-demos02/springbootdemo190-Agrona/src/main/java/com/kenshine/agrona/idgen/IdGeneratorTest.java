package com.kenshine.agrona.idgen;

import org.agrona.concurrent.IdGenerator;
import org.agrona.concurrent.SnowflakeIdGenerator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 14:14
 * @description：IdGenerator测试
 * @modified By：
 * @version: $
 */
public class IdGeneratorTest {
    public static void main(String[] args) {
        long nodeId = 1L;
        IdGenerator idGenerator = new SnowflakeIdGenerator(nodeId);

        for(int i=0;i<10;i++){
            long nextId = idGenerator.nextId();
            System.out.println(nextId);
        }
    }
}
