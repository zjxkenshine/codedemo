package com.kenshine.opencv.utils;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.util.Comparator;

/**
 * @Classname FaceUtils
 * @Description TODO
 * @Date 23/2/19 8:58
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */
public class FaceUtils {
    static {
        System.setProperty("java.awt.headless", "true");
        String dir = System.getProperty("user.dir").replace("/", "\\");
        String filePath = "\\dll\\" + (System.getProperty("java.vm.name").contains("64") ? "x64" : "x86") + "\\opencv_java460.dll";
        String path = dir.concat(filePath);
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("找不到动态库".concat(path));
        }
        System.load(path);
        System.out.println(path.concat("  load success"));
    }

    /**
     * 检测人脸数量
     *
     * @param base64
     * @return
     */
    public static int checkFaceNo(String base64) {
        String path = System.getProperty("user.dir").concat("/haarcascades/haarcascade_frontalface_alt.xml");
        CascadeClassifier faceDetector = new CascadeClassifier(path);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(StreamUtils.base642Mat(base64), faceDetections);
        return faceDetections.toArray().length;
    }

    public static String extractMaxFace(String base64) {
        String path = System.getProperty("user.dir").concat("/haarcascades/haarcascade_frontalface_alt.xml");
        CascadeClassifier faceDetector = new CascadeClassifier(path);
        MatOfRect faceDetections = new MatOfRect();
        Mat mat = StreamUtils.base642Mat(base64);
        faceDetector.detectMultiScale(mat, faceDetections);
        if (faceDetections.toArray().length > 0) {
            Rect rect = faceDetections.toList().parallelStream().max(Comparator.comparingInt(o -> o.height * o.width)).get();
            Mat face = imageCut(mat, rect.x, rect.y, rect.width, rect.height);

            return StreamUtils.catToBase64(face);

        }


        return null;
    }

    /**
     * @param image  原始图像
     * @param posX   x坐标
     * @param posY   y坐标
     * @param width  宽度
     * @param height 高度
     * @return
     */
    private static Mat imageCut(Mat image, int posX, int posY, int width, int height) {

        // 截取的区域：参数,坐标X,坐标Y,截图宽度,截图长度
        Rect rect = new Rect(posX, posY, width, height);
        // 两句效果一样
        // Mat sub = new Mat(image,rect);
        Mat sub = image.submat(rect);
        Mat mat = new Mat();
        Size size = new Size(width, height);
        // 将人脸进行截图并保存
        Imgproc.resize(sub, mat, size);
        return mat;

    }


    public static String markFace(String base64Images) {
        String path = System.getProperty("user.dir").concat("/haarcascades/haarcascade_frontalface_alt.xml");
        CascadeClassifier faceDetector = new CascadeClassifier(path);
        MatOfRect faceDetections = new MatOfRect();
        Mat mat = StreamUtils.base642Mat(base64Images);
        faceDetector.detectMultiScale(mat, faceDetections);
        if (faceDetections.toArray().length > 0) {
            for (Rect rect : faceDetections.toList()) {
                Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 3);
            }
        }
        return StreamUtils.catToBase64(mat);
    }

}
