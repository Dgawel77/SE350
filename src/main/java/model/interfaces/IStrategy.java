package model.interfaces;

import java.awt.Graphics2D;
import model.shapes.ShapeImpl;

public interface IStrategy {
  void draw(Graphics2D graphics, ShapeImpl Shape);
}
