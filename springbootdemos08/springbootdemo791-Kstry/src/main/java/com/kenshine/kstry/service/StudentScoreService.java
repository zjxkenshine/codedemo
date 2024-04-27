package com.kenshine.kstry.service;

import cn.kstry.framework.core.annotation.*;
import cn.kstry.framework.core.bpmn.enums.IterateStrategyEnum;
import cn.kstry.framework.core.bus.IterDataItem;
import cn.kstry.framework.core.enums.ScopeTypeEnum;
import com.google.common.collect.Lists;
import com.kenshine.kstry.http.QueryScoreRequest;
import com.kenshine.kstry.http.QueryScoreResponse;
import com.kenshine.kstry.http.QueryScoreVarScope;
import com.kenshine.kstry.model.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author kenshine
 * 服务组件
 *
 * @TaskComponent 指定该类成为了 Kstry 容器可解析的任务组件，可在其中定义服务节点
 * name：指定组件名称，与 bpmn 流程配置文件中task-component属性对应，默认为首字母小写的类名
 */
@TaskComponent
public class StudentScoreService {

    /**
     * 注册name为：getStudentBasic 描述信息为：查询学生基本信息 的服务节点方法
     *
     *  @TaskService 指定该方法是Kstry容器中的服务节点，也是在bpmn配置文件中可编排的最小执行单元，对应于bpmn配置文件中的bpmn:serviceTask节点
     *  name：指定该服务节点的名称，与 bpmn 配置文件中的task-service属性进行匹配对应，默认为方法名
     *  desc：节点描述信息。流程配置中未指定节点名称时，尝试获取@TaskService注解的desc属性作为name
     *  iterator：指定遍历信息，可以参考上面代码中的注释，也可跳转至后面的文档了解资源遍历功能详情
     *
     *  @NoticeResult作用：指定执行结果将被通知到StoryBus中的哪些作用域中，
     *  @NoticeResult说明，该方法执行结果将被通知到result域，最终作为Story的执行结果返回给调用方
     *
     *  @VarTaskParam标注在服务节点的方法参数上，用来从StoryBus的var域获取变量值，并直接赋值给被标注的参数项
     *
     *  @ReqTaskParam标注在服务节点的方法参数上，用来从StoryBus的req域获取变量值，并直接赋值给被标注的参数项
     *
     *  @NoticeVar作用：返回结果到studentBasic中
     */
    @TaskService(desc = "查询学生基本信息")
    @NoticeVar(target = QueryScoreVarScope.F.studentBasic)
    public StudentBasic getStudentBasic(@ReqTaskParam(QueryScoreRequest.F.studentId) Long id) {
        // mock return result
        StudentBasic studentBasic = new StudentBasic();
        studentBasic.setId(id);
        studentBasic.setAddress("XX省XX市XX区");
        studentBasic.setName("张一");
        return studentBasic;
    }

    @TaskService(desc = "查询学生敏感信息")
    @NoticeVar(target = QueryScoreVarScope.F.studentPrivacy)
    public StudentPrivacy getStudentPrivacy(@ReqTaskParam(QueryScoreRequest.F.studentId) Long id) {
        // mock return result
        StudentPrivacy studentPrivacy = new StudentPrivacy();
        studentPrivacy.setId(id);
        studentPrivacy.setBirthday("1994-01-01");
        studentPrivacy.setIdCard("133133199401012345");
        return studentPrivacy;
    }

    @TaskService(desc = "装配学生信息")
    @NoticeVar(target = QueryScoreVarScope.F.student)
    public Student assembleStudentInfo(@VarTaskParam(QueryScoreVarScope.F.studentBasic) StudentBasic studentBasic,
                                       @VarTaskParam(QueryScoreVarScope.F.studentPrivacy) StudentPrivacy studentPrivacy) {
        Student student = new Student();
        BeanUtils.copyProperties(studentBasic, student);
        BeanUtils.copyProperties(studentPrivacy, student);
        return student;
    }

