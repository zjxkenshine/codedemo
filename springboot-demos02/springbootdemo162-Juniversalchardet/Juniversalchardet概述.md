# 1.简介
编码检测工具

# 2.使用步骤
1. 构造`org.mozilla.universalchardet.UniversalDetector`实例
2. 向检测器提供数据：`UniversalDetector.handleData()`
3. 通知检测结束：`UniversalDetector.dataEnd()`
4. 获取检测编码名称：`UniversalDetector.getDetectedCharset()`
5. 重置检测器：`UniversalDetector.reset()`
