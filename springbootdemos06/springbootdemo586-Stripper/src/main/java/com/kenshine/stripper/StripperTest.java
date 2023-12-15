package com.kenshine.stripper;

import org.junit.Test;
import org.kohsuke.stripper.Main;

/**
 * @author by kenshine
 * @Classname StripperTest
 * @Description Stripper压缩class测试
 * @Date 2023-12-15 13:26
 * @modified By：
 * @version: 1.0$
 */
public class StripperTest {

    /**
     * 测试
     */
    @Test
    public void test01() throws Exception {
        Main.main(new String[]{"classes\\NekopullTest.class"});
    }

}
