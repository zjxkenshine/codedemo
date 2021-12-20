package com.kenshine.agrona.ringbuffer.many2one;

import com.kenshine.agrona.agent.MyErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.*;
import org.agrona.concurrent.ringbuffer.ManyToOneRingBuffer;
import org.agrona.concurrent.ringbuffer.RingBufferDescriptor;

import java.nio.ByteBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:19
 * @description：测试
 * @modified By：
 * @version: $
 */
@Slf4j
public class Many2OneTest {
    public static void main(String[] args) {
        final int sendCount = 100;
        final int bufferLength = 16384 + RingBufferDescriptor.TRAILER_LENGTH;

        // 构造 ringBuffer
        final UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(bufferLength));
        final ManyToOneRingBuffer ringBuffer = new ManyToOneRingBuffer(unsafeBuffer);

        // 空闲策略
        final IdleStrategy idleStrategySend1 = new BusySpinIdleStrategy();
        final IdleStrategy idleStrategySend2 = new BusySpinIdleStrategy();
        final IdleStrategy idleStrategyReceive = new BusySpinIdleStrategy();

        // 屏障控制
        final ShutdownSignalBarrier barrier = new ShutdownSignalBarrier();

        // 构造 Agent
        final SendAgent1 sendAgent1 = new SendAgent1(ringBuffer, sendCount);
        final SendAgent2 sendAgent2 = new SendAgent2(ringBuffer, sendCount);
        final ReceiveAgent receiveAgent = new ReceiveAgent(ringBuffer, barrier, sendCount);

        // 构造 AgentRunner
        final AgentRunner sendAgentRunner1 = new AgentRunner(idleStrategySend1, new MyErrorHandler(), null, sendAgent1);
        final AgentRunner sendAgentRunner2 = new AgentRunner(idleStrategySend2, new MyErrorHandler(), null, sendAgent2);
        final AgentRunner receiveAgentRunner = new AgentRunner(idleStrategyReceive, new MyErrorHandler(), null, receiveAgent);

        // 启动 Agent
        log.info("starting agent...");
        AgentRunner.startOnThread(sendAgentRunner1);
        AgentRunner.startOnThread(sendAgentRunner2);
        AgentRunner.startOnThread(receiveAgentRunner);

        // 等待最后一条消息被消费完毕
        barrier.await();

        // 关闭资源
        receiveAgentRunner.close();
        sendAgentRunner1.close();
        sendAgentRunner2.close();
    }
}
