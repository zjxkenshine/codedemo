package com.kenshine.qrext4j;

import org.iherus.codegen.Codectx;
import org.iherus.codegen.qrcode.QrcodeConfig;
import org.iherus.codegen.qrcode.QreyesFormat;
import org.iherus.codegen.qrcode.SimpleQrcodeGenerator;
import org.iherus.codegen.utils.IOUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author by kenshine
 * @Classname QrextTest
 * @Description 测试
 * @Date 2023-10-30 9:45
 * @modified By：
 * @version: 1.0$
 */
public class QrextTest {

    /**
     * 简单生成
     */
    @Test
    public void test01(){
        OutputStream out = null;
        try {
            String content = "https://gitee.com/BYSRepo/qrext4j";
            out = new FileOutputStream("img\\1.png");
            new SimpleQrcodeGenerator().generate(content).toStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 带logo二维码
     */
    @Test
    public void test02(){
        OutputStream out = null;
        try {
            String content = "https://www.baidu.com/s?ie=UTF-8&wd=qrext4j";
            new SimpleQrcodeGenerator().setLogo("img\\logo.jpeg").generate(content).toFile("img\\2.png");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 在线logo
     */
    @Test
    public void test03() throws IOException {
        String content = "https://www.apple.com/cn/";
        String logoUrl = "https://img0.baidu.com/it/u=2063546214,4275813404&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889";
        new SimpleQrcodeGenerator().setRemoteLogo(logoUrl).generate(content).toFile("img\\3.png");
    }

    /**
     * 定义二维码格式
     */
    @Test
    public void test04() throws IOException {
        QrcodeConfig config = new QrcodeConfig()
                // 边框
                .setBorderSize(2)
                // 空格
                .setPadding(10)
                .setMasterColor("#00BFFF")
                .setLogoBorderColor("#B0C4DE");

        String content = "https://baike.baidu.com/item/%E5%97%B7%E5%A4%A7%E5%96%B5/19817560?fr=aladdin";
        new SimpleQrcodeGenerator(config).setLogo("img\\logo.jpeg").generate(content).toFile("img\\4.png");
    }

    /**
     * 定义码眼样式
     */
    @Test
    public void test05() throws IOException {
        QrcodeConfig config = new QrcodeConfig()
                .setBorderSize(2)
                .setPadding(10)
                .setMasterColor("#778899")
                .setLogoBorderColor("#B0C4DE")
                .setCodeEyesPointColor("#BC8F8F")
                .setCodeEyesFormat(QreyesFormat.DR2_BORDER_C_POINT);

        String content = "https://baike.baidu.com/item/%E5%97%B7%E5%A4%A7%E5%96%B5/19817560?fr=aladdin";
        new SimpleQrcodeGenerator(config).setLogo("img\\logo.jpeg").generate(content).toFile("img\\5.png");
    }

    /**
     * 圆形logo
     */
    @Test
    public void test06() throws IOException {
        QrcodeConfig config = new QrcodeConfig()
                .setMasterColor("#5F9EA0")
                .setLogoBorderColor("#FFA07A")
                .setLogoShape(Codectx.LogoShape.CIRCLE);
        String content = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        new SimpleQrcodeGenerator(config).setLogo("img\\logo.jpeg").generate(content).toFile("img\\6.png");
    }

}
