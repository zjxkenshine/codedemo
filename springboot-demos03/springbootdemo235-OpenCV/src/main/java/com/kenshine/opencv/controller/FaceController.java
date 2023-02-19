package com.kenshine.opencv.controller;

import com.kenshine.opencv.utils.Base64Utils;
import com.kenshine.opencv.utils.FaceUtils;
import com.kenshine.opencv.utils.FileUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author by kenshine
 * @Classname FaceController
 * @Description 人脸处理
 * @Date 23/2/19 9:02
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class FaceController {

    /**
     * 测试
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return "测试";
    }

    /**
     * 获取图片中人脸个数
     *
     * @param base64Images base64图片，不包含逗号之前的部分
     * @return
     */
    @PostMapping("/checkFaceNumber")
    public int checkFaceNumber(@RequestBody String base64Images) {
        return FaceUtils.checkFaceNo(base64Images);
    }

    @PostMapping("/checkFaceNumber2")
    public int checkFaceNumber(@RequestParam("file") MultipartFile file) throws IOException {
        return FaceUtils.checkFaceNo(Base64Utils.fileToBase64(FileUtils.multipartFileToFile("E:\\file",file)));
    }

    /**
     * 提取最大脸
     *
     * @param response
     * @param base64Images
     * @throws IOException
     */
    @PostMapping("/extractMaxFace")
    public void extractMaxFace(HttpServletResponse response,@RequestBody String base64Images) throws IOException {
        int indexOf = base64Images.indexOf(",");
        if (indexOf > 0) {
            base64Images = base64Images.substring(indexOf + 1);
        }
        response.setContentType("application/octet-stream");
        PrintWriter writer = response.getWriter();
        base64Images = FaceUtils.extractMaxFace(base64Images);
        if (!StringUtils.hasLength(base64Images)) {
            throw new RuntimeException("没有人脸");
        }
        writer.write("data:image/png;base64,".concat(base64Images));
        writer.flush();

    }

    /**
     * 标记脸
     *
     * @param response
     * @param base64Images
     * @throws IOException
     */
    @PostMapping("/markFace")
    public void markFace(HttpServletResponse response,@RequestBody String base64Images) throws IOException {
        int indexOf = base64Images.indexOf(",");
        if (indexOf > 0) {
            base64Images = base64Images.substring(indexOf + 1);
        }
        response.setContentType("application/octet-stream");
        PrintWriter writer = response.getWriter();
        base64Images = FaceUtils.markFace(base64Images);
        writer.write("data:image/png;base64,".concat(base64Images));
        writer.flush();

    }

}
