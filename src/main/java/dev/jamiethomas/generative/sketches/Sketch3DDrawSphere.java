package dev.jamiethomas.generative.sketches;

import dev.jamiethomas.generative.Generative3D;
import processing.core.PApplet;

public class Sketch3DDrawSphere extends Generative3D {

  float z = 0;
  
  @Override
  public void setup() {
    background(255);
  }

  
  @Override
  public void drawWithSVGExport() {
    pushMatrix();
    translate(500, 500, z);
    rotateX(((2*PI)/1000) * -z);
    sphere(250);
    popMatrix();
    
    z++;
  }
  
  
  public static void main(String[] args) {
    String[] processingArgs = { Sketch3DDrawSphere.class.getSimpleName() };
    Sketch3DDrawSphere mySketch = new Sketch3DDrawSphere();
    PApplet.runSketch(processingArgs, mySketch);
  }
}