package com.kenshine.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.PdfEncryptionKeySize;
import com.spire.pdf.security.PdfPermissionsFlags;
import org.junit.Test;

import java.util.EnumSet;

/**
 * @author by kenshine
 * @Classname Test05
 * @Description PDF加密与解密
 * @Date 2024-02-26 9:25
 * @modified By：
 * @version: 1.0$
 */
public class Test05 {
    /**
     * 加密
     */
    @Test
    public void test01(){
        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载PDF文件
        doc.loadFromFile("pdf//Test03.pdf");

        //对文件进行加密
        PdfEncryptionKeySize keySize = PdfEncryptionKeySize.Key_128_Bit;
        String openPassword = "e-iceblue";
        String permissionPassword = "test";
        EnumSet flags = EnumSet.of(PdfPermissionsFlags.Print, PdfPermissionsFlags.Fill_Fields);
        doc.getSecurity().encrypt(openPassword, permissionPassword, flags, keySize);

        //保存文件
        doc.saveToFile("pdf//Encrypt.pdf");
        doc.close();
    }

    /**
     * 解密
     */
    @Test
    public void test02(){
        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载PDF文件
        doc.loadFromFile("pdf//Encrypt.pdf", "test");

        //对文件进行解密
        doc.getSecurity().encrypt("", "", PdfPermissionsFlags.getDefaultPermissions(), PdfEncryptionKeySize.Key_256_Bit, "test");

        //保存文件
        doc.saveToFile("pdf//Decrypt.pdf");
        doc.close();
    }
}
