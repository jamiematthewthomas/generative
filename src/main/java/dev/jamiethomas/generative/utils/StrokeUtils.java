package dev.jamiethomas.generative.utils;

import java.util.random.RandomGenerator;

import processing.core.PApplet;

public class StrokeUtils {

  /**
   * @param canvas
   * @param x0 - the x value to treat as 0
   * @param y0 - the y value to treat as 0
   * @param w - the width
   * @param h - the height of the bell curve
   */
  public static void upwardsBellCurve(PApplet canvas, int x0, int y0, int w, int h) {
    canvas.beginShape();

    // start at (x0,y0)
    canvas.vertex(x0, y0);
    // draw curve up to height with width w/2
    canvas.bezierVertex(x0 + w / 4, y0, x0 + w / 4, y0 - h, x0 + w / 2,
        y0 - h);
    // draw curve back down
    canvas.bezierVertex(x0 + 3 * (w / 4), y0 - h, x0 + 3 * (w / 4), y0,
        x0 + w, y0);
    
    canvas.endShape();
  }
  
  
  /**
   * @param canvas
   * @param x0 - the x value to treat as 0
   * @param y0 - the y value to treat as 0
   * @param w - the width
   * @param h - the height
   * @param n - the number of strokes to make
   * @param l - the max length of the stroke to me (all strokes will be made between l and l/2 in length
   */
  public static void hundredsAndThousands(PApplet canvas, int x0, int y0, int w, int h, int n, int l) {
    RandomGenerator random = RandomGenerator.getDefault();

    for (int i = 0; i < n; i++) {
      // generate a random point within the box (x0,y0) to (x0 + w, y0 + h)
      float x1 = x0 + (random.nextFloat() * w);
      float y1 = y0 + (random.nextFloat() * h);
      
      // generate a random point that is l away from the above point
      double theta = random.nextDouble(Math.TAU);
      double x2 = x1 + l * Math.cos(theta);
      double y2 = y1 + l * Math.sin(theta);
      
      // draw the line between these 2 points
      canvas.line(x1, y1, (float) x2, (float) y2);
    }
  }
  
}