package com.kenshine.multimedia.config;

import com.whty.zdxt.multimedia.util.FFmpegUtils;
import com.whty.zdxt.multimedia.util.ImageMagickUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by kenshine
 * @Classname MultimediaUtilsConfig
 * @Description MultimediaUtils配置
 * @Date 2023-12-04 12:11
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class MultimediaUtilsConfig {
    /**
     * 视频处理工具，因为所有压缩任务需要排队进行，所以FFmpegUtils需要是单例的，FFmpegUtils实例交由spring管理就为单例的
     */
    @Bean
    public FFmpegUtils fFmpegUtilsImpl() {
        return new FFmpegUtils();
    }

    /**
     * 图片处理工具
     */
    @Bean
    public ImageMagickUtils imageMagickUtils() {
        return new ImageMagickUtils();
    }
}
