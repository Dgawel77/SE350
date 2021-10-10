package model.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends ShapeImpl{
  public Rectangle(int _x, int _y, int _width, int _height, Color _sColor) {
    super(_x, _y, _width, _height, _sColor);
  }

  @Override
  public void draw(Graphics graphics){
    graphics.fillRect(x, y, width, height);
  }

}
