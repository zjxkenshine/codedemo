package com.kenshine.avatar.util;

import com.kenshine.avatar.demo02.AvatarHelper;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 14:02
 * @description：工具类
 * @modified By：
 * @version: $
 *
 * 整合了几个demo的工具类
 */
public class AvatarUtil {


    /**
     * 绘制头像存储到本地
     * @param name 用户名
     * @param outputName 输出文件名
     * @param path 本地路径
     * @throws IOException
     */
    public static void getWordImgToPath(String name, String outputName,String path) throws IOException {
        int nameLen = name.length();
        String nameWritten;
        //如果用户输入的姓名少于等于2个字符，不用截取
        if (nameLen <= 2) {
            nameWritten = name;
        } else {
            //如果用户输入的姓名大于等于3个字符，截取后面一位  可根据需求改长度
            String first = name.substring(0, 1);
            if (isChinese(first)) {
                //截取倒数两位汉字
                nameWritten = name.substring(nameLen - 1);
            } else {
                //截取前面的两个英文字母
                nameWritten = name.substring(0, 2).toUpperCase();
            }
        }

        //输出路径
        String filename = path + outputName + ".jpg";
        File file = new File(filename);


        BufferedImage rounded = getBufferedImage(nameWritten);
        ImageIO.write(rounded, "png", file);

    }


    /**
     * 绘制头像返回到response 预览或下载
     * 存储到OSS也是获取OutputStream
     * @param name 用户名
     * @param outputName 输出文件名
     * @param response 响应
     * @throws IOException
     */
    public static void getWordImgToResponse(String name, String outputName, HttpServletResponse response) throws IOException {
        int nameLen = name.length();
        String nameWritten;
        //如果用户输入的姓名少于等于2个字符，不用截取
        if (nameLen <= 2) {
            nameWritten = name;
        } else {
            //如果用户输入的姓名大于等于3个字符，截取后面一位  可根据需求改长度
            String first = name.substring(0, 1);
            if (isChinese(first)) {
                //截取倒数两位汉字
                nameWritten = name.substring(nameLen - 1);
            } else {
                //截取前面的两个英文字母
                nameWritten = name.substring(0, 2).toUpperCase();
            }
        }
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //加上这一行就变成下载文件
        //response.setHeader("Content-Disposition", "attachment;fileName=" + outputName +".jpg");
        BufferedImage rounded = getBufferedImage(nameWritten);
        ImageIO.write(rounded, "png", response.getOutputStream());
    }


    /**
     * 绘制头像并写道输出流
     * @param name 用户名
     * @param outputStream 输出流
     * @throws IOException
     */
    public static void getWordImgToOutPutStream(String name, OutputStream outputStream) throws IOException {
        int nameLen = name.length();
        String nameWritten;
        //如果用户输入的姓名少于等于2个字符，不用截取
        if (nameLen <= 2) {
            nameWritten = name;
        } else {
            //如果用户输入的姓名大于等于3个字符，截取后面一位  可根据需求改长度
            String first = name.substring(0, 1);
            if (isChinese(first)) {
                //截取倒数两位汉字
                nameWritten = name.substring(nameLen - 1);
            } else {
                //截取前面的两个英文字母
                nameWritten = name.substring(0, 2).toUpperCase();
            }
        }
        BufferedImage rounded = getBufferedImage(nameWritten);
        ImageIO.write(rounded, "png", outputStream);
    }


    /**
     * 生成像素类型头像 github那种
     * @return
     * @throws IOException
     */
    public static void getHashImgToResponse(String name,HttpServletResponse response) throws IOException {
        int id = Math.abs(name.hashCode());
        int width = 20;
        int grid = 5;
        int padding = width / 2;
        int size = width * grid + width;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D _2d = img.createGraphics();
        _2d.setColor(new Color(240, 240, 240));
        _2d.fillRect(0, 0, size, size);
        _2d.setColor(randomColor(80, 200));
        char[] idchars = createIdent(id);
        int i = idchars.length;
        for (int x = 0; x < Math.ceil(grid / 2.0); x++) {
            for (int y = 0; y < grid; y++) {
                if (idchars[--i] < 53) {
                    _2d.fillRect((padding + x * width), (padding + y * width), width, width);
                    if (x < Math.floor(grid / 2)) {
                        _2d.fillRect((padding + ((grid - 1) - x) * width), (padding + y * width), width, width);
                    }
                }
            }
        }
        _2d.dispose();
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ImageIO.write(img, "png", response.getOutputStream());
    }

    /**
     * 获取头像base64地址
     * @return
     * @throws IOException
     */
    public static String getHashImgPath(String name) throws IOException {
        String avatar = AvatarHelper.createBase64Avatar(Math.abs(name.hashCode()));
        return AvatarHelper.BASE64_PREFIX + avatar;
    }





