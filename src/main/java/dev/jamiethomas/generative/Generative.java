package dev.jamiethomas.generative;

import processing.core.PApplet;

public class Generative extends PApplet {

	static final int CANVAS_X = 1000;
	static final int CANVAS_Y = 1000;

	
	@Override
	public void settings() {
		size(CANVAS_X, CANVAS_Y);
	}
	
	public static void main(String[] args) {
		String[] processingArgs = { Generative.class.getSimpleName() };
		Generative mySketch = new Generative();
		PApplet.runSketch(processingArgs, mySketch);
	}
}
