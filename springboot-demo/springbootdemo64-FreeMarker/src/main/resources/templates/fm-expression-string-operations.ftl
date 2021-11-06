<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>字符串操作</title>
</head>
<body>
<p>插值和连接</p>
<div>
    <ul>
        <li>
            <#-- 可以在字符串字面量中使用${}在字符串中插入表达式的值 -->
            <#assign message = "Hello ${user.username} !">
            <p>message: ${message}</p>
        </li>
        <li>
            <#-- 也可以使用+号将表达式的值连接到字符串中，达到类似于插值的效果 -->
            <#assign message = "Hello " + user.username + " !">
            <p>message: ${message}</p>
        </li>
    </ul>
</div>
<p>获取字符</p>
<div>
    <ul>
        <li><p>username索引为0的字符：${user.username[0]}</p></li>
        <li><p>username索引为3的字符：${user.username[3]}</p></li>
        <li><p>username索引为8的字符：${user.username[8]}</p></li>
    </ul>
</div>
<p>字符串切分（子串）</p>
<div>
    <ul>
        <li><p>username从0到2（包括2）的子串：${user.username[0..2]}</p></li>
        <li><p>username从0到2（不包括2）的子串：${user.username[0..<2]}</p></li>
        <li><p>username从3开始长度为5的子串：${user.username[3..*5]}</p></li>
        <li><p>username从3开始长度为100的子串（切分长度已经超过了从开始索引到被切分字符串末尾的长度，所以这里只截取到字符串末尾）：${user.username[3..*100]}</p></li>
        <li><p>username从3开始一直到末尾的子串：${user.username[3..]}</p></li>
    </ul>
</div>
</body>
</html>
