package com.kenshine.multimedia.controller;

import com.kenshine.multimedia.util.FileUtil;
import com.whty.zdxt.multimedia.attribute.CompressionAttributes;
import com.whty.zdxt.multimedia.attribute.CropAttributes;
import com.whty.zdxt.multimedia.attribute.ResizeAttributes;
import com.whty.zdxt.multimedia.attribute.VideoAttributes;
import com.whty.zdxt.multimedia.enumeration.Suffix;
import com.whty.zdxt.multimedia.enumeration.VideoSize;
import com.whty.zdxt.multimedia.pojo.FFmpegInfo;
import com.whty.zdxt.multimedia.util.FFmpegUtils;
import com.whty.zdxt.multimedia.util.ImageMagickUtils;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author by kenshine
 * @Classname FileController
 * @Description 视频/图片处理示例
 * @Date 2023-12-04 13:15
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FFmpegUtils fFmpegUtils;

    @Resource
    private MultipartProperties multipartProperties;

    @Resource
    private ImageMagickUtils imageMagickUtils;

    /**
     * 获取视频信息
     */
    @PostMapping("/getVideoInfo")
    public Object getFileInfo(@RequestParam MultipartFile file) {
        String location = multipartProperties.getLocation();

        // 生成上传视频的临时文件
        File inputFile = FileUtil.multipartFile2File(file, location);

        // 调用视频处理工具类
        String inputFileName = inputFile.getName();
        FFmpegInfo info = fFmpegUtils.getInfo(location, inputFileName);

        // 删除上传视频的临时文件
        inputFile.delete();
        return info;
    }

    /**
     * 生成视频封面图
     */
    @PostMapping("/createVideoCover")
    public Object createVideoCover(@RequestParam MultipartFile file) {
        String location = multipartProperties.getLocation();
        // 生成上传视频的临时文件
        File inputFile = FileUtil.multipartFile2File(file, location);

        // 调用视频处理工具类
        String outputFileName = fFmpegUtils.createCover(location, inputFile.getName());

        // 删除上传视频的临时文件
        inputFile.delete();
        return outputFileName;
    }

    /**
     * 压缩视频
     */
    @PostMapping("/compressionVideo")
    public Object compressionVideo(@RequestParam MultipartFile file) {

        String location = multipartProperties.getLocation();

        // 生成上传视频的临时文件
        File inputFile = FileUtil.multipartFile2File(file, location);

        // 调用视频处理工具类
        CompressionAttributes compressionAttributes = new CompressionAttributes();
        // 设置视频压缩完成时的回调URL
        compressionAttributes.setProgressUrl("http://localhost:8080/file/callback?fileId=111111&a=456");

        // 设置视频压缩参数
        VideoAttributes videoAttributes = new VideoAttributes();
        videoAttributes.setMaxDuration(15);
        videoAttributes.setMaxFps(20);
        videoAttributes.setVideoSize(VideoSize.HD480);

        compressionAttributes.setVideoAttributes(videoAttributes);

        String outputFileName = fFmpegUtils.putCompressionTask(location, inputFile.getName(), compressionAttributes);

        return outputFileName;
    }

    /**
     * 压缩视频完成时的回调
     */
    @PostMapping("/callback")
    public Object callback(@RequestBody String info, @RequestParam("fileId") String fileId, @RequestParam("a") String a) {
        // 回调信息
        String[] split = info.split("/");

        // 回调参数 fileId，根据fileId查询数据库的上传临时文件名和下载临时文件名，进行文件上传和文件删除
        System.out.println(String.format("fileId为%s的文件已压缩完成", fileId));

        return null;
    }

    /**
     * 图片裁切
     */
    @PostMapping("/crop")
    public Object crop(@RequestParam MultipartFile file) {

        String location = multipartProperties.getLocation();

        // 生成上传图片的临时文件
        File inputFile = FileUtil.multipartFile2File(file, location);

        // 调用图片处理工具类
        // 裁切成3000x1200的图后，修改分辨率为宽800的图（高度按比例缩小）
        CropAttributes cropAttributes = new CropAttributes(3000, 1200, 1000, 500);
        ResizeAttributes resizeAttributes = new ResizeAttributes(800, null);
        String outputFileName = imageMagickUtils.cropAndResize(location, inputFile.getName(), cropAttributes, resizeAttributes);

        // 删除上传图片的临时文件
        inputFile.delete();
        return outputFileName;
    }

    /**
     * 图片分辨率修改
     */
    @PostMapping("/resize")
    public Object resize(@RequestParam MultipartFile file) {

        String location = multipartProperties.getLocation();

        // 生成上传图片的临时文件
        File inputFile = FileUtil.multipartFile2File(file, location);

        // 调用图片处理工具类
        ResizeAttributes resizeAttributes = new ResizeAttributes(800, null);
        String outputFileName = imageMagickUtils.resize(location, inputFile.getName(), resizeAttributes, Suffix.JPG);

        // 删除上传图片的临时文件
        inputFile.delete();
        return outputFileName;
    }
}
