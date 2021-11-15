package model.shapes.strategies;

import java.awt.Graphics2D;
import model.interfaces.IStrategy;
import model.shapes.ShapeImpl;

public class nullShapeDrawer implements IStrategy {

  @Override
  public void draw(Graphics2D graphics, ShapeImpl Shape) {
  }

  @Override
  public boolean isValid(){
    return false;
  }
}
