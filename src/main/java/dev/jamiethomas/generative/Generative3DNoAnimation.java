package dev.jamiethomas.generative;

import processing.core.PApplet;

public class Generative3DNoAnimation extends PApplet {

  static final int CANVAS_X = 1000;
  static final int CANVAS_Y = 1000;

  @Override
  public void settings() {
    size(CANVAS_X, CANVAS_Y, P3D);
  }
  
  
  public void drawWithSVGExport() {};

  
  @Override
  public void draw() {
    beginRaw(SVG, this.getClass().getSimpleName() + ".svg");
    
    drawWithSVGExport();

    endRaw();
    System.out.println("Writing SVG to file [" + this.getClass().getSimpleName() + ".svg]");
    
    stop();
  }
  
}