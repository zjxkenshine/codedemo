# 参考文档
springboot中使用Jasypt对配置文件敏感信息做加密
- https://blog.csdn.net/u011943534/article/details/118197577

springboot配置jasypt实现对配置文件敏感信息加密全流程详解
- https://blog.csdn.net/weixin_43849277/article/details/120987789

# 三种秘钥配置方式
1. 启动命令时带上密钥
`java -jar -Djasypt.encryptor.password=xxx xxx.jar`
2. 将密钥配置到机器环境变量JASYPT_PASSWORD中并使用
`java -jar -Djasypt.encryptor.password=${JASYPT_PASSWORD} xxx.jar`
3. 配置文件配置(不安全)