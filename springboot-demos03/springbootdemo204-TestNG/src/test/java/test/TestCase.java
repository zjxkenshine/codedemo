package test;

import base.BaseCase;
import com.kenshine.testng.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 8:36
 * @description：
 * @modified By：
 * @version: $
 */
public class TestCase extends BaseCase {
    @Autowired
    private ITestService iTestService;

    /**
     * 注意这个不是Junit的Test
     */
    @Test
    public void test01(){
        System.out.println(iTestService.test01());
    }

}
