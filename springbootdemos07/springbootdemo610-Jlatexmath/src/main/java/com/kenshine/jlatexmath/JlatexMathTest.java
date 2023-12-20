package com.kenshine.jlatexmath;

import org.junit.Test;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author by kenshine
 * @Classname JlatexMathTest
 * @Description jlatex latex转图片
 * @Date 2023-12-20 15:20
 * @modified By：
 * @version: 1.0$
 */
public class JlatexMathTest {


    /**
     * latex转图片
     */
    @Test
    public void test01() throws Exception {
        String latex = "\\sqrt{{\\mathrm{a}}^{2}+{\\mathrm{b}}^{2}}";
        // 保存到文件
        File file = new File("out\\test.png");
        BufferedImage image = (BufferedImage)image(latex);
        ImageIO.write(image, "png", file);
    }


    /**
     * 转换测试
     */
    @Test
    public void test02(){
        String latex = "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek}}\\\\";
        latex += "\\mbox{" + "привет мир".toUpperCase() + "}&\\mbox{" + "γειά κόσμο".toUpperCase() + "}\\\\";
        latex += "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\";
        latex += "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\";
        latex += "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\";
        latex += "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\";
        latex += "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\";
        latex += "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
        latex += "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\";
        latex += "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
        latex += "&\\\\";
        latex += "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\";
        latex += "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\";
        latex += "&\\\\";
        latex += "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\";
        latex += "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\";
        latex += "\\end{array}";

        try {
            Convert.toSVG(latex, Paths.get("svg", "Example1.svg").toString(), false);
            Convert.toSVG(latex, Paths.get("svg", "Example1_shaped.svg").toString(), true);
            Convert.SVGTo(Paths.get("svg", "Example1.svg").toString(), Paths.get("pdf", "Example1.pdf").toString(), Convert.PDF);
            Convert.SVGTo(Paths.get("svg", "Example1_shaped.svg").toString(), Paths.get("pdf", "Example1_shaped.pdf").toString(), Convert.PDF);
            Convert.SVGTo(Paths.get("svg", "Example1.svg").toString(), Paths.get("pdf", "Example1.ps").toString(), Convert.PS);
            Convert.SVGTo(Paths.get("svg", "Example1.svg").toString(), Paths.get("pdf", "Example1.eps").toString(), Convert.EPS);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * latex转图片
     */
    public static Image image(String latex) throws Exception {
        // 样式 符号以最大的尺寸呈现
        int style = TeXConstants.STYLE_DISPLAY;
        // 生成公式图片的字体大小
        float size = 24;
        // 字体颜色，黑色
        Color fg = Color.BLACK;
        // 图片背景色，默认为透明北京
        Color bg = null;
        return TeXFormula.createBufferedImage(latex, style, size, fg, bg);
    }
}
