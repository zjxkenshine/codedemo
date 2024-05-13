package com.kenshine.jtar;

import org.junit.Test;
import org.kamranzafar.jtar.TarEntry;
import org.kamranzafar.jtar.TarInputStream;
import org.kamranzafar.jtar.TarOutputStream;

import java.io.*;

/**
 * @author by kenshine
 * @Classname JtarTest
 * @Description Jtar使用测试
 * @Date 2024-05-13 9:59
 * @modified By：
 * @version: 1.0$
 */
public class JtarTest {

    /**
     * 压缩
     */
    @Test
    public void test01() throws IOException {
        // 输出流
        FileOutputStream dest = new FileOutputStream( "file/test.tar" );

        //创建tar stream
        TarOutputStream out = new TarOutputStream( new BufferedOutputStream( dest ) );

        // 压缩的文件
        File[] filesToTar=new File[2];
        filesToTar[0]=new File("file/test01.txt");
        filesToTar[1]=new File("file/test02.txt");

        for(File f:filesToTar){
            out.putNextEntry(new TarEntry(f, f.getName()));
            BufferedInputStream origin = new BufferedInputStream(new FileInputStream( f ));
            int count;
            byte[] data = new byte[2048];

            while((count = origin.read(data)) != -1) {
                out.write(data, 0, count);
            }

            out.flush();
            origin.close();
        }
        out.close();
    }

    /**
     * 解压tar文件
     */
    @Test
    public void test02() throws IOException {
        String tarFile = "file/test.tar";
        String destFolder = "file/untar";

        // 创建TarInputStream
        TarInputStream tis = new TarInputStream(new BufferedInputStream(new FileInputStream(tarFile)));
        TarEntry entry;

        while((entry = tis.getNextEntry()) != null) {
            int count;
            byte[] data = new byte[2048];
            FileOutputStream fos = new FileOutputStream(destFolder + "/" + entry.getName());
            BufferedOutputStream dest = new BufferedOutputStream(fos);

            while((count = tis.read(data)) != -1) {
                dest.write(data, 0, count);
            }

            dest.flush();
            dest.close();
        }
        tis.close();
    }
}
