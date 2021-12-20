package com.kenshine.agrona.ringbuffer.one2one;

import com.kenshine.agrona.agent.MyErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.*;
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer;
import org.agrona.concurrent.ringbuffer.RingBufferDescriptor;

import java.nio.ByteBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:09
 * @description：一对一消息测试
 * @modified By：
 * @version: $
 */
@Slf4j
public class One2OneTest {

    public static void main(String[] args) {
        final int sendCount = 18_000_000;
        final int bufferLength = 16384 + RingBufferDescriptor.TRAILER_LENGTH;

        // 构造 ringBuffer
        final UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(bufferLength));
        final OneToOneRingBuffer ringBuffer = new OneToOneRingBuffer(unsafeBuffer);

        // 空闲策略
        final IdleStrategy idleStrategySend = new BusySpinIdleStrategy();
        final IdleStrategy idleStrategyReceive = new BusySpinIdleStrategy();

        // 屏障控制
        final ShutdownSignalBarrier barrier = new ShutdownSignalBarrier();

        // 构造 Agent
        final SendAgent sendAgent = new SendAgent(ringBuffer, sendCount);
        final ReceiveAgent receiveAgent = new ReceiveAgent(ringBuffer, barrier, sendCount);

        // 构造 AgentRunner
        final AgentRunner sendAgentRunner = new AgentRunner(idleStrategySend, new MyErrorHandler(), null, sendAgent);
        final AgentRunner receiveAgentRunner = new AgentRunner(idleStrategyReceive, new MyErrorHandler(), null, receiveAgent);

        // 启动 Agent
        log.info("starting agent...");
        AgentRunner.startOnThread(sendAgentRunner);
        AgentRunner.startOnThread(receiveAgentRunner);

        //等待最后一条消息被消费完毕
        barrier.await();

        // 关闭资源
        receiveAgentRunner.close();
        sendAgentRunner.close();
    }
}
