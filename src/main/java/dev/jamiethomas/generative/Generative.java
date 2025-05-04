package dev.jamiethomas.generative;

import processing.core.PApplet;

public class Generative extends PApplet {

  static final int CANVAS_X = 1000;
  static final int CANVAS_Y = 1000;

  @Override
  public void settings() {
    size(CANVAS_X, CANVAS_Y);
  }
  
  
  public void drawWithSVGExport() {};

  
  @Override
  public void draw() {
    beginRecord(SVG, this.getClass().getSimpleName() + ".svg");
    
    drawWithSVGExport();

    endRecord();
    System.out.println("Writing SVG to file [" + this.getClass().getSimpleName() + ".svg]");
    
    stop();
  }
  
}