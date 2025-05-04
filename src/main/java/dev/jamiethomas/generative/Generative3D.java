package dev.jamiethomas.generative;

/**
 * Subclass of {@link Generative} which allows for 3D rendering
 */
public class Generative3D extends Generative {

	@Override
	public void settings() {
		size(CANVAS_X, CANVAS_Y, P3D);
	}
	
}