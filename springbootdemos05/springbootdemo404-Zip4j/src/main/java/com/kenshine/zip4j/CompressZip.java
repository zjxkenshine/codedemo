package com.kenshine.zip4j;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * zip4j组件的压缩和解压缩
 */
public class CompressZip {

    /**
     * 压缩zip文件
     * @param outZipFile 源文件（夹）
     * @param file 输出zip文件
     * @param charset 字符编码
     * @param password 密码
     * @param comment 备注
     */
    public static void zip(File file, File outZipFile, Charset charset, String password, String comment) {
        if (outZipFile == null || file == null) {
            return;
        }
        ZipParameters parameter = new ZipParameters();
        //压缩方式，使用JDK内置zip
        parameter.setCompressionMethod(CompressionMethod.DEFLATE);
        ZipFile zipFile = new ZipFile(outZipFile);
        //如果编码不为空，则设置编码
        if (charset != null) {
            zipFile.setCharset(charset);
        }
        //如果密码不为空，则设置密码
        if (StringUtils.isNotEmpty(password)) {
            //压缩方式为标准压缩
            parameter.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
            parameter.setEncryptFiles(true);
            zipFile.setPassword(password.toCharArray());
        }
        if (!file.exists()) {
            return;
        }
        try {
            //根据文件或文件夹进行压缩
            if (file.isFile()) {
                zipFile.addFile(file, parameter);
            } else if (file.isDirectory()) {
                zipFile.addFolder(file, parameter);
            }
            //设置注释
            if (StringUtils.isNotEmpty(comment)) {
                zipFile.setComment(comment);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 压缩zip文件
     * @param file 源文件（夹）
     * @param outZipFile 输出zip文件
     */
    public static void zip(File file, File outZipFile) {
        zip(file, outZipFile, Charset.forName("GBK"), null, null);
    }

    /**
     * 解压缩zip文件
     * @param inZipFile 压缩文件
     * @param file 文件
     * @param charset 编码
     * @param password 密码
     */
    public static void unzip(File inZipFile, File file, Charset charset, String password) {
        if (inZipFile == null || file == null) {
            throw new NullPointerException("文件不能为空");
        }
        try {
            if (!inZipFile.exists()) {
                throw new FileNotFoundException(inZipFile.getAbsolutePath());
            }
            ZipFile zipFile = new ZipFile(inZipFile);
            if (charset != null) {
                zipFile.setCharset(charset);
            }
            if (!zipFile.isValidZipFile()) {
                throw new IllegalArgumentException("zip文件格式不正确");
            }
            if (zipFile.isEncrypted()) {
                if (StringUtils.isEmpty(password)) {
                    throw new NullPointerException("解压密码不能为空");
                }
                zipFile.setPassword(password.toCharArray());
            }
            UnzipParameters parameter = new UnzipParameters();
            zipFile.extractAll(file.getAbsolutePath() , parameter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解压缩文件
     * @param zipFile 压缩包文件
     * @param file 文件
     */
    public static void unzip(File zipFile , File file) {
        unzip(zipFile , file, Charset.forName("GBK"), null);
    }

    /**
     * 预览压缩包文件
     * @param zipFile 压缩包文件
     * @param charset 编码
     * @return 文件列表（不含子层文件夹（夹））
     */
    public static List<View> view(File zipFile, Charset charset) {
        ZipFile outZipFile = new ZipFile(zipFile);
        if (charset != null) {
            outZipFile.setCharset(charset);
        }
        List<FileHeader> fileHeaders;
        try {
            fileHeaders = outZipFile.getFileHeaders();
            List<View> resultList = new ArrayList<>();
            for (FileHeader header : fileHeaders) {
                View item = new View();
                item.setFileName(header.getFileName());
                item.setCompressedSize(header.getCompressedSize());
                item.setUncompressedSize(header.getUncompressedSize());
                item.setDirectory(header.isDirectory());
                item.setLastModifiedTime(header.getLastModifiedTime());
                resultList.add(item);
            }
            return resultList;
        } catch (ZipException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 预览压缩包文件
     * @param zipFile 压缩包文件
     * @return 文件列表（不含子层文件夹（夹））
     */
    public static List<View> view(File zipFile) {
        return view(zipFile, Charset.forName("GBK"));
    }

}