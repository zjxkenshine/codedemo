# 1.minio特点
- 学习成本低，安装运维简单，开箱即用
- 纠删码  开启需要四个以上磁盘目录参数启动
- 一致性：Minio在分布式和单机模式下，所有读写操作都严格遵守read-after-write一致性模型

缺点：
- 不支持动态增加节点，需要使用其他方案支持扩容

# 2.windows安装服务简单过程
- 地址：https://github.com/winsw/winsw/releases
- 将WinSW.exe复制到自定义的目录，并重命名为自己想命名的服务名称minio-server.exe
- 同目录下创建minio-server.xml。特别注意，xml和exe必须同名
- 配置minio-server.xml文件
- 使用minio-server.exe install安装服务
- 安装完后，去服务中启动服务。启动成功就可以正常使用minio啦
- 使用minio-server.exe uninstall卸载服务
