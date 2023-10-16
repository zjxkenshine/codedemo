package com.kenshine.cronutils;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.field.expression.FieldExpression;
import static com.cronutils.model.field.expression.FieldExpressionFactory.*;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import org.junit.Test;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/17 1:00
 * @description：测试
 * @modified By：
 * @version: $
 */
public class CronUtilTest {
    @Test
    public void Test01(){
        // 生成cron定义
        CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
        // 解析器
        CronParser parser = new CronParser(cronDefinition);
        ExecutionTime executionTime = ExecutionTime.forCron(parser.parse("*/45 * * * * ?"));
        Optional<ZonedDateTime> zonedDateTime = executionTime.nextExecution(ZonedDateTime.now());
        System.err.println("下次执行时间: " + zonedDateTime.toString());
        Optional<ZonedDateTime> zonedDateTime1 = executionTime.lastExecution(ZonedDateTime.now());
        System.err.println("最后执行时间: " + zonedDateTime1.toString());
        ZonedDateTime timeForLast = ZonedDateTime.now();
        Optional<Duration> duration = executionTime.timeFromLastExecution(timeForLast);
        System.err.println("最后一次执行时间过去了: " + duration + " 秒");
        Optional<Duration> duration1 = executionTime.timeToNextExecution(ZonedDateTime.now());
        System.err.println("距离下次执行时间: " + duration1);
    }

    @Test
    public void Test02(){
        // 构建cron表达式
        Cron cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
                // 年
                .withYear(always())
                // 每月第几天
                .withDoM(between(SpecialChar.L, 3))
                .withMonth(always())
                // 每周第几天
                .withDoW(questionMark())
                .withHour(always())
                .withMinute(always())
                .withSecond(on(0))
                .instance();
                // Obtain the string expression
        String cronAsString = cron.asString();
        System.out.println(cronAsString);
    }


}
