# 1.javaDoc注解
- @author：标明开发该类模块的作者，多个作者之间使用,分割
- @version：标明该类模块的版本
- @see：参考转向，也就是相关主题 
   - 与@link的区别是必须顶头写
- @since：从哪个版本开始增加的
- @param：对方法中某参数的说明，如果没有参数就不能写
- @return：对方法返回值的说明，如果方法的返回值类型是void就不能写
- @exception：对方法可能抛出的异常进行说明，如果方法没有用throws显式抛出的异常就不能写 
    - 其中.@param @return和@exception这三个标记都是只用于方法的。
    - @param的格式要求: @param 形参名形参类型形参说明 
    - @return的格式要求: @return 返回值类型返回值说明
    - @exception的格式要求: @exception 异常类型异常说明
        - @param和@exception可以并列多个
- {@link}：插入一个到另一个主题的链接
- @serial：说明一个序列化属性
- {@value}：显示常量的值，该常量必须是static属性
- {@docRoot}：文档根路径

# 2.javaDoc处理工具
$ javadoc Test01.java