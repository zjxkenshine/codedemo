<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list、else、items、sep、break、continue</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>index</th>
            <th>counter</th>
            <th>is_even_item</th>
            <th>is_odd_item</th>
            <th>item_parity</th>
            <th>item_parity_cap</th>
            <th>item_cycle</th>
            <th>is_first</th>
            <th>is_last</th>
            <th>has_next</th>
        </tr>
        </thead>
        <tbody>
        <#-- users为要迭代的序列或集合，user为循环变量 -->
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <#-- 通过循环变量内建函数访问当前迭代状态
                     注意，这些内建函数只能用于list和items指令的循环变量（已废弃的foreach指令也可以）
                     list指令没有指定循环变量时，这些内建函数就作用于items指令的循环变量
                     循环变量内建函数只使用循环变量的名称，这样它们可以识别相关的正在进行的迭代
                     它们并不读取循环变量的值 -->
                <#-- 返回当前迭代基于0的索引 -->
                <td>${user?index}</td>
                <#-- 返回当前迭代基于1的索引 -->
                <td>${user?counter}</td>
                <#-- 判断当前迭代项是否有一个基于1的偶数索引
                     c为布尔值内建函数，将布尔值转换为字符串 -->
                <td>${user?is_even_item?c}</td>
                <#-- 判断当前迭代项是否有一个基于1的奇数索引 -->
                <td>${user?is_odd_item?c}</td>
                <#-- 根据迭代当前所在的基于1的索引的奇偶性，返回字符串"odd"和"even" 通常用于表格中行间的颜色变换 -->
                <td>${user?item_parity}</td>
                <#-- 根据迭代当前所在的基于1的索引的奇偶性，返回字符串"Odd"和"Even" -->
                <td>${user?item_parity_cap}</td>
                <#-- 这是item_parity更为通用的版本，可以指定值来代替"odd"和"even"，允许多于两个值
                     参数个数至少为1，无上限，类型任意 -->
                <td>${user?item_cycle("□", "△", "○")}</td>
                <#-- 判断当前迭代项是否是第一项 -->
                <td>${user?is_first?c}</td>
                <#-- 判断当前迭代项是否是最后一项 -->
                <td>${user?is_last?c}</td>
                <#-- 判断当前迭代项是否不是最后一项 -->
                <td>${user?has_next?c}</td>
            </tr>
        <#-- else部分是可选的 -->
        <#else>
            <p>No users</p>
        </#list>
        </tbody>
    </table>
