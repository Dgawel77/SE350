package model.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends ShapeImpl {
  public Ellipse(int _x, int _y, int _width, int _height, Color _sColor) {
    super(_x, _y, _width, _height, _sColor);
  }

  @Override
  public void draw(Graphics graphics){
    graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    graphics.fillOval(getX(), getY(), getWidth(), getHeight());
  }
}
