package ovalTest;

import com.kenshine.oval.entity.User;
import com.kenshine.oval.entity.User3;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 9:59
 * @description：自定义注解测试
 * @modified By：
 * @version: $
 */
public class OvalTest03 {

    @Test
    public void testCPast(){
        Validator validator = new Validator();
        User3 user = new User3();
        //格式错误
        user.setDate("2020-xxxx-26");
        //必须为大写
        user.setName("kenshine");
        List<ConstraintViolation> message = validator.validate(user);
        System.out.println(message);
    }

}
