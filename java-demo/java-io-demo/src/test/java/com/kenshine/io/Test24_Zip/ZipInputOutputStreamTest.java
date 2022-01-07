package com.kenshine.io.Test24_Zip;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 22:43
 * @description：Zip压缩解压
 * @modified By：
 * @version: $
 *
 * 使用zipInputStream打开的zip文件只能是WINRAR的zip标准格式，360快速zip是打不开的
 *  由于ZipInputStream是字节流默认utf-8编码，所以遇到zip内部的 中文名文件 是会报错的，或者是改编编码格式为gbk
 */
public class ZipInputOutputStreamTest {

    @Test
    public void test(){
    }

    //压缩
    public byte[] zipBytes(String entryname,String input) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);
        //具有新名称的entry
        ZipEntry entry = new ZipEntry(entryname);
        entry.setSize(input.getBytes().length);
        zos.putNextEntry(entry);
        int len;
        ByteArrayInputStream in=new ByteArrayInputStream(input.getBytes());
        while ((len = in.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        zos.closeEntry();
        zos.close();
        return baos.toByteArray();
    }

    //解压
    public String unZipIt(String body){
        byte[] buffer = new byte[2048];
        try {
            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(body.getBytes()));
            ZipEntry entry = zis.getNextEntry();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while(entry!= null) {
                System.out.println("Extracting: " +entry);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                }
                entry=zis.getNextEntry();
                //baos.flush();
                baos.close();
            }
            zis.close();
            System.out.println(new String(baos.toByteArray()));
            return new String(baos.toByteArray());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
