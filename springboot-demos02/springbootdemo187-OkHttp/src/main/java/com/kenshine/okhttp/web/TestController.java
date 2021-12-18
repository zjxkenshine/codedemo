package com.kenshine.okhttp.web;

import com.kenshine.okhttp.domain.Gist;
import com.kenshine.okhttp.domain.GistFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 13:53
 * @description：测试接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/test04")
    public String test04(HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String body = reader.lines().collect(Collectors.joining("\n"));
        System.out.println(body);
        return "success";
    }

    @PostMapping("/test08")
    public String test08(@RequestBody MultipartFile image){
        return image.getOriginalFilename();
    }

    @GetMapping("/test09")
    public Gist test09(){
        Gist gist = new Gist();
        GistFile gistFile = new GistFile();
        gist.setFiles(new HashMap<String,GistFile>(){{put("1",gistFile.setContent("kenshine"));}});
        return gist;
    }

    /**
     * 模拟5秒延迟
     * @return
     */
    @GetMapping("/test11")
    public String test11() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "success";
    }



}
