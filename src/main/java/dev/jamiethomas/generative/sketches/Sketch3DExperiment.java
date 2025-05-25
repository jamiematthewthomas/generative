package dev.jamiethomas.generative.sketches;

import dev.jamiethomas.generative.Generative3DNoAnimation;
import processing.core.PApplet;

public class Sketch3DExperiment extends Generative3DNoAnimation {

  @Override
  public void setup() {
    background(255);
  }


  @Override
  public void drawWithSVGExport() {
    noFill();
    rectMode(CORNERS);

    drawBars(100, Colour.CYAN,
        BarConstruction.FULL_BAR,
        BarConstruction.TWENTY_FIFTY,
        BarConstruction.FOURTY_THIRTY,
        BarConstruction.THIRTY_FOURTY,
        BarConstruction.TEN_SIXTY,
        BarConstruction.FIFTY_TWENTY,
        BarConstruction.FULL_BAR
        );

    drawBars(105, Colour.YELLOW,
        BarConstruction.FULL_BAR,
        BarConstruction.TWENTY_FIFTY,
        BarConstruction.SIXTY_TEN,
        BarConstruction.FIFTY_TWENTY,
        BarConstruction.THIRTY_FOURTY,
        BarConstruction.TEN_SIXTY,
        BarConstruction.FULL_BAR
        );

    drawBars(110, Colour.MAGENTA,
        BarConstruction.FULL_BAR,
        BarConstruction.THIRTY_FOURTY,
        BarConstruction.TEN_SIXTY,
        BarConstruction.TWENTY_FIFTY,
        BarConstruction.FIFTY_TWENTY,
        BarConstruction.FOURTY_THIRTY,
        BarConstruction.FULL_BAR
        );

    drawBars(900, Colour.CYAN,
        BarConstruction.FULL_BAR,
        BarConstruction.TWENTY_FIFTY,
        BarConstruction.FOURTY_THIRTY,
        BarConstruction.THIRTY_FOURTY,
        BarConstruction.TEN_SIXTY,
        BarConstruction.FIFTY_TWENTY,
        BarConstruction.FULL_BAR
        );

    drawBars(905, Colour.YELLOW,
        BarConstruction.FULL_BAR,
        BarConstruction.TWENTY_FIFTY,
        BarConstruction.SIXTY_TEN,
        BarConstruction.FIFTY_TWENTY,
        BarConstruction.THIRTY_FOURTY,
        BarConstruction.TEN_SIXTY,
        BarConstruction.FULL_BAR
        );

    drawBars(910, Colour.MAGENTA,
        BarConstruction.FULL_BAR,
        BarConstruction.THIRTY_FOURTY,
        BarConstruction.TEN_SIXTY,
        BarConstruction.TWENTY_FIFTY,
        BarConstruction.FIFTY_TWENTY,
        BarConstruction.FOURTY_THIRTY,
        BarConstruction.FULL_BAR
        );

  }


  private void drawBars(float yValue, Colour colour, BarConstruction... barConstructions) {

    stroke(colour.red, colour.green, colour.blue);

    float zValue = 0;

    for (BarConstruction barConstruction : barConstructions) {
      pushMatrix();
      translate(500, yValue, zValue);
      rotateX(PI/2);
      drawBar(barConstruction);
      popMatrix();

      zValue = zValue - 200;
    }
  }


  private void drawBar(BarConstruction barConstruction) {
    switch (barConstruction) {
      case FULL_BAR:
        rect(-400, 0, 400, 100);
        break;
      case TEN_SIXTY:
        rect(-400, 0, -300, 100);
        rect(-200, 0, 400, 100);
        break;
      case TWENTY_FIFTY:
        rect(-400, 0, -200, 100);
        rect(-100, 0, 400, 100);
        break;
      case THIRTY_FOURTY:
        rect(-400, 0, -100, 100);
        rect(0, 0, 400, 100);
        break;
      case FOURTY_THIRTY:
        rect(-400, 0, 0, 100);
        rect(100, 0, 400, 100);
        break;
      case FIFTY_TWENTY:
        rect(-400, 0, 100, 100);
        rect(200, 0, 400, 100);
        break;
      case SIXTY_TEN:
        rect(-400, 0, 200, 100);
        rect(300, 0, 400, 100);
        break;
    }
  }


  private enum BarConstruction {
    FULL_BAR,
    TEN_SIXTY,
    TWENTY_FIFTY,
    THIRTY_FOURTY,
    FOURTY_THIRTY,
    FIFTY_TWENTY,
    SIXTY_TEN;
  }


  private enum Colour {

    CYAN(0, 255, 255),
    MAGENTA(255, 0, 255),
    YELLOW(255, 255, 0);

    private final int red;
    private final int green;
    private final int blue;

    Colour(int red, int green, int blue) {
      this.red = red;
      this.green= green;
      this.blue = blue;
    }
  }


  public static void main(String[] args) {
    String[] processingArgs = { Sketch3DExperiment.class.getSimpleName() };
    Sketch3DExperiment mySketch = new Sketch3DExperiment();
    PApplet.runSketch(processingArgs, mySketch);
  }
}