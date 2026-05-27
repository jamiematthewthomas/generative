package dev.jamiethomas.generative.sketches;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import dev.jamiethomas.generative.Generative3DNoAnimation;
import processing.core.PApplet;

public class SketchDataLines3D extends Generative3DNoAnimation {

  private static final int NUM_LINES = 4 * 12; // 4 years of 12 months (approx)
  private static final int NUM_POINTS = 7 * 4; // 4 weeks in a period
  private static final float X_SPACING = 30;
  private static final float Z_SPACING = 80;
  private static final float AMPLITUDE = 100;
  private static final float FOREGROUND_EXTENSION_Z = 1000;
  private static final float BACKGROUND_EXTENSION_Z = 10000;

  @Override
  public void setup() {
    background(255);
  }

  /**
   * Returns the data to render as a list of series. Each series is drawn as one
   * line running from the foreground to the background, represented as a list of
   * Y deflection values (index 0 = front, last index = back). The outer list runs
   * left to right: index 0 is the leftmost line, the last index is the rightmost.
   *
   * Replace this method to swap in real numerical data.
   */
  protected List<List<Float>> getData() {
    RandomGenerator random = RandomGenerator.getDefault();
    List<List<Float>> data = new ArrayList<>();
    for (int i = 0; i < NUM_LINES; i++) {
      List<Float> series = new ArrayList<>();
      for (int j = 0; j < NUM_POINTS; j++) {
        series.add(random.nextFloat() * -1 * AMPLITUDE);
      }
      data.add(series);
    }
    return data;
  }

  @Override
  public void drawWithSVGExport() {
    noFill();
    stroke(0);

    List<List<Float>> data = getData();

    pushMatrix();
    // Place the origin at the bottom-left foreground; rotations cause each
    // successive line to appear higher and further right, producing the
    // bottom-left foreground → upper-right background perspective.
    translate(-200, 400, -800);
    rotateX(-PI / 5);
    rotateY(-PI * 2 / 9);

    pushMatrix();
    translate(0, 0, 0);
    stroke(0, 255, 255); // cyan
    drawLineGraphs(data);
    popMatrix();

    pushMatrix();
    translate(2, 2, 2);
    stroke(255, 0, 255); // magenta
    drawLineGraphs(data);
    popMatrix();

    pushMatrix();
    translate(-2, -2, -2);
    stroke(255, 255, 0); // yellow
    drawLineGraphs(data);
    popMatrix();

    popMatrix();
  }

  private void drawLineGraphs(List<List<Float>> data) {
    // Draw right-to-left so left lines (closer to the viewer under rotateY) render on top in the SVG.
    for (int i = data.size() - 1; i >= 0; i--) {
      List<Float> series = data.get(i);
      float x = i * X_SPACING;

      beginShape();
      vertex(x, 0, FOREGROUND_EXTENSION_Z);
      vertex(x, 0, Z_SPACING);
      for (int j = 0; j < series.size(); j++) {
        vertex(x, series.get(j), -j * Z_SPACING);
      }
      vertex(x, 0, -series.size() * Z_SPACING);
      vertex(x, 0, -(series.size() - 1) * Z_SPACING - BACKGROUND_EXTENSION_Z);
      endShape();
    }
  }

  public static void main(String[] args) {
    String[] processingArgs = { SketchDataLines3D.class.getSimpleName() };
    SketchDataLines3D mySketch = new SketchDataLines3D();
    PApplet.runSketch(processingArgs, mySketch);
  }
}
