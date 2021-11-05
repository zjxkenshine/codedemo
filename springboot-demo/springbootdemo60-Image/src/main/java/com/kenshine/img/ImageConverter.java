package com.kenshine.img;

import net.arnx.wmf2svg.gdi.svg.SvgGdi;
import net.arnx.wmf2svg.gdi.wmf.WmfParser;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFRenderer;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 15:00
 * @description：图片格式转换
 * @modified By：
 * @version: $
 */
public class ImageConverter {

    public static String EmfToPng(String pathName) throws Exception {
        if (checkFileTypeByName(pathName, "emf")) {
            EMFInputStream in = null;
            try {
                in = new EMFInputStream(new FileInputStream(pathName), EMFInputStream.DEFAULT_VERSION);
                EMFRenderer emfRenderer = new EMFRenderer(in);
                final int width = (int) in.readHeader().getBounds().getWidth();
                final int height = (int) in.readHeader().getBounds().getHeight();
                final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D g2 = result.createGraphics();
                emfRenderer.paint(g2);
                String destFile = pathName.substring(0, pathName.toLowerCase().lastIndexOf(".emf")) + ".png";
                ImageIO.write(result, "png", new File(destFile));
                return destFile;
            } finally {
                if (null != in) {
                    in.close();
                }
            }
        } else {
            throw new RuntimeException("Not EMF file!");
        }
    }

    public static String SvgToPng(String pathName) throws Exception {
        if (checkFileTypeByName(pathName, "svg")) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(pathName);
                String destFile = pathName.substring(0, pathName.toLowerCase().lastIndexOf(".svg")) + ".png";
                out = new FileOutputStream(destFile);
                out = new BufferedOutputStream(out);
                TranscoderInput trIn = new TranscoderInput(in);
                TranscoderOutput trOut = new TranscoderOutput(out);
                Transcoder tr = new PNGTranscoder();
                tr.transcode(trIn, trOut);
                return destFile;
            } finally {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
            }
        } else {
            throw new RuntimeException("Not SVG file!");
        }
    }

    public static String SvgToJpg(String pathName) throws Exception {
        if (checkFileTypeByName(pathName, "svg")) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(pathName);
                String destFile = pathName.substring(0, pathName.toLowerCase().lastIndexOf(".svg")) + ".jpg";
                out = new FileOutputStream(destFile);
                out = new BufferedOutputStream(out);
                TranscoderInput trIn = new TranscoderInput(in);
                TranscoderOutput trOut = new TranscoderOutput(out);
                Transcoder tr = new JPEGTranscoder();
                tr.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, 0.99f);
                tr.transcode(trIn, trOut);
                return destFile;
            } finally {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
            }
        } else {
            throw new RuntimeException("Not SVG file!");
        }
    }

    public static String SvgToStr(String pathName) throws Exception {
        if (checkFileTypeByName(pathName, "svg")) {
            BufferedReader in = null;
            try {
                StringBuffer sb = new StringBuffer();
                in = new BufferedReader(new InputStreamReader(new FileInputStream(pathName), "UTF-8"));
                String line = "";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            } finally {
                if (null != in) {
                    in.close();
                }
            }
        } else {
            throw new RuntimeException("Not SVG file!");
        }
    }

    public static String WmfToSvg(String pathName) throws Exception {
        if (checkFileTypeByName(pathName, "wmf")) {
            InputStream in = null;
            OutputStream out = null;
            try {
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer();
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 1.0//EN");
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
                        "http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd");
                //
                String destFile = pathName.substring(0, pathName.toLowerCase().lastIndexOf(".wmf")) + ".svg";
                out = new FileOutputStream(destFile);
                //
                in = new FileInputStream(pathName);
                WmfParser parser = new WmfParser();
                final SvgGdi gdi = new SvgGdi(false);
                parser.parse(in, gdi);
                Document doc = gdi.getDocument();
                transformer.transform(new DOMSource(doc), new StreamResult(out));
                out.flush();
                return destFile;
            } finally {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
            }
        } else {
            throw new RuntimeException("Not WMF file!");
        }
    }

    public static String WmfToPng(String pathName) throws Exception {
        return SvgToPng(WmfToSvg(pathName));
    }

    /**
     * @param sfm
     *            BMP/JPG/PNG/GIF
     * @param dfm
     *            BMP/JPG/PNG/GIF
     * @param pathName
     * @return
     * @throws Exception
     */
    public static String convert(String sfm, String dfm, String pathName) throws Exception {
        if (sfm.trim().equalsIgnoreCase(dfm.trim())) {
            return pathName;
        } else {
            File input = new File(pathName);
            String destFile = pathName.substring(0, pathName.toLowerCase().lastIndexOf(sfm.toLowerCase().trim()))
                    + dfm.toLowerCase().trim();;
            BufferedImage bim = ImageIO.read(input);
            File output = new File(destFile);
            ImageIO.write(bim, dfm, output);
            return destFile;
        }
    }

    private static boolean checkFileTypeByName(String pathname, String destType) {
        String fileType = pathname.substring(pathname.lastIndexOf(".") + 1, pathname.length()).toLowerCase();
        return destType.equalsIgnoreCase(fileType);
    }

    public static void main(String[] args) throws Exception {
        String PATH = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo60-Image\\src\\main\\resources\\image\\";
        System.out.println(convert("jpg", "png", PATH+"test.jpg"));
        System.out.println(convert("jpg", "BMP", PATH+"test.jpg"));
        System.out.println(convert("jpg", "gif", PATH+"test.jpg"));

        System.out.println(EmfToPng("e:/temp/image/emf1.emf"));
        System.out.println(SvgToPng("e:/temp/image/svg1.svg"));
        System.out.println(SvgToJpg("e:/temp/image/svg1.svg"));
        System.out.println(WmfToPng("e:/temp/image/wmf1.wmf"));
        System.out.println(SvgToStr("e:/temp/image/svg1.svg"));
    }

}
