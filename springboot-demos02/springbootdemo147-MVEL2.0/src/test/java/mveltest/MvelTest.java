package mveltest;

import com.kenshine.mvel.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 15:55
 * @description：Mvel使用测试
 * @modified By：
 * @version: $
 * https://www.cnblogs.com/cg14/p/11870882.html
 * 1. 基本表达式解析
 * 2. 变量空值判断
 * 3. 字段映射
 * 4. 对象属性赋值
 * 5. 值计算并返回，无需return关键字
 * 6. null 和nil 都表示空
 * 7. 两种解析表达式的方式
 * 8. 基本计算 map工厂方式
 * 9. 空安全运算符user.?parent.name
 * 10. 集合遍历
 * 11. 拆分字符串为字符数组
 * 12. If-Then-Else
 * 13. 三元运算符
 * 14. Foreach
 * 15. for
 * 16. MVEL对列表、数组、map的操作
 * 17. Do While
 * 18. Do Until
 * 19. While
 * 20. until
 * 21,22. 投影
 * 23,24. 过滤投影
 * 25. 导入调用简单hello函数 从el文件
 * 26. Lambda匿名函数
 *
 */
public class MvelTest {

    /**
     * 基本表达式解析
     */
    @Test
    public void test01_Base() {
        String expression = "foobar > 99";
        Map vars = new HashMap();
        //给foobar赋值为100
        vars.put("foobar", new Integer(100));
        Boolean result = (Boolean) MVEL.eval(expression, vars);
        if (result.booleanValue()) {
            System.out.println("表达式解析正确!");
        }
    }

