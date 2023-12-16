package com.kenshine.buildtest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname FileUtil
 * @Description 读取文件到byte数字
 * @Date 2023-12-16 8:48
 * @modified By：
 * @version: 1.0$
 */
public class FileUtil {
    public static byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }
}
