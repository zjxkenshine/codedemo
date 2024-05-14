package com.kenshine.fileservice.controller;

import idea.verlif.easy.file.page.FileQuery;
import idea.verlif.spring.file.FileService;
import idea.verlif.spring.file.domain.FileCart;
import idea.verlif.spring.file.domain.FileInfoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 文件服务器测试
 * @Date 2024-05-14 14:00
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("/file")
public class TestController {
    @Resource
    private FileService fileService;

    /**
     * 上传
     * localhost:8080/file
     */
    @PostMapping
    public int uploadFile(MultipartFile[] files) throws IOException {
        return fileService.uploadFile(new FileCart("test"), files);
    }

    /**
     * 下载
     */
    @GetMapping
    public boolean downloadFile(
            @RequestParam String fileName,
            HttpServletResponse response
    ) throws IOException {
        return fileService.downloadFile(response, new FileCart("test"), fileName);
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    public FileInfoPage getFileList(FileQuery fileQuery) {
        return fileService.getFileList(new FileCart("test"), fileQuery);
    }

    /**
     * 删除
     */
    @DeleteMapping
    public boolean deleteFile(@RequestParam String filename) {
        return fileService.deleteFile(new FileCart("test"), filename);
    }
}
