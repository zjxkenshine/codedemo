package com.kenshine.sevenzip;

import net.sf.sevenzipjbinding.IInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipNativeInitializationException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;

import java.io.RandomAccessFile;

/**
 * @author by kenshine
 * @Classname SevenZipMain
 * @Description rar5解压支持
 * @Date 2023-04-27 18:31
 * @modified By：
 * @version: 1.0$
 */
public class SevenZipMain {
    public static void main(String[] args) {
        try {
            SevenZip.initSevenZipFromPlatformJAR();
            System.out.println("7-Zip-JBinding library was initialized");
            String path1="E:\\test\\测试.rar";
            String path2="E:\\test\\解压测试";
            unRar(path1,path2);
        } catch (SevenZipNativeInitializationException e) {
            e.printStackTrace();
        }
    }

    // 执行解压
    public static void unRar(String source, String target) {
        /**
         * 1."r"：以只读形式打开，调用任何write方法都会报错
         * 2.“rw”：进行读取和写入
         * 3.“rws”：进行读取和写入，对文件内容和元数据的每次更新都会写入到基础存储设备
         * 4.“rwd”：进行读取和写入，对文件内容的每次更新都会写入到基础存储设备
         */
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(source, "r");
            IInArchive archive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile))) {
            int[] in = new int[archive.getNumberOfItems()];
            for (int i = 0; i < in.length; i++) {
                in[i] = i;
            }

            archive.extract(in, false, new ExtractCallback(archive, target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
