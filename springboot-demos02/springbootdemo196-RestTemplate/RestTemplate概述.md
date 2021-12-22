# 1.简介
- restTemplate底层是基于HttpURLConnection实现的restful风格的接口调用，
- 类似于webservice，rpc远程调用，但其工作模式更加轻量级，方便于rest请求之间的调用

# 2.restTemplate常用方法
- `getForXXX`：get请求方法
- `postForXXX`：post方法请求
- `put(...)`：put请求方法
- `delete(...)`：delete请求方法
- `exchange(...)`：通用请求方法