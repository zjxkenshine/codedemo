# 参考地址
FileService 基于Spring Boot 2.6.6的基本文件管理，包括上传、下载、分页查询、删除
- https://github.com/Verlif/file-spring-boot-starter

jdk9以上

通过FileService来使用以下功能：
- 文件上传（字节流与Base64）
- 上传文件后缀限制（allowed名单与blocked名单）
- 文件下载（字节流与Base64）
- 文件查询（分页、排序、文件名过滤等）
- 文件删除

# 踩坑
C:\Users\Administrator\AppData\Local\Temp\tomcat.8080.14176818269059022904\work\Tomcat\localhost\ROOT\tmp\upload\test\test.txt (系统找不到指定的路径。)
- MultipartConfigElement bean进行修改
- 或者在application.yml中进行配置
- 启用fileservice station配置