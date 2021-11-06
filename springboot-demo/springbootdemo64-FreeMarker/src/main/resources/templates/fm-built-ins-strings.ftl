<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>字符串内建函数</title>
</head>
<body>
<div>
    <#-- 字符串字符串必须是true或false（大小写敏感），或必须是由boolean_format设置的特定格式
         否则访问该内建函数时，会发生错误终止模板 -->
    <p>
        字符串转为布尔值（boolean）：
        <#if "true"?boolean>
            true
        </#if>
        <#if !"false"?boolean>
            false
        </#if>
    </p>
    <#-- 可以识别科学记数法，从FreeMarker 2.3.21版本开始，可以识别所有XML Schema数字格式，如NaN、INF、-INF，以及Java本地格式Infinity和-Infinity -->
    <p>
        字符串转换为数字（number）：
        ${"8"?number}、${"0.88"?number}、${"8.88E8"?number}、
        ${"NaN"?number}、${"INF"?number}、${"-INF"?number}、${"Infinity"?number}、${"-Infinity"?number}
    </p>
    <p>字符串中首单词的首字母大写（cap_first）：${str1?cap_first}</p>
    <p>字符串中首单词的首字母小写（uncap_first）：${str2?uncap_first}</p>
    <p>字符串转换为小写形式（lower_case）：${user.username?lower_case}</p>
    <p>字符串转换为大写形式（upper_case）：${user.username?upper_case}</p>
    <p>
        检查字符串是否包含指定子串（contains）：
        <#if user.username?contains("FreeMarker")>
            包含Freemarker
        <#else>
            不包含FreeMarker
        </#if>
    </p>
    <p>
        检查字符串是否以指定子串开头（ends_with）：
        <#if user.username?starts_with("SpringBoot")>
            字符串以SpringBoot开头
        <#else>
            字符串没有以SpringBoot开头
        </#if>
    </p>
    <p>
        检查字符串是否以指定子串结尾（ends_with）：
        <#if user.username?ends_with("Test")>
            字符串以Test结尾
        <#else>
            字符串没有以Test结尾
        </#if>
    </p>
    <p>如果字符串没有以第一个参数指定的子串开头，就会将它加到字符串前面，否则返回原字符串（ensure_starts_with）：${user.username?ensure_starts_with("用户名是")}、${user.username?ensure_starts_with("Spring")}</p>
    <p>如果字符串没有以第一个参数指定的子串结尾，就会将它加到字符串后面，否则返回原字符串（ensure_ends_with）：${user.username?ensure_ends_with("是用户名")}、${user.username?ensure_ends_with("Test")}</p>
    <#-- 如果第一个参数作为子串没有在该字符串中出现时（如果使用了第二个参数，那么就从给定的索引开始），返回-1 -->
    <p>返回字符串中第一次出现子串时的索引（index_of）：${user.username?index_of("in")}</p>
    <#-- 第二个参数的数值没有限制，如果是负数，效果和0一样，如果比字符串的长度大，和是字符串长度那个数效果一样 -->
    <p>返回字符串中第一次出现子串时的索引，指定开始搜索的索引位置（index_of）：${user.username?index_of("in", 5)}</p>
    <p>返回字符串中最后一次出现子串时的索引（last_index_of）：${user.username?last_index_of("in")}</p>
    <p>返回字符串中第一次出现子串时的索引，指定开始搜索的索引位置（last_index_of）：${user.username?last_index_of("in", 5)}</p>
    <p>字符串中字符数量（length）：${user.username?length}</p>
    <p>去除字符串首尾空格（trim）：${user.password?trim}</p>
    <#-- 如果没有找到参数字符串，会返回空串；如果参数是长度为0的字符串，会返回未改变的源字符串 -->
    <p>保留字符串中给定子串第一次出现之后的部分（keep_after）：${user.username?keep_after("-")}</p>
    <p>保留字符串中给定子串最后一次出现之后的部分（keep_after_last）：${user.username?keep_after_last("-")}</p>
    <p>保留字符串中给定子串第一次出现之前的部分（keep_before）：${user.username?keep_before("-")}</p>
    <p>保留字符串中给定子串最后一次出现之前的部分（keep_before_last）：${user.username?keep_before_last("-")}</p>
    <p>从字符串开头移除给定子串，如果字符串不以给定子串开头，会返回源字符串（remove_beginning）：${user.username?remove_beginning("Spring")}、${user.username?remove_beginning("spring")}</p>
    <p>从字符串结尾移除给定子串，如果字符串不以给定子串结尾，会返回源字符串（remove_ending）：${user.username?remove_ending("-Test")}、${user.username?remove_ending("-test")}</p>
    <#-- 字符串截断至给定长度并附加一个终止符字符串（默认为[...]，可以另外指定），如果字符串的长度不超过给定长度，则原样返回
         结束符字符串的长度也算在给定长度内，当给定长度比结束符字符串的长度短时，结果长度也可以比给定长度长，这种情况下，结束符字符串仍然原样返回
         还有一个额外的参数可以指定终止符字符串的假定长度，否则使用实际长度 -->
    <p>
        字符串截断至给定长度并附加一个终止符字符串（truncate）：
        <ul>
            <li>
                <#-- 如果截断发生在词的边界，那么在词尾和终止符串之间就有一个空格，否则它们之间就没有空格 -->
    <p>倾向于在词的边界处截断，但如果结果长度小于指定长度的75%，还是会在词的中间截断（truncate）：${str1?truncate(18)}、${str1?truncate(22)}、${str1?truncate(34)}、${str1?truncate(3)}、${str1?truncate(18, "...")}、${str1?truncate(18, "...", 1)}</p>
    </li>
    <li>
        <p>总是在词的边界处截断（truncate_w）：${str1?truncate_w(18)}、${str1?truncate_w(22)}、${str1?truncate_w(18, "...")}、${str1?truncate_w(18, "...", 1)}</p>
    </li>
    <li>
        <p>任何字符处截断（truncate_c）：${str1?truncate_c(18)}、${str1?truncate_c(22)}、${str1?truncate_c(18, "...")}、${str1?truncate_c(18, "...", 1)}</p>
    </li>
    </ul>
    </p>
    <#-- 字符串替换不处理单词边界，从左向右执行，若第一个参数为空串，那么所有空字符串都将被替换 -->
    <p>字符串替换（replace）：${user.username?replace("-", "_")}、${"ABABA"?replace("ABA", "BAB")}、${user.username?replace("", "_")}</p>
    <p>
        沿着另一字符串的出现处将字符串拆分为序列（split）：
        <#list user.username?split("-")>
            [
            <#items as s>
                ${s}<#sep>,
            </#items>
            ]
        </#list>
    </p>
    <p>
        包含字符串中所有单词的序列，顺序为出现在字符串中的顺序（word_list）：
        <#list user.password?word_list as word>
            [${word}]<#sep>,
        </#list>
    </p>
    <#-- 如果只有1个参数，则用空格补齐，直到整个字符串长度达到参数指定的长度
         如果有两个参数，则用第二个参数指定的字符串补齐到指定长度，如果参数2字符串长度大于1，则该字符串会周期性插入 -->
    <p>字符串从左侧补齐至指定长度（left_pad）：</p>
    <p>
        [${""?left_pad(5)}]、[${"A"?left_pad(5)}]、[${"AB"?left_pad(5)}]、
        [${"ABC"?left_pad(5)}]、[${"ABCDEF"?left_pad(5)}]、[${""?left_pad(5, "#")}]、
        [${"A"?left_pad(5, "#")}]、[${"AB"?left_pad(5, "#")}]、[${"ABC"?left_pad(5, "#")}]、
        [${"ABCDEF"?left_pad(5, "#")}]、[${""?left_pad(10, "^_^")}]、[${"A"?left_pad(10, "^_^")}]、
        [${"ABC"?left_pad(10, "^_^")}]、[${"ABCDE"?left_pad(10, "^_^")}]、[${"ABCDEFG"?left_pad(10, "^_^")}]
    </p>
    <p>字符串从右侧补齐至指定长度（right_pad）：</p>
    <p>
        [${""?right_pad(5)}]、[${"A"?right_pad(5)}]、[${"AB"?right_pad(5)}]、
        [${"ABC"?right_pad(5)}]、[${"ABCDEF"?right_pad(5)}]、[${""?right_pad(5, "#")}]、
        [${"A"?right_pad(5, "#")}]、[${"AB"?right_pad(5, "#")}]、[${"ABC"?right_pad(5, "#")}]、
        [${"ABCDEF"?right_pad(5, "#")}]、[${""?right_pad(10, "^_^")}]、[${"A"?right_pad(10, "^_^")}]、
        [${"ABC"?right_pad(10, "^_^")}]、[${"ABCDE"?right_pad(10, "^_^")}]、[${"ABCDEFG"?right_pad(10, "^_^")}]
    </p>
</div>
</body>
</html>