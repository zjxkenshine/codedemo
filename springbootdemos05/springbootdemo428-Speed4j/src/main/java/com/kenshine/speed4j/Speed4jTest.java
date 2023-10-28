package com.kenshine.speed4j;

import com.ecyrd.speed4j.StopWatch;
import com.ecyrd.speed4j.StopWatchFactory;
import com.ecyrd.speed4j.log.PeriodicalLog;
import org.junit.After;
import org.junit.Test;

import javax.management.*;
import java.lang.management.ManagementFactory;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname Speed4jTest
 * @Description Speed4j测试
 * @Date 2023-10-28 9:17
 * @modified By：
 * @version: 1.0$
 */
public class Speed4jTest {

//    @After
//    public void cleanUp() throws MalformedObjectNameException, NullPointerException {
//        pl.shutdown();
//        MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
//        ObjectName on = new ObjectName("Speed4J: name="+pl.getName());
//        assertFalse( "still registered!", mbeanServer.isRegistered(on) );
//    }

    @Test
    public void test01(){
        StopWatch sw = new StopWatch();
        int iterations = 1000;
        for( int i = 0; i < iterations; i++ ) {
            // 1111
        }
        sw.stop();
        System.out.println(sw.toString(iterations));
    }

    /**
     * StopWatchFactory loggingFactory
     * loggingFactory 配置测试
     */
    @Test
    public void test02(){
        StopWatchFactory myStopWatchFactory = StopWatchFactory.getInstance("loggingFactory");
        StopWatch sw = myStopWatchFactory.getStopWatch();
        try {
            sw.stop("busything:success");
        } finally {
            sw.stop("busything:failure");
        }
    }

    /**
     * JMX监控
     * PeriodicalLog设置属性
     */
    @Test
    public void test03() throws IntrospectionException, InstanceNotFoundException, ReflectionException, MalformedObjectNameException {
        PeriodicalLog pl = new PeriodicalLog();

        pl.setName("PeriodicalLogTest" );
        pl.setPeriod(5);
        pl.setSlf4jLogname( "PeriodicalLogTest" );

        StopWatchFactory swf = new StopWatchFactory(pl);
        pl.setSlf4jLogname("");

        MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName on = new ObjectName("Speed4J: name="+pl.getName());
        assertTrue( "jmx bean '"+on+"' is not registered!", mbeanServer.isRegistered(on) );
        MBeanInfo info = mbeanServer.getMBeanInfo( on );
        MBeanAttributeInfo[] attrs = info.getAttributes();
        assertEquals( "Should have just the defaults for now", 2, attrs.length );

        //  设置jmx
        pl.setJmx("test");
        MBeanInfo info2 = mbeanServer.getMBeanInfo( on );
        MBeanAttributeInfo[] attrs2 = info2.getAttributes();
        assertEquals( "Should have now test added", 8, attrs2.length );
        try {
            @SuppressWarnings("unused")
            MBeanInfo info3 = mbeanServer.getMBeanInfo( on );
            fail("MBean did not disappear");
        } catch( InstanceNotFoundException ignored) {}
    }

}
