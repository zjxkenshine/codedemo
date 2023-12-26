# 参考地址
Smallrye-Health 系统健康检查 主要用于Quarkus项目
- https://github.com/smallrye/smallrye-health
- https://smallrye.io/docs/smallrye-health/3.0.1/index.html

- 4.0.4 java11环境
- 3.3.1 java8环境

需要3.8.1以上版本Maven

# 概念
- Health Groups：健康组，健康组只是用户定义的一组健康检查
    - 预设值的组：liveness和readiness
- Health Registry：健康注册表提供了一种以程序方式注册健康检查的方法

# 启动
- `./mvnw quarkus:dev`

# 访问地址
- localhost:8080/q/health：所有健康检查
- localhost:8080/q/health/live：运行中
- localhost:8080/q/health/ready：准备中
- localhost:8080/q/health/started：启动中