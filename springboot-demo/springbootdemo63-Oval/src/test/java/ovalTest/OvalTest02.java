package ovalTest;

import com.kenshine.oval.entity.BusinessObject;
import com.kenshine.oval.entity.User2;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.configuration.annotation.BeanValidationAnnotationsConfigurer;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 8:47
 * @description：测试02
 * @modified By：
 * @version: $
 */
public class OvalTest02 {

    /**
     * 测试标准注解配置
     * BeanValidationAnnotationsConfigurer
     */
    @Test
    public void test01(){
        Validator validator = new Validator(new AnnotationsConfigurer(), new BeanValidationAnnotationsConfigurer());

        User2 entity = new User2();

        entity.setId("12345"); // violation - the max length is 4
        entity.setDescr(null); // violation - cannot be null
        entity.setParent(null); // violation - cannot be null

        // collect the constraint violations
        List<ConstraintViolation> violations = validator.validate(entity);
        System.out.println(violations);
    }

    /**
     * aspectj使lombok失效
     * https://blog.csdn.net/zq1994520/article/details/108095574
     *
     * TODO 没有效果，官方只有Eclipse插件的代码 待补充Oval整合AspectJ
     */
    @Test
    public void test02(){
        //throws a ConstraintsViolatedException because parameter name is null
        BusinessObject object = new BusinessObject(null);
        object.setName(null);
    }


}
