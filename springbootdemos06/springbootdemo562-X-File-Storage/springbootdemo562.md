# 参考地址
x-file-storage 
- https://gitee.com/dromara/x-file-storage

# 简介
一行代码将文件存储到 本地、FTP、SFTP、WebDAV、谷歌云、阿里云OSS、华为云OBS、七牛云Kodo、腾讯云COS、百度云 BOS、又拍云USS、MinIO、 AWS S3、金山云 KS3、美团云 MSS、京东云 OSS、天翼云 OOS、移动云 EOS、沃云 OSS、 网易数帆 NOS、Ucloud US3、青云 QingStor、IBM COS 等平台

# 踩坑
```
java.lang.NoSuchMethodError: okhttp3.RequestBody.create([BLokhttp3/MediaType;)Lokhttp3/RequestBody;
```
- 自行引入okhttp-4.9.3

```
The request signature we calculated does not match the signature you provided. Check your key and signing method
```
- access-key与secret-key不正确

# 其他功能
参考官方文档
- x-file-storage.dromara.org
- x-file-storage.xuyanwu.cn
- spring-file-storage.xuyanwu.cn