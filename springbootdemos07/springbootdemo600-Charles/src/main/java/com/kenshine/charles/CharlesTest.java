package com.kenshine.charles;

import com.amihaiemil.charles.*;
import com.amihaiemil.charles.sitemap.SitemapXmlOnDisk;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname com.kenshine.charles.CharlesTest
 * @Description 开源版本Charles jar使用
 * @Date 2023-12-18 10:52
 * @modified By：
 * @version: 1.0$
 *
 * 使用Selenium WebDriver构建
 */
public class CharlesTest {

    /**
     * 爬取并保存到内存中
     */
    @Test
    public void test01() throws DataExportException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        // ChromeDriver 需要下载Driver并放到chrome安装包下
        ChromeOptions chromeOptions=new ChromeOptions();
        WebDriver driver=new ChromeDriver(chromeOptions);

        // 存储位置在内存
        InMemoryRepository inmr = new InMemoryRepository();
        GraphCrawl graph = new GraphCrawl("https://www.baidu.com", driver, inmr);
        graph.crawl();
        for(WebPage p : inmr.getCrawledPages()) {
            System.out.println(p.getName());
            System.out.println(p.getTitle());
            System.out.println(p.getTextContent());
        }
    }

    /**
     * SitemapXmlCrawl 根据testsitemap.xml运行爬虫
     */
    @Test
    public void test02() throws DataExportException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        // ChromeDriver 需要下载Driver并放到chrome安装包下
        ChromeOptions chromeOptions=new ChromeOptions();
        WebDriver driver=new ChromeDriver(chromeOptions);

        InMemoryRepository inmr = new InMemoryRepository();
        SitemapXmlCrawl sitemapXmlCrawl = new SitemapXmlCrawl(
                driver,
                new SitemapXmlOnDisk("src/main/resources/testsitemap.xml"),
                inmr
        );
        sitemapXmlCrawl.crawl();

        for(WebPage p : inmr.getCrawledPages()) {
            System.out.println(p.getName());
            System.out.println(p.getTitle());
            System.out.println(p.getTextContent());
        }
    }

    /**
     * LiveWebPage 当前正在爬的网页
     */
    @Test
    public void test03(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        // ChromeDriver 需要下载Driver并放到chrome安装包下
        ChromeOptions chromeOptions=new ChromeOptions();
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("http://amihaiemil.github.io/page2/");
        LiveWebPage livePage = new LiveWebPage(driver);
        Set<Link> links = livePage.getLinks();
        System.out.println(links);
    }
}
