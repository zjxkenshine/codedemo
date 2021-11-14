# 1.Memcached 介绍
- Memcached是一个分布式内存对象缓存系统
- 已经逐渐被Redis所取代
- 连接：`telnet HOST PORT`

# 2.Memcached命令一览
## 2.1 存储命令
1. set：设置值，key已存在会更新，注意value是在第二行
    ```
    set key flags exptime bytes [noreply] 
    value 
    ```
    - flags：存储关于键值对的额外信息
    - bytes：在缓存中存储的字节数
    - exptime: 过期时间，默认秒，0为不过期
    - noreply：不需要返回
2. add：设置值，key已存在且未过期不会更新
    ```
    add key flags exptime bytes [noreply] 
    value
    ```
3. replace：替换，key不存在失败
    ```
    replace key flags exptime bytes [noreply]
    value
    ```
4. append：追加数据
    ```
    replace key flags exptime bytes [noreply]
    value
    ```
5. prepend：在前面追加数据，用法同上
6. CAS：检查并设置，原子写入(通过cas_token参数进行检查)
    ```
    cas key flags exptime bytes unique_cas_token [noreply]
    value
    ```
## 2.2 查找命令
1. get：获取值
    ```
    get key
    get key1 key2 key3
    ```
2. gets：获取带有CAS令牌的值，用法同上
3. delete：删除已存在的 key
    ```
    delete key [noreply]
    ```
4. incr与decr：自增或自减

## 2.3 统计命令
1. stats: 返回统计信息例如 PID(进程号)、版本号、连接数等
2. stats items：显示各个 slab 中 item 的数目和存储时长(最后一次访问距离现在的秒数)
3. stats slabs：显示各个slab的信息，包括chunk的大小、数目、使用情况等
4. stats sizes：显示所有item的大小和个数
5. flush_all：清理缓存中的所有键值对
    ```
    flush_all [time] [noreply]
    ```
    - time：指定时间后清理

# 3.Java客户端
1. Memcached-java-client 较老，不学
2. xmemcached
3. spymemcached

# 4.与Redis比较
- https://blog.csdn.net/xhf852963/article/details/100096858




