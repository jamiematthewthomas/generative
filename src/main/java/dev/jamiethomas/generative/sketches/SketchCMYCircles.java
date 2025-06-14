package dev.jamiethomas.generative.sketches;

import java.util.ArrayList;
import java.util.List;

import dev.jamiethomas.generative.Generative;
import dev.jamiethomas.generative.shapes.Circle;
import processing.core.PApplet;

/**
 * Deprecated - use {@link SketchCMYCircles3D} instead, which uses frame rotation & transation
 * instead of all the manual geometry in here.
 */
@Deprecated
public class SketchCMYCircles extends Generative {

  @Override
  public void setup() {
    background(255);
  }

  @Override
  public void drawWithSVGExport() {
    noFill();

    // construct circles upfront (so we can plot them later)
    List<Circle> cCircles = new ArrayList<Circle>();
    List<Circle> mCircles = new ArrayList<Circle>();
    List<Circle> yCircles = new ArrayList<Circle>();

    double theta = Math.PI / 120;

    for (float i = 100; i < 1000; i = i + 100) {
      for (float j = 100; j < 1000; j = j + 100) {

        // determine distance from (500, 500) and use this to determine the radius
        float d = (float) Math.sqrt(Math.pow(i - 500, 2) + Math.pow(j - 500, 2));

        // plot cyan
        cCircles.add(new Circle(i, j, 10 + (d/10)));

        // magenta is cyan rotated theta around (500,500)
        double mi = (i-500) * Math.cos(theta) - (j-500) * Math.sin(theta) + 500;
        double mj = (j-500) * Math.cos(theta) + (i-500) * Math.sin(theta) + 500;
        mCircles.add(new Circle((float) mi, (float) mj, 10 + (d/10)));

        // yellow is cyan rotated 2*theta around (500, 500)
        double yi = (i-500) * Math.cos(2*theta) - (j-500) * Math.sin(2*theta) + 500;
        double yj = (j-500) * Math.cos(2*theta) + (i-500) * Math.sin(2*theta) + 500;
        yCircles.add(new Circle((float) yi, (float) yj, 10 + (d/10)));
      }
    }

    stroke(0, 255, 255); // cyan
    cCircles.forEach(c -> circle(c.getX(), c.getY(), c.getR()));

    stroke(255, 0, 255); // magenta
    mCircles.forEach(c -> circle(c.getX(), c.getY(), c.getR()));

    stroke(255, 255, 0); // yellow
    yCircles.forEach(c -> circle(c.getX(), c.getY(), c.getR()));

  }

  public static void main(String[] args) {
    String[] processingArgs = { SketchCMYCircles.class.getSimpleName() };
    SketchCMYCircles mySketch = new SketchCMYCircles();
    PApplet.runSketch(processingArgs, mySketch);
  }
}
