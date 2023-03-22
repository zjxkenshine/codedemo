package com.kenshine.junrar;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author by kenshine
 * @Classname ZipAndRarTools
 * @Description 解压包下所有文件
 * @Date 2023/3/22 14:34
 * @modified By：
 * @version: 1.0$
 */
public class ZipAndRarTools {
    public static String srcDirectoryPath = "D:\\test\\zip";
    public static String dstDirectoryPath = "D:\\test\\unzip";

    public static void main(String[] args) {
        File srcFiles = new File(srcDirectoryPath);
        ReadRarFiles(srcFiles);

    }

    public static void ReadRarFiles(File srcFiles) {
        File dstDirectory = new File(dstDirectoryPath);

        if (!dstDirectory.exists()) {
            System.err.println("目的端不存在该目录，请检查目录是否存在！");
        }
        if (!srcFiles.exists()) {
            System.err.println("源端不存在该目录，请检查目录是否存在！");
        }

        Archive archive = null;
        String fileName = null;
        String zipFileName = null;
        FileOutputStream fileOutputStream = null;
        File[] fileList = srcFiles.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                try {
                    if (file.isFile()) {
                        zipFileName = file.getName();
                        archive = new Archive(file);
                        FileHeader fileHeader = archive.nextFileHeader();
                        while (fileHeader != null) {
                            //防止出现文件名中文乱码问题
                            fileName = fileHeader.getFileName().isEmpty() ? fileHeader.getFileNameString() : fileHeader.getFileName();
                            File destFile = new File(dstDirectoryPath + File.separator + fileName.trim());
                            File parent =  destFile.getParentFile();
                            if(!parent.exists()){
                                parent.mkdirs();
                            }
                            if(!destFile.exists()){
                                destFile.createNewFile();
                            }
                            // 排除目录
                            if(!destFile.isDirectory()) {
                                fileOutputStream = new FileOutputStream(destFile);
                                archive.extractFile(fileHeader, fileOutputStream);
                            }
                            fileHeader = archive.nextFileHeader();
                        }
                    } else {
                        ReadRarFiles(file);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(zipFileName + "解压失败！！！");
                } finally {
                    try {
                        if (fileOutputStream != null)
                            fileOutputStream.close();
                        if (archive != null)
                            archive.close();
                    } catch (Exception e) {
                        System.err.println("关闭流失败！！！");
                    }
                }
            }
        } else {
            System.err.println("该目录下没有文件和目录！！！");
        }
    }
}
