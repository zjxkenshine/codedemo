<#ftl output_format="HTML" auto_esc=false>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>autoesc、noautoesc</title>
</head>
<body>
<div>
    <#autoesc>
        <p>启用auto-escaping：${hello}</p>
    <#-- noautoesc指令可以嵌套在autoesc指令中使用，以重新禁用auto-escaping功能 -->
        <#noautoesc>
            <p>重新禁用auto-escaping：${hello}</p>
        </#noautoesc>
        <p>?no_esc也可以在autoesc指令中使用，不对单个插值进行转义：${hello?no_esc}</p>
    </#autoesc>
    <#-- 在auto-escaping（自动转义）被禁用的情况下，只转义单个插值时可以使用${expression?esc}代替autoesc指令 -->
    <p>只转义单个插值的情况下代替autoesc指令的语法：${hello?esc}</p>
    <p>由于禁用了auto-escaping，不使用autoesc指令或?esc则不会转义：${hello}</p>
</div>
</body>
</html>
