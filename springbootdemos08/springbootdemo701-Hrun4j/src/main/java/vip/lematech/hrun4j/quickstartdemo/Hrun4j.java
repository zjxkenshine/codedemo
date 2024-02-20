package vip.lematech.hrun4j.quickstartdemo;

import com.googlecode.aviator.AviatorEvaluator;
import vip.lematech.hrun4j.quickstartdemo.functions.MyFunction;
import vip.lematech.hrun4j.base.TestBase;
import vip.lematech.hrun4j.common.Constant;
import vip.lematech.hrun4j.config.RunnerConfig;
import org.testng.annotations.BeforeSuite;
import vip.lematech.hrun4j.helper.LogHelper;

/**
* Extension function
* @author lematech@foxmail.com
* @version 1.0.1
*/
public class Hrun4j extends TestBase {
    @Override
    @BeforeSuite
    public void beforeSuite(){
        LogHelper.info(" Add function to static code block !");
        AviatorEvaluator.addFunction(new MyFunction.SetupHookFunction());
        AviatorEvaluator.addFunction(new MyFunction.TearDownHookFunction());
        /**
        * 包名，资源路径下查找测试用例前置，默认：vip.lematech.hrun4j
        */
        RunnerConfig.getInstance().setPkgName("vip.lematech.hrun4j.quickstartdemo");
        /**
        * Test case file suffix
        */
        RunnerConfig.getInstance().setTestCaseExtName(Constant.SUPPORT_TEST_CASE_FILE_EXT_YML_NAME);
    }
}

