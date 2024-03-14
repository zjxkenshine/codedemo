# 参考地址
github 
- https://github.com/casbin/jcasbin

官网
- casbin.org

权限框架之jcasbin讲解
- https://blog.csdn.net/u012060033/article/details/132624403

关于springboot整合Jcasbin权限校验说明
- https://blog.csdn.net/qq_39361915/article/details/112953184

# 1.简介
jCasbin 是一个基于 RBAC 的权限访问控制框架。
## 1.1 PERM模型
在 Casbin 中, 访问控制模型被抽象为基于 PERM 的一个文件，描述了资源与用户之间的关系
- Policy：策略，定义权限的规则， p = {sub, obj, act, eft}，策略一般存储到数据库，因为会有很多
- Effect：影响，它决定我们是否可以放行
- Request：访问请求, r = {sub, obj, act}。它实际上定义了我们应该提供访问控制匹配功能的参数名称和顺序
- Matcher：匹配规则，判断 Request 是否满足 Policy。
- sub,obj,cat,eft含义
  - sub：subject，访问实体；
  - obj： object，访问的资源；
  - act： action，访问方法；
  - eft： effect，策略结果，一般为空，默认指定allow，还可以定义为deny
  
## 1.2 Model语法
Model是Casbin的具体访问模型，其主要以文件的形式出现，该文件常常以.conf最为后缀
```
# Request定义
[request_definition]
r = sub, obj, act

# 策略定义
[policy_definition]
p = sub, obj, act

# 角色定义
[role_definition]
g = _, _

[policy_effect]
e = some(where (p.eft == allow))

# 匹配器定义
[matchers]
m = g(r.sub, p.sub) && r.obj == p.obj && r.act == p.act
```
- 使用rbac需要添加`[role_definition]`部分
- request:它明确了 `e.Enforce()`函数中参数的含义。sub, obj, act 表示经典三元组: 访问实体 (Subject)，访问资源 (Object) 和访问方法 (Action)
- policy：部分的每一行称之为一个策略规则
- policy_effect：用于策略效果定义
  - some 是一个关键字，表示策略中是否存在符合后续条件的策略项。
  - where 是一个关键字，用于指定条件。
  - eft 属性表示策略的效果，通常用于表示允许访问
- role：角色，__表示通配符
- matchers：用于指定策略匹配的条件
    - g(r.sub, p.sub)：匹配主体
    - r.obj == p.obj：匹配对象
    - r.act == p.act：匹配方法

## 1.3 policy.csv
相当于一张权限表
```
p, zhangsan, data1, read
```