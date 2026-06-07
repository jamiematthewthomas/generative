package dev.jamiethomas.generative.sketches;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import dev.jamiethomas.generative.Generative3D;
import processing.core.PApplet;

public class SketchDataLines3DInteractive extends Generative3D {

  private static final int NUM_LINES = 4 * 12;
  private static final int NUM_POINTS = 7 * 4;
  private static final float X_SPACING = 30;
  private static final float Z_SPACING = 80;
  private static final float AMPLITUDE = 100;
  private static final float FOREGROUND_EXTENSION_Z = 1000;
  private static final float BACKGROUND_EXTENSION_Z = 10000;

  private float rotX = -PI / 5;
  private float rotY = -PI * 2 / 9;
  private List<List<Float>> data;

  @Override
  public void setup() {
    data = getData();
  }

  @Override
  public void mouseDragged() {
    rotY += (mouseX - pmouseX) * 0.01f;
    rotX += (mouseY - pmouseY) * 0.01f;
  }

  protected List<List<Float>> getData() {
    RandomGenerator random = RandomGenerator.getDefault();
    List<List<Float>> result = new ArrayList<>();
    for (int i = 0; i < NUM_LINES; i++) {
      List<Float> series = new ArrayList<>();
      for (int j = 0; j < NUM_POINTS; j++) {
        series.add(random.nextFloat() * -1 * AMPLITUDE);
      }
      result.add(series);
    }
    return result;
  }

  @Override
  public void drawWithSVGExport() {
    background(255);
    noFill();

    pushMatrix();
    translate(-200, 400, -800);
    rotateX(rotX);
    rotateY(rotY);

    pushMatrix();
    translate(0, 0, 0);
    stroke(0, 255, 255);
    drawLineGraphs(data);
    popMatrix();

    pushMatrix();
    translate(2, 2, 2);
    stroke(255, 0, 255);
    drawLineGraphs(data);
    popMatrix();

    pushMatrix();
    translate(-2, -2, -2);
    stroke(255, 255, 0);
    drawLineGraphs(data);
    popMatrix();

    popMatrix();
  }

  private void drawLineGraphs(List<List<Float>> data) {
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
    String[] processingArgs = { SketchDataLines3DInteractive.class.getSimpleName() };
    SketchDataLines3DInteractive mySketch = new SketchDataLines3DInteractive();
    PApplet.runSketch(processingArgs, mySketch);
  }
}
