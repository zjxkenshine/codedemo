# 参考地址
Saturn 分布式任务调度
- https://gitee.com/vipshop/Saturn

唯品会分布式任务调度平台Saturn使用手册
- https://blog.csdn.net/qq_34982426/article/details/82153376

vip saturn任务调度器使用：saturn升级支持sb2.x记要
- https://blog.csdn.net/meiliangdeng1990/article/details/100940867

唯品会开源分布式作业调度平台Saturn
- https://blog.csdn.net/xuri24/article/details/107302456

# 源码编译踩坑
1. 编译saturn-console-web时出现 
    ```
    Command execution failed.: Cannot run program "sh"
    ```
    - 删除`<executable>sh</executable>`及相关代码

2. Failed to clean project: Failed to delete F:\Github\Saturn-v3.5.1\saturn-executor\target\saturn-executor-master-SNAPSHOT\lib\zookeeper-3.4.14.jar
    - 手动clean target,重新编译

3. 找不到saturn-plugin
    - 切换到saturn-plugin目录运行mvn install

4.  network request to http://npm.tools.vipshop.com/repository/npm_public/zrender/-/zrender-4.0.5.tgz failed
    - http://npm.tools.vipshop.com/没了
    - npm-shrinkwrap.json 相关配置删除，使用默认地址

5. gyp verb check python checking for Python executable "python2" in the PATH
    - 安装python2，并设置PATH
    
# 详见源码文档
docs目录，官方文档已崩