</div>
<div>
    <#-- 如果必须在第一个列表项之前或最后一个列表项之后打印一些内容，只要有至少一项，就可以使用items指令
         当list指令没有指定循环变量时，如果至少有一项，它的主体就会被执行一次，否则就完全不执行
         内嵌的items指令会执行每一项，因此items指令来定义循环变量而不是list指令 -->
    <#list users>
        <p>如果至少有一项，此处会被执行一次，否则就完全不执行</p>
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>username</th>
                <th>password</th>
                <th>index</th>
                <th>counter</th>
                <th>is_even_item</th>
                <th>is_odd_item</th>
                <th>item_parity</th>
                <th>item_parity_cap</th>
                <th>item_cycle</th>
                <th>is_first</th>
                <th>is_last</th>
                <th>has_next</th>
            </tr>
            </thead>
            <tbody>
            <#-- 不能将items指令移出到宏或包含的模板中，items指令不能嵌入else指令
                 list可以有多个items指令，但只有其中一个被允许执行，所以多个items可以用于不同的if-else分支，但不能迭代两次
                 items指令不能有自己的嵌套else指令，只有包含它的list指令可以有
                 循环变量user仅存在于items指令体内部 -->
            <#items as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <#-- 通过循环变量内建函数访问当前迭代状态
                         注意，这些内建函数只能用于list和items指令的循环变量（已废弃的foreach指令也可以）
                         list指令没有指定循环变量时，这些内建函数就作用于items指令的循环变量
                         循环变量内建函数只使用循环变量的名称，这样它们可以识别相关的正在进行的迭代
                         它们并不读取循环变量的值 -->
                    <#-- 返回当前迭代基于0的索引 -->
                    <td>${user?index}</td>
                    <#-- 返回当前迭代基于1的索引 -->
                    <td>${user?counter}</td>
                    <#-- 判断当前迭代项是否有一个基于1的偶数索引
                         c为布尔值内建函数，将布尔值转换为字符串 -->
                    <td>${user?is_even_item?c}</td>
                    <#-- 判断当前迭代项是否有一个基于1的奇数索引 -->
                    <td>${user?is_odd_item?c}</td>
                    <#-- 根据迭代当前所在的基于1的索引的奇偶性，返回字符串"odd"和"even"，通常用于表格中行间的颜色变换 -->
                    <td>${user?item_parity}</td>
                    <#-- 根据迭代当前所在的基于1的索引的奇偶性，返回字符串"Odd"和"Even" -->
                    <td>${user?item_parity_cap}</td>
                    <#-- 这是item_parity更为通用的版本，可以指定值来代替"odd"和"even"，允许多于两个值
                         参数个数至少为1，无上限，类型任意 -->
                    <td>${user?item_cycle("□", "△", "○")}</td>
                    <#-- 判断当前迭代项是否是第一项 -->
                    <td>${user?is_first?c}</td>
                    <#-- 判断当前迭代项是否是最后一项 -->
                    <td>${user?is_last?c}</td>
                    <#-- 判断循当前迭代项是否不是最后一项 -->
                    <td>${user?has_next?c}</td>
                </tr>
            </#items>
            </tbody>
        </table>
        <p>如果至少有一项，此处会被执行一次，否则就完全不执行</p>
    <#-- else部分是可选的 -->
    <#else>
        <p>No users</p>
    </#list>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>key</th>
            <th>index</th>
            <th>counter</th>
            <th>is_even_item</th>
            <th>is_odd_item</th>
            <th>item_parity</th>
            <th>item_parity_cap</th>
            <th>item_cycle</th>
            <th>is_first</th>
            <th>is_last</th>
            <th>has_next</th>
        </tr>
        </thead>
        <tbody>
        <#-- userMap为要迭代的Map，key为键，user为值 -->
        <#list userMap as key, user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${key}</td>
                <#-- 通过循环变量内建函数访问当前迭代状态
                     注意，这些内建函数只能用于list和items指令的循环变量（已废弃的foreach指令也可以）
                     list指令没有指定循环变量时，这些内建函数就作用于items指令的循环变量
                     循环变量内建函数只使用循环变量的名称，这样它们可以识别相关的正在进行的迭代
                     它们并不读取循环变量的值 -->
                <#-- 返回当前迭代基于0的索引 -->
                <td>${user?index}</td>
                <#-- 返回当前迭代基于1的索引 -->
                <td>${user?counter}</td>
                <#-- 判断当前迭代项是否有一个基于1的偶数索引
                     c为布尔值内建函数，将布尔值转换为字符串 -->
                <td>${user?is_even_item?c}</td>
                <#-- 判断当前迭代项是否有一个基于1的奇数索引 -->
                <td>${user?is_odd_item?c}</td>
                <#-- 根据迭代当前所在的基于1的索引的奇偶性，返回字符串"odd"和"even" 通常用于表格中行间的颜色变换 -->
                <td>${user?item_parity}</td>
                <#-- 根据迭代当前所在的基于1的索引的奇偶性，返回字符串"Odd"和"Even" -->
                <td>${user?item_parity_cap}</td>
                <#-- 这是item_parity更为通用的版本，可以指定值来代替"odd"和"even"，允许多于两个值
                     参数个数至少为1，无上限，类型任意 -->
                <td>${user?item_cycle("□", "△", "○")}</td>
                <#-- 判断当前迭代项是否是第一项 -->
                <td>${user?is_first?c}</td>
                <#-- 判断当前迭代项是否是最后一项 -->
                <td>${user?is_last?c}</td>
                <#-- 判断当前迭代项是否不是最后一项 -->
                <td>${user?has_next?c}</td>
            </tr>
        <#-- else部分是可选的 -->
        <#else>
            <p>No userMap</p>
        </#list>
        </tbody>
    </table>
</div>


<!-----------------------------sep指令 ----------------------------------------->
<div>
    <p>
        username:
        <#-- 当必须在每一项之间显示一些东西时（但不是在第一项之前或最后一项之后），可以使用sep指令 -->
        <#list users as user>
        <#-- 如果将sep指令放到包含的指令关闭的位置，则可以省略sep结束标签 -->
            ${user.username}<#sep>,
        </#list>
    </p>
    <p>
        password:
        <#list users as user>
            <span>
                <#-- 由于sep指令没有放在包含的指令（这里是list指令）关闭的位置，所以这里的sep结束标签不能省略 -->
                ${user.password}<#sep>、</#sep>
            </span>
        </#list>
    </p>
</div>


<!-----------------------------list嵌套 ----------------------------------------->
<div>
    <table>
        <#-- list指令可以嵌套 -->
        <#list 1..100 as i>
            <#if i gt 9>
            <#-- break指令可以退出迭代 -->
                <#break>
            </#if>
            <tr>
                <#list 1..100 as j>
                    <#if j gt i>
                        <#break>
                    </#if>
                    <td>${i} * ${j} = ${i * j}</td>
                </#list>
            </tr>
        </#list>
    </table>
