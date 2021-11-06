<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>escape、noescape</title>
</head>
<body>
<div>
    <#-- escape指令中出现的插值会和转义表达式自动结合 -->
    <#escape esc as esc?html>
        <p>开启转义：${hello}</p>
    <#-- noescape指令关闭转义 -->
        <#noescape>
            <p>关闭转义：${hello}</p>
        </#noescape>
    </#escape>
</div>
<hr/>
<div>
    <#-- 与escape指令等价 -->
    <p>开启转义：${hello?html}</p>
    <#-- 与noescape指令等价 -->
    <p>关闭转义：${hello}</p>
</div>
<hr/>
<div>
    <#-- 在调用宏（macro）或include指令时，转义只对模板文本中escape开始标签和结束标签之间的插值起作用
         也就是说，它不会转义文本中escape开始标签之前或escape结束标签之后的任何内容
         即使该部分是在escape内部调用的 -->
    <#-- 定义宏 -->
    <#macro m1>
        <p>m1: ${hello}</p>
    </#macro>
    <#escape esc as esc?html>
        <#macro m2>
            <p>m2: ${hello}</p>
        </#macro>
        <p>${hello}</p>
    <#-- 调用宏 -->
        <@m1/>
    </#escape>
    <p>${hello}</p>
    <@m2/>
</div>
</body>
</html>