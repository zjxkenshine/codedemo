package com.kenshine.okapibarcode;

import org.junit.Test;
import uk.org.okapibarcode.backend.Code128;
import uk.org.okapibarcode.backend.DataMatrix;
import uk.org.okapibarcode.backend.HumanReadableLocation;
import uk.org.okapibarcode.backend.QrCode;
import uk.org.okapibarcode.output.Java2DRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname CodeTest
 * @Description 测试
 * @Date 2023-10-28 12:02
 * @modified By：
 * @version: 1.0$
 */
public class CodeTest {

    /**
     * Code128
     */
    @Test
    public void test01_Code128() throws IOException {
        Code128 barcode = new Code128();
        barcode.setFontName("Monospaced");
        barcode.setFontSize(16);
        barcode.setModuleWidth(2);
        barcode.setBarHeight(50);
        barcode.setHumanReadableLocation(HumanReadableLocation.BOTTOM);
        barcode.setContent("123456789");

        int width = barcode.getWidth();
        int height = barcode.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = image.createGraphics();
        Java2DRenderer renderer = new Java2DRenderer(g2d, 1, uk.org.okapibarcode.graphics.Color.WHITE, uk.org.okapibarcode.graphics.Color.BLACK);
        renderer.render(barcode);
        // main方法可用该path
        ImageIO.write(image, "png", new File("springbootdemo430-OkapiBarcode\\bar\\code128.png"));
    }

    /**
     * QR Code
     */
    @Test
    public void test02_QR_Code() throws IOException {
        QrCode barcode = new QrCode();
        barcode.setFontName("Monospaced");
        barcode.setFontSize(16);
        barcode.setModuleWidth(2);
        barcode.setBarHeight(50);
        barcode.setHumanReadableLocation(HumanReadableLocation.BOTTOM);
        barcode.setContent("123456789");

        int width = barcode.getWidth();
        int height = barcode.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = image.createGraphics();
        Java2DRenderer renderer = new Java2DRenderer(g2d, 1, uk.org.okapibarcode.graphics.Color.WHITE, uk.org.okapibarcode.graphics.Color.BLACK);
        renderer.render(barcode);
        // test中的路径
        ImageIO.write(image, "png", new File("bar\\qrcode.png"));
    }

    /**
     * Data_Matrix
     */
    @Test
    public void test03_Data_Matrix() throws IOException {
        DataMatrix barcode = new DataMatrix();
        barcode.setFontName("Monospaced");
        barcode.setFontSize(16);
        barcode.setModuleWidth(2);
        barcode.setBarHeight(50);
        barcode.setHumanReadableLocation(HumanReadableLocation.BOTTOM);
        barcode.setContent("123456789");

        int width = barcode.getWidth();
        int height = barcode.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = image.createGraphics();
        Java2DRenderer renderer = new Java2DRenderer(g2d, 1, uk.org.okapibarcode.graphics.Color.WHITE, uk.org.okapibarcode.graphics.Color.BLACK);
        renderer.render(barcode);
        // test中的路径
        ImageIO.write(image, "png", new File("bar\\dm.png"));
    }
}
