package com.kenshine.agrona.ringbuffer.broadcast;

import lombok.extern.slf4j.Slf4j;
import org.agrona.ExpandableArrayBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.AtomicBuffer;
import org.agrona.concurrent.ShutdownSignalBarrier;
import org.agrona.concurrent.broadcast.BroadcastTransmitter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:23
 * @description：发送方
 * @modified By：
 * @version: $
 */
@Slf4j
public class SendAgent implements Agent {
    private final ShutdownSignalBarrier barrier;
    private final int sendCount;
    private final BroadcastTransmitter transmitter;
    private int lastSend;
    private boolean completed;

    private final MutableDirectBuffer msgBuffer = new ExpandableArrayBuffer();

    public SendAgent(final AtomicBuffer buffer, ShutdownSignalBarrier barrier, int sendCount) {
        this.barrier = barrier;
        this.sendCount = sendCount;
        this.transmitter = new BroadcastTransmitter(buffer);
        this.lastSend = 0;
        this.completed = false;
    }

    @Override
    public int doWork() {
        if (completed) {
            return 0;
        }

        if (lastSend == sendCount) {
            log.info("completed send: {}", lastSend);
            barrier.signal();
            completed = true;
            return 0;
        }

        msgBuffer.putInt(0, lastSend);
        transmitter.transmit(1, msgBuffer, 0, Integer.BYTES);

        lastSend++;

        return 0;
    }

    @Override
    public String roleName() {
        return "sender";
    }
}
