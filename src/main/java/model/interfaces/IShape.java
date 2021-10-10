package model.interfaces;

import java.awt.Color;
import java.awt.Graphics;

public interface IShape {
  Color getColor();
  int getWidth();
  int getHeight();
  int getX();
  int getY();
  void draw(Graphics graphics);
}
