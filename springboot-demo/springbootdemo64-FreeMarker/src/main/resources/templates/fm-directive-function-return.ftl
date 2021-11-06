<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>function、return</title>
</head>
<body>
<#-- 计算两个数的平均值的方法 -->
<#-- func为方法变量的名称，x、y为存储参数的值（不是表达式）的局部变量名称，=后面的默认值（是表达式）可选 -->
<#-- 没有默认值的参数必须在有默认值的参数之前 -->
<#function func x y = 20>
    <#return (x + y) / 2>
</#function>

<#-- 计算多个数的平均值的方法 -->
<#-- 最后一个参数可以可选的包含一个尾部省略号（...），表示接受可变数量的参数，nums是额外参数的序列 -->
<#function avg nums...>
<#-- 和assign指令类似，但是它创建或替换局部变量，它只能在macro和function内部定义才起作用 -->
    <#local sum = 0>
    <#list nums as num>
        <#local sum += num>
    </#list>
    <#if nums?size != 0>
        <#return sum / nums?size>
    </#if>
</#function>

<#assign reslut = 1>
<#-- 计算一个自然数的阶乘的方法 -->
<#function factorial num>
    <#if num lt 0>
        <#return "num不能小于0">
    </#if>
    <#if num gt 1>
        <#assign reslut *= num>
    <#-- 递归调用方法计算阶乘 -->
        ${factorial(num - 1)}
    </#if>
    <#return reslut>
</#function>

<div>
    <p>计算10和20的平均值：${func(10)}</p>
    <p>计算20和30的平均值：${func(20, 30)}</p>
    <p>计算10、20、30的平均值：${avg(10, 20, 30)}</p>
    <p>计算10、20、30、40的平均值：${avg(10, 20, 30, 40)}</p>
    <#-- 如果到达</#function>（即没有return返回值），那么方法的返回值就是未定义变量 -->
    <p>计算平均值，没有传参数：${avg()!"N/A"}</p>
    <p>${num}的阶乘为：${factorial(num)}</p>
</div>
</body>
</html>
