package dev.jamiethomas.generative.sketches;

import org.ejml.simple.SimpleMatrix;

import dev.jamiethomas.generative.GenerativeSVG;
import dev.jamiethomas.generative.utils.MatrixUtils;
import processing.core.PApplet;

public class SketchMatrixMultiplication extends GenerativeSVG {

  private static final int PIXEL_WIDTH = 50;

  
	@Override
	public void setup() {
	  noStroke();
		rectMode(CORNERS);
	}

	
	@Override
	public void draw() {
	  SimpleMatrix rawRGBValues = new SimpleMatrix(
	      new double[][] {
	        new double[] {16777215d, 16777215d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d},
	        new double[] {16777215d, 00000000d, 06960264d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d},
	        new double[] {00000000d, 16777215d, 00000000d, 16777215d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d},
	        new double[] {00000000d, 00000000d, 16777215d, 00000000d, 16777215d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d},
	        new double[] {00000000d, 00000000d, 00000000d, 11868739d, 00000000d, 16777215d, 00000000d, 00000000d, 00000000d, 00000000d},
	        new double[] {00000000d, 00000000d, 00000000d, 00000000d, 16777215d, 00000000d, 05934369d, 00000000d, 00000000d, 00000000d},
	        new double[] {00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 16777215d, 00000000d, 16777215d, 00000000d, 00000000d},
	        new double[] {00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 16777215d, 00000000d, 16777215d, 00000000d},
	        new double[] {00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 11355792d, 00000000d, 16777215d},
	        new double[] {00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 00000000d, 16777215d, 16777215d},
	      });
	  
	  ///////////////////////////////////////////////////////////////////////////////
	  // FIRST MATRIX
	  ///////////////////////////////////////////////////////////////////////////////
	  
	  // scale matrix
//	  SimpleMatrix scaledRGBValues = MatrixUtils.scaleToRGB(rawRGBValues, 1);
	  SimpleMatrix scaledRGBValues = MatrixUtils.scaleToRGBCrude(rawRGBValues);
	  
	  // draw matrix
    MatrixUtils.drawMatrixOnCanvas(this, scaledRGBValues, 0, 0, PIXEL_WIDTH);
	  
    
    ///////////////////////////////////////////////////////////////////////////////
    // SECOND MATRIX
    ///////////////////////////////////////////////////////////////////////////////

    // manipulate matrix
    rawRGBValues = rawRGBValues.mult(rawRGBValues);
	      
    // scale matrix
//    scaledRGBValues = MatrixUtils.scaleToRGB(rawRGBValues, 2);
    scaledRGBValues = MatrixUtils.scaleToRGBCrude(rawRGBValues);
		
    // draw matrix
    MatrixUtils.drawMatrixOnCanvas(this, scaledRGBValues, PIXEL_WIDTH * scaledRGBValues.getNumRows(), 0, PIXEL_WIDTH);

    ///////////////////////////////////////////////////////////////////////////////
    // THIRD MATRIX
    ///////////////////////////////////////////////////////////////////////////////
    
    // manipulate matrix
    rawRGBValues = rawRGBValues.mult(rawRGBValues);
    
    // scale matrix
//    scaledRGBValues = MatrixUtils.scaleToRGB(rawRGBValues, 4);
    scaledRGBValues = MatrixUtils.scaleToRGBCrude(rawRGBValues);
    
    // draw matrix
    MatrixUtils.drawMatrixOnCanvas(this, scaledRGBValues, 0, PIXEL_WIDTH * scaledRGBValues.getNumRows(), PIXEL_WIDTH);
    
    
    ///////////////////////////////////////////////////////////////////////////////
    // FOURTH MATRIX
    ///////////////////////////////////////////////////////////////////////////////
    
    // manipulate matrix
    rawRGBValues = rawRGBValues.mult(rawRGBValues);
    
    // scale matrix
//    scaledRGBValues = MatrixUtils.scaleToRGB(rawRGBValues, 8);
    scaledRGBValues = MatrixUtils.scaleToRGBCrude(rawRGBValues);
    
    // draw matrix
    MatrixUtils.drawMatrixOnCanvas(this, scaledRGBValues, PIXEL_WIDTH * scaledRGBValues.getNumRows(), PIXEL_WIDTH * scaledRGBValues.getNumRows(), PIXEL_WIDTH);
    
    
    
    
    
		stop();
	}

	
  public static void main(String[] args) {
    String[] processingArgs = { SketchMatrixMultiplication.class.getSimpleName() };
    SketchMatrixMultiplication mySketch = new SketchMatrixMultiplication();
    PApplet.runSketch(processingArgs, mySketch);
  }
	
}