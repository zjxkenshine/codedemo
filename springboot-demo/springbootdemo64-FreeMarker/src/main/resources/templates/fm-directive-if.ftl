<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>if、else、elseif</title>
</head>
<body>
<h1>只有if，没有elseif和else</h1>
<div>
    <p>
        成绩是否是正常数据：
        <#-- 注意使用比较运算符>、>=时，FreeMarker解释>时可以把它当做ftl标签的结束符
             为了避免该问题，可以用小括号括起来或用lt代替<、lte代替<=、gt代替>、gte代替>= -->
        <#if (grade >= 0 && grade <=100)>
            <span>成绩数据正常</span>
        </#if>
    </p>
</div>
<h1>只有if和else，没有elseif</h1>
<div>
    <p>
        成绩是否及格：
        <#if grade gte 60>
            <span>及格</span>
        <#else>
            <span>不及格</span>
        </#if>
    </p>
</div>
<h1>只有if和elseif，没有else</h1>
<div>
    <p>
        成绩对应的级别：
        <#if (grade < 0 || grade > 100)>
            <span>无效数据</span>
        <#elseif (grade < 60)>
            <span>不及格</span>
        <#elseif (grade < 70)>
            <span>差</span>
        <#elseif (grade < 90)>
            <span>良</span>
        <#elseif (grade <= 100)>
            <span>优</span>
        </#if>
    </p>
</div>
<h1>if、else、elseif都有</h1>
<div>
    <p>
        成绩对应的级别：
        <#if grade lt 0 || grade gt 100>
            <span>无效数据</span>
        <#elseif grade gte 90>
            <span>优</span>
        <#elseif grade gte 70>
            <span>良</span>
        <#elseif grade gte 60>
            <span>差</span>
        <#else>
            <span>不及格</span>
        </#if>
    </p>
</div>
<h1>嵌套if指令</h1>
<div>
    <p>
        成绩对应的级别：
        <#if grade gte 0 && grade lte 100>
            <#if grade gte 60>
                <#if grade gte 70>
                    <#if grade gte 90>
                        <span>优</span>
                    <#else>
                        <span>良</span>
                    </#if>
                <#else>
                    <span>差</span>
                </#if>
            <#else>
                <span>不及格</span>
            </#if>
        <#else>
            <span>无效数据</span>
        </#if>
    </p>
</div>
</body>
</html>
