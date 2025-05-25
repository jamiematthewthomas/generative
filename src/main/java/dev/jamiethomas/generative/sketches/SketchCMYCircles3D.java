package dev.jamiethomas.generative.sketches;

import java.util.ArrayList;
import java.util.List;

import dev.jamiethomas.generative.Generative3DNoAnimation;
import processing.core.PApplet;

public class SketchCMYCircles3D extends Generative3DNoAnimation {

  @Override
  public void setup() {
    background(255);
  }

  @Override
  public void drawWithSVGExport() {
    noFill();

    List<Circle> circles = new ArrayList<Circle>();
    for (int i = -400; i <= 400; i = i + 100) {
      for (int j = -400; j <= 400; j = j + 100) {

        // determine distance from (0, 0) and use this to determine the radius
        float d = (float) Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));

        circles.add(new Circle(i, j, 10 + (d/10)));
      }
    }

    // translate the frame a bit for each colour
    float theta = PI / 120;

    pushMatrix();
    translate(500, 500);
    stroke(0, 255, 255); // cyan
    circles.forEach(c -> circle(c.getX(), c.getY(), c.getR()));
    popMatrix();

    pushMatrix();
    translate(500, 500);
    rotateZ(theta);
    stroke(255, 0, 255); // magenta
    circles.forEach(c -> circle(c.getX(), c.getY(), c.getR()));
    popMatrix();


    pushMatrix();
    translate(500, 500);
    rotateZ(2*theta);
    stroke(255, 255, 0); // yellow
    circles.forEach(c -> circle(c.getX(), c.getY(), c.getR()));
    popMatrix();

  }


  private static class Circle {

    private final float x;
    private final float y;
    private final float r;

    Circle(float x, float y, float r) {
      this.x = x;
      this.y = y;
      this.r = r;
    }

    public float getX() {
      return x;
    }

    public float  getY() {
      return y;
    }

    public float getR() {
      return r;
    }

  }

  public static void main(String[] args) {
    String[] processingArgs = { SketchCMYCircles3D.class.getSimpleName() };
    SketchCMYCircles3D mySketch = new SketchCMYCircles3D();
    PApplet.runSketch(processingArgs, mySketch);
  }
}
