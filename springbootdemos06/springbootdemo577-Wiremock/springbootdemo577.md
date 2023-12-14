# 参考地址
Mock技术的深度理解及WireMock框架基础使用
- https://blog.csdn.net/qq_36792120/article/details/121770715

可视化管理 WireMock 数据，WireMock UI
- https://testerhome.com/topics/36971

# Mock关键概念
- spy：主要是监听调用过程，不具备转发能力（类似抓包，F12的功能）
- stub：返回固定值的实现，无法在测试中进行动态变更（指无法根据真实的值进行动态变更），比较死板（类似Charles的map local功能，不经过后端，类似挡板）
- proxy：使用代理协议转发请求并返回真实内容，可以转发、监听，甚至修改（类似Charles的rewrite功能，把请求转发给真实的服务，服务返回response后，对response进行一些修改后转发给前端）
- fake：用假的实现代替真的实现，但是实现中做了些捷径（比如一个大集群下某个服务出故障，需要很长时间去修复，这个时候可以写一个简版的逻辑进行替代，通常是开发做的）
- mock：由mock库动态创建的，能提供类似spy、stub、proxy的功能。mock是一种特殊的fake，强调的是可控
- mock on stub：直接返回固定值数据
- mock on proxy：利用代理转发并修改返回数据

# WireMock的核心特性
- Request Matching：请求匹配，匹配模式多种多样，比如根据 Method、URL、Params、Headers、Body 等内容匹配，也可以使用包含、相等、正则、JSON 提取、XPath 提取、And/Or 运算符等方式匹配。
- Response Templating：响应模板，可以动态生成 Mock 数据，也可以根据请求数据动态生成响应数据。
- Simulating Faults：模拟响应错误，比如空响应。
- Delay：响应延时，比如固定延时时间、随机延时时间、模拟弱网等等。
- Scenarios：场景管理，通过使用场景，我们可以控制 Mock 的匹配顺序。
- Webhook：在响应返回后，可执行异步回调操作，适合一些异步接口。
- 流量透传：比如我们只希望个别接口走 Mock，而其他接口都走真实服务。
- 代理转发：所有请求都走真实服务。
- 流量录制：当使用 WireMock 时，录制所有经过 WireMock 的流量数据。
- 请求日志：所有发送到 WireMock 的请求都会被记录下来。
- 二次开发：比如我们可以实现自己的 Admin API、将 WireMock 数据存储到数据库而非本地文件、增加自定义的请求匹配器、自定义的响应模板等等。

# 目录
- Test01：基本使用
- Test02_RequestMatching：请求设置
- Test03_Response：响应设置
- Test04_Priority：优先级
- Test05_Proxy：代理访问
- Test06_Recorder：流量录制

流量录制与回放
- http://ip:port/__admin/recorder/
- 在这个界面输入你想要录制的网址，然后点击录制选项
- 新开一个页面，输入http://ip:port，会自动路由到你输入的网址,这个时候你可以在页面进行一些操作