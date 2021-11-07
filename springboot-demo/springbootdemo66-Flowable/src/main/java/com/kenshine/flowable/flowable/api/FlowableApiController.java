package com.kenshine.flowable.flowable.api;


import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author: kenshine
 **/
@RestController
@RequestMapping("/flowable/api")
public class FlowableApiController {

    public static final Logger logger = LogManager.getLogger(FlowableApiController.class);

    /**
     *  流程引擎
     */
    @Resource
    private ProcessEngine processEngine;


    /**
     *  用户以及组管理服务
     */
    @Resource
    private IdentityService identityService;


    /**
     *  模型服务
     */
    @Resource
    private ModelService modelService;

    /**
     *  部署服务
     */
    @Resource
    private RepositoryService repositoryService;

    /**
     *  流程实例服务
     */
    @Resource
    private RuntimeService runtimeService;


    /**
     * 流程节点任务服务
     */
    @Resource
    private TaskService taskService;

    /**
     * 历史数据服务
     */
    @Resource
    private HistoryService historyService;

    /**
     * 流程部署
     *
     * @param modelId 流程ID，来自 ACT_DE_MODEL
     * @return
     */
    @RequestMapping(value = "/deploy/{modelId}", method = RequestMethod.GET)
    public void deploy(@PathVariable(value = "modelId") String modelId) {
        // 根据模型 ID 获取模型
        Model modelData = modelService.getModel(modelId);

        byte[] bytes = modelService.getBpmnXML(modelData);
        if (bytes == null) {
            logger.error("模型数据为空，请先设计流程并成功保存，再进行发布");
        }

        BpmnModel model = modelService.getBpmnModel(modelData);
        if (model.getProcesses().size() == 0) {
            logger.error("数据模型不符要求，请至少设计一条主线流程");
        }
        byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
        String processName = modelData.getName() + ".bpmn20.xml";

        // 部署流程
        repositoryService.createDeployment()
                .name(modelData.getName())
                .addBytes(processName, bpmnBytes)
                .deploy();

        logger.info("流程部署成功：" + modelId + " " + new Date());
    }

    /**
     * 启动流程
     *
     * @param deployId 部署的流程 Id，来自 ACT_RE_PROCDEF
     * @param userId   用户 Id
     * @param dataKey  数据 Key，业务键，一般为表单数据的 ID，仅作为表单数据与流程实例关联的依据
     * @return
     */
    @RequestMapping(value = "/start/{deployId}/{userId}/{dataKey}", method = RequestMethod.GET)
    public void start(@PathVariable(value = "deployId") String deployId, @PathVariable(value = "userId") String userId, @PathVariable(value = "dataKey") String dataKey) {
        // 设置发起人
        identityService.setAuthenticatedUserId(userId);
        // 根据流程 ID 启动流程
        runtimeService.startProcessInstanceById(deployId, dataKey);
        logger.info("流程启动成功：" + deployId + " " + new Date());
    }

    /**
     * 获取当前候选组
     *
     * @param taskId 任务 Id，来自 ACT_RU_TASK
     * @return
     */
    @RequestMapping(value = "/taskInfo/{taskId}", method = RequestMethod.GET)
    public List<String> taskInfo(@PathVariable(value = "taskId") String taskId) {
        List<String> group = new ArrayList<>();
        List<IdentityLink> taskName = taskService.getIdentityLinksForTask(taskId);
        taskName.forEach(identityLink -> {
            group.add(identityLink.getGroupId());
        });
        return group;
    }

    /**
     * 设置任务参数
     *
     * @param taskId 任务ID
     * @param map 用户列表
     * @return
     */
    @RequestMapping(value = "/setVariables", method = RequestMethod.POST)
    public void setVariables(@RequestParam(value = "taskId") String taskId, @RequestBody Map<String ,Object> map) {
        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        runtimeService.setVariables(processInstanceId, map);
    }

