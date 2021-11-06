<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>布尔值内建函数</title>
</head>
<body>
<div>
    <#-- 不管boolean_format设置是什么，结果是"true"或"false" -->
    <p>布尔值转换为字符串（c）：${(grade > 60)?c}、${(grade <= 60)?c}</p>
</div>

<div>
    <p>布尔值转换为字符串（string）：</p>
    <ul>
        <#-- 布尔值为true，则返回第一个参数，否则返回第二个参数，返回值总是字符串 -->
        <li><p>成绩是否及格：${(grade > 60)?string("及格", "不及格")}</p></li>
    </ul>
</div>
<div>
    <#-- booleanExp为true，则返回第一个参数，否则返回第二个参数，参数表达式可以是任意类型，也可以是不同类型 -->
    <p>使用booleanExp?then(whenTrue, whenFalse)，类似于三元运算符（then）：</p>
    <ul>
        <li>
            <p>
                成绩对应级别：${(grade gte 0 && grade lte 100)?then((grade gte 60)?then((grade gte 70)?then((grade gte 90)?then("优", "良"), "差"), "不及格"), "无效数据")}
            </p>
        </li>
    </ul>
</div>
</body>
</html>
