<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>序列内建函数</title>
</head>
<body>
<div>
    <p>序列子变量的数量（size）：${users?size}</p>
    <p>序列的第一个子变量（first）：${users?first}</p>
    <p>序列的最后一个子变量（last）：${users?last}</p>
    <#-- 序列中不是字符串的项会被转换为字符串，参数1为给定分隔符，参数2为代替空序列的值，参数3为列表结尾
         来自Java的序列中的null值会被该内建函数忽略 -->
    <p>使用给定分隔符将序列的所有项串联成一个字符串（join）：${users?join("-", "[]", ".")}、${[]?join("-", "[]", ".")}</p>
    <p>判断序列中是否包含指定值（seq_contains）：${colors?seq_contains("green")?then("yes", "no")}、${colors?seq_contains("black")?then("yes", "no")}</p>
    <#-- 如果第一个参数指定的值没有在该序列中出现时（如果使用了第二个参数，那么就从给定的索引开始），返回-1 -->
    <p>返回序列中第一次出现指定值时的索引（seq_index_of）：${colors?seq_index_of("green")}</p>
    <#-- 第二个参数的数值没有限制，如果是负数，效果和0一样，如果比序列的长度大，和是序列长度那个数效果一样 -->
    <p>返回序列中第一次出现指定值时的索引，指定开始搜索的索引位置（seq_index_of）：${colors?seq_index_of("green", 3)}</p>
    <p>返回序列中最后一次出现指定值时的索引（seq_last_index_of）：${colors?seq_last_index_of("green")}</p>
    <p>返回序列中最后一次出现指定值时的索引，指定开始搜索的索引位置（seq_last_index_of）：${colors?seq_last_index_of("green", 3)}</p>
</div>
<div>
    <#-- 参数1指定拆分后子序列的大小（必须是数字，至少为1），参数2（以是任意类型的值）用来填充最后一个序列，以达到给定大小 -->
    <p>将序列拆分成给定大小的多个序列（chunk）：</p>
    <table>
        <#list colors?chunk(3, "?") as row>
            <tr>
                <#list row as color><td>${color}</td></#list>
            </tr>
        </#list>
    </table>
</div>
<div>
    <p>序列的反序形式（reverse）：</p>
    <table>
        <thead>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        </thead>
        <tbody>
        <#list users?reverse as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div>
    <#-- 只在子变量都是字符串，或都是数字，或都是日期值，或都是布尔值时起作用，子变量都是字符串时的排序通常是大小写不敏感的 -->
    <p>
        以升序的方式返回序列（sort）：
        <#list colors?sort>
            [
            <#items as color>
                "${color}"<#sep>,
            </#items>
            ]
        </#list>
    </p>
</div>
<div>
    <#-- 如果要降序排列，在使用该内建函数后还要使用reverse -->
    <p>返回按给定哈希表子变量升序排序的哈希序列（sort_by）：</p>
    <table>
        <thead>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        </thead>
        <tbody>
        <#list users?sort_by("username") as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div>
    <p>返回包含输入序列中从第一个不符合参数条件的元素开始的元素的序列（drop_while）：<#list colors?drop_while(color -> color?length <= 5) as color>"${color}" </#list></p>
    <p>返回只包含输入序列中第一个不符合参数条件的元素之前的元素的序列（take_while）：<#list colors?take_while(color -> color?length <= 5) as color>"${color}" </#list></p>
    <p>返回只包含参数条件返回真值的元素的序列（filter）：<#list colors?filter(color -> color?length <= 5) as color>"${color}" </#list></p>
</div>
</body>
</html>