package dev.jamiethomas.generative.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.ejml.simple.SimpleMatrix;

public class ImageUtils {

  public static BufferedImage loadImageFromFile(String pathname) {
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File(pathname).toURI().toURL());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }
  
  
  public static SimpleMatrix imageToRGBMatrix(BufferedImage image, int width, int height) {
    SimpleMatrix matrix = new SimpleMatrix(height, width);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int rgb = image.getRGB(i, j);
        matrix.set(j, i, rgb);
      }
    }
    
    return matrix;
  }
  
  
  public static SimpleMatrix imageToGreyscaleMatrix(BufferedImage image) {
    SimpleMatrix matrix = new SimpleMatrix(image.getHeight(), image.getWidth());

    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        int rgb = image.getRGB(i, j);
        int r = (rgb >> 16) & 0xFF; 
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb & 0xFF);
        int grey = (r + g + b) / 3;
        matrix.set(j, i, grey);
      }
    }
    
    return matrix;
  }
  
}