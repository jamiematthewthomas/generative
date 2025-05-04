package dev.jamiethomas.generative.sketches;

import java.awt.image.BufferedImage;

import dev.jamiethomas.generative.Generative;
import dev.jamiethomas.generative.utils.ImageUtils;
import dev.jamiethomas.generative.utils.StrokeUtils;
import processing.core.PApplet;

public class SketchDrawImageUsingStrokes extends Generative {

	@Override
	public void setup() {
		background(255);
	}

	@Override
	public void drawWithSVGExport() {
	  noFill();
	  
//	  BufferedImage image = ImageUtils.loadImageFromFile("C:/Users/jamie/Desktop/lake_compressed.png");
		BufferedImage image = ImageUtils.loadImageFromFile("C:/Users/jamie/Desktop/cat_nerd_compressed.png");

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int rgb = image.getRGB(i, j);
				int r = (rgb >> 16) & 0xFF; 
				int g = (rgb >> 8) & 0xFF;
				int b = (rgb & 0xFF);
				int grey = (r + g + b) / 3;
//				StrokeUtils.upwardsBellCurve(this, i*10, j*10, 10, (255 - grey) / 11);
				StrokeUtils.hundredsAndThousands(this, i*10, j*10, 10, 10, (255 - grey) / 25, 10);
			}
		}
		
	}

  public static void main(String[] args) {
    String[] processingArgs = { SketchDrawImageUsingStrokes.class.getSimpleName() };
    SketchDrawImageUsingStrokes mySketch = new SketchDrawImageUsingStrokes();
    PApplet.runSketch(processingArgs, mySketch);
  }
	
}