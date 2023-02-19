package com.kenshine.opencv.utils;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.opencv.imgproc.Imgproc.*;

/**
 * @Classname OpenCVUtil
 * @Description TODO
 * @Date 23/2/19 8:35
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */
//@Component
//@Scope(value = "singleton")
public class OpenCVUtil {
    /**
     * 日志组件可根据自己项目更换
     */
    private static final Logger logger = LoggerFactory.getLogger(OpenCVUtil.class);

    /**
     * 1.什么是java.awt.headless模式
     * java.awt.headless是J2SE的一种模式，用于在缺失显示屏、鼠标或者键盘时的系统配置。对于后端服务来讲，很多都是需要将这个属性设置为true的。
     * 2.什么时候使用java.awt.headless模式
     * 对于开发者来讲常常需要在该模式下工作。因为服务器（如提供Web服务的）往往可能缺少前述设备，但又需要使用他们提供的功能，生成相应的数据，以提供给客户端（如浏览器所在的配有相关的、键盘和的主机）。
     */
//    static {
//        try {
//            // 解决awt报错问题
//            logger.info("启动headless mode...");
//            System.setProperty("java.awt.headless", "true");
//            logger.info("动态库路径：{}", System.getProperty("java.library.path"));
//            logger.info("开始加载OpenCV库...");
//            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//            logger.info("load success");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 图片清晰度增强
     * 使用高斯滤波器，高斯滤镜可减少图像中的噪声并使它看起来更好(或更高分辨率)
     * http://www.srcmini.com/70014.html
     *
     * @param base64 图片Base64
     */
    public String imageDefinitionEnhance(String base64) {
        logger.info("图片清晰度增强");
        Mat source = MatUtil.base642Mat(base64);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        GaussianBlur(source, destination, new Size(0, 0), 10);
        Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
        return MatUtil.mat2Base64(destination);
    }

    /**
     * 图片对比度增强
     * 使用直方图均衡
     * http://www.srcmini.com/70010.html
     *
     * @param base64 图片Base64
     */
    public String imageContrastEnhance(String base64) {
        logger.info("图片对比度增强");
        Mat source = MatUtil.base642Mat(base64);
        cvtColor(source, source, COLOR_BGR2GRAY);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        equalizeHist(source, destination);
        return MatUtil.mat2Base64(destination);
    }

    /**
     * 图片无损放大
     * 使用高斯金字塔
     * https://blog.csdn.net/datouniao1/article/details/108535563
     *
     * @param base64 图片Base64（去文件头）
     */
    public String imageQualityEnhance(String base64) {
        logger.info("图片无损放大");
        Mat source = MatUtil.base642Mat(base64);
        Mat destination = new Mat();
        pyrUp(source, destination);
        return MatUtil.mat2Base64(destination);
    }

}
