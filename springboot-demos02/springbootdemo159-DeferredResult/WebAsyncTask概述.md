# 1.WebAsyncTask概述
- Spring提供了对异步任务API，采用 WebAsyncTask 类即可实现 异步任务。对异步任务设置相应的 回调处理，如当 任务超时、异常抛出 等

# 2.可以用线程池管理WebAsyncTask demo04
- 创建WebAsyncTask时传入一个线程池对象即可
