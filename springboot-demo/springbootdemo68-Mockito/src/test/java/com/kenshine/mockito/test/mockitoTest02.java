package com.kenshine.mockito.test;

import com.kenshine.mockito.domain.Person;
import com.kenshine.mockito.service.TimeMockTest;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.verification.Timeout;
import org.mockito.verification.VerificationMode;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 15:13
 * @description：函数操作
 * @modified By：
 * @version: $
 */
public class mockitoTest02 {

    /**
     * 暗中调用真实对象 spy
     */
    @Test
    public void test01(){
        List list = new LinkedList();
        List spy = spy(list);

        //也可以stub一些方法
        when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");
        System.out.println(spy.get(0));
        System.out.println(spy.size());
        //重置stub方法
        Mockito.reset(spy);
        System.out.println(spy.size());
        verify(spy).add("one");
        verify(spy).add("two");
    }


    /**
     * 改变默认返回值
     */
    @Test
    public void test02(){
        Person mock = mock(Person.class, Mockito.RETURNS_SMART_NULLS);
        Person mockTwo = mock(Person.class, new Answer<String>(){
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                return "kenshine";
            }
        });

        //默认返回kenshine
        System.out.println(mockTwo.getName());
        verify(mockTwo).getName();
    }


    /**
     * 捕获函数参数值
     * argument.capture()
     */
    @Test
    public void test03(){
        List mock = mock(List.class);
        List mock2 = mock(List.class);
        mock.add("John");
        mock2.add("Brian");
        mock2.add("Jim");

        ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);

        verify(mock).add(argument.capture());
        assertEquals("John", argument.getValue());

        verify(mock2, times(2)).add(argument.capture());

        assertEquals("Jim", argument.getValue());
        //多个mock使用同一个argument
        assertArrayEquals(new Object[]{"John","Brian","Jim"},argument.getAllValues().toArray());
    }



    /**
     * 部分Mock doCallRealMethod
     */
    @Test
    public void test04() throws Exception {
        Person person = mock(Person.class);
        //调用真实方法
        doCallRealMethod().when(person).setName("kenshine");
        doCallRealMethod().when(person).getName();

        person.setName("kenshine");
        System.out.println(person.getName());

        person.setName("aaa");
        System.out.println(person.getName());
    }


    /**
     * 重置mocks
     */
    @Test
    public void test05() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);

        System.out.println(mock.size());
        reset(mock);
        //从这开始，之前的交互和stub将全部失效
        System.out.println(mock.size());
    }

    /**
     * 序列化 很少使用
     */
    @Test
    public void test06() {
        List serializableMock = mock(List.class, withSettings().serializable());
    }

    /**
     * 超时判断
     */
    @Test
    public void test07(){
        TimeMockTest mock = mock(TimeMockTest.class);

        mock.someMethod();

        //测试程序将会在下面这句阻塞100毫秒，timeout的时候再进行验证是否执行过someMethod()
        verify(mock, timeout(100)).someMethod();
        //和上面代码等价
        verify(mock, timeout(100).times(1)).someMethod();

        //阻塞100ms，timeout的时候再验证是否刚好执行了2次
        verify(mock, timeout(100).times(2)).someMethod();

        //timeout的时候，验证至少执行了2次
        verify(mock, timeout(100).atLeast(2)).someMethod();

        //timeout时间后，用自定义的检验模式验证someMethod()
        VerificationMode yourOwnVerificationMode = new VerificationMode() {
            @Override
            public void verify(VerificationData data) {

            }
        };
        verify(mock, new Timeout(100, yourOwnVerificationMode)).someMethod();
    }

}
