package com.kenshine.parralleljunit;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.kohsuke.junit.ParallelTestSuite;

/**
 * @author by kenshine
 * @Classname ParrallelTest
 * @Description 并发测试
 * @Date 2023-12-15 16:46
 * @modified By：
 * @version: 1.0$
 */
public class ParrallelTest {
    public static void main(String[] args) {
        TestSuite tests = new ParallelTestSuite();
        for(int i=0; i<10; i++) {
            tests.addTest(new TestImpl());
        }
        TestRunner.run(tests);
    }

    private static class TestImpl extends TestCase {
        public TestImpl() {
            super("test");
        }

        @Override
        protected void runTest() throws Throwable {
            for( int i=0; i<10; i++ ) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread());
                System.err.println(System.currentTimeMillis());
            }
        }

    }

}
