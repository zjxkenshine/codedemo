package test;

import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 9:41
 * @description：依赖测试
 * @modified By：
 * @version: $
 */
public class Test04DependencyCase {
    @Test
    public void test1(){
        System.out.println("test1 run");
    }

    //硬依赖测试
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }

    @Test
    public void test3(){
        System.out.println("test3 run");
        throw new RuntimeException();
    }

    //硬依赖测试，会跳过
    @Test(dependsOnMethods = {"test3"})
    public void test4(){
        System.out.println("test4 run");
    }

    @Test
    public void test5(){
        System.out.println("test5 run");
        throw new RuntimeException();
    }

    //软依赖测试
    @Test(dependsOnMethods = {"test5"}, alwaysRun=true)
    public void test6(){
        System.out.println("test6 run");
    }
}