    /**
     * 设置任务参数
     *
     * @param taskId 任务ID
     * @param key 键
     * @param value 值
     * @return
     */
    @RequestMapping(value = "/setVariable", method = RequestMethod.POST)
    public void setVariable(@RequestParam(value = "taskId") String taskId, @RequestParam(value = "key") String key, @RequestParam(value = "value") Object value) {
        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, key, value);
    }

    /**
     * 设置任务参数，List 使用
     *
     * @param taskId 任务ID
     * @param key 键
     * @param value 值
     * @return
     */
    @RequestMapping(value = "/setListVariable", method = RequestMethod.POST)
    public void setListVariable(@RequestParam(value = "taskId") String taskId, @RequestParam(value = "key") String key, @RequestParam(value = "value") List<String> value) {
        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, key, value);
    }

    /**
     * 任务处理1
     *
     * @param taskId 任务 Id，来自 ACT_RU_TASK
     * @return
     */
    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
    public void task(@PathVariable(value = "taskId") String taskId) {
        Boolean isSuspended = taskService.createTaskQuery().taskId(taskId).singleResult().isSuspended();
        if (isSuspended) {
            logger.info("任务已挂起，无法完成");
            return;
        }
        // 设置任务参数，也可不设置：key value
        // 带 Local 为局部参数，只适用于本任务，不带 Local 为全局任务，可在其他任务调用参数
        taskService.setVariableLocal(taskId, "status", true);
        // 完成任务
        taskService.complete(taskId);
        logger.info("任务完成：" + taskId + " " + new Date());
    }

    /**
     * 任务处理
     *
     * @param taskId   任务 Id，来自 ACT_RU_TASK
     * @param assignee 设置审核人，替换
     * @param map      完成任务需要的条件参数
     * @return
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public void taskByAssignee(@RequestParam(value = "taskId") String taskId, @RequestParam(value = "assignee") String assignee, @RequestBody Map<String, Object> map) {
        // 设置审核人
        taskService.setAssignee(taskId, assignee);

        // 设置任务参数，也可不设置：key value，只是示例
        // 带 Local 为局部参数，只适用于本任务，不带 Local 为全局任务，可在其他任务调用参数
        taskService.setVariableLocal(taskId, "status", true);

        // 完成任务
        taskService.complete(taskId, map);
        logger.info("任务完成：" + taskId + " " + new Date());
    }

    /**
     * 中止流程
     * @param processId 流程ID
     *
     * @return
     */
    @RequestMapping(value = "/deleteProcess/{processId}", method = RequestMethod.GET)
    public void deleteProcess(@PathVariable(value = "processId") String processId) {
        runtimeService.deleteProcessInstance(processId, "中止流程");
    }

    /**
     * 获取正在运行的数据 Id 列表
     *
     * @return
     */
    @RequestMapping(value = "/getRuntimeDataId", method = RequestMethod.GET)
    public List<String> getRuntimeDataId() {
        List<String> idList = new ArrayList<>();
        // 获取正在执行的任务列表
        List<Execution> list = runtimeService.createExecutionQuery().onlyProcessInstanceExecutions().list();
        list.forEach(execution -> {
            // 根据任务获取流程实例
            // 获取流程实例种的业务 key
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(execution.getProcessInstanceId()).singleResult();
            idList.add(pi.getBusinessKey());
        });
        return idList;
    }

    /**
     * 根据用户，获取需要审核的业务键 business_key 列表
     *
     * @param userId 用户 Id
     * @return
     */
    @RequestMapping(value = "/getRuntimeBusinessKeyByUser/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> getRuntimeBusinessKeyByUser(@PathVariable(value = "userId") String userId) {
        List<Map<String, Object>> idList = new ArrayList<>();
        // 根据用户获取正在进行的任务
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).list();
        tasks.forEach(task -> {
            Map<String, Object> data = new HashMap<>();
            // 根据任务获取流程实例
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            // 获取流程实例中的业务键
            data.put("businessKey", processInstance.getBusinessKey());
            // 获取任务 Id
            data.put("taskId", task.getId());
            // 流程定义名称
            data.put("processInstanceName", processInstance.getProcessDefinitionName());
            // 流程开始时间
            data.put("startTime", processInstance.getStartTime());
            idList.add(data);
        });
        return idList;
    }

    /**
     * 获取组，获取需要审核的业务键 business_key 列表
     *
     * @param groupIds 组 Id
     * @return
     */
    @RequestMapping(value = "/getRuntimeBusinessKeyByGroup", method = RequestMethod.POST)
    public List<Map<String, Object>> getRuntimeBusinessKeyByGroup(@RequestBody List<String> groupIds) {
        List<Map<String, Object>> idList = new ArrayList<>();
        // 判断是否有组信息
        if (groupIds != null && groupIds.size() > 0) {
            // 根据发起人获取正在执行的任务列表
            List<Task> tasks = taskService.createTaskQuery().taskCandidateGroupIn(groupIds).list();
            tasks.forEach(task -> {
                Map<String, Object> data = new HashMap<>();
                // 根据任务获取流程实例
                ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
                // 获取流程实例中的业务键
                data.put("businessKey", processInstance.getBusinessKey());
                // 获取任务 Id
                data.put("taskId", task.getId());
                // 流程定义名称
                data.put("processInstanceName", processInstance.getProcessDefinitionName());
                // 流程开始时间
                data.put("startTime", processInstance.getStartTime());
                idList.add(data);
            });
        }
        return idList;
    }

    /**
     * 获取用户审核历史
     *
     * @param userId 发起人 Id
     * @return
     */
    @RequestMapping(value = "/getHistoryByUser/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> getHistoryByUser(@PathVariable(value = "userId") String userId) {
        List<Map<String, Object>> historyList = new ArrayList<>();
        // 根据用户，查询任务实例历史
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId).finished().orderByHistoricTaskInstanceEndTime().desc().list();
        list.forEach(historicTaskInstance -> {
            // 历史流程实例
            HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId()).singleResult();
            // 获取需要的历史数据
            Map<String, Object> historyInfo = new HashMap<>();
            historyInfo.put("assignee", historicTaskInstance.getAssignee());
            // 节点名称
            historyInfo.put("nodeName", historicTaskInstance.getName());
            // 流程开始时间
            historyInfo.put("startTime", historicTaskInstance.getCreateTime());
            // 节点操作时间（本流程节点结束时间）
            historyInfo.put("endTime", historicTaskInstance.getEndTime());
            // 流程定义名称
            historyInfo.put("processName", hpi.getProcessDefinitionName());
            // 流程实例 ID
            historyInfo.put("processInstanceId", historicTaskInstance.getProcessInstanceId());
            // 业务键
            historyInfo.put("businessKey", hpi.getBusinessKey());
            historyList.add(historyInfo);
        });
        return historyList;
    }

    /**
     * 通过流程实例 Id，判断流程是否结束
     *
     * @param processInstanceId 流程实例 Id
     * @return true 结束，false 未结束
     */
    @RequestMapping(value = "/checkProcessInstanceFinish/{processInstanceId}", method = RequestMethod.GET)
    public boolean checkProcessInstanceFinish(@PathVariable(value = "processInstanceId") String processInstanceId) {
        boolean isFinish = false;
        // 根据流程 ID 获取未完成的流程中是否存在此流程
        long count = historyService.createHistoricProcessInstanceQuery().unfinished().processInstanceId(processInstanceId).count();
        // 不存在说明没有结束
        if (count == 0) {
            isFinish = true;
        }
        return isFinish;
    }


    /**
     * 根据任务节点获取流程实例 Id
     *
     * @param taskId 任务节点 Id
     * @return
     */
    @RequestMapping(value = "/getTaskInfo/{taskId}", method = RequestMethod.GET)
    public String getTaskInfo(@PathVariable(value = "taskId") String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        return task.getProcessInstanceId();
    }

    /**
     * 根据流程实例 ID 获取任务进度流程图
     *
     * @param processInstanceId 流程实例 Id
     * @return
     */
    @RequestMapping(value = "/getProcessDiagram/{processInstanceId}", method = RequestMethod.GET)
    public void getProcessDiagram(@PathVariable(value = "processInstanceId") String processInstanceId, HttpServletResponse httpServletResponse) {
        // 流程定义 ID
        String processDefinitionId;

        // 查看完成的进程中是否存在此进程
        long count = historyService.createHistoricProcessInstanceQuery().finished().processInstanceId(processInstanceId).count();
        if (count > 0) {
            // 如果流程已经结束，则得到结束节点
            HistoricProcessInstance pi = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            processDefinitionId = pi.getProcessDefinitionId();
        } else {// 如果流程没有结束，则取当前活动节点
            // 根据流程实例ID获得当前处于活动状态的ActivityId合集
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            processDefinitionId = pi.getProcessDefinitionId();
        }
        List<String> highLightedActivitis = new ArrayList<>();

        // 获得活动的节点
        List<HistoricActivityInstance> highLightedActivitList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().asc().list();

        for (HistoricActivityInstance tempActivity : highLightedActivitList) {
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        List<String> flows = new ArrayList<>();
        // 获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
        ProcessEngineConfiguration processEngineConfig = processEngine.getProcessEngineConfiguration();

        ProcessDiagramGenerator diagramGenerator = processEngineConfig.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "bmp", highLightedActivitis, flows, processEngineConfig.getActivityFontName(),
                processEngineConfig.getLabelFontName(), processEngineConfig.getAnnotationFontName(), processEngineConfig.getClassLoader(), 1.0, true);

//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024*4];
//        int n;
//        while (-1 != (n = in.read(buffer))) {
//            output.write(buffer, 0, n);
//        }
//        byte[] imgData = output.toByteArray();
//        output.close();
//        in.close();
//
//        return imgData;
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
        }
    }

    /**
     * 根据任务 ID 获取任务进度流程图
     *
     * @param taskId 任务节点 Id
     * @return
     */
    @RequestMapping(value = "/getTaskProcessDiagram/{taskId}", method = RequestMethod.GET)
    public void getTaskProcessDiagram(@PathVariable(value = "taskId") String taskId, HttpServletResponse httpServletResponse) {

        // 根据任务 ID 获取流程实例 ID
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();

        // 根据流程实例获取流程图
        // 流程定义 ID
        String processDefinitionId;

        // 查看完成的进程中是否存在此进程
        long count = historyService.createHistoricProcessInstanceQuery().finished().processInstanceId(processInstanceId).count();
        if (count > 0) {
            // 如果流程已经结束，则得到结束节点
            HistoricProcessInstance pi = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            processDefinitionId = pi.getProcessDefinitionId();
        } else {// 如果流程没有结束，则取当前活动节点
            // 根据流程实例ID获得当前处于活动状态的ActivityId合集
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            processDefinitionId = pi.getProcessDefinitionId();
        }
        List<String> highLightedActivitis = new ArrayList<>();

        // 获得活动的节点
        List<HistoricActivityInstance> highLightedActivitList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().asc().list();

        for (HistoricActivityInstance tempActivity : highLightedActivitList) {
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        List<String> flows = new ArrayList<>();
        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
        ProcessEngineConfiguration processEngineConfig = processEngine.getProcessEngineConfiguration();

        ProcessDiagramGenerator diagramGenerator = processEngineConfig.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "bmp", highLightedActivitis, flows, processEngineConfig.getActivityFontName(),
                processEngineConfig.getLabelFontName(), processEngineConfig.getAnnotationFontName(), processEngineConfig.getClassLoader(), 1.0, true);

        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
        }
    }

