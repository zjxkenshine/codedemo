# 参考地址
license-tool 用于分析和操作开源的许可证标头的工具
- https://github.com/kohsuke/license-tool

# 参数说明 LicenseTool.Arguments接口
- `-validate`：设置为true以验证版权标头；如果为false，则根据需要生成/更新/插入版权标头
- `-verbose`：设置为true可获取有关每个文件所执行操作的信息
- `-dryrun`：设置为true以避免修改任何文件
- `-roots`：要处理的目录列表
- `-skipdirs`：跳过的目录名列表
- `-copyright`：包含版权标头文本的文件。不得包含任何注释字符
- `-startyear`：版权起始日期
- `-endyear`：版权终止日期
- `-options`：其他参数
- `-vcs`：版本控制系统
- `-uselastmodified`： 如果文件的最后修改日期晚于年末，则设置为true以使用VCS历史记录中文件的最后一次修改日期

# 使用测试 LicenseTest
- test01：校验开源License标头
- test02：生成开源License标头(test02.html中的Copyright生成)
