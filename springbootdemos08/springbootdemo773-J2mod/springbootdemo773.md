# 参考地址
github
- https://github.com/steveohara/j2mod/wiki

Modbus，看这个就行了
- https://zhuanlan.zhihu.com/p/377071153

j2mod相关文章系列
- https://cloud.tencent.com/developer/search/article-j2mod

# j2mod简介
- j2mod是一个开源的Modbus协议Java实现。它支持Modbus RTU和Modbus TCP，并且提供了主站和从站的功能。
- 你可以使用j2mod来创建Modbus主站来读取和写入Modbus从站设备，前身是jamod。
- 主站：客户端 从站：服务端

# J2mod库对指令码的定义
读操作：
- READ_COILS (1): 读取线圈状态（开关状态）。
- READ_DISCRETE_INPUTS (2): 读取输入状态（离散输入）。
- READ_HOLDING_REGISTERS (3): 读取保持寄存器的内容。
- READ_INPUT_REGISTERS (4): 读取输入寄存器的内容。

写操作：
- WRITE_SINGLE_COIL (5): 写入单个线圈状态。
- WRITE_SINGLE_REGISTER (6): 写入单个保持寄存器的内容。
- WRITE_MULTIPLE_COILS (15): 写入多个线圈状态。
- WRITE_MULTIPLE_REGISTERS (16): 写入多个保持寄存器的内容。

读写文件记录：
- READ_FILE_RECORD (20): 读取文件记录。
- WRITE_FILE_RECORD (21): 写入文件记录。

其他功能码：
- READ_EXCEPTION_STATUS (7): 读取异常状态。
- DIAGNOSTIC (8): 诊断。
- GET_COMM_EVENT_COUNTER (11): 获取通信事件计数器。
- GET_COMM_EVENT_LOG (12): 获取通信事件日志。