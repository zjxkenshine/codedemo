package com.kenshine.agrona.ringbuffer.many2one;

import lombok.extern.slf4j.Slf4j;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.ringbuffer.ManyToOneRingBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:12
 * @description：消费者线程
 * @modified By：
 * @version: $
 */
@Slf4j
public class ReceiveAgent implements Agent {
    private final ShutdownSignalBarrier barrier;
    private final ManyToOneRingBuffer ringBuffer;
    private final int sendCount;

    public ReceiveAgent(final ManyToOneRingBuffer ringBuffer, ShutdownSignalBarrier barrier, int sendCount) {
        this.ringBuffer = ringBuffer;
        this.barrier = barrier;
        this.sendCount = sendCount;
    }

    @Override
    public int doWork() throws Exception {
        ringBuffer.read(this::handler);
        return 0;
    }

    private void handler(int messageType, DirectBuffer buffer, int offset, int length) {
        final int lastValue = buffer.getInt(offset);

        log.info("received, type: {}, msg: {}", messageType, lastValue);

        if (lastValue == sendCount * 2) {
            log.info("received: " + lastValue);
            barrier.signal();
        }
    }

    @Override
    public String roleName() {
        return "receiver";
    }
}
