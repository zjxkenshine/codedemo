<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>switch、case、default、break</title>
</head>
<body>
<div>
    <p>
        段位：
        <#-- switch指令会选择一个匹配的case指令并继续处理模板，遇到break指令会退出switch
             如果没有匹配的case指令，存在default指令，那么它会继续处理default指令
             否则就继续处理switch结束标签后的内容 -->
        <#switch rank>
            <#case 1>
                <span>青铜</span>
                <#break>
            <#case 2>
                <span>白银</span>
                <#break>
            <#case 3>
                <span>黄金</span>
                <#break>
            <#case 4>
                <span>铂金</span>
                <#break>
            <#case 5>
                <span>钻石</span>
                <#break>
            <#case 6>
                <span>王者</span>
                <#break>
            <#default>
                <span>无段位</span>
        </#switch>
    </p>
</div>
<hr/>
<div>
    <p>
        <#-- switch指令选择一个case指令后还会继续处理直到遇到break指令
             也就是它在遇到break指令前遇到另一个case指令或<#default>标签时也不会自动退出switch指令
             这就是向下通行 -->
        <#switch rank>
            <#case 1>
                <span>LV1</span>
            <#case 2>
                <span>LV2</span>
            <#case 3>
                <span>LV3</span>
            <#case 4>
                <span>LV4</span>
            <#case 5>
                <span>LV5</span>
            <#case 6>
                <span>LV6</span>
            <#default>
                <span>LV0</span>
        </#switch>
    </p>
</div>
</body>
</html>