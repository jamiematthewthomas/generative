package dev.jamiethomas.generative.utils;

import processing.core.PApplet;

public class CurveUtils {

  public static void drawCurve(PApplet canvas, int xAxisZero, int yAxisZero, int width, int height) {
    canvas.beginShape();
    canvas.vertex(xAxisZero, yAxisZero);
    canvas.bezierVertex(xAxisZero + width / 4, yAxisZero, xAxisZero + width / 4, yAxisZero - height, xAxisZero + width / 2,
        yAxisZero - height);
    canvas.bezierVertex(xAxisZero + 3 * (width / 4), yAxisZero - height, xAxisZero + 3 * (width / 4), yAxisZero,
        xAxisZero + width, yAxisZero);
    canvas.endShape();
  }
  
}