package com.kenshine.javalin;

import io.javalin.Javalin;
import io.javalin.core.util.FileUtil;

/**
 * @author by kenshine
 * @Classname App03
 * @Description 文件上传
 * @Date 2023-11-29 11:56
 * @modified By：
 * @version: 1.0$
 */
public class App03 {
    /**
     * http://localhost:7000/
     */
    public static void main(String[] args) {
        Javalin app = Javalin.create()
                //开启静态资源
                .enableStaticFiles("/resource")
                .start(7000);

        // 文件上传
        app.post("/upload", ctx -> {
            ctx.uploadedFiles("files").forEach(file ->
                    FileUtil.streamToFile(file.getContent(), "upload/" + file.getName())
            );
            ctx.res.setCharacterEncoding("utf-8");
            ctx.result("文件上传成功");
        });
    }
}
