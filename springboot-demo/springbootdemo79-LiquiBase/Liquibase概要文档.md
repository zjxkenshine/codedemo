# 1.Liquibase概述
Liquibase是一个用于跟踪、管理和应用数据库变化的开源的数据库重构工具。它将所有数据库的变化（包括结构和数据）都保存在XML文件中，便于版本控制。

# 2.Liquibase特点
- 不依赖于特定的数据库
- 提供数据库比较功能，比较结果保存在XML中，基于该XML你可用Liquibase轻松部署或升级数据库
- 以XML存储数据库变化，其中以作者和ID唯一标识一个变化（ChangSet），支持数据库变化的合并
- 在数据库中保存数据库修改历史，在数据库升级时自动跳过已应用的变化
- 提供变化应用的回滚功能，可按时间、数量或标签（tag）回滚已应用的变化
- 可生成数据库修改文档（HTML格式）
- 提供数据重构的独立的IDE和Eclipse插件

# 3.基本规范
- ChangeSet id使用[任务ID]-[日期]-[序号]，如 T100-20181009-001
- ChangeSet必须填写author
- Liquibase禁止对业务数据进行sql操作
- 使用<sql>时，禁止包含schema名称
- Liquibase禁止使用存储过程
- 所有表，列要加remarks进行注释
- 已经执行过的ChangeSet严禁修改。
- 不要随便升级项目liquibase版本，特别是大版本升级。不同版本ChangeSet MD5SUM的算法不一样

# 4.ChangeLog也支持YAML格式或JSON格式
- https://blog.csdn.net/vicky_pyh/article/details/88979062

