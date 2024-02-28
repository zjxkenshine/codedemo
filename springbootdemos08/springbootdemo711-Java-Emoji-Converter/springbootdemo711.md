# 参考地址
java-emoji-converter Emoji转换工具，便于各种规格客户端生成的Emoji字符串转换成另外一种格式
- https://gitee.com/binary/java-emoji-converter

# 踩坑
PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException
- HTTPS 域名的公钥证书不在 JDK/JRE 的证书库中，被Java认为是不可信的
- 解决：https://www.cnblogs.com/hellxz/p/15349026.html
