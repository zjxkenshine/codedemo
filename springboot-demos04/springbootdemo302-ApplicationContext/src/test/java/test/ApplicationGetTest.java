package test;

import com.kenshine.applicationcontext.Demo302App;
import com.kenshine.applicationcontext.demo01.ContextGetDemo01;
import com.kenshine.applicationcontext.demo01.ContextGetDemo02;
import com.kenshine.applicationcontext.demo01.ContextGetDemo03;
import com.kenshine.applicationcontext.demo01.ContextGetDemo04;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 19:59
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo302App.class)
public class ApplicationGetTest {
    @Autowired
    ContextGetDemo01 contextGetDemo01;
    @Autowired
    ContextGetDemo02 contextGetDemo02;
    @Autowired
    ContextGetDemo03 contextGetDemo03;
    @Autowired
    ContextGetDemo04 contextGetDemo04;


    @Test
    public void test(){
        contextGetDemo01.show();
        contextGetDemo02.show();
        contextGetDemo03.show();
        contextGetDemo04.show();
    }
}
