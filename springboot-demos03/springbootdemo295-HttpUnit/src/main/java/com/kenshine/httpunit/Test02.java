package com.kenshine.httpunit;

import org.htmlunit.*;
import org.htmlunit.attachment.AttachmentHandler;
import org.htmlunit.html.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 12:21
 * @description：
 * @modified By：
 * @version: $
 */
public class Test02 {

    /**
     * clientHandler
     */
    @Test
    public void test01(){
        try (final WebClient webClient = new WebClient()) {
            // 调用 Window.alert()
            webClient.getAlertHandler();
            // window.confirm()
            webClient.getConfirmHandler();
            // window.prompt()
            webClient.getPromptHandler();
            // window.status
            webClient.getStatusHandler();
            // ... https://www.htmlunit.org/webclient.html#
        }
    }

    /**
     * 开启polyfill
     */
    @Test
    public void test02(){
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
            // 开启polyfill
            webClient.getOptions().setFetchPolyfillEnabled(true);
            //final HtmlPage page = webClient.getPage();
        }
    }

    /**
     * table操作
     */
    @Test
    public void test03(){
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
            final HtmlPage page = webClient.getPage("http://localhost:8080/test01");
            final HtmlTable table = page.getHtmlElementById("table1");
            for (final HtmlTableRow row : table.getRows()) {
                System.out.println("Found row");
                for (final HtmlTableCell cell : row.getCells()) {
                    System.out.println("   Found cell: " + cell.asNormalizedText());
                }
            }
            System.out.println("Cell (1,2)=" + table.getCellAt(1,2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复杂table操作
     */
    @Test
    public void test04(){
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
            final HtmlPage page = webClient.getPage("http://localhost:8080/test02");
            final HtmlTable table = page.getHtmlElementById("table1");
            for (final HtmlTableRow row : table.getRows()) {
                System.out.println("Found row");
                for (final HtmlTableCell cell : row.getCells()) {
                    System.out.println("   Found cell: " + cell.asNormalizedText());
                }
            }
            System.out.println("Cell (1,2)=" + table.getCellAt(1,2));

            // header
            final HtmlTableHeader header = table.getHeader();
            final List<HtmlTableRow> headerRows = header.getRows();
            // footer
            final HtmlTableFooter footer = table.getFooter();
            final List<HtmlTableRow> footerRows = footer.getRows();
            // body
            for (final HtmlTableBody body : table.getBodies()) {
                final List<HtmlTableRow> rows = body.getRows();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * UnexpectedPage
     * 文件下载
     */
    @Test
    public void test05() throws IOException {
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
            HtmlPage page = webClient.getPage("");
            WebWindow window = page.getEnclosingWindow();
            // 点击一些按钮执行下载
            // 处理动作
            UnexpectedPage downloadPage = (UnexpectedPage) window.getEnclosedPage();

            try (InputStream downloadedContent = downloadPage.getInputStream()) {
                // 保存到本地
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * AttachmentHandler
     * 文件下载
     */
    @Test
    public void test06(){
        final List<WebResponse> attachments = new ArrayList<>();

        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX)) {
            webClient.setAttachmentHandler(new AttachmentHandler() {
                @Override
                public boolean handleAttachment(final WebResponse response) {
                    attachments.add(response);
                    return true;
                }

                @Override
                public void handleAttachment(final Page page) {
                    throw new IllegalAccessError("handleAttachment(Page) called");
                }
            });

            // start browsing
            HtmlPage page = webClient.getPage("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传本地文件
     */
    @Test
    public void test07(){
        try (final WebClient client = new WebClient(BrowserVersion.FIREFOX)) {
            HtmlPage firstPage = client.getPage("URL_FIRST");
            HtmlForm f = firstPage.getForms().get(0);
            HtmlFileInput fileInput = f.getInputByName("myInput");

            String path = Objects.requireNonNull(getClass().getClassLoader().getResource("testfiles/" + "tiny-png.img")).toExternalForm();
            fileInput.setValue(path);
            firstPage.getHtmlElementById("mySubmit").click();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从内存上传
     */
    @Test
    public void test08(){
        try (final WebClient client = new WebClient(BrowserVersion.FIREFOX)) {
            HtmlPage firstPage = client.getPage("url");
            HtmlForm f = firstPage.getForms().get(0);
            HtmlFileInput fileInput = f.getInputByName("myInput");

            fileInput.setValue("dummy.txt");
            fileInput.setContentType("text/csv");
            fileInput.setData("My file data".getBytes());
            firstPage.getHtmlElementById("mySubmit").click();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多文件上传
     */
    @Test
    public void test09(){
        try (final WebClient client = new WebClient(BrowserVersion.FIREFOX)) {
            String filename1 = "HtmlFileInputTest_one.txt";
            String path1 = getClass().getResource(filename1).toExternalForm();
            File file1 = new File(new URI(path1));

            String filename2 = "HtmlFileInputTest_two.txt";
            String path2 = getClass().getResource(filename2).toExternalForm();
            File file2 = new File(new URI(path2));

            HtmlPage firstPage = client.getPage("URL_FIRST");
            HtmlForm form = firstPage.getForms().get(0);
            HtmlFileInput fileInput = form.getInputByName("myInput");

            fileInput.setFiles(file1, file2);

            firstPage.getHtmlElementById("mySubmit").click();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }


}
