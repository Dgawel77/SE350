package model.shapes.strategies;

import java.awt.Graphics;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

public class rectangleStrategy implements IStrategy {
  public void draw(Graphics graphics, IShape Shape){
    graphics.fillRect(Shape.getX(), Shape.getY(), Shape.getWidth(), Shape.getHeight());
  }
}
