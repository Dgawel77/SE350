package model.shapes.strategies;

import java.awt.Graphics;
import java.awt.Polygon;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

public class triangleStrategy implements IStrategy {
  public void draw(Graphics graphics, IShape Shape){
    Polygon p = new Polygon(new int[]{Shape.getX()+(Shape.getWidth()/2), Shape.getX()+Shape.getWidth(), Shape.getX()},
                            new int[]{Shape.getY(), Shape.getY()+Shape.getHeight(), Shape.getY()+Shape.getHeight()}, 3);
    graphics.drawPolygon(p);
    graphics.fillPolygon(p);
  }
}
