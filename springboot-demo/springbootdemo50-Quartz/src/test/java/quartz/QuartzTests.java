package quartz;

import com.kenshine.quartz.QuartzApp;
import com.kenshine.quartz.service.ScheduleService;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 16:28
 * @description：测试定时任务增删改查
 * @modified By：
 * @version: $
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuartzApp.class)
public class QuartzTests {

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void testAdd(){
        //每2秒执行一次
        scheduleService.addSchedule("cronScheduleDetail", "cronScheduleGroup", "com.kenshine.quartz.job.CronJob", "cronScheduleTrigger", "cronTriggerGroup", "0/2 * * * * ?");
    }

    @Test
    public void testPause(){
        scheduleService.pauseSchedule("cronScheduleDetail", "cronScheduleGroup");
    }

    @Test
    public void testResume(){
        scheduleService.resumeSchedule("cronScheduleDetail", "cronScheduleGroup");
    }

    @Test
    public void testDelete(){
        scheduleService.deleteSchedule("cronScheduleDetail", "cronScheduleGroup");
    }

    @Test
    public void testGetJobList(){
        System.out.println(scheduleService.getJobList());
    }

    /**
     * 任务详情
     */
    @Test
    public void testGetJobDetail() throws SchedulerException {
        System.out.println(scheduleService.getJobDetails("cronScheduleDetail", "cronScheduleGroup"));
    }






}
