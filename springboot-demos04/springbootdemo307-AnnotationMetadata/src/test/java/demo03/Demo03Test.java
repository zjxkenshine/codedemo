package demo03;

import com.kenshine.metadata.demo03.HandlerContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 11:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo03Test extends BaseTest{
    @Autowired
    HandlerContext handlerContext;

    @org.junit.Test
    public void test(){
        handlerContext.getInstance("risk1").handle("test");
    }
}
