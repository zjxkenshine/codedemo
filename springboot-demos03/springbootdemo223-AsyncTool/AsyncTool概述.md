# 1.基本组件
- worker： 一个最小的任务执行单元。通常是一个网络调用，或一段耗时操作
    - T，V两个泛型，分别是入参和出参类型
- callBack：对每个worker的回调，worker执行完毕后，会回调该接口
- wrapper：组合了worker和callback，是一个 最小的调度单元 。通过编排wrapper之间的关系，达到组合各个worker顺序的目的
- executor：执行器，执行wrapper
- exception：异常信息

# 2.基本使用流程
- 自定义Worker
- 自定义回调
- 组合成Wrapper
- 编排Wrapper顺序

# 3.目录
- Test01：串行任务
- test02：串行任务(1.3新写法)
- test03：任务编排一些示例




