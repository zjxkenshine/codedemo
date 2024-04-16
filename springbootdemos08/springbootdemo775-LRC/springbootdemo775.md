# 参考地址
常用校验算法
- https://blog.csdn.net/niepangu/article/details/42556745

- https://weibo.com/6003386492/IEUO7jZQX

# 冗余校验
在通讯时采取数据校验的一种办法。数据传输时，虽然数据的起始字符和结束字符可以避免参与通信的设备收到无用的数据信息/干扰信息，
但对于起始字符和结束字符之间的数据，还是可能受到干扰而产生错误，因此对通信数据进行校验是非常必要的。
校验的方法是在数据的最后加上一个冗余信息，这个信息是对数据校验的结果，所以数据校验也称之为冗余校验。
循环冗余码校验是最常用的校验方法之一。

# LRC算法过程
1. 对需要校验的数据（2n个字符）两两组成一个16进制的数值求和。
2. 将求和结果与256求余数。
3. 用256减去所得余数值得到校验结果（另一种方法：将余数值按位取反然后加1）。
4. 可以理解为一串byte数据，全部加起来，值取补码，再加1就得到lrc值
   
例如16进制数据：01 A0 7C FF 02
- （16进制计算）求和：01 + A0 + 7C + FF + 02 = 21E ◢求余数：21E % 100 = 1E◢计算：100 - 1E = E2
- （10进制计算）求和：01 + 160 + 124 + 255 + 02 = 542◢求余数：542 % 256 = 30 ◢计算：256 - 30 = 226