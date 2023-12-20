package com.kenshine.prettyformula;

import de.uni_bielefeld.cebitec.mzurowie.pretty_formula.main.FormulaParser;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname PfTest
 * @Description pretty-formula使用测试
 * @Date 2023-12-20 8:33
 * @modified By：
 * @version: 1.0$
 */
public class PfTest {
    /**
     * 转换为LeTex公式
     */
    @Test
    public void test01(){
        String formula = "(a_1 / (b_1 + sqrt(c))^2) + sin(a_2 * b_2)";
        String letex = FormulaParser.parseToLatex(formula);
        System.out.println(letex);
    }

    /**
     * 转换为位图
     */
    @Test
    public void test02(){
        String formula = "(a_1 / (b_1 + sqrt(c))^2) + sin(a_2 * b_2)";
        BufferedImage image=FormulaParser.parseToImage(formula);
        //Graphics2D g2d = image.createGraphics();
        // 创建文件对象 需手动创建output文件夹
        File output = new File("output\\tet02.png");
        // 创建文件输出流
        try {
            ImageIO.write(image, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换为矢量图
     */
    @Test
    public void test03() throws IOException {
        String formula = "(a_1 / (b_1 + sqrt(c))^2) + sin(a_2 * b_2)";
        FormulaParser.saveToSVG(formula,new File("output\\test03.svg"));
    }
}
