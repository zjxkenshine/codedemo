<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>直接指定值</title>
</head>
<body>
<div>
    <ul>
        <li><p>字符串：</p></li>
        <ul>
            <li><p>${"It's double quote: \"\", this is a backslash: \\"}</p></li>
            <li><p>${'It\'s double quote: "", this is a backslash: \\'}</p></li>
            <#-- 直接在模板中输入本文 -->
            <li><p>It's double quote: "", this is a backslash: \</p></li>
            <#-- 通过转义的方式打印具有特殊含义的${} -->
            <li><p>${"$\{user}"}</p></li>
            <#-- 通过原生字符串（引号前加r）打印具有特殊含义的${}以及\，原生字符串是一种特殊的字符串，${}和\在其中没有特殊含义，被视为普通字符串 -->
            <li><p>${r"${user}, C:\Windows"}</p></li>
        </ul>
        <li><p>数字：${1}、${+1}、${001}、${1.00}、${-1}、${0.11}</p></li>
        <#-- c为布尔值内建函数，将布尔值转换为字符串 -->
        <li><p>布尔值：${true?c}、${false?c}</p></li>
        <li>
            <p>
                序列：[
                <#list ["刘备", "关羽", "张飞"] as name>
                    "${name}"<#sep>,
                </#list>
                ]
            </p>
        </li>
        <li><p>值域：</p></li>
        <ul>
            <li>
                <#-- 1..9: [1, 2, 3, 4, 5, 6, 7, 8, 9] -->
                <p>
                    1..9: [
                    <#list 1..9 as i>
                        ${i}<#sep>,
                    </#list>
                    ]
                </p>
            </li>
            <li>
                <#-- 1..<9: [1, 2, 3, 4, 5, 6, 7, 8] -->
                <p>
                    1..<9: [
                    <#list 1..<9 as i>
                        ${i}<#sep>,
                    </#list>
                    ]
                </p>
            </li>
            <li>
                <#-- 5..*6: [5, 6, 7, 8, 9, 10] -->
                <p>
                    5..*6: [
                    <#list 5..*6 as i>
                        ${i}<#sep>,
                    </#list>
                    ]
                </p>
            </li>
        </ul>
        <li>
            <p>
                哈希表：{
                <#list {"id": 1, "username": "admin", "password": "123456"} as k, v>
                    <#if k == "id">
                        "${k}": ${v}<#sep>,
                    <#else>
                        "${k}": "${v}"<#sep>,
                    </#if>
                </#list>
                }
            </p>
        </li>
    </ul>
</div>
</body>
</html>
