package dev.jamiethomas.generative.sketches;

import java.awt.image.BufferedImage;

import org.ejml.simple.SimpleMatrix;

import dev.jamiethomas.generative.GenerativeSVG;
import dev.jamiethomas.generative.utils.ImageUtils;
import dev.jamiethomas.generative.utils.MatrixUtils;
import processing.core.PApplet;

public class SketchMatrixFromImage extends GenerativeSVG {

  @Override
  public void setup() {
    noStroke();
    rectMode(CORNERS);
  }

  @Override
  public void draw() {
    BufferedImage image = ImageUtils.loadImageFromFile("C:/Users/jamie/Desktop/cat_nerd_compressed.png");
    SimpleMatrix matrixFromImage = new SimpleMatrix(100, 100);

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        int rgb = image.getRGB(i, j);
        matrixFromImage.set(j, i, rgb);
      }
    }

//    matrixFromImage = matrixFromImage.mult(matrixFromImage);
    
    MatrixUtils.drawMatrixOnCanvas(this, MatrixUtils.scaleToRGB(matrixFromImage, 1), 0, 0, 1);

    stop();

  }

  public static void main(String[] args) {
    String[] processingArgs = { SketchMatrixFromImage.class.getSimpleName() };
    SketchMatrixFromImage mySketch = new SketchMatrixFromImage();
    PApplet.runSketch(processingArgs, mySketch);
  }

}