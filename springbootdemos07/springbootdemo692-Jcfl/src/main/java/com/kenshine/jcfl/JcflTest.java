package com.kenshine.jcfl;

import com.jbalint.jora.proto.JarToRdf;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JcflTest
 * @Description jcfl使用测试
 * @Date 2024-01-24 10:50
 * @modified By：
 * @version: 1.0$
 */
public class JcflTest {

    /**
     * jar转ttl
     */
    @Test
    public void test01() throws IOException {
        JarToRdf.main(new String[]{"lib/jcfl-1.0-SNAPSHOT.jar"});
    }
}
