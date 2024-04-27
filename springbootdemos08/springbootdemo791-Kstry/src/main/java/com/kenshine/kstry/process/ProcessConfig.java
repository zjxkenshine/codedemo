package com.kenshine.kstry.process;

import cn.kstry.framework.core.component.bpmn.joinpoint.InclusiveJoinPoint;
import cn.kstry.framework.core.component.bpmn.link.ProcessLink;
import cn.kstry.framework.core.component.bpmn.link.StartProcessLink;
import cn.kstry.framework.core.component.expression.Exp;
import cn.kstry.framework.core.enums.ScopeTypeEnum;
import com.kenshine.kstry.http.QueryScoreRequest;
import com.kenshine.kstry.service.StudentScoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by kenshine
 * @Classname studentScoreQueryProcess
 * @Description 代码方式流程编排
 * @Date 2024-04-27 10:13
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class ProcessConfig {

    /**
     *  代码方式定义流程
     *  可以自定义方法返回ProcessLink或者SubProcessLink来定义流程和子流程
     */
    @Bean
    public ProcessLink studentScoreQueryProcess() {
        String instructContent = "var classIds = [];"
                + "for (var i = 0; i< kvar.studyExperienceList.length; i++)"
                + "{"
                + "    classIds.push(kvar.studyExperienceList[i].classId);"
                + "}"
                + "return JSON.stringify(classIds)";
        StartProcessLink processLink = StartProcessLink.build(ProcessConfig::studentScoreQueryProcess);
        InclusiveJoinPoint asyncInclusive = processLink.nextInclusive(processLink.inclusive().openAsync().build());
        InclusiveJoinPoint asyncInclusive2 = asyncInclusive
                .nextService(Exp.b(e -> e.isTrue(ScopeTypeEnum.REQUEST, QueryScoreRequest.F.needScore)), StudentScoreService::getStudyExperienceList).build()
                .nextInstruct("jscript", instructContent).name("JS脚本").property("{\"result-converter\": \"object_to_long_list\",\"return-target\": \"var.classIds\"}").build()
                .nextInclusive(processLink.inclusive().openAsync().build());

        processLink.inclusive().build().joinLinks(
                processLink.parallel().notStrictMode().build().joinLinks(
                        asyncInclusive2.nextService(StudentScoreService::getClasInfoById).build(),
                        asyncInclusive2.nextService(StudentScoreService::getStudentScoreList).build()
                ).nextService(StudentScoreService::assembleScoreClassInfo).build(),
                processLink.inclusive().build().joinLinks(
                        asyncInclusive.nextService(StudentScoreService::getStudentBasic).build(),
                        asyncInclusive.nextService(StudentScoreService::getStudentPrivacy).build()
                ).nextService(StudentScoreService::assembleStudentInfo).build()
        )
                .nextService(StudentScoreService::getQueryScoreResponse).build()
                .end();
        return processLink;
    }
}
