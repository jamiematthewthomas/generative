package dev.jamiethomas.generative.shapes;

public class Circle {

  private final float x;
  private final float y;
  private final float r;

  public Circle(float x, float y, float r) {
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