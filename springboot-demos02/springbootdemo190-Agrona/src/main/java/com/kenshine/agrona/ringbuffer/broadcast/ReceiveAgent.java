package com.kenshine.agrona.ringbuffer.broadcast;

import lombok.extern.slf4j.Slf4j;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.AtomicBuffer;
import org.agrona.concurrent.MessageHandler;
import org.agrona.concurrent.broadcast.BroadcastReceiver;
import org.agrona.concurrent.broadcast.CopyBroadcastReceiver;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:22
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
public class ReceiveAgent implements Agent, MessageHandler {
    private final String name;
    private final CopyBroadcastReceiver copyBroadcastReceiver;

    public ReceiveAgent(final AtomicBuffer atomicBuffer, final String name) {
        this.name = name;
        this.copyBroadcastReceiver = new CopyBroadcastReceiver(new BroadcastReceiver(atomicBuffer));
    }

    @Override
    public int doWork() {
        copyBroadcastReceiver.receive(this);
        return 0;
    }

    @Override
    public String roleName() {
        return name;
    }

    @Override
    public void onMessage(int msgTypeId, MutableDirectBuffer buffer, int index, int length) {
        log.info("Received {}", buffer.getInt(index));
    }
}
