package com.kenshine.pnglibrary;

import io.nayuki.png.ImageEncoder;
import io.nayuki.png.PngImage;
import io.nayuki.png.chunk.Ihdr;
import io.nayuki.png.image.RgbaImage;

import java.io.File;
import java.io.IOException;

public final class RainbowRing {
	
	public static void main(String[] args) throws IOException {
		RgbaImage img = new RgbaImage() {
			public int getWidth() {
				return 400;
			}

			public int getHeight() {
				return 400;
			}

			public int[] getBitDepths() {
				return new int[]{8, 8, 8, 8};
			}

			public long getPixel(int x, int y) {
				double radius = Math.hypot(x + 0.5 - getWidth() / 2.0, y + 0.5 - getHeight() / 2.0);
				double angle = Math.atan2(y + 0.5 - getHeight() / 2.0, x + 0.5 - getWidth() / 2.0);
				long rgb = hsvToRgb(angle / (Math.PI * 2), 1, 1);
				long a = Math.round(1 / (1 + Math.exp((Math.abs(radius - getWidth() * 0.4) - 20) * 2)) * 255);
				return rgb | a << 0;
			}
		};
		
		PngImage png = ImageEncoder.toPng(img, Ihdr.InterlaceMethod.NONE);
		png.write(new File("springbootdemo824-PNGLibrary\\test\\rainbow-ring.png"));
	}
	
	
	private static long hsvToRgb(double hue, double saturation, double value) {
		hue = ((hue % 1) + 1) % 1;
		long result = 0;
		for (int i = 0; i < 3; i++) {
			double temp = (hue * 6 + 7 - i * 2) % 6;
			double x;
			if (temp < 2)
				x = 1;
			else if (temp < 3)
				x = 3 - temp;
			else if (temp < 5)
				x = 0;
			else
				x = temp - 5;
			long y = Math.round((1 - saturation + x * saturation) * value * 255);
			result |= y << ((3 - i) * 16);
		}
		return result;
	}
	
}