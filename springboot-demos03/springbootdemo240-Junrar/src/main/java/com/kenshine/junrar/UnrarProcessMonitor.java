package com.kenshine.junrar;

import com.github.junrar.UnrarCallback;
import com.github.junrar.volume.FileVolume;
import com.github.junrar.volume.Volume;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname UnrarProcessMonitor
 * @Description rar解压进度监控
 * @Date 2023/3/22 14:11
 * @modified By：
 * @version: 1.0$
 */
public class UnrarProcessMonitor implements UnrarCallback {
    private String fileName;

    public UnrarProcessMonitor(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 返回false的话，对于某些分包的rar是没办法解压正确的
     * */
    @Override
    public boolean isNextVolumeReady(Volume volume) {
        try {
            fileName = ((FileVolume) volume).getFile().getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void volumeProgressChanged(long l, long l1) {
        //输出进度
        System.out.println("Unrar "+fileName+" rate: "+(double)l/l1*100+"%");
    }

}
