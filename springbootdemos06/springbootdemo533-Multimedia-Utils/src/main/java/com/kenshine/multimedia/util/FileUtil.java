package com.kenshine.multimedia.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author by kenshine
 * @Classname FileUtil
 * @Description 文件工具
 * @Date 2023-12-04 13:15
 * @modified By：
 * @version: 1.0$
 */
public class FileUtil {
    /**
     * 将上传的MultipartFile转化为File
     */
    public static File multipartFile2File(MultipartFile multipartFile, String directory) {
        String suffix = getSuffix(multipartFile.getOriginalFilename());
        File tempFile = null;
        try {
            tempFile = new File(directory + "/" + UUID.randomUUID().toString() + suffix);
            multipartFile.transferTo(tempFile);
        } catch (IOException e) {
            throw new RuntimeException("multipartFile转File失败", e);
        }
        return tempFile;
    }

    /**
     * 获取文件拓展名
     */
    public static String getSuffix(String fileName) {
        if (fileName == null) {
            throw new RuntimeException("获取文件拓展名失败");
        }
        int index = fileName.lastIndexOf(".");
        if (-1 == index) {
            throw new RuntimeException("获取文件拓展名失败");
        }
        return fileName.substring(index);
    }

}
