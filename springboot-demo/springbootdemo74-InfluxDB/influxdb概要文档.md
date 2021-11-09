# 1.时间序列数据库TSDB
- 时间序列数据库。主要用于指处理带时间标签（按照时间的顺序变化，即时间序列化）的数据
    - 带时间标签的数据也称为时间序列数据
- 主要由电力行业、化工行业等各类型实时监测、检查与分析设备所采集、产生的数据
- TSDB特点
    - 有效处理庞大数据
    - 对重复的部分，Informix TimeSeries只保持一份数据
    - 节省空间50%，有效降低I/O
    - 主键索引更有效
    - 时间序列表头分离的特性不浪费空间
    

# 2.InfluxDB概述
- InfluxDB是一个由InfluxData开发的开源时序型数据库。它由Go写成，着力于高性能地查询与存储时序型数据
- 特点：
    - 内置HTTP接口，使用方便
    - 数据可以打标记，这样查询可以很灵活
    - 类SQL的查询语句（2.x变为了flux语句）
    - 安装管理很简单，并且读写数据很高效
    - 能够实时查询，数据在写入时被索引后就能够被立即查出
    
# 3.InfluxDB相关概念
1. InfluxQL：类sql
    ```
    -- 创建数据库 CREATE DATABASE mobai; 
    -- 查看所有数据库 SHOW DATABASES; 
    -- 指定使用的数据库 USE mobai; 
    -- 删除数据库 DROP DATABASE mobai; 
    -- 查看保留策略 SHOW retention policies ON mobai; 
    -- 创建保留策略rp-one-year CREATE retention policy "rp-one-year" ON "mobai" duration 365d replication 1 
    -- 更改保留策略rp-one-year为mobai的默认策略 ALTER retention policy "rp-one-year" ON "mobai" duration 365d replication 1 DEFAULT 
    -- 删除保留策略 DROP retention policy "rp-one-year" ON "mobai";
    ```
2. InfluxDB表Measurement: 在InfluxDB中，无需显式创建表，在写入时序数据时，InfluxDB服务器会根据行协议，按需自动创建对应的表
    - 其他基础操作详见：https://jasper-zhang1.gitbooks.io/influxdb/content/
    - windows启动：`start influxd.exe`
    - 进入控制台: `influx`
3. NTP：
    - InfluxDB使用服务器本地时间给数据加时间戳，而且是UTC时区的，并使用NTP来同步服务器之间的时间
    - 如果服务器的时钟没有通过NTP同步，那么写入InfluxDB的数据的时间戳就可能不准确
4. 添加用户密码：默认没有用户密码，配置文件开启密码配置
    ```
        create user "root" with password 'zjx123456' with all privileges
        # 用户密码登录
        influx -username  root -password zjx123456
    ```
    



