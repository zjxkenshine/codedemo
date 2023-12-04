package com.kenshine.mediaextractor;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname MeUseTest
 * @Description metadata-extractor 使用测试
 * @Date 2023-12-04 11:24
 * @modified By：
 * @version: 1.0$
 */
public class MeUseTest {

    /**
     * 读取图片信息
     */
    @Test
    public void test01() throws ImageProcessingException, IOException {
        File file = new File("img/test.jpg");
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                //标签名
                String tagName = tag.getTagName();
                //标签信息
                String desc = tag.getDescription();
                //照片信息
                System.out.println(tagName + "===" + desc);
            }
        }
    }

    /**
     * 读取视频信息
     */
    @Test
    public void test02() throws ImageProcessingException, IOException {
        File file = new File("E:\\U9视频\\U9C培训视频\\打印模板配置.mp4");
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                //标签名
                String tagName = tag.getTagName();
                //标签信息
                String desc = tag.getDescription();
                //照片信息
                System.out.println(tagName + "===" + desc);
            }
        }
    }
}
