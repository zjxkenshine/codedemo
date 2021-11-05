package ovalTest;

import com.kenshine.oval.entity.User;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 23:29
 * @description：Oval三种校验
 * @modified By：
 * @version: $
 */
public class OvalTest01 {

    /**
     * 完全校验
     */
    @Test
    public void test01(){
        Validator validator = new Validator();
        User user = new User().setUserName("a").setLoginName("b");
        List<ConstraintViolation> message = validator.validate(user);//完全验证

        System.out.println(message);
        System.out.println(message.get(0).getMessage());
    }

    /**
     * 分组校验
     */
    @Test
    public void test02(){
        Validator validator = new Validator();
        User user = new User().setUserName("a").setLoginName("b");
        //可以指定多个profile
        List<ConstraintViolation> message = validator.validate(user, "p1");
        System.out.println(message);
    }

    /**
     * 单字段校验
     */
    @Test
    public void test03() throws NoSuchFieldException {
        Validator validator = new Validator();
        User user = new User().setUserName("a").setLoginName("b");
        //仅校验userName字段
        List<ConstraintViolation> message = validator.validateFieldValue(user,user.getClass().getDeclaredField("userName"),user.getUserName());
        System.out.println(message);
    }

}
