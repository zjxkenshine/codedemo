# Quartz概要文档
## 1.一些概念
1. 任务(Job):想要实现的任务类
2. 触发器(Trigger)：执行任务
    - SimpleTigger
    - CronTrigger
    - 还有两种不常用
3. 调度器(Scheduler)：整合任务与触发器
4. 监听器：对三种组件的监听器
    - JobListener
    - TriggerListener
    - SchedulerListener
5. 执行上下文：JobExecutionContext,可获取一些数据
    - JobDataMap：传递数据
    - TriggerKey和JobKey
    - 

## 2.Cron表达式
由7个子表达式组成的字符串
- Seconds 秒
- Minutes 分钟
- Hours 小时
- Day-of-Month 月
- Day-of-Week 周中的天
- Year(optional field) 年(可选)

在线cron生成
- https://cron.qqe2.com/






