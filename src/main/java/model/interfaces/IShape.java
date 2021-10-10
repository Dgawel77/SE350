package model.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import model.region.Region;

public interface IShape {
  Color getColor();
  Region getRegion();
  int getWidth();
  int getHeight();
  int getX();
  int getY();
  void draw(Graphics graphics);

}
