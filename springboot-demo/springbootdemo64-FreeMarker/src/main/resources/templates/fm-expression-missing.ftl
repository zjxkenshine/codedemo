<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>处理不存在的值</title>
</head>
<body>
<p>默认值操作符</p>
<div>
    <ul>
        <li><p>name不存在时为默认值：${name!"No name"}</p></li>
        <#assign name = "RtxTitanV">
        <li><p>name存在时为name的值：${name!"No name"}</p></li>
        <#-- 默认值可以是任何类型的表达式 -->
        <li><p>num不存在时为默认值：${num!0}</p></li>
        <li>
            <p>
                users不存在时为默认值：[
                <#list users!["刘备", "关羽", "张飞"] as user>
                    "${user}"<#sep>,
                </#list>
                ]
            </p>
        </li>
        <#-- 如果默认值被省略了，那么它将同时是空字符串和空序列以及空哈希表 -->
        <li><p>message不存在时为默认值：${message!}</p></li>
        <#assign message = "Hello World">
        <li><p>message存在时为message的值：${message!}</p></li>
        <#-- 对于非顶层变量，默认值有两种使用方式 -->
        <li><p>第一种方式，user必须存在，否则会报错，user存在但username不存在才会使用默认值：${user.username!"No username"}</p></li>
        <#-- 当用小括号包围时，允许表达式的任意部分可以未定义，而没有小括号时，只允许表达式的最后部分未定义 -->
        <li><p>第二种方式，user不存在或user存在但username不存在都会使用默认值而不会报错：${(user.username)!"No username"}</p></li>
        <#assign seq = ["A", "B", "C"]>
        <#-- 默认值操作符也可以作用于序列子变量，序列索引为负数时会出错 -->
        <li><p>默认值操作符也可以作用于序列子变量：[${seq[0]!"?"}, ${seq[1]!"?"}, ${seq[2]!"?"}, ${seq[3]!"?"}, ${seq[4]!"?"}]</p></li>
    </ul>
</div>
<p>不存在值检测操作符</p>
<ul>
    <li>
        <p>
            password是否存在：
            <#-- 不存在值检测操作符可以检测一个值是否存在，结果为true和false，对于非顶层变量，规则与默认值操作符相同 -->
            <#if (user.password)??>
                存在
            <#else>
                不存在
            </#if>
        </p>
    </li>
</ul>
</body>
</html>