    @TaskService(desc = "获取学生学年列表")
    @NoticeVar(target = QueryScoreVarScope.F.studyExperienceList)
    public List<StudyExperience> getStudyExperienceList(@ReqTaskParam(QueryScoreRequest.F.studentId) Long id) {
        // mock return result
        return Lists.newArrayList(
                StudyExperience.builder().studentId(id).classId(1L).studyYear("2013-1-2").build(),
                StudyExperience.builder().studentId(id).classId(2L).studyYear("2014-1-2").build(),
                StudyExperience.builder().studentId(id).classId(3L).studyYear("2015-1-2").build()
        );
    }

    /**
     * 服务节点可以定义指定对数据域中的某个集合变量进行遍历执行
     *      sourceScope = ScopeTypeEnum.VARIABLE  指要对var域的变量进行遍历
     *      source = QueryScoreVarScope.F.classIds 指对var域中名为classIds的集合变量进行遍历
     *      async = true        指开启并发遍历模式
     *      strategy = IterateStrategyEnum.BEST_SUCCESS     指使用best策略遍历，best策略可以做到迭代集合中的全部项，执行失败会被忽略，将会尽量多的拿到成功项
     *
     * @return @NoticeVar(target = QueryScoreVarScope.F.classInfos) 指定要将返回结果通知到var域中的classInfos变量上，classInfos变量是List类型，框架会自动将所有单个元素组合成List返回给变量
     */
    @TaskService(desc = "查询班级信息",
            iterator = @Iterator(sourceScope = ScopeTypeEnum.VARIABLE, source = QueryScoreVarScope.F.classIds, async = true, strategy = IterateStrategyEnum.BEST_SUCCESS)
    )
    @NoticeVar(target = QueryScoreVarScope.F.classInfos)
    public ClassInfo getClasInfoById(IterDataItem<Long> classIdItem) {
        // mock return result
        Optional<Long> idOptional = classIdItem.getData();
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(idOptional.orElse(null));
        classInfo.setName("班级" + idOptional.orElse(null));
        return classInfo;
    }

    @TaskService(desc = "查询学生分数列表")
    @NoticeVar(target = QueryScoreVarScope.F.scoreInfos)
    public List<ScoreInfo> getStudentScoreList(@VarTaskParam(QueryScoreVarScope.F.studyExperienceList) List<StudyExperience> studyExperienceList) {
        // mock return result
        return studyExperienceList.stream().flatMap(se -> {
            List<ScoreInfo> scoreInfos = Lists.newArrayList(
                    ScoreInfo.builder().studentId(se.getStudentId()).classId(se.getClassId()).studyYear(se.getStudyYear()).course("语文").score(99).build(),
                    ScoreInfo.builder().studentId(se.getStudentId()).classId(se.getClassId()).studyYear(se.getStudyYear()).course("数学").score(88).build()
            );
            return scoreInfos.stream();
        }).collect(Collectors.toList());
    }

    @TaskService(desc = "组装成绩及班级信息")
    public void assembleScoreClassInfo(@VarTaskParam(QueryScoreVarScope.F.scoreInfos) List<ScoreInfo> scoreInfos,
                                       @VarTaskParam(QueryScoreVarScope.F.classInfos) List<ClassInfo> classInfos) {
        Map<Long, ClassInfo> classInfoMap = classInfos.stream().collect(Collectors.toMap(ClassInfo::getId, Function.identity(), (x, y) -> y));
        scoreInfos.forEach(scoreInfo -> {
            ClassInfo classInfo = classInfoMap.get(scoreInfo.getClassId());
            if (classInfo == null) {
                return;
            }
            scoreInfo.setClassInfo(classInfo);
        });
    }

    @NoticeResult
    @TaskService(desc = "各维度信息聚合")
    public QueryScoreResponse getQueryScoreResponse(@VarTaskParam(QueryScoreVarScope.F.student) Student student,
                                                    @VarTaskParam(QueryScoreVarScope.F.scoreInfos) List<ScoreInfo> scoreInfos) {
        QueryScoreResponse response = new QueryScoreResponse();
        response.setStudent(student);
        response.setScoreInfos(scoreInfos);
        return response;
    }
}