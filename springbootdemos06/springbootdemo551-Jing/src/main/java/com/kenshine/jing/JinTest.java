package com.kenshine.jing;

import com.thaiopensource.util.PropertyMapBuilder;
import com.thaiopensource.validate.ValidationDriver;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/7 22:59
 * @description：Jing验证测试
 * @modified By：
 * @version: $
 */
public class JinTest {

    /**
     * 验证测试
     */
    @Test
    public void test01() throws IOException, SAXException {
        ValidationDriver validationDriver = new ValidationDriver();
        validationDriver.loadSchema(new InputSource(new FileInputStream("file\\schema.xml")));
        Boolean result=validationDriver.validate(new InputSource(new FileInputStream("file\\test01.xml")));
        System.out.println(result);
    }


}
