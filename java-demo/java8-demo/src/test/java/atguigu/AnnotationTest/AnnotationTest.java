package atguigu.AnnotationTest;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 19:46
 * @description：重复注解测试
 * @modified By：
 * @version: $
 */
public class AnnotationTest {

    //重复注解
    @Test
    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void test01() throws NoSuchMethodException {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method test01 = clazz.getMethod("test01");
        MyAnnotation[] mas = test01.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma : mas) {
            System.out.println(ma.value());
        }
    }

}
