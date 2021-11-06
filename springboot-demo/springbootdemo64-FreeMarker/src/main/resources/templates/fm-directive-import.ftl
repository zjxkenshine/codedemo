<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>import</title>
</head>
<body>
<div>
    <#-- 导入一个库并创建新的命名空间，可用在导入的模板定义使导入模板可用的宏（macro）、函数和其他变量的集合
         import指令创建了一个hash变量my来访问它所创建的命名空间
         该变量位于导入模板所用的命名空间中，并作为进入导入库的命名空间的窗口 -->
    <#import "./libs/common.ftl" as com>
    <#-- 在当前命名空间（和标签所在模板关联的命名空间）创建了变量mail -->
    <#assign mail="rtx@xxx.com">
    <#-- 调用宏 -->
    <@com.copyright date = "2020-2021"/>
    <hr/>
    <#-- 使用hash变量来访问新创建的命名空间 -->
    <p>/libs/common.ftl的命名空间的变量mail: ${com.mail}</p>
    <#-- 创建或替换指定命名空间的变量，这里替换了用于/libs/common.ftl的命名空间的变量mail -->
    <#assign mail = "admin@xxx.com" in com>
    <p>/libs/common.ftl的命名空间的变量mail: ${com.mail}</p>
    <p>在当前命名空间的变量mail: ${mail}</p>
</div>
<div>
    <#-- 用同一path多次import，只在第一次调用import时创建命名空间并运行模板
         后面的调用将只是返回模板第一次被导入时创建和初始化的命名空间
         然后将相同的命名空间分配给指定的hash变量，通过该变量来访问命名空间 -->
    <#import "./libs/mylib.ftl" as my>
    <#import "./libs/common.ftl" as co>
    <#import "./libs/common.ftl" as cm>
    <#import "./libs/common.ftl" as om>
    <#-- 三个hash变量访问的都是同一个命名空间 -->
    <p>${com.mail}, ${co.mail}, ${cm.mail}, ${om.mail}</p>
    <#assign mail = "root@xxx.com" in co>
    <p>${com.mail}, ${co.mail}, ${cm.mail}, ${om.mail}</p>
</div>
</body>
</html>