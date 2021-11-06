<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>attempt、recover</title>
</head>
<body>
<div>
    <#-- 使用attempt和recover指令，即使页面某一部分输出失败，也可以让页面成功输出 -->
    <#attempt>
    <#-- attempt块总是会被执行，但是如果期间发生错误，该块的输出将会回滚，并且recover块会被执行 -->
        <p>username: ${user.username}, password: ${user.password}</p>
        <#recover>
        <#-- recover块只在attempt块执行期间发生错误时被执行，可以在这里打印错误信息或进行其他操作 -->
            <p>出现错误啦！</p>
    </#attempt>
</div>
</body>
</html>
