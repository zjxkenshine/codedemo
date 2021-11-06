<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>哈希表内建函数</title>
</head>
<body>
<div>
    <#-- 可以使用<#list attrs as key, value>...<#list>同时列出键和值 -->
    <#-- 因为哈希表通常没有定义子变量的顺序，所以键的返回顺序是任意的 -->
    <p>包含哈希中所有查询到的键的序列（keys）：</p>
    <table>
        <thead>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>key</th>
        </thead>
        <tbody>
        <#list userMap?keys as key>
            <tr>
                <td>${userMap[key].id}</td>
                <td>${userMap[key].username}</td>
                <td>${userMap[key].password}</td>
                <td>${key}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div>
    <p>包含哈希中所有值的序列（values）：</p>
    <table>
        <thead>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        </thead>
        <tbody>
        <#list userMap?values as value>
            <tr>
                <td>${value.id}</td>
                <td>${value.username}</td>
                <td>${value.password}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>
