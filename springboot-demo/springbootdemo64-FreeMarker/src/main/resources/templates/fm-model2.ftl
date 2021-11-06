<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>数据模型</title>
</head>
<body>
<p>(root)</p>
<div>
    <ul>
        <li><p>accountId = ${accountId}</p></li>
        <li><p>accountName = "${accountName}"</p></li>
        <li><p>accountPassword = "${accountPassword}"</p></li>
        <li><p>user</p></li>
        <ul>
            <li><p>id = ${user.id}</p></li>
            <li><p>username = "${user.username}"</p></li>
            <li><p>password = "${user.password}"</p></li>
        </ul>
        <li><p>orders</p></li>
        <ul>
            <#-- list指令：<#list sequence as loopVariable>repeatThis</#list> -->
            <#list orders as order>
                <li>
                    <p>(${order?index})</p>
                    <ul>
                        <li><p>orderId = ${order.orderId}</p></li>
                        <li><p>orderNumber = "${order.orderNumber}"</p></li>
                        <li><p>orderDescription = "${order.orderDescription}"</p></li>
                        <li><p>account</p></li>
                        <ul>
                            <li><p>accountId = ${order.account.accountId}</p></li>
                            <li><p>accountName = "${order.account.accountName}"</p></li>
                            <li><p>accountPassword = "${order.account.accountPassword}"</p></li>
                            <li><p>user</p></li>
                            <ul>
                                <li><p>id = ${order.account.user.id}</p></li>
                                <li><p>username = "${order.account.user.username}"</p></li>
                                <li><p>password = "${order.account.user.password}"</p></li>
                            </ul>
                        </ul>
                    </ul>
                </li>
            </#list>
        </ul>
    </ul>
</div>
</body>
</html>
