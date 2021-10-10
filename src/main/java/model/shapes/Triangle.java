package model.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends ShapeImpl {
  public Triangle(int _x, int _y, int _width, int _height, Color _sColor) {
    super(_x, _y, _width, _height, _sColor);
  }

  @Override
  public void draw(Graphics graphics){
    Polygon p = new Polygon(new int[]{x+(width/2), x+width, x}, new int[]{y, y+height, y+height}, 3);
    graphics.drawPolygon(p);
    graphics.fillPolygon(p);
  }
}
