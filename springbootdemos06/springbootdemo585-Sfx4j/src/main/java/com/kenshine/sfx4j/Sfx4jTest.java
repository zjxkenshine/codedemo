package com.kenshine.sfx4j;

import org.junit.Test;
import org.kohsuke.sfx4j.Packager;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Sfx4jTest
 * @Description 打包测试
 * @Date 2023-12-15 11:44
 * @modified By：
 * @version: 1.0$
 */
public class Sfx4jTest {

    /**
     * 打包到class文件
     */
    @Test
    public void test01() throws Exception {
        Packager.main(new String[]{"lib\\sfxtest.jar","out\\test.class"});
    }

    /**
     * 打包到jar文件
     */
    @Test
    public void test02() throws IOException {
        Packager.main(new String[]{"lib\\sfxtest.jar","out\\test.jar"});
    }

}
