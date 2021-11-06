<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>assign</title>
</head>
<body>
<div>
    <#-- 使用该指令可以创建一个新的变量，或替换一个已经存在的变量，注意只有顶级变量可以被创建或替换 -->
    <p><#assign username = "username: ${user.username}" password = "password: ${user.password}">${username}, ${password}</p>
    <hr/>
    <#-- 赋值运算符，也可以是以下简写的运算符之一：++、--、+=、-=、*=、/=、%= -->
    <p><#assign x = user.id x++ y = 3 y += x>x: ${x}, y: ${y}</p>
    <hr/>
    <p>orders:</p>
    <ul>
        <#-- 变量seq存储一个序列 -->
        <#assign seq = orders>
        <#list seq as order>
            <li>
                <p>index: ${order_index}</p>
                <ul>
                    <li><p>orderId: ${order.orderId}</p></li>
                    <li><p>orderNumber: ${order.orderNumber}</p></li>
                    <li><p>orderDescription: ${order.orderDescription}</p></li>
                </ul>
            </li>
        </#list>
    </ul>
    <hr/>
    <#-- 导入一个库并创建新的命名空间，可用在导入的模板定义使导入模板可用的宏（macro）、函数和其他变量的集合
         import指令创建了一个hash变量my来访问它所创建的命名空间
         该变量位于导入模板所用的命名空间中，并作为进入导入库的命名空间的窗口 -->
    <#import "./libs/mylib.ftl" as my>
    <#-- 使用hash变量来访问新创建的命名空间 -->
    <p>/libs/mylib.ftl的命名空间的变量mail: ${my.mail}</p>
    <#-- 创建或替换指定命名空间的变量，这里替换了用于/libs/mylib.ftl的命名空间的变量mail -->
    <#assign mail = "admin@xxx.com" in my>
    <p>/libs/mylib.ftl的命名空间的变量mail: ${my.mail}</p>
    <#-- 在当前命名空间（和标签所在模板关联的命名空间）创建了变量mail -->
    <#assign mail = "rtx@xxx.com">
    <p>在当前命名空间的变量mail: ${mail}</p>
    <hr/>
    <#-- assign指令的极端用法：捕捉在其起始标签和结束标签之间产生的输出
         标签之间的内容不会显示在页面上，但会存储在变量中 -->
    <#assign out>
        <#list orders as order>
            <p>orderId: ${order.orderId}, orderNumber: ${order.orderNumber}, orderDescription: ${order.orderDescription}</p>
        </#list>
    </#assign>
    <#-- 内建函数word_list包含字符串中所有单词的序列，内建函数size为序列中子变量（相当于Java中的数组元素）的个数 -->
    <p>单词数量：${out?word_list?size}</p>
    <p>${out}<br/></p>
</div>
</body>
</html>
