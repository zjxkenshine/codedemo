package drools;

import com.kenshine.drools.demo01.entity.Student;
import com.kenshine.drools.demo01.service.UserService;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 16:54
 * @description：高级语法测试
 * @modified By：
 * @version: $
 */
public class DroolsTest03 {

    /**
     * 全局变量测试
     */
    @Test
    public void testGlobal(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        //设置全局变量，名称和类型必须和规则文件中定义的全局变量名称对应
        kieSession.setGlobal("userService",new UserService());
        kieSession.setGlobal("count",5);
        List list = new ArrayList();//size为0
        kieSession.setGlobal("gList",list);

        kieSession.fireAllRules();
        kieSession.dispose();

        //因为在规则中为全局变量添加了两个元素，所以现在的size为2
        System.out.println(list.size());
    }


    /**
     * 测试query
     */
    @Test
    public void testQuery(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge(12);

        Student student2 = new Student();
        student2.setName("李四");
        student2.setAge(8);

        Student student3 = new Student();
        student3.setName("王五");
        student3.setAge(22);

        //将对象插入Working Memory中
        kieSession.insert(student1);
        kieSession.insert(student2);
        kieSession.insert(student3);

        //调用规则文件中的查询
        QueryResults results1 = kieSession.getQueryResults("query_1");
        int size = results1.size();
        System.out.println("size=" + size);
        for (QueryResultsRow row : results1) {
            Student student = (Student) row.get("$student");
            System.out.println(student);
        }

        //调用规则文件中的查询
        QueryResults results2 = kieSession.getQueryResults("query_2","王五");
        size = results2.size();
        System.out.println("size=" + size);
        for (QueryResultsRow row : results2) {
            Student student = (Student) row.get("$student");
            System.out.println(student);
        }
        //kieSession.fireAllRules();
        kieSession.dispose();
    }

    /**
     * function测试
     * 有问题
     */
    @Test
    public void testFunction(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Student student = new Student();
        student.setName("小明");
        student.setAge(10);
        kieSession.insert(student);

        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
