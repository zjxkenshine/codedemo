package com.kenshine.pnglibrary;

import io.nayuki.png.ImageDecoder;
import io.nayuki.png.ImageEncoder;
import io.nayuki.png.PngImage;
import io.nayuki.png.chunk.Chunk;
import io.nayuki.png.chunk.Gama;
import io.nayuki.png.chunk.Ihdr;
import io.nayuki.png.chunk.Text;
import io.nayuki.png.image.BufferedRgbaImage;
import io.nayuki.png.image.GrayImage;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname PngTest
 * @Description Png使用测试
 * @Date 2024-06-14 13:35
 * @modified By：
 * @version: 1.0$
 */
public class PngTest {
    /**
     * 生成PNG
     */
  @Test
  public void test01() throws IOException {
      BufferedRgbaImage img = new BufferedRgbaImage(10,10, new int[]{8, 8, 8, 0});
      // 长 宽 位深度
      //img.setPixel(10,10,8);
      PngImage png = ImageEncoder.toPng(img, Ihdr.InterlaceMethod.NONE);
      //png.beforeIdats.add(new Gama(1 / 2.2));
      png.afterIdats.add(new Text("Author", "Myself"));
      png.write(new File("test\\output.png"));
  }

    /**
     * 解析PNG
     */
  @Test
  public void test02() throws IOException {
      PngImage png = PngImage.read(new File("test\\output.png"));
      GrayImage img = (GrayImage) ImageDecoder.toImage(png);
      for (int y = 0; y < img.getHeight(); y++) {
          for (int x = 0; x < img.getWidth(); x++) {
              draw(img.getPixel(x, y));
          }
      }
  }

    private void draw(int pixel) {
        System.out.printf(String.valueOf(pixel));
    }
}
