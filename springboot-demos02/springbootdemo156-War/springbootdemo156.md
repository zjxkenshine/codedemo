# 参考地址
SPRINGBOOT-把WEB项目打成WAR包部署到外部TOMCAT
- https://www.cnblogs.com/lichangyunnianxue/p/9729395.html

# 主要步骤
1. pom.xml将打包方式修改为war
2. 移除嵌入的tomcat依赖
3. 启动类继承SpringBootServletInitializer实现configure方法
4. pom.xml中build-finalName配置war包名称(防止应用上下文所导致的项目访问资源加载不到的问题)
5. 在idea菜单栏中找到Build---->build Artifacts生成war