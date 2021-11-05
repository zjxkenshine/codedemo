package com.kenshine.pattern2.bridge;

/**
 * @version v1.0
 * @ClassName: AviFile
 * @Description: avi视频文件（具体的实现化角色）
 * @Author: kenshine
 */
public class AviFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件 ：" + fileName);
    }
}
