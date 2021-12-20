package com.kenshine.agrona.ringbuffer.one2one;

import lombok.extern.slf4j.Slf4j;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:01
 * @description：消费者Agent
 * @modified By：
 * @version: $
 */
@Slf4j
public class ReceiveAgent implements Agent{
    private final ShutdownSignalBarrier barrier;
    private final OneToOneRingBuffer ringBuffer;
    private final int sendCount;

    public ReceiveAgent(final OneToOneRingBuffer ringBuffer, ShutdownSignalBarrier barrier, int sendCount) {
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

        if (lastValue == sendCount) {
            log.info("received: {}", lastValue);
            // 达到消息上限时，通知 barrier
            barrier.signal();
        }
    }

    @Override
    public String roleName() {
        return "receiver";
    }
}
