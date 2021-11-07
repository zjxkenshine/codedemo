# 参考文档
BPMN 2.0规范
- https://blog.csdn.net/feng_201/article/details/92794495

BPM、BPMN、BPMN2.0概念介绍
- https://www.cnblogs.com/amerkor/p/13728576.html

Flowable从入门到入土
- https://juejin.cn/post/6844904098723004423

github
- https://github.com/flowable/flowable-engine

springboot整合flowable: 6.3.0
- https://blog.csdn.net/qq_35098526/article/details/87818988

Flowable 快速入门教程：SpringBoot 集成 Flowable + Flowable Modeler 流程配置可视化（超详细）
- https://blog.csdn.net/qq_37143673/article/details/102851433

请假流程配置示例
- https://www.cnblogs.com/nanstar/p/11959389.html


# 踩坑
- 下载下来的flowable没有app模块
    - 6.4.2版本有巨坑，换6.4.1

- mybatisplus出错
    - 由于 flowable-modeler 引入时候，会初始化 mybatis的Template和SqlFactory，这导致 mybatis-plus 本身的autoconfig 无法生效，所以需要重写
    - https://www.jianshu.com/p/f43311f3bf9f