package qlexpresstest;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExportItem;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.logging.Log;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/11 9:29
 * @description：测试(加载脚本文件方式)
 * @modified By：
 * @version: $
 */
public class qltest02 {

    /**
     * 1. 测试从文件中加载ql表达式并执行
     */
    @Test
    public void test01() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,false);
        //加载function.ql
        runner.loadExpress("function");
        //加载main.ql
        runner.loadExpress("main");
        //输出全局定义信息
        ExportItem[] exports = runner.getExportInfo();
        for (ExportItem item : exports) {
            System.out.println(item.getGlobeName());
        }
        DefaultContext<String, Object> context = new DefaultContext<>();

        Object r = runner.executeByExpressName("main", context, null,
                false, false, null);
        System.out.println("运行结果" + r);
        System.out.println("context:" + context);

        context = new DefaultContext<>();
        r = runner.execute("initial;累加;累加;return qh;",
                context, null, true, false, null);

        System.out.println("运行结果" + r);
        System.out.println("context:" + context);
    }


    /**
     * 2.从文件中加载脚本执行 include语法
     */
    @Test
    public void test02() throws Exception{
        ExpressRunner runner = new ExpressRunner(false,true);
        runner.loadExpress("includeRoot");
        DefaultContext<String, Object>  context = new DefaultContext<>();
        Object r = runner.executeByExpressName("includeRoot", context, null, false,false,null);
        System.out.println(r );
        System.out.println(context);
    }


}
