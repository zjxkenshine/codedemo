<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>数字内建函数</title>
</head>
<body>
<div>
    <p>求给定数字的绝对值（abs）：${(-5)?abs}</p>
    <p>数字转换为字符串（c）：${num?c}、${num2?c}</p>
    <#-- 1, 2, 3等转换为字符串"a", "b", "c"等，到达"z"会继续转换为"aa", "ab"等，数字最小为1，无上限 -->
    <p>
        数字转换为小写字母（lower_abc）：
        <#list 1..30 as i>
            ${i?lower_abc}<#sep>,
        </#list>
    </p>
    <p>
        数字转换为大写字母（upper_abc）：
        <#list 1..30 as i>
            ${i?upper_abc}<#sep>,
        </#list>
    </p>
    <#-- 向正无穷方向进位 -->
    <p>返回最近的整数，以.5结尾将进位（round）：${0.25?round}、${0.5?round}、${1.75?round}、${(-0.25)?round}、${(-0.5)?round}、${(-1.75)?round}</p>
    <#-- 向负无穷方向舍弃 -->
    <p>返回舍弃小数后的整数（floor）：${0.25?floor}、${0.5?floor}、${1.75?floor}、${(-0.25)?floor}、${(-0.5)?floor}、${(-1.75)?floor}</p>
    <#-- 向正无穷方向进位 -->
    <p>返回小数进位后的整数（ceiling）：${0.25?ceiling}、${0.5?ceiling}、${1.75?ceiling}、${(-0.25)?ceiling}、${(-0.5)?ceiling}、${(-1.75)?ceiling}</p>
    <p>
        数字转换成字符串（string）：
        <ul>
            <#-- 四种预定义数字格式：number、currency、percent、computer -->
            <li><P>${num?string}、${num?string.number}、${num?string.currency}、${num2?string.percent}、${num?string.computer}</P></li>
    <li><p>最小整数位为1，保留1位小数：${num2?string["0.0"]}</p></li>
    <li><p>最小整数位为3，保留2位小数：${num2?string["000.00"]}</p></li>
    <li><p>最小整数位为1，保留4位小数：${num2?string["0.####"]}</p></li>
    <li><p>最小整数位为4，保留5位小数：${num2?string["0000.#####"]}</p></li>
    <li><p>科学计数法：${num?string["0.##E0"]}</p></li>
    </ul>
    </p>
</div>
</body>
</html>
