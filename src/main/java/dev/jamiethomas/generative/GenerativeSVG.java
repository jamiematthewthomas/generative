package dev.jamiethomas.generative;

import processing.core.PApplet;

public class GenerativeSVG extends PApplet {

	static final int CANVAS_X = 1000;
	static final int CANVAS_Y = 1000;

	
	@Override
	public void settings() {
		size(CANVAS_X, CANVAS_Y, SVG, this.getClass().getSimpleName() + ".svg");
	}
	
}