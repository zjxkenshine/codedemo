# 参考地址
coderush/id-generator
- https://gitee.com/darkranger/id-generator

官方版本为独立部署rest服务，这里使用Maven整合

# 方法
IdConverter
- convert：ID与long互转

IdService                   Test01
- genId：生成id
- expId：解析id，返回ID对象
- transTime：解析时间戳
- makeId：传入参数生成ID 
    - 根据时间戳和序列号生成ID
    - 根据时间戳、机器ID和序列号生成ID

SnowflakeIdWorker：雪花算法    Test02
- nextId：生成id


