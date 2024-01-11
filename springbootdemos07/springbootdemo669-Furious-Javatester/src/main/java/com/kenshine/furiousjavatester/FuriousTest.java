package com.kenshine.furiousjavatester;

import nf.fr.eraasoft.test.Bench;
import nf.fr.eraasoft.test.Job;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname FuriousTest
 * @Description 性能测试使用
 * @Date 2024-01-11 8:16
 * @modified By：
 * @version: 1.0$
 */
public class FuriousTest {

    /**
     * 会生成gchart.dest.html文件，但是显示不了
     */
    @Test
    public void test01() throws InterruptedException{
        Bench bench = new Bench();
        bench.addJob(new Job() {
            @Override
            public void go() {
                System.out.println("Hello");
            }
        });
        bench.maxthreads(3).launch();
    }
}
