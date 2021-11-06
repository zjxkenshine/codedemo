<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>日期内建函数</title>
</head>
<body>
<div>
    <#-- 可以用来指定日期变量的哪部分在使用 -->
    <p>日期时间（datetime）：${date?datetime}</p>
    <p>日期（date）：${date?date}</p>
    <p>时间（time）：${date?time}</p>
    <p>以指定的格式将日期类型转换为字符串类型（string）：</p>
    <p>
        <ul>
            <#-- 由于FreeMarker不能决定数据模型中的日期变量是日期，时间还是日期-时间，在这种情况下，
                 ${date?string.short}这种写法没有指定要显示的确定字段，FreeMarker不指定如何显示该值，最终模板会中止执行并报错
                 为了防止这种情况，可以用?date、?time和?datetime来确定要显示的部分 -->
            <li><p>short: ${date?datetime?string.short}</p></li>
    <li><p>medium: ${date?datetime?string.medium}</p></li>
    <li><p>long: ${date?datetime?string.long}</p></li>
    <li><p>full: ${date?datetime?string.full}</p></li>
    <li><p>iso: ${date?datetime?string.iso}</p></li>
    <li><p>iso_m_u: ${date?datetime?string.iso_m_u}</p></li>
    <li><p>xs: ${date?datetime?string.xs}</p></li>
    <li><p>xs_ms_nz: ${date?datetime?string.xs_ms_nz}</p></li>
    <#-- 指定了格式之后可以不用?date、?time和?datetime，格式可以是变量或任意表达式 -->
    <li><p>${date?string["yyyy/MM/dd EEEE a hh:mm:ss"]}</p></li>
    <li><p>${date?date?string["yyyy"]}年${date?date?string["MM"]}月${date?date?string["dd"]}日</p></li>
    <li><p>${date?time?string["hh"]}时${date?time?string["mm"]}分${date?time?string["ss"]}秒</p></li>
    </ul>
    </p>
</div>
</body>
</html>
