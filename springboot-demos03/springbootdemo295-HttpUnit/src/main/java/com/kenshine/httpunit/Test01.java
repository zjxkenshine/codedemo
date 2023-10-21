package com.kenshine.httpunit;

import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.html.*;
import org.junit.Test;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 11:41
 * @description：
 * @modified By：
 * @version: $
 *
 * 基本使用
 */
public class Test01 {
    /**
     * WebClient 浏览器操作
     */
    @Test
    public void test01(){
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://www.htmlunit.org/");

            final String pageAsXml = page.asXml();
            System.out.println(pageAsXml);

            final String pageAsText = page.asNormalizedText();
            System.out.println(pageAsText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  提交表单
     */
    @Test
    public void test02(){
        try (final WebClient webClient = new WebClient()) {
            // 获取第一个页面
            final HtmlPage page1 = webClient.getPage("http://some_url");
            // 获取表单，找到提交按钮.
            final HtmlForm form = page1.getFormByName("myform");
            final HtmlSubmitInput button = form.getInputByName("submitbutton");
            final HtmlTextInput textField = form.getInputByName("userid");
            // 修改text的值
            textField.type("root");
            // 点击按钮并返回第二个页面
            final HtmlPage page2 = button.click();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定浏览器
     */
    @Test
    public void test03(){
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
            final HtmlPage page = webClient.getPage("https://www.htmlunit.org/");
            System.out.println(page.getTitleText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Element
     */
    @Test
    public void test04(){
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://some_url");
            final HtmlDivision div = page.getHtmlElementById("some_div_id");
            final HtmlAnchor anchor = page.getAnchorByName("anchor_name");
            // 节点
            NodeList inputs = page.getElementsByTagName("input");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Xpath 复杂搜索
     */
    @Test
    public void test05(){
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://htmlunit.sourceforge.io/");

            final List<?> divs = page.getByXPath("//div");

            //使用xpath
            final HtmlDivision div = (HtmlDivision) page.getByXPath("//div[@id='banner']").get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Css选择器
     */
    @Test
    public void test06(){
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://www.htmlunit.org/");

            final DomNodeList<DomNode> divs = page.querySelectorAll("div");
            for (DomNode div : divs) {
            }
            //css选择器
            final DomNode div = page.querySelector("div#breadcrumbs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
