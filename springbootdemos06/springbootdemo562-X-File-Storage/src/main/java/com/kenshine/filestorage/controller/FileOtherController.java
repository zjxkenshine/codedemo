package com.kenshine.filestorage.controller;

import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.ProgressListener;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author by kenshine
 * @Classname FileOtherController
 * @Description 其他使用
 * @Date 2023-12-09 12:56
 * @modified By：
 * @version: 1.0$
 */
public class FileOtherController {
    //注入实列
    @Resource
    private FileStorageService fileStorageService;

    /**
     * 多种上传方式
     */
    public void upload(MultipartFile file) throws FileNotFoundException {
        // 直接上传
        fileStorageService.of(file).upload();

        InputStream inputStream = new FileInputStream("");
        // 如果要用 byte[]、InputStream、URL、URI、String 等方式上传，暂时无法获取 originalFilename 属性，最好手动设置
        fileStorageService.of(inputStream).setOriginalFilename("a.jpg").upload();

        // 上传到指定路径下
        fileStorageService.of(file)
                .setPath("upload/") // 保存到相对路径下，为了方便管理，不需要可以不写
                .upload();

        // 关联文件参数并上传
        fileStorageService.of(file)
                .setObjectId("0")   // 关联对象id，为了方便管理，不需要可以不写
                .setObjectType("0") // 关联对象类型，为了方便管理，不需要可以不写
                .putAttr("role","admin") //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
                .putAttr("username","007")
                .upload();

        // 上传到指定的存储平台
        fileStorageService.of(file)
                .setPlatform("aliyun-oss-1")    // 使用指定的存储平台
                .upload();

        // 对图片进行处理并上传，有多个重载方法。图片处理使用的是 https://github.com/coobird/thumbnailator
        fileStorageService.of(file)
                .setThumbnailSuffix(".jpg") //指定缩略图后缀，必须是 thumbnailator 支持的图片格式，默认使用全局的
                .setSaveThFilename("thabc") //指定缩略图的保存文件名，注意此文件名不含后缀，默认自动生成
                .image(img -> img.size(1000,1000))  // 将图片大小调整到 1000*1000
                .thumbnail(th -> th.size(200,200))  // 再生成一张 200*200 的缩略图
                .upload();
    }

    /**
     * 监听文件上传
     */
    public void watch(MultipartFile file){
        // 方式一
        fileStorageService.of(file).setProgressMonitor(progressSize ->
                System.out.println("已上传：" + progressSize)
        ).upload();

        // 方式二
        fileStorageService.of(file).setProgressMonitor((progressSize,allSize) ->
                System.out.println("已上传 " + progressSize + " 总大小" + allSize)
        ).upload();

        // 方式三
        fileStorageService.of(file).setProgressMonitor(new ProgressListener() {
            @Override
            public void start() {
                System.out.println("上传开始");
            }

            @Override
            public void progress(long progressSize,long allSize) {
                System.out.println("已上传 " + progressSize + " 总大小" + allSize);
            }

            @Override
            public void finish() {
                System.out.println("上传结束");
            }
        }).upload();
    }

    /**
     * 各种下载方式
     */
    public void download(){
        // 获取文件信息
        FileInfo fileInfo = fileStorageService.getFileInfoByUrl("https://file.abc.com/test/a.jpg");

        // 下载为字节数组
        byte[] bytes = fileStorageService.download(fileInfo).bytes();

        // 下载到文件
        fileStorageService.download(fileInfo).file("C:\\a.jpg");

        // 下载到 OutputStream 中
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        fileStorageService.download(fileInfo).outputStream(out);

        // 获取 InputStream 手动处理
        fileStorageService.download(fileInfo).inputStream(in -> {
            //这里 读取 InputStream
        });

        // 直接通过文件信息中的 url 下载，省去手动查询文件信息记录的过程
        fileStorageService.download("https://file.abc.com/test/a.jpg").file("C:\\a.jpg");

        // 下载缩略图
        fileStorageService.downloadTh(fileInfo).file("C:\\th.jpg");
    }

    /**
     * 下载监听
     */
    public void downWatch(FileInfo fileInfo){

        // 方式一
        fileStorageService.download(fileInfo).setProgressMonitor(progressSize ->
                System.out.println("已下载：" + progressSize)
        ).file("C:\\a.jpg");

        // 方式二
        fileStorageService.download(fileInfo).setProgressMonitor((progressSize,allSize) ->
                System.out.println("已下载 " + progressSize + " 总大小" + allSize)
        ).file("C:\\a.jpg");

        // 方式三
        fileStorageService.download(fileInfo).setProgressMonitor(new ProgressListener() {
            @Override
            public void start() {
                System.out.println("下载开始");
            }

            @Override
            public void progress(long progressSize,long allSize) {
                System.out.println("已下载 " + progressSize + " 总大小" + allSize);
            }

            @Override
            public void finish() {
                System.out.println("下载结束");
            }
        }).file("C:\\a.jpg");
    }

    /**
     * 删除
     */
    public void delete(){
        //获取文件信息
        FileInfo fileInfo = fileStorageService.getFileInfoByUrl("https://file.abc.com/test/a.jpg");

        //直接删除
        fileStorageService.delete(fileInfo);

        //条件删除
        fileStorageService.delete(fileInfo,info -> {
            //检查是否满足删除条件
            return true;
        });

        //直接通过文件信息中的 url 删除，省去手动查询文件信息记录的过程
        fileStorageService.delete("https://file.abc.com/test/a.jpg");
    }

    /**
     * 判断文件是否存在
     */
    public void exist(){
        //获取文件信息
        FileInfo fileInfo = fileStorageService.getFileInfoByUrl("https://file.abc.com/test/a.jpg");

        //判断文件是否存在
        boolean exists = fileStorageService.exists(fileInfo);

        //直接通过文件信息中的 url 判断文件是否存在，省去手动查询文件信息记录的过程
        boolean exists2 = fileStorageService.exists("https://file.abc.com/test/a.jpg");
    }
}
