package test;

import base.BaseCase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 8:55
 * @description：测试2
 * @modified By：
 * @version: $
 */
public class Test02Case{

    @BeforeClass
    public void testBefore() throws Exception{
        System.out.println("this is before class");
    }

    @Test
    public void test001() throws Exception{
        System.out.println("this is TestNG test case");
    }


    @Test(enabled = false)
    public void test002() throws Exception{
        System.out.println("忽略这个用例");
    }

    /**
     * 分组测试
     */
    @Test(groups = "group1")
    public void test003() throws Exception{
        System.out.println("一组用例");
    }


    @Test(groups = "group2")
    public void test004() throws Exception{
        System.out.println("二组用例");
    }

    @AfterClass
    public void testAfter() throws Exception{
        System.out.println("this is after class");
    }
}
