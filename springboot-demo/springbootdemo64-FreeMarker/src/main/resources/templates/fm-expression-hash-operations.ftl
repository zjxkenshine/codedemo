<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>哈希表操作</title>
</head>
<body>
<h1>哈希表连接</h1>
<div>
    <table>
        <thead>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>key</th>
        </thead>
        <tbody>
        <#list map1 + map2 as k, v>
            <tr>
                <td>${v.id}</td>
                <td>${v.username}</td>
                <td>${v.password}</td>
                <td>${k}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>
