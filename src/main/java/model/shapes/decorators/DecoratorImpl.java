package model.shapes.decorators;

import java.awt.Color;
import java.awt.Graphics;
import model.interfaces.IShape;
import model.interfaces.IStrategy;
import model.region.Region;

public abstract class DecoratorImpl implements IShape {
  protected IShape coreShape;
  public DecoratorImpl(IShape Shape){
    coreShape = Shape;
  }

  @Override
  public Color getColor() {
    return coreShape.getColor();
  }

  @Override
  public Region getRegion() {
    return coreShape.getRegion();
  }

  @Override
  public int getWidth() {
    return coreShape.getWidth();
  }

  @Override
  public int getHeight() {
    return coreShape.getHeight();
  }

  @Override
  public int getX() {
    return coreShape.getX();
  }

  @Override
  public int getY() {
    return coreShape.getY();
  }

  @Override
  public IStrategy getStrategy() {
    return coreShape.getStrategy();
  }

  @Override
  public void draw(Graphics graphics) {
    coreShape.getStrategy().draw(graphics, this);
  }

  @Override
  public void move(int xc, int yc) {
    coreShape.move(xc, yc);
  }
}
