package com.kenshine.io.Test13_Checked;

import org.junit.Test;

import java.io.*;
import java.util.zip.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 10:43
 * @description：校验流 java.util.zip包下
 * @modified By：
 * @version: $
 *
 * https://blog.csdn.net/jswxharry/article/details/7481536
 *
 * Checksum 表示数据校验和的接口
 * Adler32 校验算法
 * CRC32 校验算法
 *
 * 在压缩与解压缩过程中， 使用了同一种算法，求数据的checksum值
 *
 */
public class CheckedInputOutputStreamTest {
    static final int BUFFER = 2048;

    /**
     * 1.CheckedOutputStream输出校验示例
     */
    @Test
    public void test(){
        try {
            BufferedInputStream origin = null;
            //文件输出字节流
            FileOutputStream dest = new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test13\\myfigs.zip");
            //校验字节流 使用Adler32
            CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
            //压缩字节流
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(checksum));
            //out.setMethod(ZipOutputStream.DEFLATED);
            byte data[] = new byte[BUFFER];

            String dir = "D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test09";
            File f = new File(dir);
            String files[] = f.list();
            for (int i=0; i < files.length; i++) {
                System.out.println("Adding: "+files[i]);
                FileInputStream fi = new FileInputStream(dir+File.separator+files[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                //ZipEntry元素
                ZipEntry entry = new ZipEntry(files[i]);
                out.putNextEntry(entry);
                int count;
                while((count = origin.read(data, 0,
                        BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
            //校验和
            System.out.println("checksum:"+checksum.getChecksum().getValue());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2.CheckedInputStream 校验输入的压缩文件
     * 输出的CheckSum与上面的的一致
     */
    @Test
    public void test02(){
        try {
            final int BUFFER = 2048;
            BufferedOutputStream dest = null;
            FileInputStream fis = new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test13\\myfigs.zip");
            //校验和字节输入流
            CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
            //zip字节输入流
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(checksum));
            ZipEntry entry;
            while((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " +entry);
                int count;
                byte data[] = new byte[BUFFER];
                // 写文件
                FileOutputStream fos = new FileOutputStream(entry.getName());
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0,BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
            }
            zis.close();
            System.out.println("Checksum:"+checksum.getChecksum().getValue());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
