package com.kenshine.mockito.test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 14:21
 * @description：mockito使用测试
 * @modified By：
 * @version: $
 *
 * Mockito使用示例
 */
public class mockitoTest01 {

    @Mock
    private List list;
    @Mock
    private Map<String,Object> map;


    /**
     * 模拟对象
     */
    @Test
    public void test01(){
        // 模拟LinkedList 的一个对象
        LinkedList mockedList = mock(LinkedList.class);
        // 此时调用get方法，会返回null，因为还没有对方法调用的返回值做模拟
        System.out.println(mockedList.get(0));
    }

    /**
     * 模拟方法调用的返回值
     */
    @Test
    public void test02(){
        // 模拟LinkedList 的一个对象
        LinkedList mockedList = mock(LinkedList.class);
        // 模拟获取第一个元素时，返回字符串first。  给特定的方法调用返回固定值在官方说法中称为stub。
        when(mockedList.get(0)).thenReturn("first");
        // 此时打印输出first
        System.out.println(mockedList.get(0));
    }


    /**
     * 模拟方法调用抛出异常
     */
    @Test
    public void test03(){
        // 模拟LinkedList 的一个对象
        LinkedList mockedList = mock(LinkedList.class);
        // 模拟获取第二个元素时，抛出RuntimeException
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        // 此时将会抛出RuntimeException
        System.out.println(mockedList.get(1));
        //返回值类型
        doThrow(new RuntimeException("clear exception")).when(mockedList).clear();
        mockedList.clear();
    }

    /**
     * 模拟调用方法时的参数匹配
     */
    @Test
    public void test04(){
        // 模拟LinkedList 的一个对象
        LinkedList mockedList = mock(LinkedList.class);
        // anyInt()匹配任何int参数，这意味着参数为任意值，其返回值均是element
        when(mockedList.get(anyInt())).thenReturn("element");
        // 此时打印是element
        System.out.println(mockedList.get(999));
    }

    /**
     * 模拟方法调用次数
     */
    @Test
    public void test05(){
        // 模拟LinkedList 的一个对象
        LinkedList mockedList = mock(LinkedList.class);
        // 调用add一次
        mockedList.add("once");
        // 下面两个写法验证效果一样，均验证add方法是否被调用了一次
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");
    }

    /**
     * 校验行为
     */
    @Test
    public void test06(){
        // mock creation
        List mockedList = mock(List.class);
        // using mock object
        mockedList.add("one");
        mockedList.clear();
        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 模拟方法调用(Stubbing)
     */
    @Test
    public void test07(){
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //following prints "first"
        System.out.println(mockedList.get(0));
        //following throws runtime exception
        System.out.println(mockedList.get(1));
        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    /**
     * 参数匹配
     */
    @Test
    public void test08(){
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");
        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains(Matchers.eq("aaa"))).thenReturn(false);
        //following prints "element"
        System.out.println(mockedList.get(999));
        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());
        //false
        System.out.println(mockedList.contains("aaa"));
        verify(mockedList).contains("aaa");
    }

    /**
     * 校验方法调用次数
     */
    @Test
    public void test09(){
        LinkedList mockedList = mock(LinkedList.class);
        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");
        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");
        //never
        verify(mockedList, never()).add("never happened");
        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        //至少调用两次 add("five times")
        verify(mockedList, atLeast(2)).add("five times");
        verify(mockedList, atMost(5)).add("three times");
    }

    /**
     * 模拟无返回方法抛出异常
     */
    @Test
    public void test10(){
        LinkedList mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        //following throws RuntimeException:
        mockedList.clear();
    }

    /**
     *校验方法调用顺序
     */
    @Test
    public void test11(){
        List singleMock = mock(List.class);
        singleMock.add("was added first");
        singleMock.add("was added second");
        InOrder inOrder = inOrder(singleMock);
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");



        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        firstMock.add("was called first");
        secondMock.add("was called second");
        InOrder inOrder2 = inOrder(firstMock, secondMock);
        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(secondMock).add("was called second");
    }


    /**
     * 校验方法是否从未调用
     */
    @Test
    public void test12(){
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);

        mockOne.add("one");
        verify(mockOne).add("one");
        verify(mockOne, never()).add("two");
        verifyZeroInteractions(mockTwo, mockThree);
    }

    /**
     *快速创建Mock对象
     */
    //@BeforeEach
    public void test13(){
        //配合@Mock注解快速初始化
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 自定义返回不同结果
     */
    @Test
    public void test14(){
        LinkedList mock = mock(LinkedList.class);
        when(mock.get(1))
                .thenReturn("first")  // 第一次返回结果
                .thenReturn("second") // 第二次会返回这个结果
                .thenThrow(new RuntimeException());  //抛出异常


        System.out.println(mock.get(1)); // 第一次
        System.out.println(mock.get(1)); // 第二次
        System.out.println(mock.get(1)); // 第n次(n> 2)，依旧以最后返回最后一个配置
    }


    /**
     * 对返回结果进行拦截
     */
    @Test
    public void test15(){
        LinkedList mock = mock(LinkedList.class);
        when(mock.get(anyInt())).thenAnswer((Answer) invocation -> {
            Object[] args = invocation.getArguments();
            return "called with arguments: " + args[0];
        });

        System.out.println(mock.get(1));
    }


}