    /**
     * 变量空值判断
     */
    @Test
    public void test02_Empty(){
        String expression = "a == empty && b == empty";
        Map paramMap = new HashMap<>();
        paramMap.put("a", "");
        paramMap.put("b", null);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object); // true
    }

    /**
     * 字段映射
     */
    @Test
    public void test03_mapping(){
        HashMap<Object, Object> srcMap = new HashMap<>();
        srcMap.put("name","ksnehine");
        srcMap.put("age",24);
        srcMap.put("sex","男");
        //字段映射关系
        HashMap<String, String> mapping = new HashMap<>();
        mapping.put("name","name");
        mapping.put("age","age");
        //这里先把当前年份写死为2021
        mapping.put("birthYear","2021-age");
        //目标对象
        HashMap<Object, Object> targetMap = new HashMap<>();
        //k为目标表字段，v为转换规则
        mapping.forEach((k,v)->{
            Object reValue = MVEL.eval(v,srcMap);
            System.out.println(v+":"+reValue);
            targetMap.put(k,reValue);
        });
        System.out.println("源对象"+srcMap);
        System.out.println("目标对象"+targetMap);
    }


    /**
     * 对象属性赋值
     */
    @Test
    public void test04_Get_Object_Properties(){
        User user = new User().setName("kenshine");
        String expression = "user.name = '123'";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user",user);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object);
    }

    /**
     * 值计算并返回，无需return关键字
     */
    @Test
    public void test05_Calculate_And_Return(){
        //计算b并返回
        String expression = " a = 10; b = (a = a * 2) + 10;b;";
        Map<String, Object> paramMap = new HashMap<>();
        //即便map没有任何内容 ,也需要传map 不然会报错
        Object object = MVEL.eval(expression,paramMap );
        System.out.println(object);
    }

    /**
     * null 和nil 都表示空
     */
    @Test
    public void test06_null_and_nil(){
        String expression = "a == null && b == nil";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a", null);
        paramMap.put("b", null);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object);
    }

    /**
     * 两种解析表达式的方式
     */
    @Test
    public void test07_Two_Use(){
        User foo = new User().setName("kenshine");
        Map context = new HashMap();
        String expression = "foo.name == 'test'";
        VariableResolverFactory functionFactory = new MapVariableResolverFactory(context);
        context.put("foo",foo);

        //解析表达式方式一 eval
        Boolean result = (Boolean) MVEL.eval(expression,functionFactory);
        System.out.println(result);

        //解析表达式方式二 executeExpression(compileExpression)
        Serializable compileExpression = MVEL.compileExpression(expression);
        result = (Boolean) MVEL.executeExpression(compileExpression, context, functionFactory);
        System.out.print(result);
    }

    /**
     * 基本计算 map工厂方式
     */
    @Test
    public void test08_Base_Compute_Use_MapFactory(){
        String exp = "a + b > c";
        Map varsMap = new HashMap();
        varsMap.put("a", 1); varsMap.put("b", 2);varsMap.put("c", 2);
        VariableResolverFactory factory = new MapVariableResolverFactory(varsMap);
        Object eval = MVEL.eval(exp, factory);
        System.out.println(eval);
    }

    /**
     * 空安全运算符user.?parent.name
     */
    @Test
    public void test09_Empty_Safe(){
        User user = new User();
        user.setName("kenshine");
        user.setAge(24);
        user.setParent(new User().setName("father"));
        //user 有一个parent属性 parent属性中有一个name属性
        String exp = "user.?parent.name";
        Map<String,Object> factory = new HashMap<>();
        factory.put("user",user);
//        VariableResolverFactory factory = new MapVariableResolverFactory();
        Object eval = MVEL.eval(exp, factory);
        //返回值为father
        Assert.assertEquals("father",eval);
    }

    /**
     * 集合遍历
     */
    @Test
    public void test10_Collection(){
        List<Integer> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        list.add(0);
        list.add(1);
        list.add(2);
        String exp = "list[0]";
        String exp2 = "map2.list";
        map2.put("list",list);
        map.put("list",list);
        map.put("map2",map2);
        Object eval = MVEL.eval(exp2,map);
        System.out.println(eval);
    }

    /**
     * Strings as Arrays
     * 拆分字符串为字符数组
     */
    @Test
    public void test11_Strings2Arrays(){
        String foo = "My String";
        String exp = "foo[0]";
        Map<String,Object> map = new HashMap<>();
        map.put("foo",foo);
        Object eval = MVEL.eval(exp,map);
        System.out.println(eval);
        Assert.assertEquals('M',eval);
    }

    /**
     * If-Then-Else
     * 条件判断
     */
    @Test
    public void test12_If_Then_Else(){
        //可以在MVEL表达式中调用Java方法
        String exp = "\n" +
                "if (a > 0) {\n" +
                "   System.out.println(\"比0大!\");\n" +
                "}\n" +
                "else if (a == -1) { \n" +
                "   System.out.println(\"等于-1!\");\n" +
                "}\n" +
                "else { \n" +
                "   System.out.println(\"其他值!\");\n" +
                "}\n";
        Map<String,Object> map = new HashMap<>();
        map.put("a",1);
        Object eval = MVEL.eval(exp,map);
    }

    /**
     *  三元运算符
     */
    @Test
    public void test13(){
        String expression = "num > 0 ? \"Yes\" : \"No\";";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("num", 2);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object);
    }

    /**
     * Foreach  它接受由冒号分隔的两个参数，第一个是当前元素的局部变量，
     * 第二个是要迭代的集合或数组。
     * MVEL1这里会有bug
     */
    @Test
    public void test14_Foreach(){
        List<String> people = new ArrayList<>();
        people.add("name");
        people.add("kenshine");
        people.add("qin");
        String expression = "count = 0;\n" +
                "foreach (name : people) {\n" +
                "   System.out.println(\"Person #\" + count + \":\" + name);\n" +
                "   count++;\n" +
                "};" +
                "count;";   //返回count
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("people", people);
        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object);

        String exp2 = "str = \"ABCDEFGHIJKLMNOPQRSTUVWXYZ\";\n" +
                " \n" +
                "foreach (el : str) {\n" +
                "   System.out.print(\"[\"+ el + \"]\"); \n" +
                "}";
        MVEL.eval(exp2,paramMap);
    }

    /**
     * MVEL 2.0，使用for关键字简单地简化foreach
     */
    @Test
    public void test15_For(){
        String expression ="['Jim','Bob','Tom']";
        List<String> l =(List<String>) MVEL.eval(expression);
        for(String str:l){
            System.out.println(str);
        }

        String exp = "count = 0;\n" +
                "for (name : l) {\n" +
                "   count++;\n" +
                "   System.out.println(\"l #\" + count + \":\" + name);\n" +
                "}";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("l",l);
        MVEL.eval(exp,paramMap);
    }

    /**
     * MVEL对列表、数组、map的操作
     */
    @Test
    public void test16_Array_List_Operate(){
        //list
        String expression ="['Jim','Bob','Tom']";
        List<String> l =(List<String>) MVEL.eval(expression);
        for(String str:l){
            System.out.println("list: "+str);
        }

        //数组
        String exp2 = "{'Jim','Bob','Tom'}";
        Object str = MVEL.eval(exp2);
        if(str.getClass().isArray()){
            System.out.println("array: "+String.valueOf(Array.get(str, 0)));
        }

        //map
        String exp3 ="['Kenshine' : new com.kenshine.mvel.entity.User().setName('kenshine'), 'Qin' : new com.kenshine.mvel.entity.User().setName('qin')]";
        Map o = (Map)MVEL.eval(exp3);
        User u = (User) o.get("Kenshine");
        System.out.println("map: "+u.getName());
    }

    /**
     * Do While
     */
    @Test
    public void test17_Do_While(){
        String exp3 = "do { \n" +
                "  System.out.println(\"当符合while中条件就执行:\"+x);\n" +
                " --x } \n" +
                "while (x >= 5 );";
        Map<String,Object> map = new HashMap<>();
        map.put("x",10);
        MVEL.eval(exp3,map);
    }

    /**
     * Do Until
     */
    @Test
    public void test18_Do_Until(){
        String exp3 = "do { \n" +
                "  System.out.println(\"当不符合while中条件就执行:\"+x);\n" +
                " --x } \n" +
                "until  (x < 5 );";
        Map<String,Object> map = new HashMap<>();
        map.put("x",10);
        MVEL.eval(exp3,map);
    }

    /**
     * While
     */
    @Test
    public void test19_While(){
        String exp3 = "while(x >= 5){" +
                "System.out.println(\"当符合while中条件就执行:\"+x);" +
                "--x}";
        Map<String,Object> map = new HashMap<>();
        map.put("x",10);
        MVEL.eval(exp3,map);
    }

    /**
     * until
     */
    @Test
    public void test20_Until(){
        String exp3 = "until(x < 5){" +
                "System.out.println(\"当不符合while中条件就执行:\"+x);" +
                "--x}";
        Map<String,Object> map = new HashMap<>();
        map.put("x",10);
        MVEL.eval(exp3,map);
    }

    /**
     * 投影1
     */
    @Test
    public void test21(){
        List<User> users = new ArrayList<>();
        users.add(new User().setName("kenshine"));
        users.add(new User().setName("qin"));
        users.add(new User().setName("zax"));
        String exp3 = "parentNames = (name in users); parentNames;" ;
        Map<String,Object> map = new HashMap<>();
        map.put("users",users);
        List<User> eval = (List<User>) MVEL.eval(exp3, map);
        System.out.println(eval);
    }

    /**
     * 投影2
     */
    @Test
    public void test22(){
        List<User> users = new ArrayList<>();
        users.add(new User().setParent(new User().setName("father1")));
        users.add(new User().setParent(new User().setName("father2")));
        users.add(new User().setParent(new User().setName("father3")));
        //    String exp3 = "foo=(name in (parent in users));foo" ;
        String exp3 = "foo=(parent.name in users);foo" ;
        Map<String,Object> map = new HashMap<>();
        map.put("users",users);
        List<User> eval = (List<User>) MVEL.eval(exp3, map);
        System.out.println(eval);
    }

    /**
     * 过滤投影
     */
    @Test
    public void test23(){
        List<User> users = new ArrayList<>();
        List<User> fams = new ArrayList<>();
        users.add(new User().setParent(new User().setName("kenshine").setFamilys(fams)));
        users.add(new User().setParent(new User().setName("qin").setFamilys(fams)));
        users.add(new User().setParent(new User().setName("zax").setFamilys(fams)));
        String exp3 = "($ in users if $.name contains 'q');" ;
        Map<String,Object> map = new HashMap<>();
        map.put("users",users);
        Object eval =  MVEL.eval(exp3, map);
        System.out.println(eval);
    }

    /**
     * 过滤投影2
     */
    @Test
    public void test24(){
        String exp3 = "(($ < 10) in [2,4,8,16,32]);  " ;
        String exp4 =  "($ in [2,4,8,16,32] if $ < 10); ";    // returns [2,4,8]
        Object eval =  MVEL.eval(exp3);
        System.out.println(eval);
        Object eval2 =  MVEL.eval(exp4);
        System.out.println(eval2);
    }

    /**
     * 导入调用简单hello函数
     * @throws IOException
     */
    @Test
    public void test25() throws IOException {
        File scriptFile = new File("src/main/resources/mvel/hello.el");
        Map map = new HashMap();
        map.put("name", "小明");
        MVEL.evalFile(scriptFile, ParserContext.create(), map);
        Object obj = MVEL. eval("hello(name);", map);
    }

    /**
     * Lambda(匿名函数)
     */
    @Test
    public void test26(){
        String exp = "threshold = def (x) { x >= 10 ? x : 0 };\n" +
                "result = threshold(num);\n" +
                "System.out.println(result);";
        Map map = new HashMap();
        map.put("num",15);
        MVEL. eval(exp,map);

        Map map1 = new HashMap();
        map1.put("num",9);
        MVEL. eval(exp,map1);
    }
}
