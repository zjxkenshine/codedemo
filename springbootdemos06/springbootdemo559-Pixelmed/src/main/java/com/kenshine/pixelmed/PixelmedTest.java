package com.kenshine.pixelmed;

import com.pixelmed.dicom.*;
import com.pixelmed.display.ConsumerFormatImageMaker;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname PixelmedTest
 * @Description 简单使用测试
 * @Date 2023-12-08 20:21
 * @modified By：
 * @version: 1.0$
 */
public class PixelmedTest {

    /**
     * dcm转png
     */
    @Test
    public void test01() throws IOException, DicomException {
        String dicomFilePath = "dcm\\test1.dcm";
        String outputPngFilePath = "img\\test1.png";
        ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFilePath, outputPngFilePath, "png", 0);
    }

    /**
     * dcm转png
     */
    @Test
    public void test02() throws IOException, DicomException {
        String dicomFilePath = "dcm\\test2.dcm";
        String outputPngFilePath = "img\\test2.png";
        ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFilePath, outputPngFilePath, "png", 0);
    }



}
