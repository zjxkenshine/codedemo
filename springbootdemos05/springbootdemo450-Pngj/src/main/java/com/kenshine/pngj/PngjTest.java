package com.kenshine.pngj;

import ar.com.hjg.pngj.FilterType;
import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngReader;
import ar.com.hjg.pngj.PngWriter;
import org.junit.Test;

import java.io.*;

/**
 * @author by kenshine
 * @Classname PngjTest
 * @Description 测试
 * @Date 2023-11-02 15:59
 * @modified By：
 * @version: 1.0$
 */
public class PngjTest {

    /**
     * 读取png
     */
    @Test
    public void test01() throws FileNotFoundException {
        PngReader pngr = new PngReader(new FileInputStream("img\\test.png"));
        System.out.println(pngr.imgInfo);
    }


    /**
     * 从二进制生成png图片
     */
    @Test
    public void test02() throws IOException {
        final int CHUNK_SIZE = 134217728;
        // 5*5
        final int SIDE = 5;
        byte[] buf = new byte[CHUNK_SIZE];
        int br, i,j,row=0;
        // 每个像素3字节
        int[] arr = new int[SIDE*3];

        FileInputStream fileInputStream=new FileInputStream("img\\test02.bin");
        OutputStream os = new FileOutputStream("img\\test02.png");

        ImageInfo imi = new ImageInfo(SIDE, SIDE, 8, false);
        PngWriter pngw = new PngWriter(os, imi);
        // 最大压缩
        pngw.setCompLevel(9);
        pngw.setFilterType(FilterType.FILTER_ADAPTIVE_FAST);
        // 读取
        br = fileInputStream.read(buf);
        j=0;
        System.out.println("Bytes Read: " + br);
        while(br>0) {
            for(i=0;i<br;i++) {
                arr[j++] = buf[i] & 0xFF;
                if(j==SIDE*3) {
                    // 写一行数据
                    pngw.writeRowInt(arr);
                    j=0;
                    row++;
                    if(row==SIDE) {
                        break;
                    }
                }
            }
            if(row==SIDE) {
                break;
            }
            br = fileInputStream.read(buf);
            System.out.println("Bytes Read: " + br);
        }
        pngw.end();
        System.out.println("Done.");
        fileInputStream.close();
    }



}
