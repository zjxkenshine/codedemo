# 参考地址
License3j 免费许可证管理库
- https://github.com/verhas/License3j

创建秘钥对程序
- https://github.com/verhas/license3jrepl

# 使用步骤
1. 下载 License3jrepl<p>
    下载地址：
    - https://github.com/verhas/License3jRepl/releases/download/3.1.5/License3jrepl-3.1.5-jar-with-dependencies.jar
    
2. 运行：需要jdk9以上环境
    ```
    D:\Program2\jdk\jdk17\bin\java -jar License3jrepl-3.1.5-jar-with-dependencies.jar
    # java -jar License3jrepl-3.1.5-jar-with-dependencies.jar  
    L3j> $ generateKeys algorithm=RSA size=1024 format=BASE64 public=public.key private=private.key
    ```
    - 会生成秘钥对
3. 执行dumpPublicKey获得Key<p>
并将生成的key复制到代码中
   
4. 创建license
    ```
    L3j> $ newLicense
    ```
    
5. 设置license内容并保存
    ```
    L3j> $ feature id:INT=12345
    L3j> $ feature name:STRING=kenshine
    L3j> $ saveLicense format=BASE64 license.base64
    ```

6. 签名
   ```
    L3j> $ sign
    L3j> $ saveLicense format=BASE64 license.base64
   ```
   
7. 校验签名
    ```
    L3j> $ verify
    ```
   


    