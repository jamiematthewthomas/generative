package dev.jamiethomas.generative.sketches;

import java.awt.image.BufferedImage;

import dev.jamiethomas.generative.Generative;
import dev.jamiethomas.generative.utils.CurveUtils;
import dev.jamiethomas.generative.utils.ImageUtils;
import processing.core.PApplet;

public class SketchDrawImageUsingCurves extends Generative {

	@Override
	public void setup() {
		background(255);
	}

	@Override
	public void draw() {
		BufferedImage image = ImageUtils.loadImageFromFile("C:/Users/jamie/Desktop/cat_nerd_compressed.png");

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int rgb = image.getRGB(i, j);
				int r = (rgb >> 16) & 0xFF; 
				int g = (rgb >> 8) & 0xFF;
				int b = (rgb & 0xFF);
				int grey = (r + g + b) / 3;
				CurveUtils.drawCurve(this, i*10, j*10, 10, (255 - grey) / 11);
			}
		}
		
		stop();
	}

  public static void main(String[] args) {
    String[] processingArgs = { SketchDrawImageUsingCurves.class.getSimpleName() };
    SketchDrawImageUsingCurves mySketch = new SketchDrawImageUsingCurves();
    PApplet.runSketch(processingArgs, mySketch);
  }
	
}