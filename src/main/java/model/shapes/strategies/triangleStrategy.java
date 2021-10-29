package model.shapes.strategies;

import java.awt.Graphics;
import java.awt.Polygon;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

public class triangleStrategy implements IStrategy {
  public void draw(Graphics graphics, IShape Shape){
    int x = Shape.getX();
    int y = Shape.getY();
    int width = Shape.getWidth();
    int height = Shape.getHeight();

    Polygon p = new Polygon(new int[]{x+(width/2), x+width, x},
                            new int[]{y, y+height, y+height}, 3);
    graphics.drawPolygon(p);
    graphics.fillPolygon(p);
  }
}
