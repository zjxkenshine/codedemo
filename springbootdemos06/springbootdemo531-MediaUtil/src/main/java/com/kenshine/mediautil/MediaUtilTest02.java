package com.kenshine.mediautil;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifThumbnailDirectory;
import mediautil.gen.directio.SplitInputStream;
import mediautil.image.ImageResources;
import mediautil.image.jpeg.AbstractImageInfo;
import mediautil.image.jpeg.Entry;
import mediautil.image.jpeg.Exif;
import mediautil.image.jpeg.LLJTran;
import org.junit.Test;

import java.io.*;
import java.util.Iterator;

/**
 * @author by kenshine
 * @Classname MediaUtilTest02
 * @Description 复制exif信息 media-executor读取 mediaUtil写入
 * @Date 2023-12-04 10:20
 * @modified By：
 * @version: 1.0$
 */
public class MediaUtilTest02 {

    /**
     * 复制exif信息
     */
    @Test
    public void test01(){
        File oldFile = new File("img/test.jpg");
        File newFile = new File("img/test03.jpg");
        try {
            //源图片exif信息读取
            Metadata metadata = JpegMetadataReader.readMetadata(oldFile);
            //这里要稍微注意下
            Directory directory = metadata.getDirectory(ExifThumbnailDirectory.class);
            System.out.println(metadata.getDirectories());
            Iterator<Tag> tags = directory.getTags().iterator();
            while (tags.hasNext()){
                Tag tag = tags.next();
                System.out.println("old" + tag);
            }
            //新图片exif信息读取
            metadata = JpegMetadataReader.readMetadata(newFile);
            //这里要稍微注意下
            directory = metadata.getDirectory(ExifThumbnailDirectory.class);
            tags = directory.getTags().iterator();
            while (tags.hasNext()) {
                Tag tag = tags.next();
                System.out.println("new" + tag);
            }

            //从旧文件中获取Thumbnail信息,长度和偏移量
            InputStream inOld = new BufferedInputStream(new FileInputStream("img/test.jpg"));
            SplitInputStream sipOld = new SplitInputStream(inOld);
            InputStream subIpOld = sipOld.createSubStream();
            LLJTran lljOld = new LLJTran(subIpOld);
            lljOld.initRead(LLJTran.READ_HEADER, true, true);
            sipOld.attachSubReader(lljOld, subIpOld);
            sipOld.wrapup();
            inOld.close();

            AbstractImageInfo imageInfoOld = lljOld.getImageInfo();
            Exif exifOld = (Exif)imageInfoOld;
            byte[] markerDataOld = Exif.getMarkerData();
            int thumbnailLengthOld = imageInfoOld.getThumbnailLength();
            //旧文件的偏移量
            int offsetOld = imageInfoOld.getThumbnailOffset();
            //旧文件的扩展名
            String thumbnailExtensionOld = imageInfoOld.getThumbnailExtension();
            InputStream thumbnailStreamOld = lljOld.getThumbnailAsStream();
            byte[] thumbOld = new byte[thumbnailLengthOld];
            thumbnailStreamOld.read(thumbOld);
            thumbnailStreamOld.close();
            sipOld.close();

            //目标文件exif信息修改
            InputStream fip = new BufferedInputStream(new FileInputStream("img/test03.jpg"));
            SplitInputStream sip = new SplitInputStream(fip);
            InputStream subIp = sip.createSubStream();
            LLJTran llj = new LLJTran(subIp);
            llj.initRead(LLJTran.READ_HEADER, true, true);
            sip.attachSubReader(llj, subIp);
            sip.wrapup();
            fip.close();
            // Check llj for errors
            String msg = llj.getErrorMsg();
            if (msg != null)
            {
                System.out.println("Error in LLJTran While Loading Image: " + msg);
                Exception e = llj.getException();
                if (e != null)
                {
                    System.out.println("Got an Exception, throwing it..");
                    throw e;
                }
                System.exit(1);
            }

            AbstractImageInfo imageInfo = llj.getImageInfo();
            String string = imageInfo.getThumbnailExtension();
            System.out.println(string);
            if (imageInfo.getThumbnailLength() > 0)
            {
                System.out.println("Image already has a Thumbnail. Exitting..");
                System.exit(1);
            }
            if (!(imageInfo instanceof Exif))
            {
                System.out.println("Adding a Dummy Exif Header");
                llj.addAppx(markerDataOld, 0, markerDataOld.length, true);

                imageInfo = llj.getImageInfo();

                Exif exif = (Exif)imageInfo;
                // 更改了Exif中的日期/时间和尺寸
                Entry entry = exif.getTagValue(Exif.DATETIME, true);
                if (entry != null) {
                    entry.setValue(0, "1998:08:18 11:15:00");
                }
                entry = exif.getTagValue(Exif.DATETIMEORIGINAL, true);
                if (entry != null) {
                    entry.setValue(0, "1998:08:18 11:15:00");
                }
                entry = exif.getTagValue(Exif.DATETIMEDIGITIZED, true);
                if (entry != null) {
                    entry.setValue(0, "1998:08:18 11:15:00");
                }

                int imageWidth = llj.getWidth();
                int imageHeight = llj.getHeight();
                if (imageWidth > 0 && imageHeight > 0)
                {
                    entry = exif.getTagValue(Exif.EXIFIMAGEWIDTH, true);
                    if (entry != null) {
                        entry.setValue(0, imageWidth);
                    }
                    entry = exif.getTagValue(Exif.EXIFIMAGELENGTH, true);
                    if (entry != null) {
                        entry.setValue(0, imageHeight);
                    }
                }
            }

            if (llj.setThumbnail(thumbOld, 294, thumbOld.length, ImageResources.EXT_JPG)) {
                System.out.println("Successfully Set New Thumbnail");
            } else {
                System.out.println("Error Setting New Thumbnail");
            }
            fip = new BufferedInputStream(new FileInputStream("c:/new.jpg"));
            OutputStream out = new BufferedOutputStream(new FileOutputStream("c:/new2.jpg"));

            // 在llj中替换新的Exif Header，同时从fip复制图像
            llj.xferInfo(fip, out, LLJTran.REPLACE, LLJTran.REPLACE);
            fip.close();
            out.close();
            llj.freeMemory();
            lljOld.freeMemory();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
