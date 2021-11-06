<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>macro、nested、return</title>
</head>
<body>
<div>
    <#-- 变量会在模板开始时被创建，而不管macro指令放置在模板的什么位置，所以可以将调用宏放在宏定义之前 -->
    <@copy/>
    <#-- 在当前命名空间中创建一个宏（macro）变量，宏变量存储模板片段，可以被用作自定义指令 -->
    <#macro copy>
        <p>&copy; 2021 Kenshine . All rights reserved.</p>
    </#macro>
</div>


<#--宏可以带参数，参数可以设置默认值-->
<div>
    <#-- 宏可以带有参数，当将宏变量作为指令时，必须给所有参数赋值，除了有默认值的参数
         默认值当且仅当调用宏而不给参数赋值时起作用 -->
    <#macro mac x y = 20>
        <p>计算${x}和${y}的平均值：${(x + y) / 2}</p>
    </#macro>
    <@mac 10/>
    <@mac x = 20 y = 30/>
</div>

<#--宏支持可变数量的位置参数，不管它是使用位置参数还是命名参数传递-->
<div>
    <#-- 支持可变数量的位置参数的宏，不管它是使用位置参数还是命名参数传递 -->
    <#macro avg nums...>
        <#local sum = 0>
        <p>
            <#if nums?is_sequence>
                <#list nums>
                    计算
                    <#items as num>
                        <#local sum += num>
                        ${num}<#sep>、
                    </#items>
                    的平均值：
                </#list>
                <#if nums?size != 0>
                    ${sum / nums?size}
                </#if>
            <#else>
                <#list nums>
                    计算
                    <#items as key, num>
                        <#local sum += num>
                        ${key}（${num}）<#sep>、
                    </#items>
                    的平均值：
                </#list>
                <#if nums?size != 0>
                    ${sum / nums?size}
                </#if>
            </#if>
        </p>
    </#macro>
    <@avg/>
    <@avg 10 20 30/>
    <@avg 10 20 30 40/>
    <@avg a = 20 b = 30 c = 40/>
    <@avg a = 20 b = 30 c = 40 d = 50/>
</div>


<#--宏支持命名参数和可变数量的参数混合使用，不管它是使用位置参数还是命名参数传递。-->
<div>
    <#-- 支持命名参数和可变数量的参数混合使用的宏，不管它是使用位置参数还是命名参数传递 -->
    <#macro m a b ext...>
        <ul>
            <li><p>a = ${a}</p></li>
            <li><p>b = ${b}</p></li>
            <ul>
                <#if ext?is_sequence>
                    <#list ext as e>
                        <li><p>ext[${e?index}] = ${e}</p></li>
                    </#list>
                <#else>
                    <#list ext as k, v>
                        <li><p>${k} = ${v}</p></li>
                    </#list>
                </#if>
            </ul>
        </ul>
    </#macro>
    <@m 1 3 5 7 9/>
    <@m a = 2 b = 4 c = 6 d = 8 e = 10/>
</div>


<!--宏也可以递归调用-->
<div>
    <#assign reslut = 1>
    <#-- 用于计算阶乘的宏 -->
    <#macro factorial num>
        <#if num lt 0>
            <#assign reslut = "num不能小于0">
        </#if>
        <#if num gt 1>
            <#assign reslut *= num>
        <#-- 递归调用宏计算阶乘 -->
            <@factorial num = num - 1/>
        </#if>
    </#macro>
    <@factorial num/>
    <p>${num}的阶乘为：${reslut}</p>
</div>


<#--nested指令执行自定义指令开始和结束标签中间的模板片段。如果没有调用nested指令，自定义指令开始和结束标签中的部分将会被忽略。nested指令可以对嵌套内容创建循环变量-->
<div>
    <#macro nested_test count>
        <table>
            <#list 1..count as i>
                <tr>
                    <#list 1..count as j>
                        <#if j lte i>
                        <#-- nested指令执行自定义指令开始和结束标签中间的模板片段
                             嵌套的片段可以包含模板中任意合法的内容，在宏调用的地方被执行
                             如果没有调用nested指令，自定义指令开始和结束标签中的部分将会被忽略
                             nested指令可以对嵌套内容创建循环变量 -->
                            <#nested i, j, i * j>
                        </#if>
                    </#list>
                </tr>
            </#list>
        </table>
    </#macro>
    <@nested_test 9; i, j>
        <td>${i} * ${j} = ${i * j}</td>
    </@nested_test>
</div>


<#--使用return指令可以将宏或函数定义体停留在任何位置-->
<div>
    <#macro return_test>
        <p>&copy; 2021 Kenshine . All rights reserved.</p>
         <#-- return指令可以将宏或函数定义体停留在任何位置 -->
        <#return>
        <p>email: Kenshine@xxx.com</p>
    </#macro>
    <@return_test/>
</div>



</body>
</html>
