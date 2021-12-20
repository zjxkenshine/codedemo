package com.kenshine.agrona.ringbuffer.one2one;

import org.agrona.concurrent.Agent;
import org.agrona.concurrent.AtomicBuffer;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:02
 * @description：生产者
 * @modified By：
 * @version: $
 */
public class SendAgent implements Agent {
    private final int sendCount;
    private final OneToOneRingBuffer ringBuffer;
    private int currentCountItem = 1;

    public SendAgent(final OneToOneRingBuffer ringBuffer, int sendCount) {
        this.ringBuffer = ringBuffer;
        this.sendCount = sendCount;
    }

    @Override
    public int doWork() {
        // 当达到发送上限时，不再发送
        if (currentCountItem > sendCount) {
            return 0;
        }

        // 通过 tryClaim 方式写入数据
        int claimIndex = ringBuffer.tryClaim(1, Integer.BYTES);
        if (claimIndex > 0) {
            currentCountItem += 1;
            final AtomicBuffer buffer = ringBuffer.buffer();
            buffer.putInt(claimIndex, currentCountItem);
            ringBuffer.commit(claimIndex);
        }
        return 0;
    }

    @Override
    public String roleName() {
        return "sender";
    }
}
