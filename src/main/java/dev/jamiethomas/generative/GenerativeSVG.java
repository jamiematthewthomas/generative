package dev.jamiethomas.generative;

import dev.jamiethomas.generative.sketches.SketchDrawImageUsingCurves;
import processing.core.PApplet;

public class GenerativeSVG extends PApplet {

	static final int CANVAS_X = 1000;
	static final int CANVAS_Y = 1000;

	
	@Override
	public void settings() {
		size(CANVAS_X, CANVAS_Y, SVG, SketchDrawImageUsingCurves.class.getSimpleName() + ".svg");
	}
	
	public static void main(String[] args) {
		String[] processingArgs = { SketchDrawImageUsingCurves.class.getSimpleName() };
		SketchDrawImageUsingCurves mySketch = new SketchDrawImageUsingCurves();
		PApplet.runSketch(processingArgs, mySketch);
	}
	
}
