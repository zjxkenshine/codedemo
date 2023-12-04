# 参考地址
Disroute是一个状态分发处理工具，根据对象里面的某个属性值定义不同的执行方法，完成处理逻辑的解耦，优化大量if-else逻辑
- https://gitee.com/huoyo/disroute

Java-Disroute：消息对象注解式分发处理工具，优化大量if-else
- https://blog.csdn.net/qq_21120275/article/details/119425612

# 踩坑
处理类注解 @Route("test")
- 不能为@Route("context")

