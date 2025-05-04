package dev.jamiethomas.generative.sketches;

import dev.jamiethomas.generative.Generative3D;
import processing.core.PApplet;

public class Sketch3DExperiment extends Generative3D {

  float z = 0;
  
  @Override
  public void setup() {
    background(255);
  }
  
  @Override
  public void draw() {

    pushMatrix();
    translate(500, 500, z);
    rotateX(((2*PI)/1000) * -z);
    sphere(250);
    popMatrix();
    
    
    z++;
  }
  
  public static void main(String[] args) {
    String[] processingArgs = { Sketch3DExperiment.class.getSimpleName() };
    Sketch3DExperiment mySketch = new Sketch3DExperiment();
    PApplet.runSketch(processingArgs, mySketch);
  }
  
}