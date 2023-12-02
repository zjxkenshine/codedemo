# 参考地址
ZipTrack分析并发程序的踪迹，压缩为slp(直线程序)，并检查是否存在数据竞争
- https://github.com/umangm/ziptrack

rv-predict 生成trace数据
-  https://runtimeverification.com/predict
-  https://runtimeverification.github.io/rv-toolkit-docs/predict/java/quickstart/
-  https://github.com/runtimeverification/predict/releases

rv-predict 详见 springbootdemo500-RvPredict
```
-javaagent:F:\IDEAworkespace\codedemo\springbootdemos05\springbootdemo499-Ziptrack\lib\rv-predict.jar="--base-log-dir F:\IDEAworkespace\codedemo\springbootdemos05\springbootdemo499-Ziptrack\file
```

# jar使用
- 下载源码
- ant编译打jar包
- 使用jar包 java -jar 方式

```
java -classpath ziptrack/lib/*;ziptrack.jar PrintTrace -p=F:\IDEAworkespace\codedemo\springbootdemos05\springbootdemo499-Ziptrack\file\rv-predict -f=rv -m=F:\IDEAworkespace\codedemo\springbootdemos05\springbootdemo499-Ziptrack\file\rv-predict\map.txt > F:\IDEAworkespace\codedemo\springbootdemos05\springbootdemo499-Ziptrack\file\rv-predict\trace.txt 
```

# 源码类说明
- PrintTrace.java：RV-Predict 运行时断言 https://runtimeverification.com/predict
- ZipHB.java：用于HB race检测压缩轨迹
- ZipLockSet.java：用于检测在压缩轨迹上违反锁集规则的情况
- ZipMetaInfo.java：用于打印痕迹特性
- TransformGrammar.java：用于将一个SLP S转换成另一个SLP S'，该SLP S'具有更多只有终端符号的产生规则
    - 如将`A -> b1 . . . bk C d1 . . . dm `转换
    ```
      A -> B C D
      B -> b1 . . . bk
      D -> d1 . . . dm
    ```
