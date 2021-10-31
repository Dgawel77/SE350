package model.shapes.strategies;

import java.awt.Graphics2D;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

public class nullShapeDrawer implements IStrategy {

  public nullShapeDrawer(){
  }

  @Override
  public void draw(Graphics2D graphics, IShape Shape) {
  }
}
