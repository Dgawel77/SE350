package model.shapes.strategies;

import java.awt.Graphics;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

public class ellipseStrategy implements IStrategy {
  public void draw(Graphics graphics, IShape Shape){
    graphics.drawOval(Shape.getX(), Shape.getY(), Shape.getWidth(), Shape.getHeight());
    graphics.fillOval(Shape.getX(), Shape.getY(), Shape.getWidth(), Shape.getHeight());
  }
}