    /**
     * 获取图片
     * @param nameWritten 图片展示的文字
     * @return
     */
    private static BufferedImage getBufferedImage(String nameWritten) {
        int width = 100;
        int height = 100;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setBackground(getRandomColor());

        g2.clearRect(0, 0, width, height);

        g2.setPaint(Color.WHITE);


        Font font = null;
        //两个字及以上
        if(nameWritten.length() >= 2) {
            font = new Font("微软雅黑", Font.PLAIN, 30);
            g2.setFont(font);

            String firstWritten = nameWritten.substring(0, 1);
            String secondWritten = nameWritten.substring(1, 2);

            //两个中文 如 言曌
            if (isChinese(firstWritten) && isChinese(secondWritten)) {
                g2.drawString(nameWritten, 20, 60);
            }
            //首中次英 如 罗Q
            else if (isChinese(firstWritten) && !isChinese(secondWritten)) {
                g2.drawString(nameWritten, 27, 60);

                //首英,如 AB
            } else {
                nameWritten = nameWritten.substring(0,1);
            }

        }
        //一个字
        if(nameWritten.length() ==1) {
            //中文
            if(isChinese(nameWritten)) {
                font = new Font("微软雅黑", Font.PLAIN, 50);
                g2.setFont(font);
                g2.drawString(nameWritten, 25, 70);
            }
            //英文
            else {
                font = new Font("微软雅黑", Font.PLAIN, 55);
                g2.setFont(font);
                g2.drawString(nameWritten.toUpperCase(), 33, 67);
            }

        }

        return makeRoundedCorner(bi, 99);
    }


    /**
     * 判断字符串是否为中文
     * @param str
     * @return
     */
    private static boolean isChinese(String str) {
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find())
            return true;
        else
            return false;
    }

    /**
     * 获得随机颜色
     * @return
     */
    private static Color getRandomColor() {
        String[] beautifulColors =
                new String[]{"232,221,203", "205,179,128", "3,101,100", "3,54,73", "3,22,52",
                        "237,222,139", "251,178,23", "96,143,159", "1,77,103", "254,67,101", "252,157,154",
                        "249,205,173", "200,200,169", "131,175,155", "229,187,129", "161,23,21", "34,8,7",
                        "118,77,57", "17,63,61", "60,79,57", "95,92,51", "179,214,110", "248,147,29",
                        "227,160,93", "178,190,126", "114,111,238", "56,13,49", "89,61,67", "250,218,141",
                        "3,38,58", "179,168,150", "222,125,44", "20,68,106", "130,57,53", "137,190,178",
                        "201,186,131", "222,211,140", "222,156,83", "23,44,60", "39,72,98", "153,80,84",
                        "217,104,49", "230,179,61", "174,221,129", "107,194,53", "6,128,67", "38,157,128",
                        "178,200,187", "69,137,148", "117,121,71", "114,83,52", "87,105,60", "82,75,46",
                        "171,92,37", "100,107,48", "98,65,24", "54,37,17", "137,157,192", "250,227,113",
                        "29,131,8", "220,87,18", "29,191,151", "35,235,185", "213,26,33", "160,191,124",
                        "101,147,74", "64,116,52", "255,150,128", "255,94,72", "38,188,213", "167,220,224",
                        "1,165,175", "179,214,110", "248,147,29", "230,155,3", "209,73,78", "62,188,202",
                        "224,160,158", "161,47,47", "0,90,171", "107,194,53", "174,221,129", "6,128,67",
                        "38,157,128", "201,138,131", "220,162,151", "137,157,192", "175,215,237", "92,167,186",
                        "255,66,93", "147,224,255", "247,68,97", "185,227,217"};
        int len = beautifulColors.length;
        Random random = new Random();
        String[] color = beautifulColors[random.nextInt(len)].split(",");
        return new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]),
                Integer.parseInt(color[2]));
    }


    /**
     * 图片做圆角处理
     * @param image
     * @param cornerRadius
     * @return
     */
    private static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }


    private static Color randomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(Math.abs(bc - fc));
        int g = fc + random.nextInt(Math.abs(bc - fc));
        int b = fc + random.nextInt(Math.abs(bc - fc));
        return new Color(r, g, b);
    }

    private static char[] createIdent(int id) {
        BigInteger bi_content = new BigInteger((id + "").getBytes());
        BigInteger bi = new BigInteger(id + "identicon" + id, 36);
        bi = bi.xor(bi_content);
        return bi.toString(10).toCharArray();
    }


    // 可以直接在<img/>标签或者浏览器地址栏预览的base64编码头
    public static final String BASE64_PREFIX = "data:image/png;base64,";

    /**
     * 生成头像的base64编码
     * @param id
     * @return
     * @throws IOException
     */
    public static String createBase64Avatar(int id) throws IOException {
        return new String(Base64.getEncoder().encode(create(id)));
    }

    /**
     * 根据id生成一个头像，颜色随机。如果是使用hashCode()值的话，值可能为负数。需要要注意。
     * @param id
     * @return
     * @throws IOException
     */
    public static byte[] create(int id) throws IOException {
        int width = 20;
        int grid = 5;
        int padding = width / 2;
        int size = width * grid + width;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D _2d = img.createGraphics();
        _2d.setColor(new Color(240, 240, 240));
        _2d.fillRect(0, 0, size, size);
        _2d.setColor(randomColor(80, 200));
        char[] idchars = createIdent(id);
        int i = idchars.length;
        for (int x = 0; x < Math.ceil(grid / 2.0); x++) {
            for (int y = 0; y < grid; y++) {
                if (idchars[--i] < 53) {
                    _2d.fillRect((padding + x * width), (padding + y * width), width, width);
                    if (x < Math.floor(grid / 2)) {
                        _2d.fillRect((padding + ((grid - 1) - x) * width), (padding + y * width), width, width);
                    }
                }
            }
        }
        _2d.dispose();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }



}
