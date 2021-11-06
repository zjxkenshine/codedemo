<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>global</title>
</head>
<body>
<div>
    <p>数据模型中的username: ${username}</p>
    <#-- global指令创建的变量（全局变量）会隐藏数据模型中的同名变量 -->
    <#global username = "MaChao">
    <p>global指令创建的变量username会隐藏数据模型中的username: ${username}</p>
    <p>此时使用特殊变量globals访问的是全局变量username: ${.globals.username}</p>
    <#-- 仍然可以使用特殊变量data_model访问数据模型中的变量 -->
    <p>可以使用特殊变量data_model访问数据模型中的变量username: ${.data_model.username}</p>
    <#-- 在当前命名空间，相同名称的变量存在会隐藏global指令创建的变量 -->
    <#assign username = "ZhangFei">
    <p>assign指令在当前命名空间创建的变量username隐藏了global指令创建的变量username: ${username}</p>
    <#-- 使用特殊变量globals不但可以访问数据模型中的变量，还可以访问global指令创建的变量 -->
    <p>可以使用特殊变量globals访问全局变量username: ${.globals.username}</p>
</div>
</body>
</html>
