# 1.Docker简介
1. Docker是一个开源项目，基于Go语言实现，目标是实现轻量级的操作系统虚拟化解决方案，基础是Linux容器(LXC)等技术
2. 与传统虚拟机相比，Docker优势体现为启动速度快、占用体积小

# 2.Docker组件
1. Docker服务器与客户端
    - 服务器内有很多容器
    - 客户端-守护进程-容器
    - 可以在同一台宿主机上运行Docker守护进程和客户端
2. 镜像：
    - 与虚拟机镜像类似
3. 容器：
    - 容器基于镜像启动，一旦容器启动，就可以进入容器中安装自己需要的软件或者服务
4. Registry(注册中心)
    - docker hub
    - 阿里云容器镜像服务
    
# 3.基本操作命令
1. 镜像相关
    - 查看镜像：`docker images`
    - 搜索镜像: `docker search 镜像名称`
    - 拉取镜像: `docker pull 镜像名称`
    - 删除镜像: `docker rmi 镜像ID`
2. 容器相关
    - 查看容器
        - 查看正在运行中的容器：`docker ps`
        - 查看所有容器：`docker ps -a`
        - 查看最后一次运行的容器：`docker ps -l`
        - 查看停止的容器：`docker ps -f status=exited`
    - 创建 `docker run...`
        - 交互方式:`docker run -it --name=容器名称 镜像名称:标签 /bin/bash`
        - 守护方式：`docker run -di --name=容器名称 镜像名称:标签`
            - 登录守护容器：`docker exec -it 容器名称(或容器ID) /bin/bash`
         - 端口映射：`docker run ... -p 宿主机端口:容器端口 /bin/bash`
    - 停止与启动容器
        - 启动容器：`docker start 容器名称(或容器ID)`,守护方式
        - 停止容器：`docker stop 容器名称(或容器ID)`
    - 文件拷贝:
        - 入：`docker cp 需要拷贝的文件或目录 容器名称(或ID):容器目录`
        - 出：`docker cp 容器名称(或ID):容器目录 需要拷贝的文件或目录`
    - 目录挂载：将宿主机目录和容器目录进行映射，这样可以通过修改宿主机某个目录文件从而影响容器
        - `docker run -di -v 宿主机目录:容器目录 --name=容器名称 镜像名称:tag`
        - `docker run -di -v 宿主机目录:容器目录 --privileged=true --name=容器名称 镜像名称:tag` 多级目录
    - 查看容器IP地址：
        - 各种数据：`docker inspect 容器名称(容器ID)`
        - 直接输出容器IP：`docker inspect --format='{{.NetworkSettings.IPAddress}}' 容器名称（容器ID）`
    - 删除容器
        - `docker rm 容器名称(或ID)`
        - 无法移除一个正在运行的容器，需要先停止后移除
3. 构建镜像操作：
    - Dockerfile构建镜像：`docker build -t='镜像名称 容器目录`,.为当前目录
    - 镜像是否构建完成：`docker images`
    - 标记镜像：`docker tag nginx 192.168.64.130:5000/mynginx01`
    - push到私服：
        - `docker start registry`
        - `docker push 192.168.64.130:5000/mynginx01`
    - 私服配置：`/etc/local/deamon.json`
        ```
            { "registry_mirrors": [https://docker.mirrors.ustc.edu.cn"], "insecure-registries": ["192.168.64.130:5000"] }
        ```
4. 迁移与备份
    - 容器保存为镜像：`docker commit 容器名 镜像名`
    - 镜像备份：将镜像保存为tar文件`docker save -o nginx01.tar mynginx01`
    - 镜像恢复与迁移：`docker load -i nginx01.tar`

        

    
