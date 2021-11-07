# 1.Flowable概述
1. Flowable是一个业务流程管理(BPM)和工作流系统
2. Flowable整体是通过ProcessEngine来操作的
    - RepositoryService 管理流程定义
    - RuntimeService 执行管理，包括启动、推进、删除流程实例等操作
    - TaskService 任务管理
    - HistoryService 历史管理(执行完的数据的管理)
    - IdentityService 组织机构管理
    - FormService 一个可选服务，任务表单管理
    - ManagerService
  - 流程构建：
    - 通过流程的bpmn文件进行部署流程：通过idea插件创建流程并保存为bpmn文件
    - 使用bpmn模型构建并部署流程：bpmn.js,前端也可自行实现
  - 其他：
    - 数据库脚本:默认Liquibase版本管理
    - 所有节点的ID不能是数字
  
  
# 2.Flowable表
配置好springboot依赖就会生成46张表
## 资源库流程规则表
- act_re_deployment 部署信息表
- act_re_model 流程设计模型部署表
- act_re_procdef 流程定义数据表
## 运行时数据库表
- act_ru_execution 运行时流程执行实例表
- act_ru_identitylink 运行时流程人员表，主要存储任务节点与参与者的相关信息
- act_ru_task 运行时任务节点表
- act_ru_variable 运行时流程变量数据表
## 历史数据库表
- act_hi_actinst 历史节点表
- act_hi_attachment 历史附件表
-  act_hi_comment 历史意见表
- act_hi_identitylink 历史流程人员表
- act_hi_detail 历史详情表，提供历史变量的查询
- act_hi_procinst 历史流程实例表
- act_hi_taskinst 历史任务实例表
- act_hi_varinst 历史变量表
## 组织机构表
- act_id_group 用户组信息表
- act_id_info 用户扩展信息表
- act_id_membership 用户与用户组对应信息表
- act_id_user 用户信息表
## 通用数据表
- act_ge_bytearray 二进制数据表
- act_ge_property 属性数据表存储整个流程引擎级别的数据,初始化表结构时，会默认插入三条记录

# 3.基本开发流程
1. 创建流程定义xml，放在`resources/processes/`下
    - 有各种在线可视化画图并转成xml的方案
    - 也可以通过processEngine
2. 通过ProcessEngine对流程进行操作
    - 添加数据等，详见各service功能


# 4. flowable组成模块
- 内容引擎 ContentEngine
    - ContentManagementService：提供对数据库表的管理操作
    - ContentService：实现对内容的创建、删除、保存和获取的基本操作。
    - ContentEngineConfiguration：最主要的作用是提供Mybatis的封装，实现数据库相关配置的获取
- 身份识别引擎 IdmEngine
    - IdmIdentityService：
        - 提供用户的创建、修改、删除、密码修改、登录、用户头像设置等；
        - 提供组Group的创建、删除、用户与组关系的关联、删除关联；
        - 提供权限的创建、删除、关联等。
    - IdmManagementService：对身份识别相关的数据库表进行统计、获取表的列信息
    - IdmEngineConfiguration：提供数据库配置信息
- 表单引擎 FormEngine
    - FormManagementService
    - FormRepositoryService
    - FormService
    - FormEngineConfiguration
- 决策引擎 DmnEngine
    - DmnManagementService
    - DmnRepositoryService
    - DmnRuleService
    - DmnHistoryService
    - DmnEngineConfiguration
- 流程引擎 ProcessEngine
    - 见最上面

  