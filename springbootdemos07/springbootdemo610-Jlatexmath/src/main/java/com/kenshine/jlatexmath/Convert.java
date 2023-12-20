package com.kenshine.jlatexmath;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.fop.render.ps.EPSTranscoder;
import org.apache.fop.render.ps.PSTranscoder;
import org.apache.fop.svg.AbstractFOPTranscoder;
import org.apache.fop.svg.PDFTranscoder;
import org.scilab.forge.jlatexmath.DefaultTeXFont;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * 转换器
 * @author kenshine
 */
public class Convert {

    public static final int PDF = 0;
    public static final int PS = 1;
    public static final int EPS = 2;

    /**
     * latex转svg文件
     * fontAsShapes：如果为true，则在转换中将所有文本转换为SVG形状
     */
    public static void toSVG(String latex, String file, boolean fontAsShapes) throws IOException {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(document);

        SVGGraphics2D g2 = new SVGGraphics2D(ctx, fontAsShapes);

        DefaultTeXFont.registerAlphabet(new CyrillicRegistration());
        DefaultTeXFont.registerAlphabet(new GreekRegistration());

        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
        icon.setInsets(new Insets(5, 5, 5, 5));
        g2.setSVGCanvasSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        g2.setColor(Color.white);
        g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());

        JLabel jl = new JLabel();
        jl.setForeground(new Color(0, 0, 0));
        icon.paintIcon(jl, g2, 0, 0);

        boolean useCSS = true;
        FileOutputStream svgs = new FileOutputStream("out/" + file);
        Writer out = new OutputStreamWriter(svgs, "UTF-8");
        g2.stream(out, useCSS);
        svgs.flush();
        svgs.close();
    }

    /**
     * svg转换为pdf/ps/eps
     */
    public static void SVGTo(String inSVG, String out, int type) {
        AbstractFOPTranscoder trans;
        switch (type) {
            case PDF:
                trans = new PDFTranscoder();
                break;
            case PS:
                trans = new PSTranscoder();
                break;
            case EPS:
                trans = new EPSTranscoder();
                break;
            default:
                trans = null;
        }

        try {
            String filename = "out/" + inSVG;
            System.out.println("transcoding "
                    + filename);
            TranscoderInput input = new TranscoderInput(new FileInputStream(filename));
            OutputStream os = new FileOutputStream("out/" + out);
            TranscoderOutput output = new TranscoderOutput(os);
            trans.transcode(input, output);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(
                    "Problem when exporting " + inSVG + " to " + out + "!\n" + e.toString());
            throw new RuntimeException(e);
        }
    }
}