# 1.简介
在Filter中能修改的HttpServletRequest
- 用HttpServletRequestWrapper替换HttpServletRequest
- 用HttpServletResponseWrapper替换HttpServletResponse

# 2.使用场景
- Xss过滤
- HttpServletRequest参数多次读/修改

# 3.类结构
![](img/HttpServletRequest.jpg)