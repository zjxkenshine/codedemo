<#macro copyright date>
<#-- 数据模型中的变量在任何位置都是可见的，所以这里依然能访问到user -->
    <p>&copy; ${date} ${user.username}. All rights reserved.</p>
    <p>email: ${mail}</p>
</#macro>
<#assign mail = "${user.username}@xxx.com">