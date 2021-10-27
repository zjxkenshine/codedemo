# springbootdemo23 参考文档
Springboot2.0 邮件发送
- https://blog.csdn.net/qq_32258777/article/details/86641728




# 配置
```
# 新浪邮箱配置
spring:
 mail:
   host: smtp.exmail.qq.com
   username: chenmingjian@asdeven.com
   password: aA282423456
   default-encoding: UTF-8

# QQ邮箱配置
spring:
 mail:
   host: smtp.qq.com
   username: chenmingjian@qweeeven.com
   password: aA28123445  # 不是邮箱密码，而是授权码
   default-encoding: UTF-8

# 网易系(126/163/yeah)邮箱配置
spring:
  mail:
    host: smtp.126.com # 如果是163邮箱，则 smtp.163.com
    username: chenmingjian@asddeven.com
    password: aA2824412334 # 不是邮箱密码，而是授权码
    default-encoding: UTF-8
```