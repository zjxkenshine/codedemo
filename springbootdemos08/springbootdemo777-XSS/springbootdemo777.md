# 参考地址
Spring Boot 如何防护 XSS + SQL 注入攻击 ？终于懂了
- https://blog.csdn.net/weiwosuoai/article/details/137095047

# XSS漏洞概述
跨站脚本攻击XSS是指攻击者往Web页面里插入恶意Script代码，当用户浏览该页之时，嵌入其中Web里面的Script代码会被解析执行，从而达到恶意攻击用户的目的。XSS攻击针对的是用户层面的攻击！

## XSS攻击分类
- 存储型XSS： 存储型XSS，持久化，代码是存储在服务器中的，如在个人信息或发表文章等地方，插入代码，如果没有过滤或过滤不严，那么这些代码将储存到服务器中，用户访问该页面的时候触发代码执行。这种XSS比较危险，容易造成蠕虫，盗窃cookie
- 反射型XSS： 非持久化，需要欺骗用户自己去点击链接才能触发XSS代码（服务器中没有这样的页面和内容），一般容易出现在搜索页面
- DOM型XSS： 不经过后端，DOM-XSS漏洞是基于文档对象模型(DOM)的一种漏洞，DOM-XSS是通过url传入参数去控制触发的，其实也属于反射型XSS。

## 防护建议
- 限制用户输入，表单数据规定值得类型，例如年龄只能是int，name为字母数字组合。
- 对数据进行html encode处理。
- 过滤或移除特殊的html标签。
- 过滤javascript事件的标签。

## 两种过滤方式
- XssHttpServletRequestWrapper+XssFilter
- MappingJackson2HttpMessageConverter+StringDeserializer