package com.kenshine.justsimmand;

import idea.verlif.justsimmand.LoadConfig;
import idea.verlif.justsimmand.SmdConfig;
import idea.verlif.justsimmand.SmdExecutor;
import idea.verlif.justsimmand.info.SmdArgInfo;
import idea.verlif.justsimmand.info.SmdGroupInfo;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname SimmandTest
 * @Description 指令测试
 * @Date 2024-05-05 8:39
 * @modified By：
 * @version: 1.0$
 */
public class SimmandTest {

    /**
     * 基础用法
     */
    @Test
    public void test01() throws NoSuchMethodException {
        // 实例化指令执行器
        SmdExecutor smdExecutor = new SmdExecutor();
        // 将对象加载到命令执行器，并将加载模式设置为正模式和扩展模式
        smdExecutor.add(
                new SimpleMath(),
                new LoadConfig().loadMode(LoadConfig.LoadMode.POSITIVE, LoadConfig.LoadMode.EXTEND));
        // 执行方法
        System.out.println("plus : " + smdExecutor.execute("SimpleMath plus 2 3"));
        System.out.println("square : " + smdExecutor.execute("SimpleMath square 2"));
    }

    /**
     * 高级用法
     */
    @Test
    public void test02() throws NoSuchMethodException {
        // 实例化指令执行器
        SmdExecutor smdExecutor = new SmdExecutor();
        // 添加指令对象
        smdExecutor.add(new Math());
        // 设定指令前缀别名，这里表示输入 "3" 或 "test" 就相当于输入了 "math plus --b 4" 该版本没用
        // 这里的 "--b" 表示后面的 "4" 是属于参数 "b" 的
        //smdExecutor.addPrefixReplace("math plus --b 4", "3", "test");
        // 使用别名进行指令调用，这里因为 "a" 并不是强制参数且是基础类型，所以会给予默认值 "0"
        System.out.println("使用指令前缀别名: " + smdExecutor.execute("math plus --b 4"));
        // 这里同样因为 "b" 设定有默认值，所以也不需要输入 "b" 的值
        System.out.println("使用指令设定值: " + smdExecutor.execute("math plus"));
        System.out.println("基础调用: " + smdExecutor.execute("math ^ 2"));
        // 输出help
        List<SmdGroupInfo> run = smdExecutor.help(null,null);
        for (SmdGroupInfo smdGroupInfo : run) {
            System.out.print(smdGroupInfo);
        }
    }

    /**
     * 指令链接
     *
     * 可以将(groupA methodA paramA)(methodB paramB)(methodC paramC)拆解成以下部分
     */
    @Test
    public void test03(){
        SmdExecutor smdExecutor = new SmdExecutor();
        // 开启指令链接
        smdExecutor.getSmdConfig().setLinkable(true);

    }

    /**
     * 在指令中可使用的对象替换标识,指令中通过#{key}进行使用
     */
    @Test
    public void test04() throws NoSuchMethodException {
        SmdExecutor smdExecutor = new SmdExecutor();
        // 添加自己到指令中
        smdExecutor.add(smdExecutor);
        // 创建开启指令链配置
        SmdConfig config = new SmdConfig().linkable(true);
        // 将配置添加到执行器配置中
        smdExecutor.variable("config", config);
        // 在指令中使用#{config}来将变量直接传入参数，以此来设置此执行器配置
        smdExecutor.execute("executor setSmdConfig #{config}");
    }

}
