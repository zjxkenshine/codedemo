package agrona;

import com.kenshine.agrona.agent.MyAgent;
import com.kenshine.agrona.agent.MyErrorHandler;
import com.kenshine.agrona.agent.MyIdleStrategy;
import org.agrona.ErrorHandler;
import org.agrona.concurrent.AgentRunner;
import org.agrona.concurrent.AtomicBuffer;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.concurrent.status.AtomicCounter;
import org.agrona.concurrent.status.CountersManager;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 9:42
 * @description：测试Agent代理
 * @modified By：
 * @version: $
 */
public class AgentTest {

    /**
     * 测试AgentRunner
     */
    @Test
    public void test01_AgentRunner(){
        IdleStrategy myIdleStrategy = new MyIdleStrategy();
        ErrorHandler myErrorHandler = new MyErrorHandler();

        //AtomicBuffer用于支持AtomicCounter 20kb
        AtomicBuffer atomicBuffer = new UnsafeBuffer(new byte[20*1024]);
        //可跨线程和进程读取的原子计数器 还可以传递一个CountersManager
        AtomicCounter atomicCounter = new AtomicCounter(atomicBuffer,1);
        AgentRunner agentRunner = new AgentRunner(myIdleStrategy,myErrorHandler,atomicCounter,new MyAgent());
        //启动一个线程执行
        AgentRunner.startOnThread(agentRunner);
    }
}
