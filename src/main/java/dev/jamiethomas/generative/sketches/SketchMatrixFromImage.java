package dev.jamiethomas.generative.sketches;

import java.awt.image.BufferedImage;

import org.ejml.simple.SimpleMatrix;

import dev.jamiethomas.generative.Generative;
import dev.jamiethomas.generative.utils.ImageUtils;
import dev.jamiethomas.generative.utils.MatrixUtils;
import processing.core.PApplet;

public class SketchMatrixFromImage extends Generative {

  @Override
  public void setup() {
    noStroke();
    rectMode(CORNERS);
  }

  @Override
  public void draw() {
    BufferedImage image = ImageUtils.loadImageFromFile("C:/Users/jamie/Desktop/cat_nerd_compressed_width.png");
    SimpleMatrix matrixFromImage = ImageUtils.imageToGreyscaleMatrix(image); 
    MatrixUtils.drawGreyscaleMatrixOnCanvas(this, matrixFromImage, 0, 0, 1);

    stop();
  }

  public static void main(String[] args) {
    String[] processingArgs = { SketchMatrixFromImage.class.getSimpleName() };
    SketchMatrixFromImage mySketch = new SketchMatrixFromImage();
    PApplet.runSketch(processingArgs, mySketch);
  }

}