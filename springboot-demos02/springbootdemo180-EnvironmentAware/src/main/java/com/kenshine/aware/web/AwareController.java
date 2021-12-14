package com.kenshine.aware.web;

import com.kenshine.aware.test.TestAware;
import com.kenshine.aware.test.TestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 23:02
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class AwareController {

    @GetMapping("/test01")
    public String testAware(){
        TestBean testBean = (TestBean) TestAware.getBean("testBean");
        testBean.test();
        return testBean.getSuccess();
    }


}
