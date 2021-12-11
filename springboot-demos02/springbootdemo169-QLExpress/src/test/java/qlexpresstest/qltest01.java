package qlexpresstest;

import com.kenshine.qlexpress.example.BeanExample;
import com.kenshine.qlexpress.operators.TestOperator;
import com.ql.util.express.*;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/11 8:30
 * @description：测试(代码编写脚本方式)
 * @modified By：
 * @version: $
 */
public class qltest01 {

    /**
     * 1.基本用法
     */
    @Test
    public void test01() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "a+b*c";
        /**
         *  @param expressString 程序文本
         *  @param context 执行上下文，参数
         *  @param errorList 输出的错误信息List
         *  @param isCache 是否使用Cache中的指令集
         *  @param isTrace 是否输出详细的执行指令信息
         */
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }


    /**
     * 2.脚本中定义function
     */
    public void functionABC(Long a,Integer b,String c) {
        System.out.println(a+b+c);
        System.out.println("functionABC");
    }

    private static qltest01 singleton = new qltest01();

    /**
     * 脚本定义
     */
    @Test
    public void test02_Function() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        //定义脚本
        runner.addFunctionOfServiceMethod("abc", singleton,"functionABC",new Class[]{Long.class,Integer.class,String.class},null);
        String exp = "abc(a,b,c)";
        IExpressContext<String, Object> context = new DefaultContext<>();
        context.put("a",1L);
        context.put("b",2);
        context.put("c","3");

        //优先从本地指令集缓存获取指令集，没有的话生成并且缓存在本地
        InstructionSet instructionSet = runner.getInstructionSetFromLocalCache(exp);
        //获取一个表达式需要的外部变量名称列表
        String[] outFunctionNames = runner.getOutFunctionNames(exp);
        //外部方法名称
        String[] outVarNames = runner.getOutVarNames(exp);
        runner.execute(exp, context, null, false, false);
    }


    /**
     * 3.Operator简单使用
     */
    @Test
    public void test03() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        //if then else
        runner.addOperatorWithAlias("如果", "if",null);
        runner.addOperatorWithAlias("则", "then",null);
        runner.addOperatorWithAlias("否则", "else",null);

        String exp = "如果  (语文+数学+英语>270) 则 {return 1;} 否则 {return 0;}";
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("语文",60);
        context.put("数学",20);
        context.put("英语",100);
        int r = (Integer)runner.execute(exp,context,null,false,false,null);
        System.out.println(r);
    }

    /**
     * 4.自定义Operator操作符
     */
    @Test
    public void test04() throws Exception {
        //定义表达式，相当于 1+(2*2)+(3*3)
        String exp = " 1 addT 2 addT 3";
        ExpressRunner runner = new ExpressRunner();
        //定义操作符addT，其实现为TestOperator
        runner.addOperator("addT", new TestOperator());
        //执行表达式
        int r = (Integer)runner.execute(exp,null,null,false,false);
        System.out.println(r);
    }

    /**
     * 5.自定义Operator操作符另一种用法，添加为方法
     */
    @Test
    public void test05() throws Exception {
        //定义表达式，相当于 1+(2*2)
        String exp = "addT(1,2)";
        ExpressRunner runner = new ExpressRunner();
        //添加操作符为方法
        runner.addFunction("addT", new TestOperator());
        //执行表达式 要传入数据则使用DefaultContext
        int r = (Integer)runner.execute(exp,null,null,false,false);
        System.out.println(r);
    }

    /**
     * 6.绑定java类或对象方法
     * addFunctionOfClassMethod 绑定对象方法
     * addFunctionOfServiceMethod 绑定实例方法
     */
    @Test
    public void test06() throws Exception {
        ExpressRunner runner = new ExpressRunner();

        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs", new String[] { "double" }, null);
        //类方法
        runner.addFunctionOfClassMethod("转换为大写", BeanExample.class.getName(), "upper", new String[] { "String" }, null);

        runner.addFunctionOfServiceMethod("打印", System.out, "println",new String[] { "String" }, null);
        //对象方法
        runner.addFunctionOfServiceMethod("contains", new BeanExample(), "anyContains", new Class[] { String.class, String.class }, null);

        IExpressContext<String, Object> context = new DefaultContext<>();

        String exp = "取绝对值(-100);转换为大写(\"hello world\");打印(\"你好吗？\");contains(\"helloworld\",\"aeiou\")";
        runner.execute(exp, context, null, false, false);
    }


    /**
     * 7.macro 宏定义
     */
    @Test
    public void test07_macro() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        //脚本
        runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
        runner.addMacro("是否优秀", "计算平均成绩>90");
        IExpressContext<String, Object> context =new DefaultContext<String, Object>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Object result = runner.execute("是否优秀", context, null, false, false);
        System.out.println(result);
    }

    /**
     * 8.编译脚本，查询外部需要定义的变量和函数
     */
    @Test
    public void test08_OutVarNames() throws Exception {
        String express = "int 平均分 = (语文+数学+英语+综合考试.科目2)/4.0;return 平均分";
        //@param aIsPrecise 是否需要高精度计算支持 aIstrace 是否跟踪执行指令的过程
        ExpressRunner runner = new ExpressRunner(true,true);
        String[] names = runner.getOutVarNames(express);
        for(String s:names){
            System.out.println("var : " + s);
        }
    }


    /**
     * 9.不定参数...的使用
     */
    @Test
    public void test09_MethodReplace() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        IExpressContext<String,Object> expressContext = new DefaultContext<>();
        runner.addFunctionOfServiceMethod("getTemplate", this, "getTemplate", new Class[]{Object[].class}, null);

        //(1)默认使用数组传参
        Object r = runner.execute("getTemplate([11,'22',33L,true])", expressContext, null,false, false);
        System.out.println(r);

        //(2)也可以使用动态参数，需要设置supportDynamicParams为true
        DynamicParamsUtil.supportDynamicParams = true;
        r = runner.execute("getTemplate(11,'22',33L,true)", expressContext, null,false, false);
        System.out.println(r);
    }

    //等价于getTemplate(Object[] params)
    public Object getTemplate(Object... params){
        String result = "";
        for(Object obj:params){
            result = result+obj+",";
        }
        return result;
    }

    /**
     * 10.关于集合的快捷写法
     */
    @Test
    public void test10_Set() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,false);
        DefaultContext<String, Object> context = new DefaultContext<>();
        //Map
        String express = "abc = NewMap(1:1,2:2); return abc.get(1) + abc.get(2);";
        Object r = runner.execute(express, context, null, false, false);
        System.out.println(r);
        //List
        express = "abc = NewList(1,2,3); return abc.get(1)+abc.get(2)";
        r = runner.execute(express, context, null, false, false);
        System.out.println(r);
        //array
        express = "abc = [1,2,3]; return abc[1]+abc[2];";
        r = runner.execute(express, context, null, false, false);
        System.out.println(r);
    }




}