</div>

<!------------------------------continue跳过迭代---------------------------------->
<div>
    <table>
        <#list 1..9 as i>
            <tr>
                <#if i % 2 == 0>
                <#-- continue指令跳过当前迭代的剩余部分，继续下一次迭代 -->
                    <#continue>
                </#if>
                <#list 1..9 as j>
                    <#if j gt i>
                        <#break>
                    </#if>
                    <#if j % 3 == 0>
                        <#continue>
                    </#if>
                    <td>${i} * ${j} = ${i * j}</td>
                </#list>
            </tr>
        </#list>
    </table>
</div>

<div>
    <table>
        <#-- 使用序列的内建函数来代替if和break的组合 -->
        <#assign seq = 1..100>
        <#-- 内建函数take_while返回只包含输入序列中第一个不符合参数条件的元素之前的元素的序列 -->
        <#list seq?take_while(i -> i lte 9) as i>
            <tr>
                <#list seq?take_while(j -> j lte i) as j>
                    <td>${i} * ${j} = ${i * j}</td>
                </#list>
            </tr>
        </#list>
    </table>
</div>
<hr/>
<div>
    <table>
        <#-- 使用序列的内建函数来代替if和break或continue的组合 -->
        <#assign seq = 1..9>
        <#-- 内建函数filter返回只包含参数条件返回真值的元素的序列 -->
        <#list seq?filter(i -> i % 2 != 0) as i>
            <tr>
                <#list seq?take_while(j -> j lte i)?filter(j -> j % 3 != 0) as j>
                    <td>${i} * ${j} = ${i * j}</td>
                </#list>
            </tr>
        </#list>
    </table>
</div>
<hr/>

<!-----------------------内建函数take_while、filter来代替if和break或continue的组合----------------->
<div>
    <table>
        <#-- 使用序列的内建函数来代替if和break的组合 -->
        <#assign seq = 1..100>
        <#-- 内建函数take_while返回只包含输入序列中第一个不符合参数条件的元素之前的元素的序列 -->
        <#list seq?take_while(i -> i lte 9) as i>
            <tr>
                <#list seq?take_while(j -> j lte i) as j>
                    <td>${i} * ${j} = ${i * j}</td>
                </#list>
            </tr>
        </#list>
    </table>
</div>
<hr/>
<div>
    <table>
        <#-- 使用序列的内建函数来代替if和break或continue的组合 -->
        <#assign seq = 1..9>
        <#-- 内建函数filter返回只包含参数条件返回真值的元素的序列 -->
        <#list seq?filter(i -> i % 2 != 0) as i>
            <tr>
                <#list seq?take_while(j -> j lte i)?filter(j -> j % 3 != 0) as j>
                    <td>${i} * ${j} = ${i * j}</td>
                </#list>
            </tr>
        </#list>
    </table>
</div>
<hr/>
<div>
    <#assign lines = ["Stop listing", "when a", "certain element", "", "is found"]>
    <p>
        if、break和sep指令一起使用：
        <#list lines as line>
            <#if line == ''>
                <#break>
            </#if>
            ${line}<#sep>,
        </#list>
    </p>
    <p>
        使用内建函数take_while代替if和break的组合：
        <#list lines?take_while(line -> line != '') as line>
            ${line}<#sep>,
        </#list>
    </p>
</div>


<#----------------------------局部变量隐藏全局普通变量 ---------------------------------->
<div>
    <#-- 局部变量会隐藏同名的普通变量，循环变量也会隐藏同名的局部变量和普通变量 -->
    <#assign x = "plain1">
    <p>1: ${x}</p>
    <@test/>
    <p>6: ${x}</p>
    <#list ["loop2"] as x>
        <p>7: ${x}</p>
        <#assign x = "plain2">
        <p>8: ${x}</p>
    </#list>
    <p>9: ${x}</p>
    <#macro test>
        <p>2: ${x}</p>
        <#local x = "local">
        <p>3: ${x}</p>
        <#list ["loop1"] as x>
            <p>4: ${x}</p>
        </#list>
        <p>5: ${x}</p>
    </#macro>
</div>

<#----------------------------局部变量隐藏外部变量 ---------------------------------->
<div>
    <#-- 内部循环变量会隐藏外部循环变量 -->
    <#list ["loop1"] as x>
        <p>1: ${x}</p>
        <#list ["loop2"] as x>
            <p>2: ${x}</p>
            <#list ["loop3"] as x>
                <p>3: ${x}</p>
            </#list>
            <p>4: ${x}</p>
        </#list>
        <p>5: ${x}</p>
    </#list>
</div>



</body>
</html>