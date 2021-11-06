<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>运算符</title>
</head>
<body>
<p>x=${x}, y=${y}</p>
<#-- 需要保证算术运算符两边都是结果为数字的表达式
     +号例外，如果+一边是数字，另一边是字符串，那么数字会转换成字符串，然后进行字符串连接 -->
<p>算术运算符：+、-、*、/、%</p>
<ul>
    <li><p>(y + x % 3) * (y - x / 2) ：${(y + x % 3) * (y - x / 2)}</p></li>
</ul>
<#-- ==或!=两边的表达式的结果都必须是标量，而且两个标量都必须是相同类型
     由于FreeMarker是精确比较，所以在比较字符串时要注意大小写和空格
     <、<=、>=、>不能作用于字符串 -->
<p>比较运算符：==、!=、>（gt）、<（lt）、>=（gte）、<=（lte）</p>
<ul>
    <li>
        <p>
            x == y：
            <#if x == y>
                x等于y
            <#else>
                x不等于y
            </#if>
        </p>
    </li>
    <li>
        <p>
            x != y：
            <#if x != y>
                x不等于y
            <#else>
                x等于y
            </#if>
        </p>
    </li>
    <li>
        <p>
            x > 5：
            <#-- 注意使用比较运算符>、>=时，FreeMarker解释>时可以把它当做ftl标签的结束符
                 为了避免该问题，可以用小括号括起来或用lt代替<、lte代替<=、gt代替>、gte代替>= -->
            <#if (x > 5)>
                x大于5
            <#else>
                x不大于5
            </#if>
        </p>
    </li>
    <li>
        <p>
            y lte 2：
            <#if y lte 2>
                y小于等于2
            <#else>
                y大于2
            </#if>
        </p>
    </li>
</ul>
<#-- 逻辑运算符只对布尔值起作用，否则，将出现错误导致模板处理中止 -->
<p>逻辑运算符：&&、||、!</p>
<ul>
    <li>
        <p>
            y lt x && -x gt -y：
            <#if y lt x && -x gt -y>
                true
            <#else>
                false
            </#if>
        </p>
    </li>
    <li>
        <p>
            -x <= -y || y >= x：
            <#if (-x <= -y || y >= x)>
                true
            <#else>
                false
            </#if>
        </p>
    </li>
    <li>
        <p>
            !(-x < -y || y gte x)：
            <#if !(-x < -y || y gte x)>
                true
            <#else>
                false
            </#if>
        </p>
    </li>
</ul>
</body>
</html>