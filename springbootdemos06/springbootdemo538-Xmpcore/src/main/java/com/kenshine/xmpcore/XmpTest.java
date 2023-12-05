package com.kenshine.xmpcore;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPIterator;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author by kenshine
 * @Classname XmpTest
 * @Description xmpcore简单使用测试
 * @Date 2023-12-05 9:08
 * @modified By：
 * @version: 1.0$
 */
public class XmpTest {

    /**
     * xmpMeta 解析xmp文件并输出信息
     */
    @Test
    public void test01() throws FileNotFoundException, XMPException {
        FileInputStream fileInputStream = new FileInputStream("img/test.xmp");
        XMPMeta xmpMeta = XMPMetaFactory.parse(fileInputStream);
        XMPIterator xmpIterator = xmpMeta.iterator();
        while (true) {
            if (xmpIterator.hasNext()) {
                // 输出xmp属性
                XMPPropertyInfo property = (XMPPropertyInfo) xmpIterator.next();
                System.out.println(property.getPath() + ": " + property.getValue());
            } else {
                break;
            }
        }
    }

    @Test
    public void test02() throws FileNotFoundException, XMPException {
        FileInputStream fileInputStream = new FileInputStream("img/test02.xmp");
        XMPMeta xmpMeta = XMPMetaFactory.parse(fileInputStream);
        XMPIterator xmpIterator = xmpMeta.iterator();
        while (true) {
            if (xmpIterator.hasNext()) {
                // 输出xmp属性
                XMPPropertyInfo property = (XMPPropertyInfo) xmpIterator.next();
                System.out.println(property.getPath() + ": " + property.getValue());
            } else {
                break;
            }
        }
    }
}
