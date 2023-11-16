package com.kenshine.nlp2cron;

import cn.langpy.nlp2cron.CrondUtil;
import cn.langpy.nlp2cron.core.CrondModel;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Nlp2CornTest
 * @Description 测试
 * @Date 2023-11-16 12:08
 * @modified By：
 * @version: 1.0$
 */
public class Nlp2CronTest {

    /**
     * 使用测试
     */
    @Test
    public void test01(){
        /*模型初始化，初始化需要时间，可提前进行初始化*/
        CrondModel.init("D:\\Github\\codedemo\\springbootdemos05\\springbootdemo486-Nlp2cron\\model");
        String test1 = "明早八点";
        String test2 = "每天晚上7点开始";
        String test3 = "每15分钟一次";
        String test4 = "每2小时一次";
        String test5 = "每天晚上7点开始";
        String test6 = "每天早上7点开始";
        String test7 = "上午一点执行";
        String test8 = "明天早上8点";
        String cron1 = CrondUtil.toCron(test1);
        String cron2 = CrondUtil.toCron(test2);
        String cron3 = CrondUtil.toCron(test3);
        String cron4 = CrondUtil.toCron(test4);
        String cron5 = CrondUtil.toCron(test5);
        String cron6 = CrondUtil.toCron(test6);
        String cron7 = CrondUtil.toCron(test7);
        String cron8 = CrondUtil.toDate(test8);
        String cron9 = CrondUtil.toDateTime(test8);
        String cron10 = CrondUtil.toTime(test8);
        /*使用完关闭 如果在web中需要重复使用则不需要关闭*/
        CrondModel.close();
        //明早八点 转为cron表达式：0 0 8 3 1 ? 2021
        System.out.println(cron1);
        //每天晚上7点开始 转为cron表达式：0 0 19 * * ? *
        System.out.println(cron2);
        //每15分钟一次 转为cron表达式：0 0/15 * * * ? *
        System.out.println(cron3);
        //每2小时一次 转为cron表达式：0 0 0/2 * * ? *
        System.out.println(cron4);
        //每天晚上7点开始 转为cron表达式：0 0 19 * * ? *
        System.out.println(cron5);
        //每天早上7点开始 转为cron表达式：0 0 7 * * ? *
        System.out.println(cron6);
        //上午一点执行 转为cron表达式：0 0 1 * * ? *
        System.out.println(cron7);
        //明天早上八点 转为date表达式：2021-01-03
        System.out.println(cron8);
        //明天早上八点 转为datetime表达式：2021-01-03 08:00:00
        System.out.println(cron9);
        //明天早上八点 转为time表达式：08:00:00
        System.out.println(cron10);
    }
}
