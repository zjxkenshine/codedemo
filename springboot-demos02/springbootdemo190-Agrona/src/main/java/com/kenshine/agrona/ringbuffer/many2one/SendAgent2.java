package com.kenshine.agrona.ringbuffer.many2one;

import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.AtomicBuffer;
import org.agrona.concurrent.ringbuffer.ManyToOneRingBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:14
 * @description：生产者线程2
 * @modified By：
 * @version: $
 */
@Slf4j
public class SendAgent2 implements Agent {
    private final int sendCount;
    private final ManyToOneRingBuffer ringBuffer;
    private int currentCountItem = 1;

    public SendAgent2(final ManyToOneRingBuffer ringBuffer, int sendCount) {
        this.ringBuffer = ringBuffer;
        this.sendCount = sendCount;
    }

    @Override
    public int doWork() {
        if (currentCountItem > sendCount) {
            return 0;
        }

        int claimIndex = ringBuffer.tryClaim(2, Integer.BYTES);
        if (claimIndex > 0) {
            currentCountItem += 1;
            final AtomicBuffer buffer = ringBuffer.buffer();
            buffer.putInt(claimIndex, currentCountItem + sendCount);
            ringBuffer.commit(claimIndex);
        }
        return 0;
    }

    @Override
    public String roleName() {
        return "sender2";
    }

}
