package vip.lematech.hrun4j.quickstartdemo.testcases.get;

import org.testng.annotations.Test;
import vip.lematech.hrun4j.quickstartdemo.Hrun4j;
import vip.lematech.hrun4j.core.engine.TestCaseExecutorEngine;
import vip.lematech.hrun4j.entity.testcase.TestCase;


/**
 * @author lematech@foxmail.com
 * @version 1.0.1
 */
public class GetTest extends Hrun4j {
    @Test(dataProvider = "dataProvider")
    public void getScene(TestCase testCase) {
        TestCaseExecutorEngine.getInstance().execute(testCase);
    }
}
