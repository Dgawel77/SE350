package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import model.region.Region;

public interface IShape {
  Color getPrimaryColor();
  Color getSecondaryColor();
  Color getOutlineColor();
  Region getRegion();
  int getWidth();
  int getHeight();
  int getX();
  int getY();
  void draw(Graphics2D graphics);
  void move(int xc, int yc);
  void setOutlineStrategy(IStrategy outlineStrategy);
  void setFillStrategy(IStrategy fillStrategy);
  void setSelectionStrategy(IStrategy selectionStrategy);
}
