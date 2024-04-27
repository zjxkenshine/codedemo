package com.kenshine.kstry;

import cn.kstry.framework.core.annotation.EnableKstry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname KstryApplication
 * @Description Kstry项目
 * @Date 2024-04-27 9:00
 * @modified By：
 * @version: 1.0$
 *
 * bpmnPath： 指定bpmn文件位置，多个路径可以通过,隔开。支持bpmn、json两种流程配置文件格式
 */
@SpringBootApplication
@EnableKstry(bpmnPath = "./bpmn/*.bpmn,./bpmn/*.json")
public class KstryApplication {
    public static void main(String[] args) {
        SpringApplication.run(KstryApplication.class, args);
    }
}
