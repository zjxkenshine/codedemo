package com.kenshine.jdring;

import com.kenshine.jdring.listener.Buzzing;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/27 0:18
 * @description：测试类
 * @modified By：
 * @version: $
 */
public class TimeTest {
    @Test
    public void test01() throws PastDateException {
        AlarmManager mgr = new AlarmManager();
        long current = System.currentTimeMillis();
        System.out.println("Current date is " + new Date(current));

        AlarmListener listener = entry -> System.out.println("fixed date alarm : " + entry);

        // 日期时钟
        mgr.addAlarm("kenshine1",new Date(current + (5 * 1000)), listener);
        mgr.addAlarm("kenshine2",new Date(current + (10 * 1000)), listener);

        System.out.println("Here are the registered alarms: ");
        System.out.println("----------------------------");
        List list = mgr.getAllAlarms();
        for(Iterator it = list.iterator(); it.hasNext();) {
            System.out.println("- " + it.next());
        }
        System.out.println("----------------------------");
    }

    /**
     * 闹钟提醒
     * @throws PastDateException
     */
    @Test
    public void test02() throws PastDateException {
        AlarmManager mgr = new AlarmManager( );
        // 每个小时的第20分钟开始
        mgr.addAlarm("kenshine",20, -1, -1, -1, -1, -1, new Buzzing("提示消息"));
    }

    /**
     * 纪念日
     * @throws PastDateException
     */
    @Test
    public void test03() throws PastDateException {
        AlarmManager mgr = new AlarmManager( );
        mgr.addAlarm("kenshine",00, 12, 20, Calendar.MARCH, -1, -1,
                new Buzzing("记住明天是周年纪念！") );
    }


}
