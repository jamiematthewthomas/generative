package dev.jamiethomas.generative.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
  
  
}
