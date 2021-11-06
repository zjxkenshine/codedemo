<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>include</title>
</head>
<body>
<div>
    <#assign date = "2020-2021">
    <#assign mail = "rtx@xxx.com">
    <#-- 在模板中插入另一个FreeMarker模板文件，被包含的文件和包含它的模板共享变量 -->
    <#include "./libs/copyright.ftl">
    <hr/>
    <#include "./libs/common.ftl">
    <#-- 如果宏（macro）定义是用include指令插入的，那么在FreeMarker执行include指令之前，它们将无法使用
         所以调用include指令插入的宏需在include之后进行 -->
    <@copyright date = "2021-2022"/>
</div>
</body>
</html>
