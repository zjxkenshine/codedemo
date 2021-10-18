package com.kenshine.demo02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 9:42
 * @description：上传Controller
 * @modified By：
 * @version: 1.0$
 */
@Controller
public class UploadController {

    @Value("${uploadFolder}")
    private String  fileDir;

    @RequestMapping("/picUpload")
    public String picUpload(){
        //跳转到picUpload.html
        return "picUpload";
    }

    /**
     * 多文件上传
     * @return
     */
    @RequestMapping("/multiUpload")
    public String multiUpload(){
        //跳转到multiUpload.html
        return "multiUpload";
    }

    @ResponseBody
    @PostMapping("/upload")
    public Object upload(MultipartFile fileUpload){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        try {

            System.out.println("------->>"+fileDir);
            File dir = new File(fileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File upload_file = new File(fileDir + fileName);
            fileUpload.transferTo(upload_file);
            return new Message(0,"success to upload");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(-1,"fail to upload");
        }
    }

    /**
     * 多文件上传接口
     * @param fileUpload
     * @return
     */
    @RequestMapping(value = "/uploadMultifile", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadMultiFile(@RequestParam("attachment") MultipartFile[] fileUpload) {

        try {
            for (int i=0;i<fileUpload.length;i++){
                //获取文件名
                String fileName = fileUpload[i].getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                //指定本地文件夹存储图片
                File dir = new File(fileDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                if (fileUpload[i]!=null){
                    File upload_file = new File(fileDir + fileName);
                    fileUpload[i].transferTo(upload_file);
                }
            }
            return new Message(0,"success to upload");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(-1,"fail to upload");
        }

    }

}
