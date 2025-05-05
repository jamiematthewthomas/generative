package dev.jamiethomas.generative;

/**
 * Subclass of {@link Generative} which allows for 3D rendering.
 * <p>
 * Write to SVG by hitting 'r'
 */
public class Generative3D extends Generative {

  private boolean record;

  @Override
  public void settings() {
    size(CANVAS_X, CANVAS_Y, P3D);
  }

  
  @Override
  public void draw() {
    if (record) {
      beginRaw(SVG, this.getClass().getSimpleName() + ".svg");
    }

    drawWithSVGExport();
    
    if (record) {
      endRaw();
      System.out.println("Writing SVG to file [" + this.getClass().getSimpleName() + ".svg]");
      record = false;
    }
  }

  
  //Hit 'r' to record a single frame
  public void keyPressed() {
   if (key == 'r') {
     record = true;
   }
  }
	
}