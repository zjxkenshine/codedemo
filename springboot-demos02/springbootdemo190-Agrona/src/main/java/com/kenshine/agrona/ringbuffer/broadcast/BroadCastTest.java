package com.kenshine.agrona.ringbuffer.broadcast;

import lombok.extern.slf4j.Slf4j;
import org.agrona.concurrent.*;

import java.nio.ByteBuffer;
import static org.agrona.concurrent.broadcast.BroadcastBufferDescriptor.TRAILER_LENGTH;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 11:24
 * @description：测试广播
 * @modified By：
 * @version: $
 */
@Slf4j
public class BroadCastTest {
    public static void main(String[] args) {
        final int sendCount = 1000;
        final int bufferLength = 65536 + TRAILER_LENGTH;
        final UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(bufferLength));
        //空闲策略
        final IdleStrategy idleStrategySend = new SleepingMillisIdleStrategy();
        final IdleStrategy idleStrategyReceive2 = new BusySpinIdleStrategy();
        final IdleStrategy idleStrategyReceive1 = new BusySpinIdleStrategy();
        final ShutdownSignalBarrier barrier = new ShutdownSignalBarrier();

        //创建agent
        final ReceiveAgent receiveAgent1 = new ReceiveAgent(unsafeBuffer, "receiveAgent1");
        final ReceiveAgent receiveAgent2 = new ReceiveAgent(unsafeBuffer, "receiveAgent2");
        final SendAgent sendAgent = new SendAgent(unsafeBuffer, barrier, sendCount);

        //创建agent runner
        final AgentRunner sendAgentRunner = new AgentRunner(idleStrategySend,
                Throwable::printStackTrace, null, sendAgent);
        final AgentRunner receiveAgentRunner1 = new AgentRunner(idleStrategyReceive1,
                Throwable::printStackTrace, null, receiveAgent1);
        final AgentRunner receiveAgentRunner2 = new AgentRunner(idleStrategyReceive2,
                Throwable::printStackTrace, null, receiveAgent2);

        log.info("starting");

        //运行线程
        AgentRunner.startOnThread(sendAgentRunner);
        AgentRunner.startOnThread(receiveAgentRunner1);
        AgentRunner.startOnThread(receiveAgentRunner2);

        //等待接收完毕
        barrier.await();

        //关闭
        receiveAgentRunner1.close();
        sendAgentRunner.close();
        receiveAgentRunner2.close();
    }
}
