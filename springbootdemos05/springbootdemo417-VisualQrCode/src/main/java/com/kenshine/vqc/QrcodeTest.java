package com.kenshine.vqc;

import com.boat.visualqrcode.VisualQRCode;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/26 23:33
 * @description：测试
 * @modified By：
 * @version: $
 */
public class QrcodeTest {
    public static final String outPutPath="E:\\test\\";

    /**
     * 方形码眼，方形小点
     */
    @Test
    public void test01(){
        String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
        try {
            VisualQRCode.createQRCode(url,
                    "./img/lg-logo.jpg",
                    outPutPath + "QRCodePOSITIONRECTANGLE.png",
                    'H',
                    new Color(2, 85, 43),
                    null,
                    null,
                    null,
                    true,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_RECTANGLE,
                    VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方圆形码眼，圆形小点
     */
    @Test
    public void test02(){
        String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
        try {
            VisualQRCode.createQRCode(url,
                    "./img/lg-logo.jpg",
                    outPutPath + "FILLCIRCLE.png",
                    'H',
                    new Color(2, 85, 43),
                    null,
                    null,
                    null,
                    true,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE,
                    VisualQRCode.FILL_SHAPE_MODEL_CIRCLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 二维码在图片右下角
     */
    @Test
    public void test03(){
        String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
        try {
            VisualQRCode.createQRCode(url,
                    "./img/xmyrz.jpg",
                    outPutPath+"LARGEIMG.png",
                    'H',
                    new Color(170, 24, 67),
                    800,
                    420,
                    200,
                    false,
                    VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE,
                    VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