//    /**
//     * 监听器
//     *
//     * @param execution 分配执行实例
//     */
//    public boolean accessCondition(DelegateExecution execution) {
//
//        // 已完成的实例数
//        int completedInstance = (int) execution.getVariable("nrOfCompletedInstances");
//        // 实例总数
//        int totalInstance = (int) execution.getVariable("nrOfInstances");
//
////            if (execution.getVariable("sum") == null) {
////                execution.setVariable("sum", 0);
////            }
////            // 计算已完成多少
////            int sum = (int) execution.getVariable("sum");
//
//        // 已完成的实例数 * 2 >= 实例总数，说明完成
//        if (completedInstance * 2  >= totalInstance) {
//            // 完成
//            return true;
//        } else {
//            // 未完成
//            return false;
//        }
//    }

//    /**
//     * 据任务节点id判断该节点是否为会签节点
//     *
//     * @param taskId 任务节点id
//     */
//    public boolean isMultiInstance(String taskId) {
//        boolean flag = false;
//        Task task=processEngine.getTaskService().createTaskQuery() // 创建任务查询
//                .taskId(taskId) // 根据任务id查询
//                .singleResult();
//        if(task != null){
//            // 获取流程定义id
//            String processDefinitionId=task.getProcessDefinitionId();
//
//            ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) processEngine.getRepositoryService()
//                    .getProcessDefinition(processDefinitionId);
//
//            // 根据活动id获取活动实例
//            HistoricActivityInstance activityInstance = historyService.createHistoricActivityInstanceQuery().processDefinitionId(processDefinitionId).unfinished().singleResult();
//
//            activityInstance.getActivityType()
//
//            if(((ActivityImpl) activityImpl).getActivityBehavior() instanceof ParallelMultiInstanceBehavior){
//                ParallelMultiInstanceBehavior behavior = (ParallelMultiInstanceBehavior)activityImpl.getActivityBehavior();
//                if(behavior != null && behavior.getCollectionExpression() != null){
//                    flag = true;
//                }
//            }
//        }
//
//        return flag;
//    }

}