package dev.jamiethomas.generative.utils;

import org.ejml.simple.SimpleMatrix;

import processing.core.PApplet;

public class MatrixUtils {

  /**
   * RGB max value: 16777215 (0xffffff)
   */
  public static final int RGB_MAX = 16777215;

  /**
   * Draws the supplied RGB-scaled matrix on the canvas.
   * 
   * @param canvas the {@link PApplet} canvas
   * @param rgbValues the RGB-scaled matrix to draw
   * @param xAxisZero the x-axis coordinate of the upper-left-hand corner of the image to draw
   * @param yAxisZero the y-axis coordinate of the upper-left-hand corner of the image to draw
   * @param pixelWidth the width of the pixels of the image to draw
   */
  public static void drawMatrixOnCanvas(PApplet canvas, SimpleMatrix rgbValues, int xAxisZero, int yAxisZero, int pixelWidth) {
    for (int i = 0; i < rgbValues.getNumCols(); i++) {
      for (int j = 0; j < rgbValues.getNumCols(); j++) {

        int rgb = ((Double) rgbValues.get(j, i)).intValue();

        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb & 0xFF);

        System.err.println("Filling pixel [" + i + "," + j + "] with rgb value [" + rgb + "]");
        canvas.fill(r, g, b);
        canvas.rect(xAxisZero + (i * pixelWidth), yAxisZero + (j * pixelWidth), xAxisZero + ((i + 1) * pixelWidth),
            yAxisZero + ((j + 1) * pixelWidth));
      }
    }
  }

  /**
   * Crudely scales the elements of the given matrix such that the maximum value
   * in the matrix is {@link MatrixUtils#RGB_MAX}.
   * 
   * @param matrixToScale the matrix to scale
   * @return the RGB-scaled matrix
   */
  public static SimpleMatrix scaleToRGBCrude(SimpleMatrix matrixToScale) {
    return matrixToScale.scale(RGB_MAX / matrixToScale.elementMax());
  }

  /**
   * Scales the elements of the given matrix to be displayed as RGB. This assumes
   * a matrix which was already scaled to RGB and has been multiplied by another
   * RGB-scaled matrix a number of times.
   * <p>
   * For example, an RGB-scaled matrix which has been multiplied by itself once
   * can be scaled back down to RGB by passing a magnitude of 2 in here.
   * 
   * @param matrixToScale the matrix to scale
   * @param magnitude     the number of times the RGB-scaled matrix has been
   *                      multiplied by another RGB-scaled matrix.
   * @return the RGB-scaled matrix
   */
  public static SimpleMatrix scaleToRGB(SimpleMatrix matrixToScale, int magnitude) {
    return matrixToScale.scale(Math.pow(RGB_MAX, 1 - magnitude));
  }
}