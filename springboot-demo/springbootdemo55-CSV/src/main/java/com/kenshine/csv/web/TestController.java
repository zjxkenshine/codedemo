package com.kenshine.csv.web;

import com.kenshine.csv.service.CsvService;
import com.kenshine.csv.utils.CSVUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 10:32
 * @description：测试Controller
 * @modified By：
 * @version: $
 */
@Slf4j
@RestController
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    //定义自己的服务类接口
    @Autowired
    private CsvService service;

    /**
     * @param response
     * @return
     * @Description 下载CSV
     **/
    @GetMapping("/downloadAll")
    public String downloadAllUserRoleCSV(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String[] head = service.getHead();
        List<String[]> values = service.getValues();
        String fileName = service.getName();

        File file = CSVUtils.makeTempCSV(fileName, head, values);

        //浏览器设置 fileName不支持中文
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            //IE浏览器处理
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName +".csv");
        CSVUtils.downloadFile(response, file);
        return null;
    }

    /**
     * @return
     * @Description 上传CSV
     * @Param file
     **/
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        try {
            //上传内容不能为空
            if (multipartFile.isEmpty()) {
                return "500";
            }
            List<List<String>> userRoleLists = CSVUtils.readCSV(multipartFile, 2);
            service.doSth(userRoleLists);
            return "200";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "500";
    }

}
