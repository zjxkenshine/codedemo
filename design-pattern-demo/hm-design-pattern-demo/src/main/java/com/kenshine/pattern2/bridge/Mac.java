package com.kenshine.pattern2.bridge;

/**
 * @version v1.0
 * @ClassName: Mac
 * @Description: Mac操作系统(扩展抽象化角色)
 * @Author: kenshine
 */
public class Mac extends OpratingSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
