# 参考地址
SpringBoot整合Light Security框架
- https://www.cnblogs.com/pxblog/p/14446623.html

Light Security
- https://gitee.com/itmuch/light-security

# light security简介
特点：
- 上手快速
- 开箱即用
- 轻量级，代码精简，不到500行代码；
- 功能实用，市面上安全框架常见能力与套路均已具备：
    - 支持 RESTful 权限控制
    - 支持灵活的权限配置(代码配置方式优先级更高)
    - 支持基于配置文件的权限配置
    - 支持基于代码的权限控制
    - 支持基于注解的权限控制
    - 设计简单，没有复杂概念；
    
Spring Web编程模型
- 基于权限配置的方式：核心是1个拦截器
- 基于注解的权限控制：核心是1个切面
WebFlux编程模型
- 基于权限配置的方式：核心是1个过滤器
- 基于注解的权限控制：核心是1个切面

# 测试脚本
### 第一步：模拟登陆，返回token
GET http://localhost:8009/login


### 【可入】第二步：请求带上token，请求/user端点，该端点需要具备admin/user角色之一才能访问
GET http://localhost:8009/user
Authorization:Bearer 第一步返回的token


### 【无权】第三步：请求带上token，请求/user-no-access端点，该端点需同时具备admin/user/xx角色之一才能访问
GET http://localhost:8009/user-no-access
Authorization:Bearer 第一步返回的token


### 【可入】第四步：请求带上token，请求/annotation-test端点，该端点必须同时具备admin以及user角色才能访问
GET http://localhost:8009/annotation-test
Authorization:Bearer 第一步返回的token


### 【无权】第五步：请求带上token，请求/annotation-test-no-access端点，该端点必须同时具备admin、user、xx角色才能访问
GET http://localhost:8009/annotation-test-no-access
Authorization:Bearer 第一步返回的token
