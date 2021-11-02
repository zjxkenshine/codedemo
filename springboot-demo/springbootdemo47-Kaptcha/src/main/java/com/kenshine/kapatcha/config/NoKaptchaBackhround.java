package com.kenshine.kapatcha.config;

import com.google.code.kaptcha.BackgroundProducer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 0:06
 * @description：去除验证码背景
 * @modified By：
 * @version: $
 */
public class NoKaptchaBackhround extends Configurable implements BackgroundProducer {

    public NoKaptchaBackhround(){
    }

    @Override
    public BufferedImage addBackground(BufferedImage baseImage) {
        int width = 400;
        int height = 125;
        BufferedImage imageWithBackground = new BufferedImage(width, height, 1);
        Graphics2D graph = (Graphics2D)imageWithBackground.getGraphics();
        graph.fill(new Rectangle2D.Double(0.0D, 0.0D, (double)width, (double)height));
        graph.drawImage(baseImage, 0, 0, null);
        return imageWithBackground;
    }


}
