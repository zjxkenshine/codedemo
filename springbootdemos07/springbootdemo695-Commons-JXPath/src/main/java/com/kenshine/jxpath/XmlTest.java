package com.kenshine.jxpath;

import com.kenshine.jxpath.model.Company;
import org.apache.commons.jxpath.JXPathContext;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname XmlTest
 * @Description 测试
 * @Date 2024-01-29 11:09
 * @modified By：
 * @version: 1.0$
 */
public class XmlTest {

    /**
     * Container是实现对JXPath透明的间接机制的对象
     */
    @Test
    public void test01(){
        JXPathContext context = JXPathContext.newContext(new Company());
        String street = (String)context.getValue("locations/vendor/location[@id = 'store102']//street");
        System.out.println(street);
    }
}
