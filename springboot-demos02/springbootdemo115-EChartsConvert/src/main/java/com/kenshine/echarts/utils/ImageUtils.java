package com.kenshine.echarts.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 8:34
 * @description：圖像工具類
 * @modified By：
 * @version: $
 */
public class ImageUtils {
    private ImageUtils() {
    }

    /**
     * 将base64转为图片
     * */
    public static void convertBase64ToImage(String base64, OutputStream os) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        // 解密
        byte[] b = decoder.decode(base64);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        os.write(b);
        os.flush();
    }

}
