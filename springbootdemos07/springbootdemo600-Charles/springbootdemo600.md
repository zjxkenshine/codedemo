# 参考地址
charles 开源版
- https://github.com/opencharles/charles
- https://amihaiemil.com/2016/12/05/project-charles.html

最全的 Charles 抓包工具详解
- https://blog.csdn.net/yuzhiqiang666/article/details/89481252

charles-crack 破解
- https://github.com/WrBug/charles-crack

软件测试教程Charles抓包工具测试实战
- https://www.bilibili.com/video/BV1mQ4y1N7dn
- https://www.yuque.com/weijinhuadechengxuyuan/hiw7ie/sik0lp

# 包简介
sitemap 包：
- SitemapXml：代表sitemap.xml文件
- SitemapXmlLocation：sitemap.xml文件的位置
- SitemapXmlOnDisk：本地sitemap.xml
- SitemapXmlOnline：在线
- Url：sitemap的在线位置
- UrlSet：多个url

charles 包：
- WebCrawl：web爬虫
- GraphCrawl：以图表（树）的形式从索引页面开始对网站进行爬取
- RetriableCrawl：重试爬虫
- SitemapXmlCrawl：基于给定的sitemap xml对网站进行爬取
- SwitchableCrawl：如果出现RuntimeException而失败，则切换到网站进行爬取
- WebPage：web页面接口
- LiveWebPage：当前正在爬的网页
- SnapshotWebPage：爬取的web页面
- Repository：已爬取数据的存储库
- InMemoryRepository：存储在内存
- JsonFilesRepository：以json格式将每个页面导出到指定的文件中

# 踩坑
chromedriver下载
- http://chromedriver.storage.googleapis.com/index.html
- https://chromedriver.chromium.org/downloads

Windows系统下Chromedriver.exe安装及配置
- https://blog.csdn.net/weixin_57038791/article/details/130631803
