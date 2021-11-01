package com.kenshine.code.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author kenshine
 * @create 2020-07-02 19:23
 * 本地文件管理工具类
 **/
public class FileUtils {
    /**
     * 获取扩展名
     */
    public static String extName(String filename){
        if (StringUtils.isEmpty(filename)) {
            return "";
        }
        int inx = filename.lastIndexOf(".");
        if (inx == -1) {
            return "";
        } else {
            return filename.substring(inx + 1);
        }
    }


    /**
     * 创建目录和文件
     */
    public static void touch(String fileName){
        File file = new File(fileName);
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        touch(file);
    }

    /**
     * 创建目录和文件
     */
    public static void touch(File file) {
        long currentTime = System.currentTimeMillis();
        if (!file.exists()) {
            System.err.println("file not found:" + file.getName());
            System.err.println("Create a new file:" + file.getName());
            try {
                if (file.createNewFile()) {
                    System.out.println("Succeeded!");
                } else {
                    System.err.println("Create file failed!");
                }
            } catch (IOException e) {
                System.err.println("Create file failed!");
                e.printStackTrace();
            }
        }
        boolean result = file.setLastModified(currentTime);
        if (!result) {
            System.err.println("touch failed: " + file.getName());
        }
    }

}
