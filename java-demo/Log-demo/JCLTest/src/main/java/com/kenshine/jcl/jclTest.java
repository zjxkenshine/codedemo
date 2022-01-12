package com.kenshine.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class jclTest {

    @Test
    public void testQuick(){
        //获取 log日志记录器对象
        Log log= LogFactory.getLog(jclTest.class);
        //日志记录输出
        log.info("hello jcl");
    }

}
